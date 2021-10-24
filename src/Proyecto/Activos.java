package Proyecto;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;

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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santillanes
 */
public class Activos extends javax.swing.JFrame {
    String usuario;
    String c0,c1,c2,c3,c4,c5,c6,c7,c8,c9;
    /**
     * Creates new form Activos
     */
    
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
    
    public Activos(String usu) throws IOException, NotFoundException, ChecksumException, FormatException {
        usuario = usu;
        initComponents();
        
        setSize(414, 896);
        this.setLocationRelativeTo(null);
        
        btnGenerar.setBorder(new RoundedBorder(30));
        btnVolver.setBorder(new RoundedBorder(30));
        
        btn1.setVisible(false);
        btn2.setVisible(false);
        btn3.setVisible(false);
        btn4.setVisible(false);
        btn5.setVisible(false);
        btn6.setVisible(false);
        btn7.setVisible(false);
        btn8.setVisible(false);
        btn9.setVisible(false);
        btn10.setVisible(false);
        
        String datos = "";
        if (new File("C:\\Users\\Santillanes\\Desktop\\Prog lógica y funcional\\Equipo2_P1_U2_PLF\\DataBases\\"+usuario+"QRsDataBase").exists()) {
            try {
                ObjectInputStream tra = new ObjectInputStream(new FileInputStream("C:\\Users\\Santillanes\\Desktop\\Prog lógica y funcional\\Equipo2_P1_U2_PLF\\DataBases\\"+usuario+"QRsDataBase"));
                datos = tra.readObject().toString();
                System.out.println("datos = "+datos);
            } catch (FileNotFoundException ex) {
                System.out.println("Error Activos.java: "+ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (datos.length() != 0) {
                System.out.println("datos0 = " + datos.charAt(0));
                while(datos.charAt(0) == '|'){
                    System.out.println("datos en while = " + datos);
                    datos = datos.substring(1);
                    if (datos.length() == 0) {
                        break;
                    }
                }
            }
            
            
            String[] parts = datos.split("\\|");
            
            for (int i = 0; i < parts.length; i++) {
                System.out.println("i = " + i);
                Reader lector = new MultiFormatReader();
                File ubicacionImagen = new File("C:\\Users\\Santillanes\\Desktop\\Prog lógica y funcional\\Equipo2_P1_U2_PLF\\Images\\"+parts[i]);
                BufferedImage imagen;

                if(ubicacionImagen.exists() && !("".equals(datos))){
                    System.out.println("========== QR #"+(i+1)+" =================");
                    imagen = ImageIO.read(ubicacionImagen);
                    LuminanceSource fuente = new BufferedImageLuminanceSource(imagen);
                    BinaryBitmap mapaBits = new BinaryBitmap(new HybridBinarizer(fuente));
                    Result resultado = lector.decode(mapaBits);
                    System.out.println("Contenido del codigo = "+resultado.getText());
                    
                    String[] resu = resultado.getText().split("\n");
                    
                    switch (i) {
                        case 0:
                            btn1.setVisible(true);
                            btn1.setBorder(new RoundedBorder(30));
                            btn1.setText(resu[0]+" - "+resu[1]);                            
                            c0 = resu[0];
                            break;
                        case 1:
                            btn2.setVisible(true);
                            btn2.setBorder(new RoundedBorder(30));
                            btn2.setText(resu[0]+" - "+resu[1]);
                            c1 = resu[0];
                            break;
                        case 2:
                            btn3.setVisible(true);
                            btn3.setBorder(new RoundedBorder(30));
                            btn3.setText(resu[0]+" - "+resu[1]);
                            c2 = resu[0];
                            break;
                        case 3:
                            btn4.setVisible(true);
                            btn4.setBorder(new RoundedBorder(30));
                            btn4.setText(resu[0]+" - "+resu[1]);
                            c3 = resu[0];
                            break;
                        case 4:
                            btn5.setVisible(true);
                            btn5.setBorder(new RoundedBorder(30));
                            btn5.setText(resu[0]+" - "+resu[1]);
                            c4 = resu[0];
                            break;
                        case 5:
                            btn6.setVisible(true);
                            btn6.setBorder(new RoundedBorder(30));
                            btn6.setText(resu[0]+" - "+resu[1]);
                            c5 = resu[0];
                            break;
                        case 6:
                            btn7.setVisible(true);
                            btn7.setBorder(new RoundedBorder(30));
                            btn7.setText(resu[0]+" - "+resu[1]);
                            c6 = resu[0];
                            break;
                        case 7:
                            btn8.setVisible(true);
                            btn8.setBorder(new RoundedBorder(30));
                            btn8.setText(resu[0]+" - "+resu[1]);
                            c7 = resu[0];
                            break;
                        case 8:
                            btn9.setVisible(true);
                            btn9.setBorder(new RoundedBorder(30));
                            btn9.setText(resu[0]+" - "+resu[1]);
                            c8 = resu[0];
                            break;
                        case 9:
                            btn10.setVisible(true);
                            btn10.setBorder(new RoundedBorder(30));
                            btn10.setText(resu[0]+" - "+resu[1]);
                            c9 = resu[0];
                            break;
                        default:
                            break;
                    }
                        
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Este usuario no tiene QRs activos.");
        }
        
    }
    
    
    private Activos() {
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

        jLabel1 = new javax.swing.JLabel();
        btn2 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QR Activos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 40, 186, 45);

        btn2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setText("jButton1");
        btn2.setContentAreaFilled(false);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn2);
        btn2.setBounds(50, 190, 310, 40);

        btn1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setText("jButton1");
        btn1.setContentAreaFilled(false);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1);
        btn1.setBounds(50, 130, 310, 40);

        btn4.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn4.setForeground(new java.awt.Color(255, 255, 255));
        btn4.setText("jButton1");
        btn4.setContentAreaFilled(false);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn4);
        btn4.setBounds(50, 310, 310, 40);

        btn5.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn5.setForeground(new java.awt.Color(255, 255, 255));
        btn5.setText("jButton1");
        btn5.setContentAreaFilled(false);
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn5);
        btn5.setBounds(50, 370, 310, 40);

        btn6.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn6.setForeground(new java.awt.Color(255, 255, 255));
        btn6.setText("jButton1");
        btn6.setContentAreaFilled(false);
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn6);
        btn6.setBounds(50, 430, 310, 40);

        btn7.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn7.setForeground(new java.awt.Color(255, 255, 255));
        btn7.setText("jButton1");
        btn7.setContentAreaFilled(false);
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        getContentPane().add(btn7);
        btn7.setBounds(50, 490, 310, 40);

        btn10.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn10.setForeground(new java.awt.Color(255, 255, 255));
        btn10.setText("jButton1");
        btn10.setContentAreaFilled(false);
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });
        getContentPane().add(btn10);
        btn10.setBounds(50, 670, 310, 40);

        btn9.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn9.setForeground(new java.awt.Color(255, 255, 255));
        btn9.setText("jButton1");
        btn9.setContentAreaFilled(false);
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        getContentPane().add(btn9);
        btn9.setBounds(50, 610, 310, 40);

        btn8.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn8.setForeground(new java.awt.Color(255, 255, 255));
        btn8.setText("jButton1");
        btn8.setContentAreaFilled(false);
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        getContentPane().add(btn8);
        btn8.setBounds(50, 550, 310, 40);

        btn3.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setText("jButton1");
        btn3.setContentAreaFilled(false);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3);
        btn3.setBounds(50, 250, 310, 40);

        btnVolver.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Salir");
        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver);
        btnVolver.setBounds(151, 813, 113, 33);

        btnGenerar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerar.setText("Generar QR");
        btnGenerar.setContentAreaFilled(false);
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerar);
        btnGenerar.setBounds(116, 755, 183, 33);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo 414x986 4.0.png"))); // NOI18N
        getContentPane().add(fondo);
        fondo.setBounds(-2, -2, 420, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        
        CrearQR nF = new CrearQR(usuario);
        nF.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
        Pantalla2 nF = new Pantalla2(usuario);
        nF.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        detalleActivo nF = null;
        try {
            nF = new detalleActivo(usuario, c0);
        } catch (IOException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ChecksumException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FormatException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        }
        nF.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        detalleActivo nF = null;
        try {
            nF = new detalleActivo(usuario, c1);
        } catch (IOException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ChecksumException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FormatException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        }
        nF.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        detalleActivo nF = null;
        try {
            nF = new detalleActivo(usuario, c2);
        } catch (IOException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ChecksumException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FormatException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        }
        nF.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        detalleActivo nF = null;
        try {
            nF = new detalleActivo(usuario, c3);
        } catch (IOException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ChecksumException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FormatException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        }
        nF.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        detalleActivo nF = null;
        try {
            nF = new detalleActivo(usuario, c4);
        } catch (IOException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ChecksumException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FormatException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        }
        nF.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        detalleActivo nF = null;
        try {
            nF = new detalleActivo(usuario, c5);
        } catch (IOException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ChecksumException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FormatException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        }
        nF.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        detalleActivo nF = null;
        try {
            nF = new detalleActivo(usuario, c6);
        } catch (IOException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ChecksumException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FormatException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        }
        nF.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        detalleActivo nF = null;
        try {
            nF = new detalleActivo(usuario, c7);
        } catch (IOException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ChecksumException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FormatException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        }
        nF.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        detalleActivo nF = null;
        try {
            nF = new detalleActivo(usuario, c8);
        } catch (IOException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ChecksumException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FormatException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        }
        nF.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        detalleActivo nF = null;
        try {
            nF = new detalleActivo(usuario, c9);
        } catch (IOException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ChecksumException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FormatException ex) {
            Logger.getLogger(Activos.class.getName()).log(Level.SEVERE, null, ex);
        }
        nF.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn10ActionPerformed

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
            java.util.logging.Logger.getLogger(Activos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Activos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Activos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Activos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Activos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
