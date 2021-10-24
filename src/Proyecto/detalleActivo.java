/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Santillanes
 */


  

public class detalleActivo extends javax.swing.JFrame {
    String usu, cod;
    String direccion;
    /**
     * Creates new form detalleActivo
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
    
    
    JTextField txtExpiracion = new RoundJTextField(15);
    JTextField txtGeneracion = new RoundJTextField(15);
    JTextField txtNombre = new RoundJTextField(15);
    JTextField txtParen = new RoundJTextField(15);
    JTextField txtTel = new RoundJTextField(15);
    
    public detalleActivo(String usuario, String codigo) throws IOException, NotFoundException, ChecksumException, FormatException {
        usu = usuario;
        cod = codigo;
        direccion = "C:\\Users\\Santillanes\\Desktop\\Prog lógica y funcional\\Equipo2_P1_U2_PLF\\Images\\"+usu+"_"+cod+".png";
        initComponents();
        setSize(414, 896);
        this.setLocationRelativeTo(null);
               
        jPanel1.add(txtExpiracion);
        jPanel1.add(txtGeneracion);
        jPanel1.add(txtNombre);
        jPanel1.add(txtParen);
        jPanel1.add(txtTel);
        
        txtExpiracion.setVisible(true);
        txtExpiracion.setBounds(47, 466, 320, 35);
        txtExpiracion.setEditable(false);
        
        
        txtGeneracion.setVisible(true);
        txtGeneracion.setBounds(47, 368, 320, 35);
        txtGeneracion.setEditable(false);

        
        txtNombre.setVisible(true);
        txtNombre.setBounds(47, 73, 320, 35);
        txtNombre.setEditable(false);
        
        txtParen.setVisible(true);
        txtParen.setBounds(47, 270, 320, 35);
        txtParen.setEditable(false);
        
        txtTel.setVisible(true);
        txtTel.setBounds(47, 172, 320, 35);
        txtTel.setEditable(false);
        
        btnBorrar.setBorder(new RoundedBorder(30));
        btnCompartir.setBorder(new RoundedBorder(30));
        btnVolver.setBorder(new RoundedBorder(30));
        
        Reader lector = new MultiFormatReader();
        File ubicacionImagen = new File(direccion);
        BufferedImage imagen;
        
        System.out.println(ubicacionImagen.getPath());
        
        if (ubicacionImagen.exists()) {
            imagen = ImageIO.read(ubicacionImagen);
            LuminanceSource fuente = new BufferedImageLuminanceSource(imagen);
            BinaryBitmap mapaBits = new BinaryBitmap(new HybridBinarizer(fuente));
            Result resultado = lector.decode(mapaBits);
            System.out.println("Detalle del codigo = "+resultado.getText());
            
            String[] resu = resultado.getText().split("\n");
            
            txtNombre.setText(resu[1]);
            txtTel.setText(resu[2]);
            txtParen.setText(resu[3]);
            txtGeneracion.setText(resu[4]);
            txtExpiracion.setText(resu[5]);
            
            lblImg.setIcon(new ImageIcon(direccion));
        }
        
        
    }

    private detalleActivo() {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblImg = new javax.swing.JLabel();
        btnCompartir = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre del visitante");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(47, 40, 182, 23);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Teléfono del visitante");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(47, 139, 188, 23);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Parentesco del visitante");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(53, 237, 211, 23);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha y hora de generación del QR");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(53, 335, 305, 23);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha y hora de expiración del QR");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(53, 433, 298, 23);
        jPanel1.add(lblImg);
        lblImg.setBounds(110, 520, 200, 200);

        btnCompartir.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        btnCompartir.setForeground(new java.awt.Color(255, 255, 255));
        btnCompartir.setText("Compartir");
        btnCompartir.setContentAreaFilled(false);
        btnCompartir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompartir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompartirActionPerformed(evt);
            }
        });
        jPanel1.add(btnCompartir);
        btnCompartir.setBounds(47, 764, 144, 33);

        btnBorrar.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrar.setText("Borrar");
        btnBorrar.setContentAreaFilled(false);
        btnBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrar);
        btnBorrar.setBounds(223, 764, 144, 33);

        btnVolver.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setContentAreaFilled(false);
        btnVolver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver);
        btnVolver.setBounds(151, 818, 113, 33);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 420, 900);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo 414x986 4.0.png"))); // NOI18N
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 420, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        Activos nF = null;
        try {
            nF = new Activos(usu);
        } catch (IOException | NotFoundException | ChecksumException | FormatException ex) {
            Logger.getLogger(Pantalla2.class.getName()).log(Level.SEVERE, null, ex);
        }
        nF.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCompartirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompartirActionPerformed
        // TODO add your handling code here:
        
        compartirQR nF = new compartirQR(usu,direccion);
        nF.setVisible(true);
        this.dispose(); 
        
    }//GEN-LAST:event_btnCompartirActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        
        if (JOptionPane.showConfirmDialog(null, "¿Estás seguro de borrar este QR?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            
            String datos = "";
            try {
                // TODO add your handling code here:
                ObjectInputStream tra = new ObjectInputStream(new FileInputStream("C:\\Users\\Santillanes\\Desktop\\Prog lógica y funcional\\Equipo2_P1_U2_PLF\\DataBases\\"+usu+"QRsDataBase"));
                datos = tra.readObject().toString();
            } catch (IOException ex) {
                Logger.getLogger(detalleActivo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(detalleActivo.class.getName()).log(Level.SEVERE, null, ex);
            }

            String[] parts = datos.split("\\|");
            
            
            String direc = "C:\\Users\\Santillanes\\Desktop\\Prog lógica y funcional\\Equipo2_P1_U2_PLF\\Images\\"+usu+"_"+cod+".png";

            for (int i = 0; i < parts.length; i++) {
                if (parts[i].equals(usu+"_"+cod+".png")) {
                    File archivo = new File(direc);
                    boolean estatus = archivo.delete();
                    if (!estatus) {
                        System.out.println("Error no se ha podido eliminar el  archivo");
                    }else{
                        System.out.println("Se ha eliminado el archivo exitosamente");
                    }
                    parts[i] = "X";
                }
            }

            String nuevoDatos = "";

            for (int i = 0; i < parts.length; i++) {
                if (!("X".equals(parts[i]))) {
                    nuevoDatos += parts[i]+"|";
                }
            }

            try {
                ObjectOutputStream guar = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Santillanes\\Desktop\\Prog lógica y funcional\\Equipo2_P1_U2_PLF\\DataBases\\"+usu+"QRsDataBase"));
                guar.writeObject(nuevoDatos);
                System.out.println("guar = " + guar);
            } catch (IOException ex) {
                Logger.getLogger(detalleActivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JOptionPane.showMessageDialog(null, "QR borrado con éxito.");
            Activos nF = null;
            try {
                nF = new Activos(usu);
            } catch (IOException | NotFoundException | ChecksumException | FormatException ex) {
                Logger.getLogger(Pantalla2.class.getName()).log(Level.SEVERE, null, ex);
            }
            nF.setVisible(true);
            this.dispose();
            
        } else {
            
        }
        
        
    }//GEN-LAST:event_btnBorrarActionPerformed

    //################################################## ENVIAR CORREO ######################################
    correo c = new correo();
    
    
    public void enviarCorreo() throws MessagingException{
        System.out.println("direccion = " + direccion);
        System.out.println("direccion = " + direccion);
        c.setContra("ProyectoFraccionamiento");
        c.setUsuarioCorreo("Equipo2PLF@gmail.com");
        c.setAsunto("Código QR");
        c.setMensaje("¡Hola! Este es tu código QR. \nRecuerda guardarlo muy bien, ya que será tu boleto de entrada y salida del fraccionamiento.");
        c.setDestino(JOptionPane.showInputDialog("Igrese su correo electrónico: "));
        c.setNombreArchivo("CódigoQR.png");
        c.setRutaArchivo(direccion);
        controlador co = new controlador();
        if (co.enviarCorreo(c)) {
            JOptionPane.showMessageDialog(null, "¡QR compartido con éxito!");
        }else{
            JOptionPane.showMessageDialog(null, "Error al enviar el mensaje.");
        }
        
    }
    
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
            java.util.logging.Logger.getLogger(detalleActivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detalleActivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detalleActivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detalleActivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detalleActivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCompartir;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImg;
    // End of variables declaration//GEN-END:variables
}
