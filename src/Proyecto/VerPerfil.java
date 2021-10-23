package Proyecto;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
public class VerPerfil extends javax.swing.JFrame {
    String usuario;
    /**
     * Creates new form EditarPerfil
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
    
    JTextField txtUsu = new RoundJTextField(15);
    JTextField txtNombre = new RoundJTextField(15);
    JTextField txtDire = new RoundJTextField(15);
    JTextField txtTelefono = new RoundJTextField(15);
    JTextField txtEmail = new RoundJTextField(15);
    JTextField txtFecha = new RoundJTextField(15);
    
    JPasswordField txtPass = new RoundJTextPass(15);

    
    
    public VerPerfil(String usu) {
        usuario = usu;
        initComponents();
        
        jPanel1.add(txtUsu);
        jPanel1.add(txtNombre);
        jPanel1.add(txtDire);
        jPanel1.add(txtTelefono);
        jPanel1.add(txtEmail);
        jPanel1.add(txtFecha);
        jPanel1.add(txtPass);
        

        //this.add(txtUsu);
        txtUsu.setVisible(true);
        txtUsu.setBounds(47, 170, 320, 35);
        txtUsu.setEditable(false);
        
        txtNombre.setVisible(true);
        txtNombre.setBounds(47, 258, 320, 35);
        txtNombre.setEditable(false);
        
        txtDire.setVisible(true);
        txtDire.setBounds(47, 346, 320, 35);
        txtDire.setEditable(false);
        
        txtTelefono.setVisible(true);
        txtTelefono.setBounds(47, 434, 320, 35);
        txtTelefono.setEditable(false);
        
        txtEmail.setVisible(true);
        txtEmail.setBounds(47, 522, 320, 35);
        txtEmail.setEditable(false);
        
        txtFecha.setVisible(true);
        txtFecha.setBounds(47, 610, 320, 35);
        txtFecha.setEditable(false);

        txtPass.setVisible(true);
        txtPass.setBounds(47, 698, 320, 35);
        txtPass.setEditable(false);
        
        setSize(414, 896);
        this.setLocationRelativeTo(null);
        
        btnChgPass.setBorder(new RoundedBorder(30));
        btnVolver.setBorder(new RoundedBorder(30));
        
        //Establecer datos del usuario
        try{
            ObjectInputStream tra = new ObjectInputStream(new FileInputStream(usuario));
                    // "c" es el numero de control y el nombre del archivo que se va a buscar
                    // Input es entrada, es para importar los datos de los archivos ya creados
            Object usua = tra.readObject();
            Object nom = tra.readObject();
            Object dire = tra.readObject();
            Object tel = tra.readObject();
            Object email = tra.readObject();
            Object fec = tra.readObject();
            Object pass = tra.readObject();
                    //En estas 3 lineas se leen los datos del archivo ya existente
                    // .readObject() es para leer datos del archivo ya existente
            txtUsu.setText(usua.toString());
            txtNombre.setText(nom.toString());
            txtDire.setText(dire.toString());
            txtTelefono.setText(tel.toString());
            txtEmail.setText(email.toString());
            txtFecha.setText(fec.toString());
            txtPass.setText(pass.toString());
                    //Sirve para colocar en los textField los datos leidos
                    
                    //PARA CREAR ARCHIVOS, ES NECESARIO UN TRY CATCH
        }catch(IOException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error. "+e.getMessage());
        }
        
    }

    private VerPerfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        btnVolver = new javax.swing.JButton();
        btnChgPass = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        btnVolver.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Salir");
        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver);
        btnVolver.setBounds(151, 823, 113, 33);

        btnChgPass.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnChgPass.setForeground(new java.awt.Color(255, 255, 255));
        btnChgPass.setText("Cambiar contraseña");
        btnChgPass.setContentAreaFilled(false);
        btnChgPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChgPassActionPerformed(evt);
            }
        });
        jPanel1.add(btnChgPass);
        btnChgPass.setBounds(90, 769, 234, 33);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Contraseña:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(53, 665, 101, 23);

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Residente desde:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(53, 577, 151, 23);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Correo electrónico:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(53, 489, 162, 23);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Teléfono:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(53, 401, 190, 23);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dirección:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(47, 313, 83, 23);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(47, 137, 68, 23);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre del residente:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(47, 225, 189, 23);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ver Perfil");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(117, 65, 180, 52);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 420, 900);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo2.0.png"))); // NOI18N
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 420, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
        Pantalla2 nF = new Pantalla2(usuario);
        nF.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnChgPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChgPassActionPerformed
        
        ChngPass nF = new ChngPass(usuario);
        nF.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnChgPassActionPerformed

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
            java.util.logging.Logger.getLogger(VerPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChgPass;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
