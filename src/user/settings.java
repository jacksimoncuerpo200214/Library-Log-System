/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import admin.admindashboard;
import manageUser.*;
import auth.*;
import auth.*;
import javax.swing.JOptionPane;
import config.usersession;

public class settings extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public settings() {
        initComponents();
        loadUserData();
    }

    private void loadUserData() {
        try {
            usersession session = usersession.getInstance();
            firstname.setText(session.getFirstname());
            lastname.setText(session.getLastname());
            email.setText(session.getEmail());
            phonenumber.setText(session.getPhone() != null ? session.getPhone() : "");
            address.setText(session.getAddress());
            username.setText(session.getUsername());
            // Password fields left empty for security reasons

            // Load image
            String imageFileName = session.getImage();
            if (imageFileName != null && !imageFileName.isEmpty()) {
                String imagePath = "src/images/" + imageFileName;
                java.awt.Image img = new javax.swing.ImageIcon(imagePath).getImage();
                java.awt.Image scaledImg = img.getScaledInstance(image.getWidth(), image.getHeight(), java.awt.Image.SCALE_SMOOTH);
                image.setIcon(new javax.swing.ImageIcon(scaledImg));
            } else {
                image.setIcon(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load user data: " + e.getMessage());
        }
    }

    private String selectedImagePath = null;

    private void savechangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savechangesActionPerformed
        try {
            String fname = firstname.getText().trim();
            String lname = lastname.getText().trim();
            String mail = email.getText().trim();
            String phone = phonenumber.getText().trim();
            String addr = address.getText().trim();
            String user = username.getText().trim();

            char[] passChars = passwordfield.getPassword();
            String newPass = new String(passChars);
            char[] confirmPassChars = confirmPassword.getPassword();
            String confirmPass = new String(confirmPassChars);

            if (fname.isEmpty() || lname.isEmpty() || mail.isEmpty() || user.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields.");
                return;
            }

            if (!newPass.isEmpty() || !confirmPass.isEmpty()) {
                if (!newPass.equals(confirmPass)) {
                    JOptionPane.showMessageDialog(this, "Passwords do not match.");
                    return;
                }
                if (newPass.length() < 8) {
                    JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long.");
                    return;
                }
            }

            config.dbConnect db = new config.dbConnect();

            String updateSql;
            if (!newPass.isEmpty()) {
                String hashedPass = config.dbConnect.hashPassword(newPass);
                updateSql = "UPDATE user SET FirstName = '" + fname + "', LastName = '" + lname + "', Email = '" + mail + "', Phone = '" + phone + "', Address = '" + addr + "', Password = '" + hashedPass + "'";
            } else {
                updateSql = "UPDATE user SET FirstName = '" + fname + "', LastName = '" + lname + "', Email = '" + mail + "', Phone = '" + phone + "', Address = '" + addr + "'";
            }

            if (selectedImagePath != null) {
                // Store only the filename in the database, not full path
                String fileName = new java.io.File(selectedImagePath).getName();
                updateSql += ", image = '" + fileName + "'";
            }

            updateSql += " WHERE Username = '" + user + "'";

            int result = db.InsertData(updateSql);
            if (result == 1) {
                JOptionPane.showMessageDialog(this, "Changes saved successfully!");

                // Update session data
                usersession session = usersession.getInstance();
                session.setFirstname(fname);
                session.setLastname(lname);
                session.setEmail(mail);
                session.setPhone(phone);
                session.setAddress(addr);
                session.setUsername(user);
                if (!newPass.isEmpty()) {
                    session.setPassword(config.dbConnect.hashPassword(newPass));
                }
                if (selectedImagePath != null) {
                    session.setImage(selectedImagePath);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save changes. Please try again.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_savechangesActionPerformed

    private void selectimage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectimage1ActionPerformed
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == javax.swing.JFileChooser.APPROVE_OPTION) {
            try {
                java.io.File file = fileChooser.getSelectedFile();
                // Copy file to src/images/ folder only if not already there
                java.nio.file.Path sourcePath = file.toPath();
                String fileName = file.getName();
                java.nio.file.Path targetDir = java.nio.file.Paths.get("src/images");
                if (!java.nio.file.Files.exists(targetDir)) {
                    java.nio.file.Files.createDirectories(targetDir);
                }
                java.nio.file.Path targetPath = targetDir.resolve(fileName);
                if (!sourcePath.toAbsolutePath().startsWith(targetDir.toAbsolutePath())) {
                    // If file exists, rename with timestamp
                    if (java.nio.file.Files.exists(targetPath)) {
                        String name = fileName.substring(0, fileName.lastIndexOf('.'));
                        String ext = fileName.substring(fileName.lastIndexOf('.'));
                        String newFileName = name + "_" + System.currentTimeMillis() + ext;
                        targetPath = targetDir.resolve(newFileName);
                    }
                    java.nio.file.Files.copy(sourcePath, targetPath);
                } else {
                    targetPath = sourcePath;
                }
                selectedImagePath = targetPath.toString();

                java.awt.Image img = new javax.swing.ImageIcon(selectedImagePath).getImage();
                java.awt.Image scaledImg = img.getScaledInstance(image.getWidth(), image.getHeight(), java.awt.Image.SCALE_SMOOTH);
                image.setIcon(new javax.swing.ImageIcon(scaledImg));
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Failed to select image: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_selectimage1ActionPerformed

    private void removeimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeimageActionPerformed
        // Only remove image displayed in image icon, do not update database path
        selectedImagePath = null;
        java.awt.Image img = new javax.swing.ImageIcon("src/images/Background.png").getImage();
        java.awt.Image scaledImg = img.getScaledInstance(image.getWidth(), image.getHeight(), java.awt.Image.SCALE_SMOOTH);
        image.setIcon(new javax.swing.ImageIcon(scaledImg));
    }//GEN-LAST:event_removeimageActionPerformed

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        firstname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        savechanges = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        phonenumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        passwordfield = new javax.swing.JPasswordField();
        confirmPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        removeimage = new javax.swing.JButton();
        selectimage1 = new javax.swing.JButton();
        backbutton = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(52, 73, 94));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstname.setBackground(new java.awt.Color(255, 255, 255));
        firstname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 280, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("My Account");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 390, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 110, 20));

        savechanges.setBackground(new java.awt.Color(255, 255, 255));
        savechanges.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        savechanges.setForeground(new java.awt.Color(0, 0, 0));
        savechanges.setText("Save");
        savechanges.setBorder(null);
        savechanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savechangesActionPerformed(evt);
            }
        });
        jPanel2.add(savechanges, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 300, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("First Name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 80, 20));

        lastname.setBackground(new java.awt.Color(255, 255, 255));
        lastname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 280, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Last Name");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 80, 20));

        email.setBackground(new java.awt.Color(255, 255, 255));
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 280, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 80, 20));

        phonenumber.setBackground(new java.awt.Color(255, 255, 255));
        phonenumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phonenumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(phonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 280, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone Number");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 120, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Address");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 120, 20));

        address.setBackground(new java.awt.Color(255, 255, 255));
        address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 280, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Username");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 120, 20));

        username.setBackground(new java.awt.Color(255, 255, 255));
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 280, 30));

        passwordfield.setBackground(new java.awt.Color(255, 255, 255));
        passwordfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(passwordfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 280, 30));

        confirmPassword.setBackground(new java.awt.Color(255, 255, 255));
        confirmPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confirmPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(confirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 280, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cornfirm Password");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 110, 20));

        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 160, 110));

        removeimage.setBackground(new java.awt.Color(255, 255, 255));
        removeimage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        removeimage.setForeground(new java.awt.Color(0, 0, 0));
        removeimage.setText("Remove");
        removeimage.setBorder(null);
        removeimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeimageActionPerformed(evt);
            }
        });
        jPanel2.add(removeimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 110, 30));

        selectimage1.setBackground(new java.awt.Color(255, 255, 255));
        selectimage1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        selectimage1.setForeground(new java.awt.Color(0, 0, 0));
        selectimage1.setText("Select");
        selectimage1.setBorder(null);
        selectimage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectimage1ActionPerformed(evt);
            }
        });
        jPanel2.add(selectimage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 110, 30));

        backbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backicon.png"))); // NOI18N
        backbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backbuttonMouseClicked(evt);
            }
        });
        jPanel2.add(backbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 740, 540));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Background.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbuttonMouseClicked
        usersession session = usersession.getInstance();
        String role = session.getRole();
        if(role.equalsIgnoreCase("admin")){
             new admindashboard().setVisible(true);
            this.dispose();
        }
        else{
             new userdashboard().setVisible(true);
             this.dispose();
        }
       
    }//GEN-LAST:event_backbuttonMouseClicked

                                                

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JTextField address;
    private javax.swing.JLabel backbutton;
    private javax.swing.JPasswordField confirmPassword;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel image;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lastname;
    private javax.swing.JPasswordField passwordfield;
    private javax.swing.JTextField phonenumber;
    private javax.swing.JButton removeimage;
    private javax.swing.JButton savechanges;
    private javax.swing.JButton selectimage1;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
