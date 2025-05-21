/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import admin.*;
import auth.*;
import javax.swing.JOptionPane;

public class userdashboard extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public userdashboard() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        borrowbook = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        books = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        welcomer = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
        settings.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Settings");
        settings.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 180, 30));

        jPanel1.add(settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 180, 210));

        borrowbook.setBackground(new java.awt.Color(236, 240, 241));
        borrowbook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        borrowbook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrowbookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                borrowbookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                borrowbookMouseExited(evt);
            }
        });
        borrowbook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrowbooks.png"))); // NOI18N
        borrowbook.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("My Borrowed Books");
        borrowbook.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 180, 30));

        jPanel1.add(borrowbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 180, 210));

        books.setBackground(new java.awt.Color(236, 240, 241));
        books.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        books.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                booksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                booksMouseExited(evt);
            }
        });
        books.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/booksicon.png"))); // NOI18N
        books.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("View Books");
        books.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 180, 30));

        jPanel1.add(books, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 180, 210));

        welcomer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        welcomer.setForeground(new java.awt.Color(255, 255, 255));
        welcomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomer.setText("Welcome User!");
        jPanel1.add(welcomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 410, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Dashboard");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 80));

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

    private void booksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseClicked
      new viewbooks().setVisible(true);
      this.dispose();
    }//GEN-LAST:event_booksMouseClicked

    private void borrowbookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowbookMouseClicked
      new myborrowed().setVisible(true);
      this.dispose();
    }//GEN-LAST:event_borrowbookMouseClicked

    private void booksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_booksMouseEntered

    private void booksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_booksMouseExited

    private void borrowbookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowbookMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_borrowbookMouseEntered

    private void borrowbookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowbookMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_borrowbookMouseExited

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
         logAction("User Logged Out.");
      this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(userdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userdashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JPanel books;
    private javax.swing.JPanel borrowbook;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel settings;
    private javax.swing.JLabel welcomer;
    // End of variables declaration//GEN-END:variables
}
