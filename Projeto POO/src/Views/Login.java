/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author leonardo.vinagre
 */
public class Login extends javax.swing.JFrame {

    Connection connection;
    Statement statement;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        painel = new javax.swing.JPanel();
        painelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fieldLogin = new javax.swing.JTextField();
        painelPassword = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JPasswordField();
        painelAcoes = new javax.swing.JPanel();
        buttonLogin = new javax.swing.JButton();
        createAccount = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painel.setBackground(new java.awt.Color(250, 250, 250));
        painel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelLogin.setBackground(new java.awt.Color(250, 250, 250));
        painelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Login: ");
        painelLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        fieldLogin.setBackground(new java.awt.Color(250, 250, 250));
        painelLogin.add(fieldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, -1));

        painel.add(painelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 60));

        painelPassword.setBackground(new java.awt.Color(250, 250, 250));
        painelPassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Password");
        painelPassword.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        fieldPassword.setBackground(new java.awt.Color(250, 250, 250));
        painelPassword.add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, -1));

        painel.add(painelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 230, 60));

        painelAcoes.setBackground(new java.awt.Color(250, 250, 250));
        painelAcoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonLogin.setText("Entrar");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        painelAcoes.add(buttonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        createAccount.setText("Criar conta");
        createAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountActionPerformed(evt);
            }
        });
        painelAcoes.add(createAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        painel.add(painelAcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 190, 50));

        jPanel1.add(painel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 230, 180));

        buttonClose.setText("Sair");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });
        jPanel1.add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 60, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/achadosperdidos",
                    "adm",
                    "root");
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(
                "SELECT * FROM usuario WHERE login='" +
                fieldLogin.getText() +
                "' AND senha=SHA1('" +
                new String(fieldPassword.getPassword()) +
                "');"
              );
            if (result.next()) {
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
                this.setVisible(false);
            } else {
                throw new Exception("Login ou senha incorretos!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        try {
            statement.close();
            connection.close();
        } catch (Exception f) {
            JOptionPane.showMessageDialog(this,
                    f.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_buttonLoginActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountActionPerformed
        JFrame frame = new JFrame("Glass pane");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        JPanel p1 = new JPanel();
        JLabel label = new JLabel("glasspane ex");
        p1.add(label);
        frame.getContentPane().add(p1);
        frame.setVisible(true);
        painel.setVisible(false);
    }//GEN-LAST:event_createAccountActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton createAccount;
    private javax.swing.JTextField fieldLogin;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painel;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel painelLogin;
    private javax.swing.JPanel painelPassword;
    // End of variables declaration//GEN-END:variables
}