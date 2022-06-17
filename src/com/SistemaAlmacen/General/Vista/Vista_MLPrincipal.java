/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaAlmacen.General.Vista;


import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Carlos
 */
public class Vista_MLPrincipal extends javax.swing.JPanel {

    Usuario usserlogueado;
    
    public Vista_MLPrincipal(Usuario usuario) {
        initComponents();
        this.usserlogueado = usuario;
        
        setSize(710, 520);
        setLocation(0,0);
        
        //lbTitulo.setText("Bienvenido "+ this.usserlogueado.getNombre());
        /*
        lbImagenPrincipal.setSize(248, 237);
        ImageIcon lol5=new ImageIcon(getClass().getResource("../../imagen/imagen_almacen.jpg"));
        ImageIcon imag=new ImageIcon(lol5.getImage().getScaledInstance(lbImagenPrincipal.getWidth(), lbImagenPrincipal.getHeight(), Image.SCALE_DEFAULT));
        lbImagenPrincipal.setIcon(imag);
        */
        
        lbFondoBienvenido.setSize(710, 480);
        ImageIcon lol=new ImageIcon(getClass().getResource("../../imagen/fondo_bienvenido.png"));
        ImageIcon ima=new ImageIcon(lol.getImage().getScaledInstance(lbFondoBienvenido.getWidth(), lbFondoBienvenido.getHeight(), Image.SCALE_DEFAULT));
        lbFondoBienvenido.setIcon(ima);
        
        icono_lista.setSize(20, 20);
        ImageIcon lol5=new ImageIcon(getClass().getResource("../../imagen/check.png"));
        ImageIcon imag=new ImageIcon(lol5.getImage().getScaledInstance(icono_lista.getWidth(), icono_lista.getHeight(), Image.SCALE_DEFAULT));
        icono_lista.setIcon(imag);
        
        icono_lista1.setSize(20, 20);
        ImageIcon lol1=new ImageIcon(getClass().getResource("../../imagen/check.png"));
        ImageIcon imag1=new ImageIcon(lol1.getImage().getScaledInstance(icono_lista1.getWidth(), icono_lista1.getHeight(), Image.SCALE_DEFAULT));
        icono_lista1.setIcon(imag1);
        
        icono_lista2.setSize(20, 20);
        ImageIcon lol2=new ImageIcon(getClass().getResource("../../imagen/check.png"));
        ImageIcon imag2=new ImageIcon(lol2.getImage().getScaledInstance(icono_lista2.getWidth(), icono_lista2.getHeight(), Image.SCALE_DEFAULT));
        icono_lista2.setIcon(imag2);
        
        icono_lista4.setSize(20, 20);
        ImageIcon lol3=new ImageIcon(getClass().getResource("../../imagen/check.png"));
        ImageIcon imag3=new ImageIcon(lol3.getImage().getScaledInstance(icono_lista4.getWidth(), icono_lista4.getHeight(), Image.SCALE_DEFAULT));
        icono_lista4.setIcon(imag3);
        
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        pnlBody = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        icono_lista = new javax.swing.JLabel();
        icono_lista1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        icono_lista2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        icono_lista4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbFondoBienvenido = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(710, 520));
        setPreferredSize(new java.awt.Dimension(710, 520));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setMinimumSize(new java.awt.Dimension(710, 70));

        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(102, 102, 102));
        lbTitulo.setText("BIENVENIDO");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(510, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 70));

        pnlBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlBody.setPreferredSize(new java.awt.Dimension(710, 720));
        pnlBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Control de productos por ubicaciones");
        pnlBody.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 420, 20));
        pnlBody.add(icono_lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 20, 20));
        pnlBody.add(icono_lista1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 20, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Automatización de procesos");
        pnlBody.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 420, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Control de Inventario");
        pnlBody.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 450, 20));
        pnlBody.add(icono_lista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 20, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sistema de Gestión de Almacén");
        pnlBody.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 450, 20));
        pnlBody.add(icono_lista4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 20, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Control de Compras");
        pnlBody.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 420, 20));

        lbFondoBienvenido.setMaximumSize(new java.awt.Dimension(5550, 5550));
        lbFondoBienvenido.setMinimumSize(new java.awt.Dimension(710, 420));
        pnlBody.add(lbFondoBienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 480));

        add(pnlBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 710, 480));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icono_lista;
    private javax.swing.JLabel icono_lista1;
    private javax.swing.JLabel icono_lista2;
    private javax.swing.JLabel icono_lista4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbFondoBienvenido;
    public javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    // End of variables declaration//GEN-END:variables
}
