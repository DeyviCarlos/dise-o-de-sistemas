package com.SistemaAlmacen.Configuracion.Vista;

import com.SistemaAlmacen.Configuracion.BO.Tipo_usuarioBO;
import com.SistemaAlmacen.Configuracion.BO.UsuarioBO;
import com.SistemaAlmacen.Configuracion.Entidad.Tipo_usuario;
import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import static com.SistemaAlmacen.Configuracion.Vista.Vista_Usuario.tblUsuarios;
import com.SistemaAlmacen.General.Utiles.ModalAdvertencia;
import com.SistemaAlmacen.General.Utiles.ModalError;
import com.SistemaAlmacen.General.Utiles.ModalListo;
import com.SistemaAlmacen.General.Utiles.Tabla;
import com.SistemaAlmacen.General.Vista.Vista_MenuPrincipal_Admin;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class Vista_Usuario extends javax.swing.JPanel {

    UsuarioBO userbo;
    ArrayList<Usuario> arrUsuario;
    DefaultTableModel modelo;
    Tabla llenar_tabla= new Tabla();      
    JFrame paterframe;
    
    public Vista_Usuario(JFrame frame) {
        userbo = new UsuarioBO();
        this.arrUsuario = new ArrayList<>();
        paterframe = frame;
        
        initComponents();
        
        setSize(710, 520);
        setLocation(0,0);
        
        btnBuscar.setSize(30, 30);
        ImageIcon lol6=new ImageIcon(getClass().getResource("../../imagen/buscar.jpg"));
        ImageIcon imag=new ImageIcon(lol6.getImage().getScaledInstance(btnBuscar.getWidth(), btnBuscar.getHeight(), Image.SCALE_DEFAULT));
        btnBuscar.setIcon(imag);

        btnAgregar.setSize(30, 30);
        ImageIcon lol=new ImageIcon(getClass().getResource("../../imagen/agregar1.png"));
        ImageIcon ima=new ImageIcon(lol.getImage().getScaledInstance(btnAgregar.getWidth(), btnAgregar.getHeight(), Image.SCALE_DEFAULT));
        btnAgregar.setIcon(ima);
        
        this.arrUsuario = userbo.listarUsuario();
        
        
        //cargarTabla();
        
        llenar_tabla.mostrar_tabla(tblUsuarios, getLista_Usuarios(), getTitulo_Usuario());
        editarColumnas();
    
    }
    
   void editarColumnas(){
        tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblUsuarios.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblUsuarios.getColumnModel().getColumn(6).setPreferredWidth(64);
        tblUsuarios.getColumnModel().getColumn(7).setPreferredWidth(30);
        tblUsuarios.getColumnModel().getColumn(8).setPreferredWidth(30);
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
        result[7] = "";
        result[8] = "";
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

                btneditar.setCursor(new Cursor(getCursor().HAND_CURSOR));
                btneditar.setVisible(true);
                //btneliminar.setCursor(new Cursor(getCursor().HAND_CURSOR));
                
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCabeceraConfiguracion = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        pnlUsuarioConfiguracion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscarUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(710, 490));
        setPreferredSize(new java.awt.Dimension(710, 490));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCabeceraConfiguracion.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("USUARIO");

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setBorder(null);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setFocusable(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCabeceraConfiguracionLayout = new javax.swing.GroupLayout(pnlCabeceraConfiguracion);
        pnlCabeceraConfiguracion.setLayout(pnlCabeceraConfiguracionLayout);
        pnlCabeceraConfiguracionLayout.setHorizontalGroup(
            pnlCabeceraConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraConfiguracionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(557, Short.MAX_VALUE))
        );
        pnlCabeceraConfiguracionLayout.setVerticalGroup(
            pnlCabeceraConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabeceraConfiguracionLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(pnlCabeceraConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        add(pnlCabeceraConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 70));

        pnlUsuarioConfiguracion.setBackground(new java.awt.Color(255, 255, 255));
        pnlUsuarioConfiguracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUsuarios.setBackground(new java.awt.Color(204, 204, 255));
        tblUsuarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblUsuarios.setForeground(new java.awt.Color(0, 102, 255));
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblUsuarios.setSelectionBackground(new java.awt.Color(255, 255, 153));
        tblUsuarios.setSelectionForeground(new java.awt.Color(0, 102, 102));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        pnlUsuarioConfiguracion.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 95, 630, 282));

        jSeparator1.setBackground(new java.awt.Color(0, 51, 204));
        pnlUsuarioConfiguracion.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 620, 15));

        txtBuscarUsuario.setBorder(null);
        txtBuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarUsuarioKeyReleased(evt);
            }
        });
        pnlUsuarioConfiguracion.add(txtBuscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 590, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Buscar");
        pnlUsuarioConfiguracion.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 70, 19));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlUsuarioConfiguracion.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 30, 30));

        add(pnlUsuarioConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, 720, 430));
    }// </editor-fold>//GEN-END:initComponents

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        //int fila = tbl.rowAtPoint(e.getPoint);
        //int columna = tbl.columnAtPoint(e.getPoint); 
        
        int column = tblUsuarios.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblUsuarios.getRowHeight();
        
        if(row <tblUsuarios.getRowCount() && row >= 0 && column<tblUsuarios.getColumnCount() && column>=0){
            Object objeto = tblUsuarios.getValueAt(row,column);
            if(objeto instanceof JButton){
                ((JButton)objeto).doClick();
                JButton bot = (JButton) objeto;
                int filaselecciona = tblUsuarios.getSelectedRow();
                
                if(bot.getName().equals("edit")){ 
                    if(filaselecciona>=0){
                        int id=Integer.valueOf((String)tblUsuarios.getValueAt(filaselecciona, 1));
                        
                        Vista_EditarUsuario viewEditUsuario = new Vista_EditarUsuario(userbo.obtenerUsuario(id));
                        viewEditUsuario.setVisible(true);
                        viewEditUsuario.setLocationRelativeTo(null);
                    }
                }else if(bot.getName().equals("delete")){
                    //JOptionPane.showConfirmDialog(bot, objeto)
                    int id =Integer.valueOf((String)tblUsuarios.getValueAt(filaselecciona, 1));
                    ModalAdvertencia advertencia = new ModalAdvertencia(paterframe, true);
                    
                    if(advertencia.confirm == 1){
                        if(userbo.eliminarUsuario(id)){
                        
                            arrUsuario = userbo.listarUsuario();
                            llenar_tabla.mostrar_tabla(tblUsuarios, getLista_Usuarios(), getTitulo_Usuario());
                            editarColumnas();
                            ModalListo listo = new ModalListo(paterframe, true, "Usuario Eliminado");
                            //JOptionPane.showMessageDialog(null, "Usuario Eliminado");
                        
                        }else{
                            ModalError error = new ModalError(paterframe, true,"No se pudo Eliminar");
                            //JOptionPane.showMessageDialog(null, "No se pudo Eliminar");
                        }
                    }
                }
            }
            
        }
        
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Vista_RegistroUsuario viewRegistrar = new Vista_RegistroUsuario();
        viewRegistrar.setVisible(true);
        viewRegistrar.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseEntered
        int column = tblUsuarios.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblUsuarios.getRowHeight();
        
        if(row <tblUsuarios.getRowCount() && row >= 0 && column<tblUsuarios.getColumnCount() && column>=0){
            Object objeto = tblUsuarios.getValueAt(row,column);
            if(column == 7){
               //objeto.
            }
            
            /*
            Object objeto = tblUsuarios.getValueAt(row,column);
            if(objeto instanceof JButton){
                ((JButton)objeto).doClick();
                JButton bot = (JButton) objeto;
                
                if(bot.getName().equals("edit")){ 
                    bot.setBackground(new Color(0, 0, 0));
                }else if(bot.getName().equals("delete")){

                }
            }*/
            
        }
    }//GEN-LAST:event_tblUsuariosMouseEntered

    private void tblUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseExited
        
    }//GEN-LAST:event_tblUsuariosMouseExited

    private void txtBuscarUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarUsuarioKeyReleased
 
        arrUsuario = userbo.buscarUsuario(txtBuscarUsuario.getText());
        llenar_tabla.mostrar_tabla(tblUsuarios, getLista_Usuarios(), getTitulo_Usuario());
        editarColumnas();

      
    }//GEN-LAST:event_txtBuscarUsuarioKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlCabeceraConfiguracion;
    private javax.swing.JPanel pnlUsuarioConfiguracion;
    public static javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtBuscarUsuario;
    // End of variables declaration//GEN-END:variables

    /*
    public Usuario obtenerUser(int i){ 
        for (Usuario usuario : arrUsuario) {
            if(usuario.getId_usuario() == i){
                return usuario;
            }
        }
        return null;
    }
    */

}
