package com.SistemaAlmacen.Compra.Vista;

import com.SistemaAlmacen.Compra.BO.CompraBO;
import com.SistemaAlmacen.Compra.BO.DetalleCompraBO;
import com.SistemaAlmacen.Compra.Entidad.Compra;
import com.SistemaAlmacen.Configuracion.Vista.*;
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


public class Vista_Compra extends javax.swing.JPanel {

    CompraBO compraBO;
    ArrayList<Compra> arrCompra;
    DefaultTableModel modelo;
    Tabla llenar_tabla= new Tabla();      
    JFrame paterframe;
    Usuario userlogeado;
    
    DetalleCompraBO detBO;
    
    public Vista_Compra(JFrame frame, Usuario usuario) {
        compraBO = new CompraBO();
        this.arrCompra = new ArrayList<>();
        paterframe = frame;
        userlogeado = usuario;
        detBO = new DetalleCompraBO();
        
        initComponents();
        llenar_tabla = new Tabla();
        
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
        
        this.arrCompra = compraBO.listarCompra();
        llenar_tabla.mostrar_tabla(tblCompra, getLista_Compra(), getTitulo_Compra());
        editarColumnas();
    
    }
    
   void editarColumnas(){
        tblCompra.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblCompra.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblCompra.getColumnModel().getColumn(6).setPreferredWidth(30);
        tblCompra.getColumnModel().getColumn(7).setPreferredWidth(30);
        //tblCompra.getColumnModel().getColumn(8).setPreferredWidth(30);
    }
    
    public Object[] getTitulo_Compra(){
        Object result[] = new Object[8];
        result[0] = "N°";
        result[1] = "Código";
        result[2] = "Fecha de Compra";
        result[3] = "Proveedor";
        result[4] = "Usuario";
        result[5] = "Precio Total";
        result[6] = "";
        result[7] = "";
        //result[8] = "";
        return result;
    }
    public Object[][] getLista_Compra(){
        Object[][] result = new Object[this.arrCompra.size()][8];
        int indice =0;
        for(Compra comp : this.arrCompra){
            if(comp != null){
                result[indice][0] = String.valueOf((indice+1));
                result[indice][1] = String.valueOf(comp.getId_compra());
                result[indice][2] = comp.getFecha_compra();
                result[indice][3] = comp.getProv().getRazon_Social();
                result[indice][4] = comp.getUsu().getNombre();
                result[indice][5] = comp.getPrecio_total();
                
                //boton detalle
                JButton btndetalle = new JButton();
                btndetalle.setName("detail");
                btndetalle.setSize(20, 20);
                btndetalle.setAlignmentX(5);
                btndetalle.setAlignmentY(5);
                btndetalle.setBackground(new Color(44, 21, 243));
                ImageIcon lol3=new ImageIcon(getClass().getResource("../../imagen/detalle.png"));
                ImageIcon ima1=new ImageIcon(lol3.getImage().getScaledInstance(btndetalle.getWidth(), btndetalle.getHeight(), Image.SCALE_DEFAULT));
                btndetalle.setIcon(ima1);
                //Boton Editar Componentes
                /*
                JButton btneditar = new JButton();
                btneditar.setName("edit");
                btneditar.setSize(20, 20);
                btneditar.setAlignmentX(5);
                btneditar.setAlignmentY(5);
                btneditar.setBackground(new Color(61, 199, 67));
                ImageIcon lol=new ImageIcon(getClass().getResource("../../imagen/editar.png"));
                ImageIcon imag=new ImageIcon(lol.getImage().getScaledInstance(btneditar.getWidth(), btneditar.getHeight(), Image.SCALE_DEFAULT));
                btneditar.setIcon(imag);
                */
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
                result[indice][6] = btndetalle;
                //result[indice][7] = btneditar;
                result[indice][7] = btneliminar;
                
                indice++; 
            }
        }
        Object[][] result_final=new Object[indice][8];
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
        tblCompra = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscarCompra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(710, 490));
        setPreferredSize(new java.awt.Dimension(710, 490));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCabeceraConfiguracion.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("COMPRA");

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

        tblCompra.setBackground(new java.awt.Color(204, 204, 255));
        tblCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblCompra.setForeground(new java.awt.Color(0, 102, 255));
        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblCompra.setSelectionBackground(new java.awt.Color(255, 255, 153));
        tblCompra.setSelectionForeground(new java.awt.Color(0, 102, 102));
        tblCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCompra);

        pnlUsuarioConfiguracion.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 95, 630, 282));

        jSeparator1.setBackground(new java.awt.Color(0, 51, 204));
        pnlUsuarioConfiguracion.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 620, 15));

        txtBuscarCompra.setBorder(null);
        txtBuscarCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarCompraKeyReleased(evt);
            }
        });
        pnlUsuarioConfiguracion.add(txtBuscarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 590, 30));

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

    private void tblCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCompraMouseClicked
        int column = tblCompra.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblCompra.getRowHeight();
        
        
        
        if(row <tblCompra.getRowCount() && row >= 0 && column<tblCompra.getColumnCount() && column>=0){
            Object objeto = tblCompra.getValueAt(row,column);
            if(objeto instanceof JButton){
                ((JButton)objeto).doClick();
                JButton bot = (JButton) objeto;
                int filaselecciona = tblCompra.getSelectedRow();
                
                if(bot.getName().equals("delete")){
                    int id =Integer.valueOf((String)tblCompra.getValueAt(filaselecciona, 1));
                    ModalAdvertencia advertencia = new ModalAdvertencia(paterframe, true);
                    
                    if(advertencia.confirm == 1){
                        //eliminar la variable condición y colocar en el if tu medoto a con el objeto a devolver similar a lo comentado
                        //boolean condicion = true;
                        if(compraBO.eliminarCompra(id)){
                        //if(condicion){
                            /*retornar un arreglo de los elementos que pide la vista */
                            arrCompra = compraBO.listarCompra();
                           
                            llenar_tabla.mostrar_tabla(tblCompra, getLista_Compra(), getTitulo_Compra());
                            editarColumnas();
                            ModalListo listo = new ModalListo(paterframe, true, "Compra Eliminada");
                        
                        }else{
                            ModalError error = new ModalError(paterframe, true,"No se pudo Eliminar");
                        }
                    }
                }else if(bot.getName().equals("detail")){
                    int id =Integer.valueOf((String)tblCompra.getValueAt(filaselecciona, 1));
                    //falta obtener el objeto compra e introducirlo en la vista
                    
                    detBO.generarDetalle(id);
                    
                }
            }
            
        }
        
    }//GEN-LAST:event_tblCompraMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Vista_CrearCompra viewnuevacompra = new Vista_CrearCompra(userlogeado);
        viewnuevacompra.setVisible(true);
        viewnuevacompra.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCompraKeyReleased
        arrCompra = compraBO.buscarCompra(txtBuscarCompra.getText());
        llenar_tabla.mostrar_tabla(tblCompra, getLista_Compra(), getTitulo_Compra());
        editarColumnas();

        
        
    }//GEN-LAST:event_txtBuscarCompraKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlCabeceraConfiguracion;
    private javax.swing.JPanel pnlUsuarioConfiguracion;
    public static javax.swing.JTable tblCompra;
    private javax.swing.JTextField txtBuscarCompra;
    // End of variables declaration//GEN-END:variables
}
