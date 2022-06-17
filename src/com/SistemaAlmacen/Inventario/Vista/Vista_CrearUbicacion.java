package com.SistemaAlmacen.Inventario.Vista;


import com.SistemaAlmacen.Configuracion.Vista.*;
import com.SistemaAlmacen.Configuracion.BO.Tipo_usuarioBO;
import com.SistemaAlmacen.Configuracion.BO.UsuarioBO;
import com.SistemaAlmacen.Configuracion.Entidad.Tipo_usuario;
import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import com.SistemaAlmacen.General.Utiles.ModalError;
import com.SistemaAlmacen.General.Utiles.ModalListo;
import com.SistemaAlmacen.General.Utiles.Tabla;
import com.SistemaAlmacen.Inventario.BO.UbicacionBO;
import com.SistemaAlmacen.Inventario.Entidad.Ubicacion;
import static com.SistemaAlmacen.Inventario.Vista.Vista_Ubicacion.tblUbicacion;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Vista_CrearUbicacion extends javax.swing.JFrame {
    
    Ubicacion ubicacion;
    //Tipo_usuario tp_usuario;
    UbicacionBO ubiBO;
    Calendar c;
    int xMouse;
    int yMouse;
    DefaultTableModel modelo;
    ArrayList<Ubicacion> arrUbicacion;
    Tabla llenar_tabla = new Tabla();
    
    public Vista_CrearUbicacion() {
        initComponents();
        this.ubiBO = new UbicacionBO();
        this.arrUbicacion = new ArrayList<>();
        
        c=Calendar.getInstance();
        c.setTime(new Date());
        jdateFecha.setCalendar(c);
    }
    
    public Object[] getTitulo_Ubicacion(){
        Object result[] = new Object[6];
        result[0] = "N°";
        result[1] = "Cógigo";
        result[2] = "Bloque";
        result[3] = "Fecha de Ubicacion";
        result[4] = "";
        result[5] = "";
        return result;
    
    }
    public Object[][] getLista_Ubicacion(){
       Object[][] result = new Object[this.arrUbicacion.size()][6];
        int indice =0;
        for(Ubicacion ubi : this.arrUbicacion){
            if(ubi != null){
                result[indice][0] = String.valueOf((indice+1));
                result[indice][1] = String.valueOf(ubi.getIdUbicacion());
                result[indice][2] = ubi.getBloque();
                result[indice][3] = ubi.getFecha_ubicacion();

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
                
                result[indice][4] = btneditar;
                result[indice][5] = btneliminar;
                
                indice++; 
            }
        }
        Object[][] result_final=new Object[indice][6];
        for(int i=0;i<indice;i++){
            result_final[i]=result[i];
        }
        return result_final;
    } 
    void editarColumnas(){
        tblUbicacion.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblUbicacion.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblUbicacion.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblUbicacion.getColumnModel().getColumn(5).setPreferredWidth(30);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtBloque = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlMovimiento = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        txtUsuario = new javax.swing.JTextField();
        jdateFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 270));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setMinimumSize(new java.awt.Dimension(348, 270));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 270));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("CREAR UBICACIÓN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 34, 190, 23));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Bloque");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 85, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Fecha");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 126, 292, 10));

        txtBloque.setBorder(null);
        jPanel1.add(txtBloque, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 105, 292, 20));

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
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 75, 31));

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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 75, 31));

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

        txtUsuario.setBorder(null);
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 292, 20));
        jPanel1.add(jdateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 290, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Tipo_usuario tip;
                
        String nombre = txtBloque.getText();
        
        java.util.Date fec;
        Date date;
        fec = jdateFecha.getDate();
        date=new java.sql.Date(fec.getTime());
        
        
        //String fecha = txFecha.getText();
  
        //verificar que el tipo sea un dato correcto
        ubicacion = new Ubicacion(nombre, (java.sql.Date) date);
        //****************modificar la condicion***********************
        if(ubiBO.agregarUbicacion(ubicacion)){
            ModalListo mod = new ModalListo(this,true,"Ubucacón Registrada");
            
            //limpiarCampos
            //**************Agregar el retorno de elementos*********************
            this.arrUbicacion = ubiBO.listarUbicacion();
            llenar_tabla.mostrar_tabla(Vista_Ubicacion.tblUbicacion, getLista_Ubicacion(), getTitulo_Ubicacion());
            editarColumnas();
            dispose();
            
        }else{
            ModalError error = new ModalError(this, true,"No se pudo registrar");
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
            java.util.logging.Logger.getLogger(Vista_CrearUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_CrearUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_CrearUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_CrearUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_CrearUbicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private com.toedter.calendar.JDateChooser jdateFecha;
    private javax.swing.JPanel pnlMovimiento;
    public javax.swing.JTextField txtBloque;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
