package com.SistemaAlmacen.Compra.Vista;


import com.SistemaAlmacen.Compra.BO.ProveedorBO;
import com.SistemaAlmacen.Compra.Entidad.Proveedor;
import static com.SistemaAlmacen.Compra.Vista.Vista_Proveedor.tblProveedor;
import com.SistemaAlmacen.General.Utiles.ModalError;
import com.SistemaAlmacen.General.Utiles.ModalListo;
import com.SistemaAlmacen.General.Utiles.Tabla;
import com.SistemaAlmacen.Inventario.Vista.Vista_Producto;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Vista_EditarProveedor extends javax.swing.JFrame {
    
    ProveedorBO provBO;
    ArrayList<Proveedor> arrProvedor;
    Proveedor prov;
    int codigo;
    
    int xMouse;
    int yMouse;
    DefaultTableModel modelo;
    Tabla llenar_tabla = new Tabla();
    
    
    
    public Vista_EditarProveedor(Proveedor provedor) {
        initComponents();
        this.provBO = new ProveedorBO();
        this.arrProvedor = new ArrayList<>();
        codigo = provedor.getIdProveedor();
        
        txtDireccion.setText(provedor.getDireccion());
        txtRUC.setText(provedor.getRuc());
        txtRazonSocial.setText(provedor.getRazon_Social());
        txtTelefono.setText(provedor.getTelefono());
        
               
        
    }
    
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlMovimiento = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        txtRUC = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtTelefono = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 360));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 530));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("EDITAR PROVEEDOR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 34, 210, 23));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Razón Social");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 85, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Ruc");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 126, 292, 10));

        txtRazonSocial.setBorder(null);
        jPanel1.add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 105, 292, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Dirección");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 182, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Teléfono");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 222, -1, -1));

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 75, 31));

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelarMousePressed(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 75, 31));

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

        jPanel1.add(pnlMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 346, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 292, 10));

        txtRUC.setBorder(null);
        jPanel1.add(txtRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 292, 20));

        txtDireccion.setBorder(null);
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 292, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 292, 10));

        txtTelefono.setBorder(null);
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 292, 20));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 292, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
      
        String razon = txtRazonSocial.getText();
        String ruc = txtRUC.getText();
        String dir = txtDireccion.getText();
        String telf = txtTelefono.getText();
        //verificar que el tipo sea un dato correcto
        prov = new Proveedor(codigo,razon, ruc, dir, telf);
        
        //****************modificar la condicion***********************
        if(provBO.modificarProveedor(prov)){
            ModalListo mod = new ModalListo(this,true,"Proveedor Editado");
            
            //limpiarCampos
            //**************Agregar el retorno de elementos*********************
            this.arrProvedor = provBO.listarProveedor();
            llenar_tabla.mostrar_tabla(Vista_Proveedor.tblProveedor, getLista_Proveedor(), getTitulo_Proveedor());
            editarColumnas();
            dispose();  
        }else{
            ModalError error = new ModalError(this, true,"No se pudo editar");
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

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        btnGuardar.setBackground(new Color(0, 66, 255));
    }//GEN-LAST:event_btnGuardarMousePressed

    private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
         btnCancelar.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnCancelarMousePressed

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
            java.util.logging.Logger.getLogger(Vista_EditarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_EditarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_EditarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_EditarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_EditarProveedor(prov).setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel pnlMovimiento;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtRUC;
    public javax.swing.JTextField txtRazonSocial;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
