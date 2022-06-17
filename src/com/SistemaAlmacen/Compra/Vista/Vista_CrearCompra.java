/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaAlmacen.Compra.Vista;

import com.SistemaAlmacen.Compra.BO.CompraBO;
import com.SistemaAlmacen.Compra.BO.DetalleCompraBO;
import com.SistemaAlmacen.Compra.BO.ProveedorBO;
import com.SistemaAlmacen.Compra.Entidad.Compra;
import com.SistemaAlmacen.Compra.Entidad.DetalleCompra;
import com.SistemaAlmacen.Compra.Entidad.Proveedor;
import static com.SistemaAlmacen.Compra.Vista.Vista_Compra.tblCompra;
import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import com.SistemaAlmacen.General.Utiles.ModalAdvertencia;
import com.SistemaAlmacen.General.Utiles.ModalError;
import com.SistemaAlmacen.General.Utiles.ModalListo;
import com.SistemaAlmacen.General.Utiles.Tabla;
import com.SistemaAlmacen.Inventario.BO.ProductoBO;
import com.SistemaAlmacen.Inventario.Entidad.Producto;
import java.awt.Color;
import java.awt.Image;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class Vista_CrearCompra extends javax.swing.JFrame {

    int  xMouse;
    int  yMouse;

    private ArrayList<Compra> arrCompra;
    private ArrayList<DetalleCompra> arrDetcom;
    private DetalleCompra detComp;
    private Usuario usu;
    private Producto prod;
    private ProductoBO prodBO;
    Compra com;
    CompraBO comBO;
    Calendar c;
    DetalleCompraBO detComBO;
    private ProveedorBO proveedorBO;
    Date date;
    Tabla tabla;
    int codigo;
    DefaultTableModel modelo;
    
    public Vista_CrearCompra(Usuario usu) {
        initComponents();
        this.usu = usu;
        proveedorBO = new ProveedorBO();
        prodBO = new ProductoBO();
        comBO = new CompraBO();
        arrCompra = new ArrayList<>();
        arrDetcom = new ArrayList<>();
        tabla = new Tabla();
        com = new Compra();
        detComBO = new DetalleCompraBO();
        proveedorBO.listarComboProveedor(cbxProveedor);
        prodBO.listarComboProducto(cboxProducto);
        System.out.println("Tamaño: "+arrDetcom.size());
        
        codigo=comBO.codigoActual();
        
        arrCompra = comBO.listarCompra();
        
        c=Calendar.getInstance();
        c.setTime(new Date());
        iniciarFecha();
        txtTotal.setEditable(false);
        txtCodigoCompra.setEditable(false);
        txtCodigoCompra.setText(String.valueOf(codigo+1));
        tabla.mostrar_tabla(tblRegistraCompra, getLista_CompraDetalle(), getTitulo_CompraDetalle());
        editarColumnasDetalle();
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
        Object[][] result_final=new Object[indice][88];
        for(int i=0;i<indice;i++){
            result_final[i]=result[i];
        }
        return result_final;
    } 
    
    /********************Detalle************************/
    void editarColumnasDetalle(){
        tblRegistraCompra.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblRegistraCompra.getColumnModel().getColumn(4).setPreferredWidth(30);
    }
    
    public Object[] getTitulo_CompraDetalle(){
        Object result[] = new Object[5];
        result[0] = "N°";
        result[1] = "Producto";
        result[2] = "Cantidad";
        result[3] = "Precio U.";
        result[4] = "";
        return result;
    }
    public Object[][] getLista_CompraDetalle(){
            Object[][] result = new Object[this.arrDetcom.size()][5];
            int indice =0;
            for(DetalleCompra detcomp : this.arrDetcom){
                
                if(detcomp != null){
                    result[indice][0] = String.valueOf((indice+1));
                    
                    result[indice][1] = detcomp.getProd().getNombre();
                    result[indice][2] = String.valueOf(detcomp.getCantidad());
                    result[indice][3] =String.valueOf(detcomp.getPrecio());
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
    private void iniciarFecha(){
        
        datechoser.setCalendar(c);
        /*
        datechoser.setCalendar(c.get(Calendar.DAY_OF_MONTH)+
                "/"+(c.get(Calendar.MONTH)+1)+
                "/"+ c.get(Calendar.YEAR)));
        */
        //txtFecha.setEditable(false);
    /*
    fechaComprobante=new JDateChooser();
    pnlNor.add(fechaComprobante);
    */
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        datechoser = new com.toedter.calendar.JDateChooser();
        cbxProveedor = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlContenedorLista = new javax.swing.JPanel();
        pnlDetalleLista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistraCompra = new javax.swing.JTable();
        pnlAgregar = new javax.swing.JPanel();
        btnAgregarRow = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        pnlMovimiento = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cboxProducto = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtCodigoCompra = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(112, 112, 112));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear Compra");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Fecha");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 60, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 590, 10));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Proveedor");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 60, -1));
        jPanel1.add(datechoser, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 220, 20));

        cbxProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxProveedor.setBorder(null);
        jPanel1.add(cbxProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 291, -1));

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
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 75, 31));

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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 75, 31));

        pnlContenedorLista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDetalleLista.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetalleLista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblRegistraCompra.setBackground(new java.awt.Color(204, 204, 255));
        tblRegistraCompra.setForeground(new java.awt.Color(0, 102, 255));
        tblRegistraCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRegistraCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblRegistraCompra.setSelectionBackground(new java.awt.Color(255, 255, 153));
        tblRegistraCompra.setSelectionForeground(new java.awt.Color(0, 102, 102));
        tblRegistraCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegistraCompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRegistraCompra);

        pnlDetalleLista.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 220));

        pnlContenedorLista.add(pnlDetalleLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 220));

        pnlAgregar.setBackground(new java.awt.Color(255, 255, 255));

        btnAgregarRow.setBackground(new java.awt.Color(73, 97, 163));
        btnAgregarRow.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarRow.setText("Agregar");
        btnAgregarRow.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarRow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarRow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarRowMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarRowMouseExited(evt);
            }
        });
        btnAgregarRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRowActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Total");

        txtTotal.setBorder(null);

        javax.swing.GroupLayout pnlAgregarLayout = new javax.swing.GroupLayout(pnlAgregar);
        pnlAgregar.setLayout(pnlAgregarLayout);
        pnlAgregarLayout.setHorizontalGroup(
            pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgregarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAgregarRow, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(418, 418, 418)
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(221, 221, 221))
        );
        pnlAgregarLayout.setVerticalGroup(
            pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgregarLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarRow, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlContenedorLista.add(pnlAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 224, 660, 50));

        jPanel1.add(pnlContenedorLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 660, 270));

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
            .addGap(0, 706, Short.MAX_VALUE)
        );
        pnlMovimientoLayout.setVerticalGroup(
            pnlMovimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(pnlMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 706, 20));

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Producto");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 66, 20));

        cboxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cboxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 290, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 590, 10));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 140, 10));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 130, -1));

        jLabel5.setText("Precio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        txtCantidad.setBorder(null);
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 110, 20));

        txtPrecio.setBorder(null);
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 140, 20));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 110, 10));

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("N°");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 54, 40, 20));

        txtCodigoCompra.setBorder(null);
        txtCodigoCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txtCodigoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 120, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 120, 10));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 532, 660, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlMovimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMovimientoMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlMovimientoMousePressed

    private void pnlMovimientoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMovimientoMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse); 
    }//GEN-LAST:event_pnlMovimientoMouseDragged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        /*
        date =  datechoser.getDate();
        
        long d = date.getTime();
        Date fecha = new Date(d);
        */
        java.util.Date fec;
        
        double precio;
        String prov;
        //String prod;
        ArrayList<DetalleCompra> listaDetalle;
        Proveedor prove = new Proveedor();
        ProveedorBO provBO = new ProveedorBO();
        ArrayList<Proveedor> arrprov = new ArrayList<>();
        arrprov = proveedorBO.listarProveedor();
        
        prov = cbxProveedor.getSelectedItem().toString();
        
        for(Proveedor proveed : arrprov){
            if(proveed.getRazon_Social().equalsIgnoreCase(prov)){
                prove = proveed;
            }
        }      
        //prove = provBO.obtenerProveedor();
        listaDetalle = new ArrayList<>();
        listaDetalle = arrDetcom;
        
        fec = datechoser.getDate();
        date=new java.sql.Date(fec.getTime());

        precio = Double.parseDouble(txtTotal.getText());
        
        
        com = new Compra((java.sql.Date) date, precio, prove, usu, listaDetalle);
        
        //****************modificar la condicion***********************
        if(comBO.registrarCompra(com)){
            com.setId_compra(comBO.codigoActual());
            //com.setId_compra(codigo+1);
            for(DetalleCompra detcom : listaDetalle){
                detcom.setCom(com);
                detComBO.registrarDetalle(detcom);
            }
            ModalListo mod = new ModalListo(this,true,"Compra Registrada");
            
            //limpiarCampos
            //**************Agregar el retorno de elementos*********************
            this.arrCompra = comBO.listarCompra();
            tabla.mostrar_tabla(tblCompra, getLista_Compra(), getTitulo_Compra());
            editarColumnas();
            dispose();
            
        }else{
            ModalError error = new ModalError(this, true,"No se pudo registrar");
        } 
        
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    
    
    private void btnAgregarRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRowActionPerformed
        int cantidad;
        double precio;
        String pro;
        
        cantidad = Integer.parseInt(txtCantidad.getText());
        precio = Double.parseDouble(txtPrecio.getText());
        pro =cboxProducto.getSelectedItem().toString();
        prod = new Producto();
        prod.setNombre(pro);
        
        detComp = new DetalleCompra(null,prod,cantidad,precio);
        this.arrDetcom.add(detComp);

        tabla.mostrar_tabla(tblRegistraCompra, getLista_CompraDetalle(), getTitulo_CompraDetalle());
        editarColumnasDetalle();
        double cont = 0;
        for(DetalleCompra detc : arrDetcom){
            
           cont = cont + detc.getPrecio()*detc.getCantidad();
            
        }
        txtTotal.setText(String.valueOf(cont));
        txtCantidad.setText("");
        txtPrecio.setText("");
        cboxProducto.setSelectedIndex(0);
        
    }//GEN-LAST:event_btnAgregarRowActionPerformed

    private void tblRegistraCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegistraCompraMouseClicked
        int column = tblRegistraCompra.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblRegistraCompra.getRowHeight();

        if(row <tblRegistraCompra.getRowCount() && row >= 0 && column<tblRegistraCompra.getColumnCount() && column>=0){
            Object objeto = tblRegistraCompra.getValueAt(row,column);
            if(objeto instanceof JButton){
                ((JButton)objeto).doClick();
                JButton bot = (JButton) objeto;
                int filaselecciona = tblRegistraCompra.getSelectedRow();
                if(bot.getName().equals("delete")){
                    String nombre_prod =(String)tblRegistraCompra.getValueAt(filaselecciona, 1);
                    ModalAdvertencia advertencia = new ModalAdvertencia(this, true);

                    if(advertencia.confirm == 1){
                        //eliminar la variable condición y colocar en el if tu medoto a con el objeto a devolver similar a lo comentado
                        //boolean condicion = true;
                        DetalleCompra detcom = new DetalleCompra(null, new Producto(nombre_prod), 0, 0);
                        
                        detcom.getProd().setNombre(nombre_prod);
                        
                        for (int i = 0; i < arrDetcom.size(); i++) {
                            if(arrDetcom.get(i).getProd().getNombre().equalsIgnoreCase(detcom.getProd().getNombre())){
                                arrDetcom.remove(i);
                            }
                        }

                        tabla.mostrar_tabla(tblRegistraCompra, getLista_CompraDetalle(), getTitulo_CompraDetalle());
                        editarColumnas();
                        ModalListo listo = new ModalListo(this, true, "Fila Eliminada");
                 
                    }
                }
            }
            
        }
        
        
        
    }//GEN-LAST:event_tblRegistraCompraMouseClicked

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

    private void btnAgregarRowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarRowMouseEntered
        btnAgregarRow.setBackground(new Color(0, 66, 255));
    }//GEN-LAST:event_btnAgregarRowMouseEntered

    private void btnAgregarRowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarRowMouseExited
        btnAgregarRow.setBackground(new Color(73, 97, 163));
    }//GEN-LAST:event_btnAgregarRowMouseExited

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
            java.util.logging.Logger.getLogger(Vista_CrearCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_CrearCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_CrearCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_CrearCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarRow;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboxProducto;
    private javax.swing.JComboBox<String> cbxProveedor;
    private com.toedter.calendar.JDateChooser datechoser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPanel pnlAgregar;
    private javax.swing.JPanel pnlContenedorLista;
    private javax.swing.JPanel pnlDetalleLista;
    private javax.swing.JPanel pnlMovimiento;
    public static javax.swing.JTable tblRegistraCompra;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigoCompra;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
