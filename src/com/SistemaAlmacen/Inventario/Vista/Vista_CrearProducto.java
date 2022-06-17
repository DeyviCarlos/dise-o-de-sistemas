/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaAlmacen.Inventario.Vista;



import static com.SistemaAlmacen.General.Vista.Vista_MenuPrincipal_Admin.pnlContenido;
import com.SistemaAlmacen.Inventario.BO.CategoriaBO;
import com.SistemaAlmacen.Inventario.BO.ProductoBO;
import com.SistemaAlmacen.Inventario.BO.UbicacionBO;
import com.SistemaAlmacen.Inventario.Entidad.Categoria;
import com.SistemaAlmacen.Inventario.Entidad.Producto;
import com.SistemaAlmacen.Inventario.Entidad.Ubicacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author IO1
 */
public class Vista_CrearProducto extends javax.swing.JFrame {

    ProductoBO productoBO = new ProductoBO();
    String estado = "";
    CategoriaBO catBO = new CategoriaBO();
    UbicacionBO ubicBO = new UbicacionBO();
    
    int  xMouse;
    int  yMouse;
    
    
    public Vista_CrearProducto() {
        initComponents();
        listarComboCategoria();
        listarComboUbicacion();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        btngEstado = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        spnStock = new javax.swing.JSpinner();
        txtImagen = new javax.swing.JTextField();
        btnImagen = new javax.swing.JButton();
        cboCategoria = new javax.swing.JComboBox<>();
        cboUbicacion = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rbtnActivado = new javax.swing.JRadioButton();
        rbtnDesactivado = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();

        jTextField5.setText("jTextField5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("NOMBRE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 71, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("DESCRIPCIÓN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 141, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("PRECIO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 206, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("STOCK");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 268, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("CATEGORIA");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 433, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("UBICACIÓN");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 499, -1, -1));

        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 103, 382, -1));

        txtDescripcion.setBorder(null);
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 161, 382, -1));

        txtPrecio.setBorder(null);
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 226, 382, -1));

        spnStock.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnStock.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.add(spnStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 323, 382, -1));

        txtImagen.setEnabled(false);
        jPanel1.add(txtImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 320, 233, -1));

        btnImagen.setText("Seleccionar Imagen");
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });
        jPanel1.add(btnImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 361, 173, -1));

        cboCategoria.setBorder(null);
        jPanel1.add(cboCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 457, 382, -1));

        cboUbicacion.setBorder(null);
        jPanel1.add(cboUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 519, 382, -1));

        btnGuardar.setBackground(new java.awt.Color(73, 97, 163));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
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
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 132, 37));

        btnCancelar.setBackground(new java.awt.Color(255, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 610, 132, 37));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("CREAR DE PRODUCTOS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 36, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("ESTADO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 361, -1, -1));

        btngEstado.add(rbtnActivado);
        rbtnActivado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnActivado.setForeground(new java.awt.Color(102, 102, 102));
        rbtnActivado.setText("Activado");
        rbtnActivado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rbtnActivado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnActivadoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnActivado, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 381, -1, -1));

        btngEstado.add(rbtnDesactivado);
        rbtnDesactivado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnDesactivado.setForeground(new java.awt.Color(102, 102, 102));
        rbtnDesactivado.setText("Desactivado");
        rbtnDesactivado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rbtnDesactivado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDesactivadoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnDesactivado, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 381, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 84, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 181, 382, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 244, 382, 13));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 119, 382, 16));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        Vista_Producto viewProd = new Vista_Producto(this);
        
        pnlContenido.removeAll();
        pnlContenido.add(viewProd, BorderLayout.CENTER);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        String ruta = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        chooser.setFileFilter(filter);
        
        int respuesta = chooser.showOpenDialog(this);
        
        if(respuesta == chooser.APPROVE_OPTION){
            ruta = chooser.getSelectedFile().getPath();
            String nombreImg = chooser.getSelectedFile().getName();
            Image mImagen = new ImageIcon(ruta).getImage();
            ImageIcon mIcon = new ImageIcon(mImagen.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
            lblImagen.setIcon(mIcon);
            txtImagen.setText(ruta);
        }
    }//GEN-LAST:event_btnImagenActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        if(verificarCampos()){
           JOptionPane.showMessageDialog(null,"Completar correctamente todos los campos");
        }else{
           try {
               
                Producto producto= new Producto(); 
                
                producto.setNombre(txtNombre.getText());
                producto.setDescripcion(txtDescripcion.getText());
                producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
                producto.setStock(Integer.parseInt(spnStock.getValue()+""));
                System.out.println(spnStock.getValue()+"");
                producto.setEstado(estado);
                producto.setImagen(txtImagen.getText());
                producto.setCategoria(cboCategoria.getSelectedItem()+"");
                producto.setUbicacion(cboUbicacion.getSelectedItem()+"");
                
                String mensaje=productoBO.agregarProducto(producto);
                JOptionPane.showMessageDialog(null, mensaje);
                limpiar();
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Error: "+ e.getMessage());
           }
           
       }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void rbtnActivadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnActivadoActionPerformed
        this.estado = "ACTIVO";
    }//GEN-LAST:event_rbtnActivadoActionPerformed

    private void rbtnDesactivadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDesactivadoActionPerformed
        this.estado = "INACTIVO";
    }//GEN-LAST:event_rbtnDesactivadoActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
        char []p={'1','2','3','4','5','6','7','8','9','0','.'};
    int b=0;
    for(int i=0;i<=10;i++){
        if (p[i]==evt.getKeyChar()){b=1;}
    }
    
    if(b==0){evt.consume(); getToolkit().beep(); }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse); 
    }//GEN-LAST:event_jPanel3MouseDragged

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
   
    private boolean verificarCampos(){
        return txtNombre.getText().isEmpty() || txtDescripcion.getText().isEmpty() || !validarPrecio() || estado.equals("") || txtImagen.getText().isEmpty();
    }
    
    private boolean validarPrecio(){
        String precio = txtPrecio.getText();
        String regex = 
       "[0-9]{1,}[\\.]{0,1}[0-9]{0,2}";;

        Pattern patron = Pattern.compile(regex);
        if(!patron.matcher(precio).matches()){ 
            return false;
        }else{ 
            return true;
        }
    }
    
    
    private void limpiar(){
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtImagen.setText("");
        spnStock.setValue(0);
        lblImagen.setIcon(null);
    }
    
    private void listarComboCategoria(){
        ArrayList<Categoria> categorias = new ArrayList();
        categorias = (ArrayList<Categoria>) catBO.listarCategoria();
        for (Categoria cat : categorias) {
            cboCategoria.addItem(cat.getNombre());
        }
    }
    
    private void listarComboUbicacion(){
        ArrayList<Ubicacion> ubicacion = new ArrayList();
        ubicacion = (ArrayList<Ubicacion>) ubicBO.listarUbicacion();
        for (Ubicacion ubic : ubicacion) {
            cboUbicacion.addItem(ubic.getBloque());
        }
    }
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
            java.util.logging.Logger.getLogger(Vista_CrearProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_CrearProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_CrearProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_CrearProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_CrearProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImagen;
    private javax.swing.ButtonGroup btngEstado;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JComboBox<String> cboUbicacion;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JRadioButton rbtnActivado;
    private javax.swing.JRadioButton rbtnDesactivado;
    private javax.swing.JSpinner spnStock;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtImagen;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
