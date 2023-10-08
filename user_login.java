/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app_pack;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 2004d
 */
public class user_login extends javax.swing.JFrame {

    PreparedStatement stm;
    String send_regis = "";
    Connection con;
    static ResultSet data;
    /**
     * Creates new form user_login
     */
    public user_login() {
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/college_mgt";
        String user = "root";
        String password = "0000";
        con = DriverManager.getConnection(url,user,password);
//        String q1 = "select * from data1";
//        sm = (PreparedStatement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Cannot connect to the database.\n Please ask the developer to take care of this bug.","ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
            System.exit(0);
        }
        setIconImage();
        initComponents();
    }
    private void setIconImage() 
    {   
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("a1.png")));        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        regisid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(204, 255, 204));
        setLocation(new java.awt.Point(550, 150));
        setOpacity(1.0f);
        setPreferredSize(new java.awt.Dimension(810, 620));
        setResizable(false);
        setSize(new java.awt.Dimension(810, 620));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Sitka Display", 1, 24)); // NOI18N
        jLabel2.setText("Registration ID");
        jLabel2.setFocusable(false);
        jLabel2.setRequestFocusEnabled(false);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 180, 58));

        regisid.setBackground(new java.awt.Color(242, 242, 242));
        regisid.setFont(new java.awt.Font("Sitka Banner", 1, 24)); // NOI18N
        regisid.setToolTipText("ENter Adhar number.");
        regisid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        regisid.setMargin(new java.awt.Insets(1, 3, 1, 1));
        regisid.setSelectedTextColor(new java.awt.Color(153, 255, 255));
        regisid.setSelectionColor(new java.awt.Color(0, 255, 0));
        regisid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regisidActionPerformed(evt);
            }
        });
        getContentPane().add(regisid, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 360, 60));

        jLabel3.setFont(new java.awt.Font("Sitka Display", 1, 24)); // NOI18N
        jLabel3.setText("Password");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 168, 58));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(221, 117, 110));
        jLabel4.setText("New to app?");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, 20));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("  SignUp");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jButton3.setIconTextGap(2);
        jButton3.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 80, 30));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton1.setText("LogIn");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 150, 50));

        jLabel8.setBackground(new java.awt.Color(221, 117, 110));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Login");
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 80));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Sitka Display", 1, 24)); // NOI18N
        jLabel6.setText("User Name");
        jLabel6.setFocusable(false);
        jLabel6.setRequestFocusEnabled(false);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 168, 58));

        name.setBackground(new java.awt.Color(242, 242, 242));
        name.setFont(new java.awt.Font("Sitka Banner", 1, 24)); // NOI18N
        name.setToolTipText("Enter Your Name");
        name.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        name.setMargin(new java.awt.Insets(1, 3, 1, 1));
        name.setSelectedTextColor(new java.awt.Color(153, 255, 255));
        name.setSelectionColor(new java.awt.Color(0, 255, 0));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
        });
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 360, 50));

        password.setBackground(new java.awt.Color(242, 242, 242));
        password.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        password.setText("  password564646456545645645654");
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 360, 50));

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton2.setText("Forgot Password?");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 130, -1));

        jLabel5.setBackground(new java.awt.Color(255, 237, 219));
        jLabel5.setOpaque(true);
        jLabel5.setPreferredSize(new java.awt.Dimension(707, 610));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, -20, 940, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regisidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regisidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regisidActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        signUp sg = new signUp();
        sg.show();
        
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(regisid.getText().equals("") || name.getText().equals("") || password.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Data Fields cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
        }
        if(verify_data())
        {
            Dashboard af = new Dashboard(send_regis);
            af.show();
            dispose();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
    private boolean verify_data() 
    {
        String query = "select name,password from signup where referid = " + regisid.getText();        
        try 
        {
            stm = con.prepareStatement(query);
            data = stm.executeQuery(query);
            if(data == null)
            {
                JOptionPane.showMessageDialog(this,"Invalid user.\n If you didn't signup then signup first.","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
            while(data.next())
            {
                if(name.getText().equals(data.getString(1)) && password.getText().equals(data.getString(2)))
                {
                    send_regis  = regisid.getText();
                    regisid.setText("");
                    name.setText("");
                    password.setText("");
                    JOptionPane.showMessageDialog(this,"Welcome! " +  name.getText(),"Welcome",JOptionPane.PLAIN_MESSAGE);
                    return true;
                }                
            }            
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this,"Invalid user.\n If you didn't SignUp then SignUp first.","Error",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyReleased
        // TODO add your handling code here:
        int pos = name.getCaretPosition();
        name.setText(name.getText().toUpperCase());
        name.setCaretPosition(pos);
    }//GEN-LAST:event_nameKeyReleased

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        // TODO add your handling code here:
        password.setText("");
    }//GEN-LAST:event_passwordFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ForgotPassword fp = new ForgotPassword();
        fp.show();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(user_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_login().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField regisid;
    // End of variables declaration//GEN-END:variables

    
}