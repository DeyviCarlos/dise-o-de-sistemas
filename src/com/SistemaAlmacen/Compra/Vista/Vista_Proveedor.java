package com.SistemaAlmacen.Compra.Vista;


import com.SistemaAlmacen.Compra.BO.ProveedorBO;
import com.SistemaAlmacen.Compra.Entidad.Proveedor;
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


public class Vista_Proveedor extends javax.swing.JPanel {

    ProveedorBO provBO;
    ArrayList<Proveedor> arrProvedor;
    DefaultTableModel modelo;
    Tabla llenar_tabla= new Tabla();        
    JFrame paterframe;
    public Vista_Proveedor(JFrame frame) {
        provBO = new ProveedorBO();
        this.arrProvedor = new ArrayList<>();
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
       this.arrProvedor = provBO.listarProveedor();
        
        llenar_tabla.mostrar_tabla(tblProveedor, getLista_Proveedor(), getTitulo_Proveedor());
        editarColumnas();
    
    }
    
    //define el largo de cada celda
    void editarColumnas(){
        tblProveedor.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblProveedor.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblProveedor.getColumnModel().getColumn(5).setPreferredWidth(30);
        tblProveedor.getColumnModel().getColumn(6).setPreferredWidth(30);
    }
    
    public Object[] getTitulo_Proveedor(){
        Object result[] = new Object[7];
        result[0] = "N°";
        result[1] = "Código";
        result[2] = "Razón Social";
        result[3] = "Ruc";
        result[4] = "Dirección";
        result[5] = "";
        result[6] = "";
        return result;
    }
    public Object[][] getLista_Proveedor(){
        Object[][] result = new Object[this.arrProvedor.size()][7];
        int indice =0;
        for(Proveedor proved : this.arrProvedor){
            if(proved != null){
                result[indice][0] = String.valueOf((indice+1));
                result[indice][1] = String.valueOf(proved.getIdProveedor());
                result[indice][2] = proved.getRazon_Social();
                result[indice][3] = proved.getRuc();
                result[indice][4] = proved.getDireccion();

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

                //btneditar.setCursor(new Cursor(getCursor().HAND_CURSOR));
                //btneliminar.setCursor(new Cursor(getCursor().HAND_CURSOR));
                
                result[indice][5] = btneditar;
                result[indice][6] = btneliminar;
                
                indice++; 
            }
        }
        Object[][] result_final=new Object[indice][7];
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
        tblProveedor = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscarProveedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(710, 490));
        setPreferredSize(new java.awt.Dimension(710, 490));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCabeceraConfiguracion.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("PROVEEDOR");

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
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(493, Short.MAX_VALUE))
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

        tblProveedor.setBackground(new java.awt.Color(204, 204, 255));
        tblProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblProveedor.setForeground(new java.awt.Color(0, 102, 255));
        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblProveedor.setSelectionBackground(new java.awt.Color(255, 255, 153));
        tblProveedor.setSelectionForeground(new java.awt.Color(0, 102, 102));
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedor);

        pnlUsuarioConfiguracion.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 95, 630, 282));

        jSeparator1.setBackground(new java.awt.Color(0, 51, 204));
        pnlUsuarioConfiguracion.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 620, 15));

        txtBuscarProveedor.setBorder(null);
        txtBuscarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProveedorKeyReleased(evt);
            }
        });
        pnlUsuarioConfiguracion.add(txtBuscarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 590, 30));

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

    private void tblProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMouseClicked
        int column = tblProveedor.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblProveedor.getRowHeight();
        
        if(row <tblProveedor.getRowCount() && row >= 0 && column<tblProveedor.getColumnCount() && column>=0){
            Object objeto = tblProveedor.getValueAt(row,column);
            if(objeto instanceof JButton){
                ((JButton)objeto).doClick();
                JButton bot = (JButton) objeto;
                int filaselecciona = tblProveedor.getSelectedRow();
                if(bot.getName().equals("edit")){ 
                    if(filaselecciona>=0){
                        int id=Integer.valueOf((String)tblProveedor.getValueAt(filaselecciona, 1));
                        
                        Vista_EditarProveedor viewEditUsuario = new Vista_EditarProveedor(provBO.obtenerProveedor(id));
                        viewEditUsuario.setVisible(true);
                        viewEditUsuario.setLocationRelativeTo(null);
                        
                    }
                }else if(bot.getName().equals("delete")){
                    int id =Integer.valueOf((String)tblProveedor.getValueAt(filaselecciona, 1));
                    ModalAdvertencia advertencia = new ModalAdvertencia(paterframe, true);
                    
                    if(advertencia.confirm == 1){
                        //eliminar la variable condición y colocar en el if tu medoto a con el objeto a devolver similar a lo comentado
                        if(provBO.eliminarProveedor(id)){
                            /*retornar un arreglo de los elementos que pide la vista*/
                            arrProvedor = provBO.listarProveedor();
                            
                            llenar_tabla.mostrar_tabla(tblProveedor, getLista_Proveedor(), getTitulo_Proveedor());
                            editarColumnas();
                            ModalListo listo = new ModalListo(paterframe, true, "Proveedor Eliminada");
                        
                        }else{
                            ModalError error = new ModalError(paterframe, true,"No se pudo Eliminar");
                        }
                    }
                }
            }
            
        }
        
        
        
        
    }//GEN-LAST:event_tblProveedorMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Vista_CrearProveedor viewRegistrar = new Vista_CrearProveedor();
        viewRegistrar.setVisible(true);
        //viewRegistrar.setSize(350, 240);
        viewRegistrar.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProveedorKeyReleased
        arrProvedor = provBO.buscarProveedor(txtBuscarProveedor.getText());
        llenar_tabla.mostrar_tabla(tblProveedor, getLista_Proveedor(), getTitulo_Proveedor());
        editarColumnas();
    }//GEN-LAST:event_txtBuscarProveedorKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlCabeceraConfiguracion;
    private javax.swing.JPanel pnlUsuarioConfiguracion;
    public static javax.swing.JTable tblProveedor;
    private javax.swing.JTextField txtBuscarProveedor;
    // End of variables declaration//GEN-END:variables
}
