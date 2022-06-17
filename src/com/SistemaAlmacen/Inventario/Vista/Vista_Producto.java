package com.SistemaAlmacen.Inventario.Vista;

import static com.SistemaAlmacen.Configuracion.Vista.Vista_Usuario.tblUsuarios;
import com.SistemaAlmacen.General.Utiles.ModalAdvertencia;
import com.SistemaAlmacen.General.Utiles.ModalError;
import com.SistemaAlmacen.General.Utiles.ModalListo;
import com.SistemaAlmacen.General.Utiles.Tabla;
import com.SistemaAlmacen.Inventario.BO.ProductoBO;
import com.SistemaAlmacen.Inventario.Entidad.Producto;
import java.awt.Color;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.table.DefaultTableModel;


public class Vista_Producto extends javax.swing.JPanel {

    
    ProductoBO prodBO;
    ArrayList<Producto> arrProducto;
    DefaultTableModel modelo;
    Tabla llenar_tabla= new Tabla();      
    JFrame paterframe;
    public Vista_Producto(JFrame frame) {
        prodBO = new ProductoBO();
        this.arrProducto = new ArrayList<>();
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
        
        this.arrProducto = prodBO.listarProducto();

        //cargarTabla();
        
        llenar_tabla.mostrar_tabla(tblProducto, getLista_Producto(), getTitulo_Producto());
        editarColumnas();
    }
    
   void editarColumnas(){
        tblProducto.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblProducto.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblProducto.getColumnModel().getColumn(6).setPreferredWidth(64);
        tblProducto.getColumnModel().getColumn(8).setPreferredWidth(30);
        tblProducto.getColumnModel().getColumn(9).setPreferredWidth(30);
    }
    
    public Object[] getTitulo_Producto(){
        Object result[] = new Object[10];
        result[0] = "N°";
        result[1] = "Código";
        result[2] = "Nombre";
        result[3] = "Descripción";
        result[4] = "Precio";
        result[5] = "Stock";
        result[6] = "Categoría";
        result[7] = "Ubicación";
        result[8] = "";
        result[9] = "";
        return result;
    }
    public Object[][] getLista_Producto(){
        Object[][] result = new Object[this.arrProducto.size()][10];
        int indice =0;
        for(Producto prod : this.arrProducto){
            if(prod != null){
                result[indice][0] = String.valueOf((indice+1));
                result[indice][1] = String.valueOf(prod.getIdProducto());
                result[indice][2] = prod.getNombre();
                result[indice][3] = prod.getDescripcion();
                result[indice][4] = prod.getPrecio();
                result[indice][5] = prod.getStock();
                result[indice][6] = prod.getCategoria();
                result[indice][7] = prod.getUbicacion();
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
                
                result[indice][8] = btneditar;
                result[indice][9] = btneliminar;
                
                indice++; 
            }
        }
        Object[][] result_final=new Object[indice][10];
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
        tblProducto = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscarProducto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(710, 490));
        setPreferredSize(new java.awt.Dimension(710, 490));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCabeceraConfiguracion.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("PRODUCTO");

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

        tblProducto.setBackground(new java.awt.Color(204, 204, 255));
        tblProducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblProducto.setForeground(new java.awt.Color(0, 102, 255));
        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblProducto.setSelectionBackground(new java.awt.Color(255, 255, 153));
        tblProducto.setSelectionForeground(new java.awt.Color(0, 102, 102));
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducto);

        pnlUsuarioConfiguracion.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 95, 630, 282));

        jSeparator1.setBackground(new java.awt.Color(0, 51, 204));
        pnlUsuarioConfiguracion.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 620, 15));

        txtBuscarProducto.setBorder(null);
        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
        });
        pnlUsuarioConfiguracion.add(txtBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 590, 30));

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

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        int column = tblProducto.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblProducto.getRowHeight();
        if(row <tblProducto.getRowCount() && row >= 0 && column<tblProducto.getColumnCount() && column>=0){
            Object objeto = tblProducto.getValueAt(row,column);
            if(objeto instanceof JButton){
                ((JButton)objeto).doClick();
                JButton bot = (JButton) objeto;
                int filaselecciona = tblProducto.getSelectedRow();
                
                if(bot.getName().equals("edit")){ 
                    if(filaselecciona>=0){
                        int id=Integer.valueOf((String)tblProducto.getValueAt(filaselecciona, 1));
                        System.out.println("EL codigo:" + id);
                        
                        Vista_EditarProducto viewEditProducto = new Vista_EditarProducto(prodBO.obtenerProducto(id));
                        viewEditProducto.setVisible(true);
                        viewEditProducto.setLocationRelativeTo(null);
                        
                    }
                }else if(bot.getName().equals("delete")){
                    int id =Integer.valueOf((String)tblProducto.getValueAt(filaselecciona, 1));
                    ModalAdvertencia advertencia = new ModalAdvertencia(paterframe, true);
                    
                    if(advertencia.confirm == 1){
                        //eliminar la variable condición y colocar en el if tu medoto a con el objeto a devolver similar a lo comentado
                        if(prodBO.eliminarProducto(id)){
                            /*retornar un arreglo de los elementos que pide la vista*/
                            arrProducto = prodBO.listarProducto();
                            
                            llenar_tabla.mostrar_tabla(tblProducto, getLista_Producto(), getTitulo_Producto());
                            editarColumnas();
                            ModalListo listo = new ModalListo(paterframe, true, "Producto Eliminada");
                        
                        }else{
                            ModalError error = new ModalError(paterframe, true,"No se pudo Eliminar");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_tblProductoMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Vista_CrearProducto viewRegistrar = new Vista_CrearProducto();
        viewRegistrar.setVisible(true);
        viewRegistrar.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        arrProducto = prodBO.buscarProducto(txtBuscarProducto.getText());
        llenar_tabla.mostrar_tabla(tblProducto, getLista_Producto(), getTitulo_Producto());
        editarColumnas();
    }//GEN-LAST:event_txtBuscarProductoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlCabeceraConfiguracion;
    private javax.swing.JPanel pnlUsuarioConfiguracion;
    public static javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables
}
