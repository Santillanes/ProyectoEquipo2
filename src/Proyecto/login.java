package Proyecto;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Santillanes
 */
class RoundJTextField extends JTextField {

    private Shape shape;

    public RoundJTextField(int size) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
    }

    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }
}

class RoundJTextPass extends JPasswordField {

    private Shape shape;

    public RoundJTextPass(int size) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
    }

    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }
}

class RoundedBorder implements Border {

    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}

public class login extends javax.swing.JFrame {

    boolean ver = false;
    String user = "";

    /**
     * Creates new form login
     */
    JTextField txtUsu = new RoundJTextField(15);
    JPasswordField txtPass2 = new RoundJTextPass(15);

    public login() {
        initComponents();

        jPanel1.add(txtUsu);
        jPanel1.add(txtPass2);

        //this.add(txtUsu);
        txtUsu.setVisible(true);
        txtUsu.setBounds(47, 429, 320, 35);

        txtPass2.setVisible(true);
        txtPass2.setBounds(47, 528, 320, 35);

        setSize(414, 896);
        this.setLocationRelativeTo(null);

        btnEntrar.setBorder(new RoundedBorder(30));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnVer = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo 414x896.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 420, 896);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Soporte (?)");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(169, 862, 76, 21);

        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ojo.png"))); // NOI18N
        btnVer.setBorderPainted(false);
        btnVer.setContentAreaFilled(false);
        btnVer.setFocusPainted(false);
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        jPanel1.add(btnVer);
        btnVer.setBounds(325, 527, 37, 37);

        btnEntrar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Ingresar");
        btnEntrar.setContentAreaFilled(false);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEntrar);
        btnEntrar.setBounds(145, 600, 124, 29);

        lblUsuario.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("USUARIO");
        jPanel1.add(lblUsuario);
        lblUsuario.setBounds(165, 392, 84, 29);

        lblContraseña.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lblContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lblContraseña.setText("CONTRASEÑA");
        jPanel1.add(lblContraseña);
        lblContraseña.setBounds(145, 491, 124, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logotipo.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(61, 72, 293, 293);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 410, 900);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo2.0.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 420, 896);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    public boolean validarLog(String usuario){
        try{
            ObjectInputStream tra = new ObjectInputStream(new FileInputStream(usuario));
            
            Object usua = tra.readObject();
            Object nom = tra.readObject();
            Object dire = tra.readObject();
            Object tel = tra.readObject();
            Object email = tra.readObject();
            Object fec = tra.readObject();
            Object pass = tra.readObject();
            
            
            if (txtPass2.getText().equals(pass)) {
                user = usua.toString();
                return true;
            }else{
                return false;
            }
                   
        }catch(IOException | ClassNotFoundException e){
            return false;
        }
    }

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        
        if (validarLog(txtUsu.getText())) {
            Pantalla2 nF = new Pantalla2(user);
            nF.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto.\nIntente nuevamente.");
            txtPass2.setText("");
            txtUsu.setText("");
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:
        if (!ver) {
            txtPass2.setEchoChar((char) 0);
            ver = true;
        } else {
            txtPass2.setEchoChar('*');
            ver = false;
        }

    }//GEN-LAST:event_btnVerActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new login().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
