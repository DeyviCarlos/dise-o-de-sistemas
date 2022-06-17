package com.SistemaAlmacen.Configuracion.Vista;


import com.SistemaAlmacen.Configuracion.BO.Tipo_usuarioBO;
import com.SistemaAlmacen.Configuracion.BO.UsuarioBO;
import com.SistemaAlmacen.Configuracion.Entidad.Tipo_usuario;
import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import com.SistemaAlmacen.General.Utiles.ModalAdvertencia;
import com.SistemaAlmacen.General.Utiles.ModalError;
import com.SistemaAlmacen.General.Utiles.ModalListo;
import com.SistemaAlmacen.General.Utiles.Tabla;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
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


public class Vista_TipoUsuario extends javax.swing.JPanel {

    Tipo_usuarioBO tpuserBO;
    ArrayList<Tipo_usuario> arrTipoUsuario;
    DefaultTableModel modelo;
    Tabla llenar_tabla= new Tabla();        
    JFrame paterframe;
    public Vista_TipoUsuario(JFrame frame) {
        tpuserBO = new Tipo_usuarioBO();
        this.arrTipoUsuario = new ArrayList<>();
        paterframe = frame;
        
        initComponents();
        
        setSize(710, 520);
        setLocation(0,0);
        
        btnBuscar.setSize(30, 30);
        ImageIcon lol6=new ImageIcon(getClass().getResource("../../imagen/buscar.png"));
        ImageIcon imag=new ImageIcon(lol6.getImage().getScaledInstance(btnBuscar.getWidth(), btnBuscar.getHeight(), Image.SCALE_DEFAULT));
        btnBuscar.setIcon(imag);
        
        
        btnAgregar.setSize(30, 30);
        ImageIcon lol=new ImageIcon(getClass().getResource("../../imagen/agregar1.png"));
        ImageIcon ima=new ImageIcon(lol.getImage().getScaledInstance(btnAgregar.getWidth(), btnAgregar.getHeight(), Image.SCALE_DEFAULT));
        btnAgregar.setIcon(ima);

        //devuelve una lista
        this.arrTipoUsuario = tpuserBO.listarTipoUsuario();
        
        llenar_tabla.mostrar_tabla(tblTipoUsuario, getLista_TipoUsuarios(), getTitulo_TipoUsuario());
        editarColumnas();
    
    }
    
    //define el largo de cada celda
    void editarColumnas(){
        tblTipoUsuario.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblTipoUsuario.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblTipoUsuario.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblTipoUsuario.getColumnModel().getColumn(4).setPreferredWidth(30);
    }
    
    public Object[] getTitulo_TipoUsuario(){
        Object result[] = new Object[5];
        result[0] = "N°";
        result[1] = "Código";
        result[2] = "Nombre";
        result[3] = "";
        result[4] = "";
        return result;
    }
    public Object[][] getLista_TipoUsuarios(){
        Object[][] result = new Object[this.arrTipoUsuario.size()][5];
        int indice =0;
        for(Tipo_usuario tp_usu : this.arrTipoUsuario){
            if(tp_usu != null){
                result[indice][0] = String.valueOf((indice+1));
                result[indice][1] = String.valueOf(tp_usu.getTipouser());
                result[indice][2] = tp_usu.getNombre();

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

                result[indice][3] = btneditar;
                result[indice][4] = btneliminar;
                
                indice++; 
            }
        }
        Object[][] result_final=new Object[indice][5];
        for(int i=0;i<indice;i++){
            result_final[i]=result[i];
        }
        return result_final;
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCabeceraConfiguracion = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        pnlUsuarioConfiguracion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTipoUsuario = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscarTipoUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(710, 490));
        setPreferredSize(new java.awt.Dimension(710, 490));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCabeceraConfiguracion.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("TIPO USUARIO");

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
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(507, Short.MAX_VALUE))
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

        tblTipoUsuario.setBackground(new java.awt.Color(204, 204, 255));
        tblTipoUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblTipoUsuario.setForeground(new java.awt.Color(0, 102, 255));
        tblTipoUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblTipoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblTipoUsuario.setSelectionBackground(new java.awt.Color(255, 255, 153));
        tblTipoUsuario.setSelectionForeground(new java.awt.Color(0, 102, 102));
        tblTipoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTipoUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTipoUsuario);

        pnlUsuarioConfiguracion.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 95, 630, 282));

        jSeparator1.setBackground(new java.awt.Color(0, 51, 204));
        pnlUsuarioConfiguracion.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 620, 15));

        txtBuscarTipoUsuario.setBorder(null);
        txtBuscarTipoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarTipoUsuarioKeyReleased(evt);
            }
        });
        pnlUsuarioConfiguracion.add(txtBuscarTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 590, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Buscar");
        pnlUsuarioConfiguracion.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 70, 19));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlUsuarioConfiguracion.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 30, 30));

        add(pnlUsuarioConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, 720, 430));
    }// </editor-fold>//GEN-END:initComponents

    private void tblTipoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoUsuarioMouseClicked
        int column = tblTipoUsuario.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblTipoUsuario.getRowHeight();
        
        if(row <tblTipoUsuario.getRowCount() && row >= 0 && column<tblTipoUsuario.getColumnCount() && column>=0){
            Object objeto = tblTipoUsuario.getValueAt(row,column);
            if(objeto instanceof JButton){
                ((JButton)objeto).doClick();
                JButton bot = (JButton) objeto;
                
                int filaselecciona = tblTipoUsuario.getSelectedRow();
                if(bot.getName().equals("edit")){ 
                    if(filaselecciona>=0){
                        int id=Integer.valueOf((String)tblTipoUsuario.getValueAt(filaselecciona, 1));
                        
                        Vista_EditarTipoUsuario viewEditUsuario = new Vista_EditarTipoUsuario(tpuserBO.obtenerTipoUsuario(id));
                        viewEditUsuario.setVisible(true);
                        viewEditUsuario.setLocationRelativeTo(null);
                        
                    }
                }else if(bot.getName().equals("delete")){
                    int id =Integer.valueOf((String)tblTipoUsuario.getValueAt(filaselecciona, 1));
                    ModalAdvertencia advertencia = new ModalAdvertencia(paterframe, true);
                    
                    if(advertencia.confirm == 1){
                        //eliminar la variable condición y colocar en el if tu medoto a con el objeto a devolver similar a lo comentado
                        if(tpuserBO.eliminarTipoUsuario(id)){
                        
                            /*retornar un arreglo de los elementos que pide la vista   */
                            arrTipoUsuario =   tpuserBO.listarTipoUsuario();
                         
                            llenar_tabla.mostrar_tabla(tblTipoUsuario, getLista_TipoUsuarios(), getTitulo_TipoUsuario());
                            editarColumnas();
                            ModalListo listo = new ModalListo(paterframe, true, "Tipo de Usuario Eliminado");
                        
                        }else{
                            ModalError error = new ModalError(paterframe, true,"No se pudo Eliminar");
                        }
                    }
                }
            }
            
        }
        
        
        
        
    }//GEN-LAST:event_tblTipoUsuarioMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Vista_RegistroTipoUsuario viewRegistrar = new Vista_RegistroTipoUsuario();
        viewRegistrar.setVisible(true);
        viewRegistrar.setSize(350, 240);
        viewRegistrar.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarTipoUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarTipoUsuarioKeyReleased
        arrTipoUsuario = tpuserBO.buscarTipoUsuario(txtBuscarTipoUsuario.getText());
        llenar_tabla.mostrar_tabla(tblTipoUsuario, getLista_TipoUsuarios(), getTitulo_TipoUsuario());
        editarColumnas();
    }//GEN-LAST:event_txtBuscarTipoUsuarioKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        arrTipoUsuario = tpuserBO.buscarTipoUsuario(txtBuscarTipoUsuario.getText());
        llenar_tabla.mostrar_tabla(tblTipoUsuario, getLista_TipoUsuarios(), getTitulo_TipoUsuario());
        editarColumnas();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlCabeceraConfiguracion;
    private javax.swing.JPanel pnlUsuarioConfiguracion;
    public static javax.swing.JTable tblTipoUsuario;
    private javax.swing.JTextField txtBuscarTipoUsuario;
    // End of variables declaration//GEN-END:variables
}
