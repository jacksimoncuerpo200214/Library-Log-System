/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import auth.*;
import javax.swing.JOptionPane;
import manageBooks.manageBooks;
import manageBorrows.manageBorrows;
import manageUser.manageUser;
import user.settings;

public class admindashboard extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public admindashboard() {
        initComponents();
    }

    public static void logAction(String action) {
        try {
            int currentUserId = config.usersession.getInstance().getId();
            System.out.println("Logging action for user ID: " + currentUserId + " Action: " + action);
            logs.logger.logAction(currentUserId, action);
            System.out.println("Action logged out successfully.");
        } catch (Exception e) {
            System.err.println("Error logging action: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        settings = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        manageBorrows = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        manageUser = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        manageBooks = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        welcomer = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        viewlogs = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, 90, 40));

        settings.setBackground(new java.awt.Color(236, 240, 241));
        settings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsMouseExited(evt);
            }
        });
        settings.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
        settings.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Settings");
        settings.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 180, 30));

        jPanel1.add(settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 180, 210));

        manageBorrows.setBackground(new java.awt.Color(236, 240, 241));
        manageBorrows.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        manageBorrows.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageBorrowsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                manageBorrowsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                manageBorrowsMouseExited(evt);
            }
        });
        manageBorrows.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrowbooks.png"))); // NOI18N
        manageBorrows.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Manage Borrows");
        manageBorrows.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 180, 30));

        jPanel1.add(manageBorrows, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 180, 210));

        manageUser.setBackground(new java.awt.Color(236, 240, 241));
        manageUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        manageUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                manageUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                manageUserMouseExited(evt);
            }
        });
        manageUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usericon.png"))); // NOI18N
        manageUser.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Manage Users");
        manageUser.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 176, 180, 30));

        jPanel1.add(manageUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 180, 210));

        manageBooks.setBackground(new java.awt.Color(236, 240, 241));
        manageBooks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        manageBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageBooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                manageBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                manageBooksMouseExited(evt);
            }
        });
        manageBooks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/booksicon.png"))); // NOI18N
        manageBooks.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Manage Books");
        manageBooks.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 180, 30));

        jPanel1.add(manageBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 180, 210));

        welcomer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        welcomer.setForeground(new java.awt.Color(255, 255, 255));
        welcomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomer.setText("Welcome Admin!");
        jPanel1.add(welcomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 410, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Admin Dashboard");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 80));

        viewlogs.setBackground(new java.awt.Color(236, 240, 241));
        viewlogs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        viewlogs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewlogsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewlogsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewlogsMouseExited(evt);
            }
        });
        viewlogs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logs.png"))); // NOI18N
        viewlogs.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Logs");
        viewlogs.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 180, 30));

        jPanel1.add(viewlogs, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 180, 210));

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

    private void manageUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageUserMouseClicked
        new manageUser().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageUserMouseClicked

    private void manageBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageBooksMouseClicked
       new manageBooks().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageBooksMouseClicked

    private void manageBorrowsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageBorrowsMouseClicked
       new manageBorrows().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageBorrowsMouseClicked

    private void manageUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_manageUserMouseEntered

    private void manageUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageUserMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_manageUserMouseExited

    private void manageBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageBooksMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_manageBooksMouseEntered

    private void manageBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageBooksMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_manageBooksMouseExited

    private void manageBorrowsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageBorrowsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_manageBorrowsMouseEntered

    private void manageBorrowsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageBorrowsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_manageBorrowsMouseExited

    private void settingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseClicked
        new settings().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_settingsMouseClicked

    private void settingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_settingsMouseEntered

    private void settingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_settingsMouseExited

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
      new login().setVisible(true);
        logAction("Admin Logged Out.");
      this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void viewlogsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewlogsMouseClicked
      new logs.logs().setVisible(true);
      this.dispose();
    }//GEN-LAST:event_viewlogsMouseClicked

    private void viewlogsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewlogsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_viewlogsMouseEntered

    private void viewlogsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewlogsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_viewlogsMouseExited

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
            java.util.logging.Logger.getLogger(admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admindashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel manageBooks;
    private javax.swing.JPanel manageBorrows;
    private javax.swing.JPanel manageUser;
    private javax.swing.JPanel settings;
    private javax.swing.JPanel viewlogs;
    private javax.swing.JLabel welcomer;
    // End of variables declaration//GEN-END:variables
}
