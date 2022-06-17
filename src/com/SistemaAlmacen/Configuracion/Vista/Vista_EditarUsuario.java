package com.SistemaAlmacen.Configuracion.Vista;


import com.SistemaAlmacen.Configuracion.BO.Tipo_usuarioBO;
import com.SistemaAlmacen.Configuracion.BO.UsuarioBO;
import com.SistemaAlmacen.Configuracion.Entidad.Tipo_usuario;
import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import static com.SistemaAlmacen.Configuracion.Vista.Vista_Usuario.tblUsuarios;
import com.SistemaAlmacen.General.Utiles.ModalError;
import com.SistemaAlmacen.General.Utiles.ModalListo;
import com.SistemaAlmacen.General.Utiles.Tabla;
import com.SistemaAlmacen.General.Vista.Vista_MenuPrincipal_Admin;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Vista_EditarUsuario extends javax.swing.JFrame {
    int cod;
    Usuario usuario;
    UsuarioBO userbo;
    int xMouse;
    int yMouse;
    
    DefaultTableModel modelo;
    ArrayList<Usuario> arrUsuario;
    Tipo_usuarioBO tp_userbo = new Tipo_usuarioBO();
    
    Tabla llenar_tabla = new Tabla();
    
    //Usuario usuario;
    
    public Vista_EditarUsuario(Usuario usuario) {
        initComponents();
        this.userbo = new UsuarioBO();
        this.arrUsuario = new ArrayList<>();
        tp_userbo.listaComboTipoUsuario(cboTipoUsuario);
        
        cod = usuario.getId_usuario();
        System.out.println(usuario.getNombre());
        txtNombre.setText(usuario.getNombre());
        txtApellidoP.setText(usuario.getApelliP());
        txtApellidoM.setText(usuario.getApellim());
        txtTelef.setText(usuario.getTelefono());
        txtEmail.setText(usuario.getEmail());
        txtDni.setText(usuario.getDni());
        txtUsuario.setText(usuario.getUser_nombre());
        jpassContra.setText(usuario.getContra());
        System.out.println(usuario.getT_user().getNombre());
        cboTipoUsuario.setSelectedItem(usuario.getT_user().getNombre());

        
    }
    
    public Object[] getTitulo_Usuario(){
        Object result[] = new Object[9];
        result[0] = "N°";
        result[1] = "Código";
        result[2] = "Nombre";
        result[3] = "Apellido P.";
        result[4] = "Apellido M.";
        result[5] = "Rol";
        result[6] = "Dni";
        result[7] = "Editar";
        result[8] = "Eliminar";
        return result;
    
    }
    public Object[][] getLista_Usuarios(){
       Object[][] result = new Object[this.arrUsuario.size()][9];
        int indice =0;
        for(Usuario usu : this.arrUsuario){
            if(usu != null){
                result[indice][0] = String.valueOf((indice+1));
                result[indice][1] = String.valueOf(usu.getId_usuario());
                result[indice][2] = usu.getNombre();
                result[indice][3] = usu.getApelliP();
                result[indice][4] = usu.getApellim();
                result[indice][5] = usu.getT_user().getNombre();
                result[indice][6] = usu.getDni();

                //Boton Editar Componentes
                JButton btneditar = new JButton();
                btneditar.setName("edit");
                btneditar.setSize(20, 20);
                btneditar.setAlignmentX(5);
                btneditar.setAlignmentY(5);
                btneditar.setBackground(new Color(61, 199, 67));
                ImageIcon lol=new ImageIcon(getClass().getResource("../../imagen/editar.png"));
                ImageIcon imag=new ImageIcon(lol.getImage().getScaledInstance(btneditar.getWidth(), btneditar.getHeight(), Image.SCALE_DEFAULT));
                btneditar.setIcon(imag);
                //Boton Eliminar Componentes
                JButton btneliminar = new JButton();
                btneliminar.setName("delete");
                btneliminar.setSize(20, 20);
                btneliminar.setAlignmentX(5);
                btneliminar.setAlignmentY(5);
                btneliminar.setBackground(new Color(255, 0, 51));
                ImageIcon lol1=new ImageIcon(getClass().getResource("../../imagen/eliminar.png"));
                ImageIcon ima=new ImageIcon(lol1.getImage().getScaledInstance(btneliminar.getWidth(), btneliminar.getHeight(), Image.SCALE_DEFAULT));
                btneliminar.setIcon(ima);
                /*
                btneditar.setCursor(new Cursor(getCursor().HAND_CURSOR));
                btneliminar.setCursor(new Cursor(getCursor().HAND_CURSOR));
                */
                result[indice][7] = btneditar;
                result[indice][8] = btneliminar;
                
                indice++; 
            }
        }
        Object[][] result_final=new Object[indice][9];
        for(int i=0;i<indice;i++){
            result_final[i]=result[i];
        }
        return result_final;
    } 

    
    void editarColumnas(){
        tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblUsuarios.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblUsuarios.getColumnModel().getColumn(6).setPreferredWidth(64);
        tblUsuarios.getColumnModel().getColumn(7).setPreferredWidth(30);
        tblUsuarios.getColumnModel().getColumn(8).setPreferredWidth(30);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cboTipoUsuario = new javax.swing.JComboBox<>();
        pnlMovimiento = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtDni = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtTelef = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtEmail = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtUsuario = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jpassContra = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 530));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 530));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("EDITAR USUARIO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 34, 170, 23));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Nombres");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 85, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Apellido Paterno");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 126, 292, 10));

        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 105, 292, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Apellido Materno");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 182, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Dni");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 222, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Teléfono");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 262, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("E-mail");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 302, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Usuario");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 342, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Constraseña");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 382, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(73, 97, 163));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 75, 31));

        btnCancelar.setBackground(new java.awt.Color(188, 76, 76));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 75, 31));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Tipo de Usuario");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 422, -1, -1));

        cboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion el Tipo de Usuario", "Item 2", "Item 3", "Item 4" }));
        cboTipoUsuario.setBorder(null);
        jPanel1.add(cboTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 442, 292, 30));

        pnlMovimiento.setBackground(new java.awt.Color(255, 255, 255));
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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMovimientoLayout.setVerticalGroup(
            pnlMovimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel1.add(pnlMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 345, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 292, 10));

        txtApellidoP.setBorder(null);
        jPanel1.add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 292, 20));

        txtApellidoM.setBorder(null);
        jPanel1.add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 292, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 292, 10));

        txtDni.setBorder(null);
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 292, 20));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 292, 10));

        txtTelef.setBorder(null);
        jPanel1.add(txtTelef, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 292, 20));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 292, 10));

        txtEmail.setBorder(null);
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 292, 20));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 292, 10));

        txtUsuario.setBorder(null);
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 292, 20));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 292, 10));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 292, 10));

        jpassContra.setBorder(null);
        jPanel1.add(jpassContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 290, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombre = txtNombre.getText();
        String apelliP = txtApellidoP.getText();
        String apellim = txtApellidoM.getText();
        String telefono = txtTelef.getText();
        String email = txtEmail.getText();
        String dni = txtDni.getText();
        String usua = txtUsuario.getText();
        String contra = jpassContra.getText();
        String tipo = cboTipoUsuario.getSelectedItem().toString();
        //verificar que el tipo sea un dato correcto
        usuario = new Usuario(cod,nombre, apelliP, apellim, telefono, email, dni, usua, contra,new Tipo_usuario(tipo));
        
        if(this.userbo.modificarUsuario(usuario)){
            //limpiarCampos
            if(cod==Vista_MenuPrincipal_Admin.usserlogeado.getId_usuario()){
                Vista_MenuPrincipal_Admin.lblUserSesion.setText(usuario.getNombre());
            }
            
            this.arrUsuario = userbo.listarUsuario();
            llenar_tabla.mostrar_tabla(Vista_Usuario.tblUsuarios, getLista_Usuarios(), getTitulo_Usuario()); 
            editarColumnas();
            ModalListo listo = new ModalListo(this, true, "Usuario Editado");
            //JOptionPane.showMessageDialog(null, "Usuario Editado Correctamente");
            dispose();
            
            
        }else{
            ModalError error = new ModalError(this, true,"No se pudo editar");
            //JOptionPane.showMessageDialog(null, "No se pudo editar al Usuario");
        }
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void pnlMovimientoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMovimientoMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_pnlMovimientoMouseDragged

    private void pnlMovimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMovimientoMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlMovimientoMousePressed

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        btnGuardar.setBackground(new Color(0, 66, 255));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        btnGuardar.setBackground(new Color(73, 97, 163));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
         btnCancelar.setBackground(new Color(188, 76, 76));
    }//GEN-LAST:event_btnCancelarMouseExited

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
            java.util.logging.Logger.getLogger(Vista_EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*   java.awt.EventQueue.invokeLater(new Runnable() {
        
            public void run() {
                new Vista_EditarUsuario(Usuario ).setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JComboBox<String> cboTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JPasswordField jpassContra;
    private javax.swing.JPanel pnlMovimiento;
    public javax.swing.JTextField txtApellidoM;
    public javax.swing.JTextField txtApellidoP;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelef;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
