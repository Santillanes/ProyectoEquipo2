package Proyecto;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicComboBoxUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santillanes
 */




public class CrearQR extends javax.swing.JFrame {
    String usuario;
    String nombre;
    /**
     * Creates new form CrearQR
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
    
    
    
    JTextField txtNomVis = new RoundJTextField(15);
    JTextField txtTelVis = new RoundJTextField(15);
    
    public CrearQR(String usu) {
        initComponents();
        
        jPanel1.add(txtNomVis);
        jPanel1.add(txtTelVis);
        
        txtNomVis.setVisible(true);
        txtNomVis.setBounds(47, 372, 320, 35);
        
        txtTelVis.setVisible(true);
        txtTelVis.setBounds(47, 470, 320, 35);
        
        
       
        
        /*String texto = "<html><body>El QR que est??s por generar tendr?? <br> un solo uso para entrar y salir <br> del fraccionamiento. </body></html>";
        lblCade.setText(texto);
        lblCade.setHorizontalAlignment(SwingConstants.CENTER);
        lblCade.setBounds(53, 154, 308, 81);*/
        
        setSize(414, 896);
        this.setLocationRelativeTo(null);
        
        btnGenerar.setBorder(new RoundedBorder(30));
        btnVolver.setBorder(new RoundedBorder(30));
        //cmbParentesco.setBorder(new RoundedBorder(30));
        
        usuario = usu;
        cmbParentesco.addItem("Elige...");
        cmbParentesco.addItem("Hijo");
        cmbParentesco.addItem("Hija");
        cmbParentesco.addItem("Padre");
        cmbParentesco.addItem("Madre");
        cmbParentesco.addItem("Abuelo");
        cmbParentesco.addItem("Abuela");
        cmbParentesco.addItem("Tio");
        cmbParentesco.addItem("Tia");
        cmbParentesco.addItem("Hermano");
        cmbParentesco.addItem("Hermana");
        cmbParentesco.addItem("Otro");
        
        
        
        txtTelVis.addKeyListener(new KeyListener(){

            public void keyTyped(KeyEvent e){
                if (txtTelVis.getText().length()== 10)
                    e.consume();
            }

            public void keyPressed(KeyEvent arg0) {
            }

            public void keyReleased(KeyEvent arg0) {
            }
        });
        
    }
    
    private CrearQR() {
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
        btnGenerar = new javax.swing.JButton();
        cmbParentesco = new javax.swing.JComboBox<>();
        btnVolver = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCade = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCade1 = new javax.swing.JLabel();
        lblCade2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        btnGenerar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerar.setText("Generar QR");
        btnGenerar.setContentAreaFilled(false);
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerar);
        btnGenerar.setBounds(129, 696, 156, 45);

        jPanel1.add(cmbParentesco);
        cmbParentesco.setBounds(47, 569, 320, 35);

        btnVolver.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Salir");
        btnVolver.setContentAreaFilled(false);
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver);
        btnVolver.setBounds(151, 772, 113, 33);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tel??fono del visitante:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(47, 437, 270, 23);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Parentesco del visitante:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(53, 536, 290, 23);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre del visitante:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(47, 338, 280, 23);

        lblCade.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lblCade.setForeground(new java.awt.Color(255, 255, 255));
        lblCade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCade.setText("del fraccionamiento.");
        lblCade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblCade);
        lblCade.setBounds(117, 210, 180, 23);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Crear QR");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(119, 71, 176, 52);

        lblCade1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lblCade1.setForeground(new java.awt.Color(255, 255, 255));
        lblCade1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCade1.setText("El QR que est??s por generar tendr??");
        lblCade1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblCade1);
        lblCade1.setBounds(53, 154, 308, 23);

        lblCade2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lblCade2.setForeground(new java.awt.Color(255, 255, 255));
        lblCade2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCade2.setText("un solo uso para entrar y salir");
        lblCade2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblCade2);
        lblCade2.setBounds(77, 182, 260, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-2, -1, 420, 900);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo 414x896 3.0.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 410, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
        Pantalla2 nF = new Pantalla2(usuario);
        nF.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnVolverActionPerformed

          
    
    
    
    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        String otro = "vacio";
        if (cmbParentesco.getSelectedItem() == "Otro") {
            otro = JOptionPane.showInputDialog("??Qu?? eres del residente?");
            if (otro.length() != 0){
                cmbParentesco.addItem(otro);
                cmbParentesco.setSelectedItem(otro);
            }
        }
        if (txtNomVis.getText()!="" && cmbParentesco.getSelectedItem() != "Elige..." && txtTelVis.getText()!="") {
            try {
                String code = "";
                for (int i = 1; i <= 10; i++) {
                    int num = (int)((Math.random()*9)+1);
                    code += num;
                }
                System.out.println("code = " + code);
                //String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                LocalDateTime gene = LocalDateTime.now();
                LocalDateTime expira = gene.plusDays(1);
                
                String cont = code
                        + "\n"+txtNomVis.getText()
                        +"\n"+txtTelVis.getText()
                        +"\n"+cmbParentesco.getSelectedItem()
                        +"\n"+gene
                        +"\n"+expira;
                
                System.out.println("gene = " + gene);
                System.out.println("expira = " + expira);
                
                String content = cont;
                String filePath = "C:\\Users\\Santillanes\\Desktop\\Prog l??gica y funcional\\Equipo2_P1_U2_PLF\\Images\\";
                String fileType = "png";
                int size = 200;
                //UUID uuid = UUID.randomUUID();
                //String randomUUIDString = uuid.toString();
                QRCodeWriter qrcode = new QRCodeWriter();
                BitMatrix matrix = qrcode.encode(content, BarcodeFormat.QR_CODE, size, size);
                //File qrFile = new File(filePath + usuario + "_" + randomUUIDString + "." + fileType);
                File qrFile = new File(filePath + usuario + "_" + code + "." + fileType);
                //nombre = filePath + usuario + "_" + randomUUIDString + "." + fileType;
                nombre = filePath + usuario + "_" + code + "." + fileType;
                System.out.println("filePath = " + filePath);
                //System.out.println("randomUUIDString = " + randomUUIDString);
                System.out.println("randomUUIDString = " + code);
                System.out.println("fileType = " + fileType);
                int matrixWidth = matrix.getWidth();
                BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
                image.createGraphics();

                Graphics2D graphics = (Graphics2D) image.getGraphics();
                graphics.setColor(Color.WHITE);
                graphics.fillRect(0, 0, matrixWidth, matrixWidth);
                graphics.setColor(Color.BLACK);

                for (int b = 0; b < matrixWidth; b++) {
                    for (int j = 0; j < matrixWidth; j++) {
                        if (matrix.get(b, j)) {
                            graphics.fillRect(b, j, 1, 1);
                        }
                    }
                }
                ImageIO.write(image, fileType, qrFile);
                
                // CREACI??N DE ARCHIVO CON LOS QRs
                String dire = "C:\\Users\\Santillanes\\Desktop\\Prog l??gica y funcional\\Equipo2_P1_U2_PLF\\DataBases\\"+usuario+"QRsDataBase";
                if (new File(dire).exists()) {
                    ObjectInputStream tra = new ObjectInputStream(new FileInputStream(dire));
                    Object con = tra.readObject();
                    ObjectOutputStream guar = new ObjectOutputStream(new FileOutputStream(dire));
                    guar.writeObject(con+"|"+usuario + "_" + code + "." + fileType);
                }else{
                    ObjectOutputStream guar = new ObjectOutputStream(new FileOutputStream(dire));
                    guar.writeObject(usuario + "_" + code + "." + fileType);
                }
                
                ObjectInputStream tra = new ObjectInputStream(new FileInputStream(dire));
                System.out.println("Archivo = " + tra.readObject());
                
            } catch (WriterException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CrearQR.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ExitoQR nF = new ExitoQR(usuario, nombre);
            nF.setVisible(true);
            this.dispose();
            
        }else{
            JOptionPane.showMessageDialog(null, "Llene todos los campos.");
        }
        
    }//GEN-LAST:event_btnGenerarActionPerformed

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
            java.util.logging.Logger.getLogger(CrearQR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearQR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearQR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearQR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearQR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbParentesco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCade;
    private javax.swing.JLabel lblCade1;
    private javax.swing.JLabel lblCade2;
    // End of variables declaration//GEN-END:variables
}
