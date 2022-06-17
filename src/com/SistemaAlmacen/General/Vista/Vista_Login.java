package com.SistemaAlmacen.General.Vista;

//import com.SistemaGestionAlmacenv2.Vista.*;
//import com.SistemaGestionAlmacenv2.BO.LoginBO;
//import com.SistemaGestionAlmacenv2.Entidad.Login;
//import com.SistemaGestionAlmacenv2.Entidad.Usuario;
import com.SistemaAlmacen.General.BO.LoginBO;
import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import com.SistemaAlmacen.General.Entidad.Login;
import com.SistemaAlmacen.General.Utiles.ModalError;
import com.placeholder.PlaceHolder;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class Vista_Login extends javax.swing.JFrame {

    Login log;
    LoginBO logbo;
    int xMouse;
    int yMouse;
    
    PlaceHolder pl;
    
    
    public Vista_Login() {
        initComponents();
        logbo = new LoginBO();

        ImageIcon lol=new ImageIcon(getClass().getResource("../../imagen/fondo.jpg"));
        ImageIcon titulo=new ImageIcon(lol.getImage().getScaledInstance(this.lbFondo.getWidth(), this.lbFondo.getHeight(), Image.SCALE_DEFAULT));
        this.lbFondo.setIcon(titulo);
        
        ImageIcon lol4=new ImageIcon(getClass().getResource("../../imagen/logo.jpg"));
        ImageIcon logo=new ImageIcon(lol4.getImage().getScaledInstance(this.lbTitulo.getWidth(), this.lbTitulo.getHeight(), Image.SCALE_DEFAULT));
        this.lbTitulo.setIcon(logo);

        ImageIcon lol1=new ImageIcon(getClass().getResource("../../imagen/user.png"));
        ImageIcon usuario=new ImageIcon(lol1.getImage().getScaledInstance(this.lbUsuario.getWidth(), this.lbUsuario.getHeight(), Image.SCALE_DEFAULT));
        this.lbUsuario.setIcon(usuario);

        ImageIcon lol2=new ImageIcon(getClass().getResource("../../imagen/contra.png"));
        ImageIcon contraseña=new ImageIcon(lol2.getImage().getScaledInstance(this.lbContra.getWidth(), this.lbContra.getHeight(), Image.SCALE_DEFAULT));
        this.lbContra.setIcon(contraseña);
        
        
        pl = new PlaceHolder(txtUser, "Usuario");
        pl = new PlaceHolder(jpassContra, "Contraseña");
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlExit = new javax.swing.JPanel();
        lbCerrar = new javax.swing.JLabel();
        lbFondo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbUsuario = new javax.swing.JLabel();
        lbContra = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtUser = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JButton();
        lbTitulo = new javax.swing.JLabel();
        jpassContra = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        pnlMovimiento = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlExit.setBackground(new java.awt.Color(102, 102, 102));

        lbCerrar.setBackground(new java.awt.Color(255, 255, 255));
        lbCerrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lbCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCerrar.setText("X");
        lbCerrar.setAlignmentX(0.5F);
        lbCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCerrarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCerrarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlExitLayout = new javax.swing.GroupLayout(pnlExit);
        pnlExit.setLayout(pnlExitLayout);
        pnlExitLayout.setHorizontalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        pnlExitLayout.setVerticalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
        );

        jPanel1.add(pnlExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 30, 30));

        lbFondo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 0, 600, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(lbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 20, 20));
        jPanel2.add(lbContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 20, 20));

        jSeparator1.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 284, 193, 10));

        txtUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtUser.setBorder(null);
        jPanel2.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 254, 193, 30));

        btnIniciarSesion.setBackground(new java.awt.Color(0, 102, 102));
        btnIniciarSesion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseExited(evt);
            }
        });
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        btnIniciarSesion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnIniciarSesionKeyPressed(evt);
            }
        });
        jPanel2.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 395, 193, 31));

        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setText("Sistema de Gestión de Almacén");
        jPanel2.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 106, 225, 50));

        jpassContra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpassContra.setBorder(null);
        jpassContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpassContraKeyPressed(evt);
            }
        });
        jPanel2.add(jpassContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 321, 193, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator3.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 351, 193, 10));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 480));

        pnlMovimiento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlMovimientoMouseDragged(evt);
            }
        });
        pnlMovimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlMovimientoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlMovimientoLayout = new javax.swing.GroupLayout(pnlMovimiento);
        pnlMovimiento.setLayout(pnlMovimientoLayout);
        pnlMovimientoLayout.setHorizontalGroup(
            pnlMovimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        pnlMovimientoLayout.setVerticalGroup(
            pnlMovimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(pnlMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseClicked
        System.exit(0);        
    }//GEN-LAST:event_lbCerrarMouseClicked

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        String user;
        String pass;
        user = txtUser.getText();
        pass = jpassContra.getText();
        
        log = new Login(user, pass);
        Usuario usuario = logbo.iniciarSesion(log);
        if(usuario != null){
            Vista_MenuPrincipal_Admin viewMPAdmin = new Vista_MenuPrincipal_Admin(usuario);
            viewMPAdmin.setVisible(true);
            viewMPAdmin.setLocationRelativeTo(null);
            this.dispose();
        }else{
            ModalError moderr = new ModalError(this, true, "Digite correctamente los campos");
        } 

    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void lbCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMousePressed

    }//GEN-LAST:event_lbCerrarMousePressed

    private void lbCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseEntered
        pnlExit.setBackground(Color.red);
    }//GEN-LAST:event_lbCerrarMouseEntered

    private void lbCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseExited
        pnlExit.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_lbCerrarMouseExited

    private void btnIniciarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseEntered
        
        btnIniciarSesion.setBackground(new Color(51, 181, 54));
    }//GEN-LAST:event_btnIniciarSesionMouseEntered

    private void btnIniciarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseExited
        btnIniciarSesion.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_btnIniciarSesionMouseExited

    private void pnlMovimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMovimientoMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlMovimientoMousePressed

    private void pnlMovimientoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMovimientoMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_pnlMovimientoMouseDragged

    private void btnIniciarSesionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIniciarSesionKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String user;
            String pass;
            user = txtUser.getText();
            pass = jpassContra.getText();

            log = new Login(user, pass);
            Usuario usuario = logbo.iniciarSesion(log);
            if(usuario != null){
                Vista_MenuPrincipal_Admin viewMPAdmin = new Vista_MenuPrincipal_Admin(usuario);
                viewMPAdmin.setVisible(true);
                viewMPAdmin.setLocationRelativeTo(null);
                this.dispose();
            }else{
                ModalError moderr = new ModalError(this, true, "Digite correctamente los campos");
            } 
        }
    }//GEN-LAST:event_btnIniciarSesionKeyPressed

    private void jpassContraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpassContraKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String user;
            String pass;
            user = txtUser.getText();
            pass = jpassContra.getText();
            log = new Login(user, pass);
            Usuario usuario = logbo.iniciarSesion(log);
            if(usuario != null){
                Vista_MenuPrincipal_Admin viewMPAdmin = new Vista_MenuPrincipal_Admin(usuario);
                viewMPAdmin.setVisible(true);
                viewMPAdmin.setLocationRelativeTo(null);
                this.dispose();
            }else{
                ModalError moderr = new ModalError(this, true, "Digite correctamente los campos");
            } 
        }
    }//GEN-LAST:event_jpassContraKeyPressed

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
            java.util.logging.Logger.getLogger(Vista_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Vista_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnIniciarSesion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JPasswordField jpassContra;
    public javax.swing.JLabel lbCerrar;
    public javax.swing.JLabel lbContra;
    public javax.swing.JLabel lbFondo;
    public javax.swing.JLabel lbTitulo;
    public javax.swing.JLabel lbUsuario;
    public javax.swing.JPanel pnlExit;
    private javax.swing.JPanel pnlMovimiento;
    public javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
