/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaAlmacen.General.Vista;


import com.SistemaAlmacen.Compra.Vista.Vista_Compra;
import com.SistemaAlmacen.Compra.Vista.Vista_Proveedor;
import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import com.SistemaAlmacen.Configuracion.Vista.Vista_TipoUsuario;
import com.SistemaAlmacen.Configuracion.Vista.Vista_Usuario;
import com.SistemaAlmacen.Inventario.Vista.Vista_Categoria;
import com.SistemaAlmacen.Inventario.Vista.Vista_Producto;
import com.SistemaAlmacen.Inventario.Vista.Vista_Ubicacion;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Carlos
 */
public class Vista_MenuPrincipal_Admin extends javax.swing.JFrame {

    public static Usuario usserlogeado;
    
    int xMouse;
    int yMouse;
    
    public Vista_MenuPrincipal_Admin(Usuario usuario) {
        this.usserlogeado = usuario; 
        
        
        initComponents();
        
        ImageIcon lol4=new ImageIcon(getClass().getResource("../../imagen/logo.jpg"));
        ImageIcon logo=new ImageIcon(lol4.getImage().getScaledInstance(this.lbLogo.getWidth(), this.lbLogo.getHeight(), Image.SCALE_DEFAULT));
        this.lbLogo.setIcon(logo);
        //Home
        ImageIcon lol=new ImageIcon(getClass().getResource("../../imagen/home.png"));
        ImageIcon home=new ImageIcon(lol.getImage().getScaledInstance(this.lbIconoPrincipal.getWidth(), this.lbIconoPrincipal.getHeight(), Image.SCALE_DEFAULT));
        this.lbIconoPrincipal.setIcon(home);
        //Inventario
        ImageIcon lol3=new ImageIcon(getClass().getResource("../../imagen/inventario.png"));
        ImageIcon inventario=new ImageIcon(lol3.getImage().getScaledInstance(this.lbIconoInventario.getWidth(), this.lbIconoInventario.getHeight(), Image.SCALE_DEFAULT));
        this.lbIconoInventario.setIcon(inventario);
        
        ImageIcon lol8=new ImageIcon(getClass().getResource("../../imagen/producto.png"));
        ImageIcon subinventarioProd=new ImageIcon(lol8.getImage().getScaledInstance(this.lbIconoProducto.getWidth(), this.lbIconoProducto.getHeight(), Image.SCALE_DEFAULT));
        this.lbIconoProducto.setIcon(subinventarioProd);
        
        ImageIcon lol9=new ImageIcon(getClass().getResource("../../imagen/categoria.png"));
        ImageIcon subinventarioCat=new ImageIcon(lol9.getImage().getScaledInstance(this.lbIconoCategoria.getWidth(), this.lbIconoCategoria.getHeight(), Image.SCALE_DEFAULT));
        this.lbIconoCategoria.setIcon(subinventarioCat);
        
        ImageIcon lol10=new ImageIcon(getClass().getResource("../../imagen/ubicacion.png"));
        ImageIcon subinventarioUbi=new ImageIcon(lol10.getImage().getScaledInstance(this.lbIconoUbicacion.getWidth(), this.lbIconoUbicacion.getHeight(), Image.SCALE_DEFAULT));
        this.lbIconoUbicacion.setIcon(subinventarioUbi);
        //Compra
        ImageIcon lol2=new ImageIcon(getClass().getResource("../../imagen/compra1.png"));
        ImageIcon compra=new ImageIcon(lol2.getImage().getScaledInstance(this.lbIconoCompra.getWidth(), this.lbIconoCompra.getHeight(), Image.SCALE_DEFAULT));
        this.lbIconoCompra.setIcon(compra);
        
        ImageIcon lol11=new ImageIcon(getClass().getResource("../../imagen/compra2.png"));
        ImageIcon subcompra_lista=new ImageIcon(lol11.getImage().getScaledInstance(this.lbIconoCompraLista.getWidth(), this.lbIconoCompraLista.getHeight(), Image.SCALE_DEFAULT));
        this.lbIconoCompraLista.setIcon(subcompra_lista);
        
        ImageIcon lol12=new ImageIcon(getClass().getResource("../../imagen/proveedor.png"));
        ImageIcon subcompra_prov=new ImageIcon(lol12.getImage().getScaledInstance(this.lbIconoProveedor.getWidth(), this.lbIconoProveedor.getHeight(), Image.SCALE_DEFAULT));
        this.lbIconoProveedor.setIcon(subcompra_prov);
        
        //Configuracion Usuario
        ImageIcon lol1=new ImageIcon(getClass().getResource("../../imagen/configUser.png"));
        ImageIcon usuarios=new ImageIcon(lol1.getImage().getScaledInstance(this.lbIconoConfiguracion.getWidth(), this.lbIconoConfiguracion.getHeight(), Image.SCALE_DEFAULT));
        this.lbIconoConfiguracion.setIcon(usuarios);
        
        ImageIcon lol13=new ImageIcon(getClass().getResource("../../imagen/user.png"));
        ImageIcon subusuarios_usuario=new ImageIcon(lol13.getImage().getScaledInstance(this.lbIconoUsuario.getWidth(), this.lbIconoUsuario.getHeight(), Image.SCALE_DEFAULT));
        this.lbIconoUsuario.setIcon(subusuarios_usuario);
        
        ImageIcon lol14=new ImageIcon(getClass().getResource("../../imagen/usuarios.png"));
        ImageIcon subusuarios_tipoUsu=new ImageIcon(lol14.getImage().getScaledInstance(this.lbIconoTipoUsuario.getWidth(), this.lbIconoTipoUsuario.getHeight(), Image.SCALE_DEFAULT));
        this.lbIconoTipoUsuario.setIcon(subusuarios_tipoUsu);
        
        
        ImageIcon lol7=new ImageIcon(getClass().getResource("../../imagen/en_linea.png"));
        ImageIcon enline=new ImageIcon(lol7.getImage().getScaledInstance(this.lbIconoSesion.getWidth(), this.lbIconoSesion.getHeight(), Image.SCALE_DEFAULT));
        this.lbIconoSesion.setIcon(enline);
        
        lblUserSesion.setText(this.usserlogeado.getNombre());
        //agregando cursor con codigo
        //lblUserSesion.setCursor(new Cursor(getCursor().HAND_CURSOR));
        
        
        
        //se elminan los submenus
        pnlML2.remove(pnlSubMenuCompra);
        pnlML2.remove(pnlSubMenuInvetario1);
        pnlML2.remove(pnlSubMenuInventario2);
        pnlML2.remove(pnlSubMenuConfig);
        
        //carga el contenido principal del sistema
        cargar_ContenedorPrincipal(usserlogeado);
        
    }
    
    
    //RNG 333333
    void setColor(JPanel panel){
        //color negro
        //panel.setBackground(new Color(0,0,0));
           panel.setBackground(new Color(21,101,192));
    }
    void resetColor(JPanel panel){
        //plomo
        //panel.setBackground(new Color(51,51,51));
           panel.setBackground(new Color(18,90,173));
    }
    void cargar_ContenedorPrincipal(Usuario usuario){
        Vista_MLPrincipal viewPrincipal = new Vista_MLPrincipal(usuario);

        pnlContenido.removeAll();
        pnlContenido.add(viewPrincipal, BorderLayout.CENTER);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }
    
    void cargar_ContenedorUsuario(){
        Vista_Usuario viewConfig = new Vista_Usuario(this);
        
        pnlContenido.removeAll();
        pnlContenido.add(viewConfig, BorderLayout.CENTER);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }
    
    void cargar_ContenedorCompra(){
        Vista_Compra viewCompra = new Vista_Compra(this,  usserlogeado);
        
        pnlContenido.removeAll();
        pnlContenido.add(viewCompra, BorderLayout.CENTER);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }
    void cargar_ContenedorProducto(){
        Vista_Producto viewProd = new Vista_Producto(this);
        
        pnlContenido.removeAll();
        pnlContenido.add(viewProd, BorderLayout.CENTER);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }
    
    void cargar_ContenedorProveedor(){
        Vista_Proveedor viewproveedor = new Vista_Proveedor(this);
        
        pnlContenido.removeAll();
        pnlContenido.add(viewproveedor, BorderLayout.CENTER);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }
    
    void cargar_ContenedorUbicacion(){
        Vista_Ubicacion viewInventario = new Vista_Ubicacion(this);
        
        pnlContenido.removeAll();
        pnlContenido.add(viewInventario, BorderLayout.CENTER);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }
    
    void cargar_ContenedorCategoria(){
        Vista_Categoria viewCategoria = new Vista_Categoria(this);
        
        pnlContenido.removeAll();
        pnlContenido.add(viewCategoria, BorderLayout.CENTER);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }
    
    void cargar_ContenedorTipoUsuario(){
        Vista_TipoUsuario viewTpUsuario = new Vista_TipoUsuario(this);
        
        pnlContenido.removeAll();
        pnlContenido.add(viewTpUsuario, BorderLayout.CENTER);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupo1 = new javax.swing.ButtonGroup();
        btnGrupo2 = new javax.swing.ButtonGroup();
        btnGrupo3 = new javax.swing.ButtonGroup();
        pnlVistaPrincipal = new javax.swing.JPanel();
        pnlMenuLateral = new javax.swing.JPanel();
        pnlMenuLogo = new javax.swing.JPanel();
        lbLogo = new javax.swing.JLabel();
        pnlML2 = new javax.swing.JPanel();
        pnlMenuPrincipal = new javax.swing.JPanel();
        lbMenuPrincipal = new javax.swing.JLabel();
        lbIconoPrincipal = new javax.swing.JLabel();
        pnlMenuInventario = new javax.swing.JPanel();
        lbMenuInventario = new javax.swing.JLabel();
        lbIconoInventario = new javax.swing.JLabel();
        pnlSubMenuInvetario1 = new javax.swing.JPanel();
        pnlSubMenuInventario_Producto = new javax.swing.JPanel();
        lbIconoProducto = new javax.swing.JLabel();
        lbSubMenuInventarioProducto = new javax.swing.JLabel();
        pnlSubMenuInventario_Categoria = new javax.swing.JPanel();
        lbSubMenuInventarioCategoria = new javax.swing.JLabel();
        lbIconoCategoria = new javax.swing.JLabel();
        pnlSubMenuInventario2 = new javax.swing.JPanel();
        pnlSubMenuInventario_Ubicacion = new javax.swing.JPanel();
        lbSubMenuInventarioUbicacion = new javax.swing.JLabel();
        lbIconoUbicacion = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        pnlMenuCompra = new javax.swing.JPanel();
        lbMenuCompra = new javax.swing.JLabel();
        lbIconoCompra = new javax.swing.JLabel();
        pnlSubMenuCompra = new javax.swing.JPanel();
        pnlSubMenuCompra_Compra = new javax.swing.JPanel();
        lbSubMenuCompraLista = new javax.swing.JLabel();
        lbIconoCompraLista = new javax.swing.JLabel();
        pnlSubMenuCompra_Proveedor = new javax.swing.JPanel();
        lbSubMenuInventarioProveedor = new javax.swing.JLabel();
        lbIconoProveedor = new javax.swing.JLabel();
        pnlMenuConfiguracionUser = new javax.swing.JPanel();
        lbMenuConfiguracion = new javax.swing.JLabel();
        lbIconoConfiguracion = new javax.swing.JLabel();
        pnlSubMenuConfig = new javax.swing.JPanel();
        pnlSubMenuConfig_Usuario = new javax.swing.JPanel();
        lbSubMenuConfigUsuario = new javax.swing.JLabel();
        lbIconoUsuario = new javax.swing.JLabel();
        pnlSubMenuConfig_TipoUsuario = new javax.swing.JPanel();
        lbSubMenuConfTipoUsuario = new javax.swing.JLabel();
        lbIconoTipoUsuario = new javax.swing.JLabel();
        pnlContenido = new javax.swing.JPanel();
        pnlMenuBar = new javax.swing.JPanel();
        pnlCerrarSesion = new javax.swing.JPanel();
        lbCerrarSesion = new javax.swing.JLabel();
        pnlMovimiento = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlUserSesion = new javax.swing.JPanel();
        lblUserSesion = new javax.swing.JLabel();
        lbIconoSesion = new javax.swing.JLabel();
        pnlTitulo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        pnlVistaPrincipal.setMinimumSize(new java.awt.Dimension(1000, 550));
        pnlVistaPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenuLateral.setBackground(new java.awt.Color(13, 71, 161));
        pnlMenuLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenuLogo.setBackground(new java.awt.Color(13, 71, 161));
        pnlMenuLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlMenuLogo.add(lbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 34, 250, 54));

        pnlMenuLateral.add(pnlMenuLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 288, 100));

        pnlML2.setBackground(new java.awt.Color(13, 71, 161));
        pnlML2.setMaximumSize(new java.awt.Dimension(300, 300));
        pnlML2.setPreferredSize(new java.awt.Dimension(287, 300));
        pnlML2.setLayout(new java.awt.GridLayout(10, 1));

        pnlMenuPrincipal.setBackground(new java.awt.Color(21, 101, 192));
        pnlMenuPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        pnlMenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuPrincipal.setPreferredSize(new java.awt.Dimension(260, 50));
        pnlMenuPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlMenuPrincipalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlMenuPrincipalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlMenuPrincipalMousePressed(evt);
            }
        });

        lbMenuPrincipal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbMenuPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuPrincipal.setText("Principal");

        lbIconoPrincipal.setBackground(new java.awt.Color(21, 101, 182));
        lbIconoPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        lbIconoPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlMenuPrincipalLayout = new javax.swing.GroupLayout(pnlMenuPrincipal);
        pnlMenuPrincipal.setLayout(pnlMenuPrincipalLayout);
        pnlMenuPrincipalLayout.setHorizontalGroup(
            pnlMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuPrincipalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbIconoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMenuPrincipalLayout.setVerticalGroup(
            pnlMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuPrincipalLayout.createSequentialGroup()
                .addComponent(lbMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlMenuPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIconoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlML2.add(pnlMenuPrincipal);

        pnlMenuInventario.setBackground(new java.awt.Color(18, 90, 173));
        pnlMenuInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlMenuInventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlMenuInventarioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlMenuInventarioMousePressed(evt);
            }
        });

        lbMenuInventario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbMenuInventario.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuInventario.setText("Gestión Inventario");

        lbIconoInventario.setForeground(new java.awt.Color(255, 255, 255));
        lbIconoInventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlMenuInventarioLayout = new javax.swing.GroupLayout(pnlMenuInventario);
        pnlMenuInventario.setLayout(pnlMenuInventarioLayout);
        pnlMenuInventarioLayout.setHorizontalGroup(
            pnlMenuInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIconoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbMenuInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMenuInventarioLayout.setVerticalGroup(
            pnlMenuInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuInventarioLayout.createSequentialGroup()
                .addGroup(pnlMenuInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMenuInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMenuInventarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbIconoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pnlML2.add(pnlMenuInventario);

        pnlSubMenuInvetario1.setBackground(new java.awt.Color(18, 90, 173));
        pnlSubMenuInvetario1.setLayout(new java.awt.GridLayout(2, 1));

        pnlSubMenuInventario_Producto.setBackground(new java.awt.Color(18, 90, 173));
        pnlSubMenuInventario_Producto.setForeground(new java.awt.Color(255, 255, 255));
        pnlSubMenuInventario_Producto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlSubMenuInventario_Producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSubMenuInventario_ProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSubMenuInventario_ProductoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSubMenuInventario_ProductoMousePressed(evt);
            }
        });

        lbSubMenuInventarioProducto.setForeground(new java.awt.Color(255, 255, 255));
        lbSubMenuInventarioProducto.setText("Producto");

        javax.swing.GroupLayout pnlSubMenuInventario_ProductoLayout = new javax.swing.GroupLayout(pnlSubMenuInventario_Producto);
        pnlSubMenuInventario_Producto.setLayout(pnlSubMenuInventario_ProductoLayout);
        pnlSubMenuInventario_ProductoLayout.setHorizontalGroup(
            pnlSubMenuInventario_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubMenuInventario_ProductoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbIconoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSubMenuInventarioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        pnlSubMenuInventario_ProductoLayout.setVerticalGroup(
            pnlSubMenuInventario_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIconoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lbSubMenuInventarioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlSubMenuInvetario1.add(pnlSubMenuInventario_Producto);

        pnlSubMenuInventario_Categoria.setBackground(new java.awt.Color(18, 90, 173));
        pnlSubMenuInventario_Categoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlSubMenuInventario_Categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSubMenuInventario_CategoriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSubMenuInventario_CategoriaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSubMenuInventario_CategoriaMousePressed(evt);
            }
        });

        lbSubMenuInventarioCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lbSubMenuInventarioCategoria.setText("Categoría");

        javax.swing.GroupLayout pnlSubMenuInventario_CategoriaLayout = new javax.swing.GroupLayout(pnlSubMenuInventario_Categoria);
        pnlSubMenuInventario_Categoria.setLayout(pnlSubMenuInventario_CategoriaLayout);
        pnlSubMenuInventario_CategoriaLayout.setHorizontalGroup(
            pnlSubMenuInventario_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubMenuInventario_CategoriaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbIconoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSubMenuInventarioCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        pnlSubMenuInventario_CategoriaLayout.setVerticalGroup(
            pnlSubMenuInventario_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubMenuInventario_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbIconoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbSubMenuInventarioCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlSubMenuInvetario1.add(pnlSubMenuInventario_Categoria);

        pnlML2.add(pnlSubMenuInvetario1);

        pnlSubMenuInventario2.setBackground(new java.awt.Color(18, 90, 173));
        pnlSubMenuInventario2.setLayout(new java.awt.GridLayout(2, 1));

        pnlSubMenuInventario_Ubicacion.setBackground(new java.awt.Color(18, 90, 173));
        pnlSubMenuInventario_Ubicacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlSubMenuInventario_Ubicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSubMenuInventario_UbicacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSubMenuInventario_UbicacionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSubMenuInventario_UbicacionMousePressed(evt);
            }
        });

        lbSubMenuInventarioUbicacion.setForeground(new java.awt.Color(255, 255, 255));
        lbSubMenuInventarioUbicacion.setText("Ubicación");

        javax.swing.GroupLayout pnlSubMenuInventario_UbicacionLayout = new javax.swing.GroupLayout(pnlSubMenuInventario_Ubicacion);
        pnlSubMenuInventario_Ubicacion.setLayout(pnlSubMenuInventario_UbicacionLayout);
        pnlSubMenuInventario_UbicacionLayout.setHorizontalGroup(
            pnlSubMenuInventario_UbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubMenuInventario_UbicacionLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbIconoUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSubMenuInventarioUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        pnlSubMenuInventario_UbicacionLayout.setVerticalGroup(
            pnlSubMenuInventario_UbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIconoUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lbSubMenuInventarioUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlSubMenuInventario2.add(pnlSubMenuInventario_Ubicacion);

        jPanel7.setBackground(new java.awt.Color(18, 90, 173));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlSubMenuInventario2.add(jPanel7);

        pnlML2.add(pnlSubMenuInventario2);

        pnlMenuCompra.setBackground(new java.awt.Color(18, 90, 173));
        pnlMenuCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlMenuCompraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlMenuCompraMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlMenuCompraMousePressed(evt);
            }
        });

        lbMenuCompra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbMenuCompra.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuCompra.setText("Gestión Compra");

        lbIconoCompra.setBackground(new java.awt.Color(255, 255, 255));
        lbIconoCompra.setForeground(new java.awt.Color(255, 255, 255));
        lbIconoCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlMenuCompraLayout = new javax.swing.GroupLayout(pnlMenuCompra);
        pnlMenuCompra.setLayout(pnlMenuCompraLayout);
        pnlMenuCompraLayout.setHorizontalGroup(
            pnlMenuCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIconoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMenuCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMenuCompraLayout.setVerticalGroup(
            pnlMenuCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbMenuCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMenuCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIconoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 14, Short.MAX_VALUE))
        );

        pnlML2.add(pnlMenuCompra);

        pnlSubMenuCompra.setBackground(new java.awt.Color(18, 90, 173));
        pnlSubMenuCompra.setLayout(new java.awt.GridLayout(2, 1));

        pnlSubMenuCompra_Compra.setBackground(new java.awt.Color(18, 90, 173));
        pnlSubMenuCompra_Compra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlSubMenuCompra_Compra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSubMenuCompra_CompraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSubMenuCompra_CompraMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSubMenuCompra_CompraMousePressed(evt);
            }
        });

        lbSubMenuCompraLista.setForeground(new java.awt.Color(255, 255, 255));
        lbSubMenuCompraLista.setText("Compra");

        javax.swing.GroupLayout pnlSubMenuCompra_CompraLayout = new javax.swing.GroupLayout(pnlSubMenuCompra_Compra);
        pnlSubMenuCompra_Compra.setLayout(pnlSubMenuCompra_CompraLayout);
        pnlSubMenuCompra_CompraLayout.setHorizontalGroup(
            pnlSubMenuCompra_CompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubMenuCompra_CompraLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbIconoCompraLista, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSubMenuCompraLista, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        pnlSubMenuCompra_CompraLayout.setVerticalGroup(
            pnlSubMenuCompra_CompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubMenuCompra_CompraLayout.createSequentialGroup()
                .addGroup(pnlSubMenuCompra_CompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSubMenuCompra_CompraLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbIconoCompraLista, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbSubMenuCompraLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlSubMenuCompra.add(pnlSubMenuCompra_Compra);

        pnlSubMenuCompra_Proveedor.setBackground(new java.awt.Color(18, 90, 173));
        pnlSubMenuCompra_Proveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlSubMenuCompra_Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSubMenuCompra_ProveedorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSubMenuCompra_ProveedorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSubMenuCompra_ProveedorMousePressed(evt);
            }
        });

        lbSubMenuInventarioProveedor.setForeground(new java.awt.Color(255, 255, 255));
        lbSubMenuInventarioProveedor.setText("Proveedor");

        javax.swing.GroupLayout pnlSubMenuCompra_ProveedorLayout = new javax.swing.GroupLayout(pnlSubMenuCompra_Proveedor);
        pnlSubMenuCompra_Proveedor.setLayout(pnlSubMenuCompra_ProveedorLayout);
        pnlSubMenuCompra_ProveedorLayout.setHorizontalGroup(
            pnlSubMenuCompra_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubMenuCompra_ProveedorLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbIconoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSubMenuInventarioProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        pnlSubMenuCompra_ProveedorLayout.setVerticalGroup(
            pnlSubMenuCompra_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubMenuCompra_ProveedorLayout.createSequentialGroup()
                .addGroup(pnlSubMenuCompra_ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSubMenuCompra_ProveedorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbIconoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbSubMenuInventarioProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlSubMenuCompra.add(pnlSubMenuCompra_Proveedor);

        pnlML2.add(pnlSubMenuCompra);

        pnlMenuConfiguracionUser.setBackground(new java.awt.Color(18, 90, 173));
        pnlMenuConfiguracionUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuConfiguracionUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlMenuConfiguracionUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlMenuConfiguracionUserMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlMenuConfiguracionUserMousePressed(evt);
            }
        });

        lbMenuConfiguracion.setBackground(new java.awt.Color(51, 51, 51));
        lbMenuConfiguracion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbMenuConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuConfiguracion.setText("Configurarción de Usuario");

        lbIconoConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        lbIconoConfiguracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlMenuConfiguracionUserLayout = new javax.swing.GroupLayout(pnlMenuConfiguracionUser);
        pnlMenuConfiguracionUser.setLayout(pnlMenuConfiguracionUserLayout);
        pnlMenuConfiguracionUserLayout.setHorizontalGroup(
            pnlMenuConfiguracionUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuConfiguracionUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIconoConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbMenuConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMenuConfiguracionUserLayout.setVerticalGroup(
            pnlMenuConfiguracionUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuConfiguracionUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIconoConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 14, Short.MAX_VALUE))
            .addComponent(lbMenuConfiguracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlML2.add(pnlMenuConfiguracionUser);

        pnlSubMenuConfig.setBackground(new java.awt.Color(18, 90, 173));
        pnlSubMenuConfig.setLayout(new java.awt.GridLayout(2, 1));

        pnlSubMenuConfig_Usuario.setBackground(new java.awt.Color(18, 90, 173));
        pnlSubMenuConfig_Usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlSubMenuConfig_Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSubMenuConfig_UsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSubMenuConfig_UsuarioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSubMenuConfig_UsuarioMousePressed(evt);
            }
        });

        lbSubMenuConfigUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbSubMenuConfigUsuario.setText("Usuario");

        javax.swing.GroupLayout pnlSubMenuConfig_UsuarioLayout = new javax.swing.GroupLayout(pnlSubMenuConfig_Usuario);
        pnlSubMenuConfig_Usuario.setLayout(pnlSubMenuConfig_UsuarioLayout);
        pnlSubMenuConfig_UsuarioLayout.setHorizontalGroup(
            pnlSubMenuConfig_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubMenuConfig_UsuarioLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbIconoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSubMenuConfigUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        pnlSubMenuConfig_UsuarioLayout.setVerticalGroup(
            pnlSubMenuConfig_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubMenuConfig_UsuarioLayout.createSequentialGroup()
                .addGroup(pnlSubMenuConfig_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSubMenuConfig_UsuarioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbIconoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbSubMenuConfigUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlSubMenuConfig.add(pnlSubMenuConfig_Usuario);

        pnlSubMenuConfig_TipoUsuario.setBackground(new java.awt.Color(18, 90, 173));
        pnlSubMenuConfig_TipoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlSubMenuConfig_TipoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSubMenuConfig_TipoUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSubMenuConfig_TipoUsuarioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSubMenuConfig_TipoUsuarioMousePressed(evt);
            }
        });

        lbSubMenuConfTipoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbSubMenuConfTipoUsuario.setText("Tipo de Usuario");

        javax.swing.GroupLayout pnlSubMenuConfig_TipoUsuarioLayout = new javax.swing.GroupLayout(pnlSubMenuConfig_TipoUsuario);
        pnlSubMenuConfig_TipoUsuario.setLayout(pnlSubMenuConfig_TipoUsuarioLayout);
        pnlSubMenuConfig_TipoUsuarioLayout.setHorizontalGroup(
            pnlSubMenuConfig_TipoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubMenuConfig_TipoUsuarioLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbIconoTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSubMenuConfTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        pnlSubMenuConfig_TipoUsuarioLayout.setVerticalGroup(
            pnlSubMenuConfig_TipoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubMenuConfig_TipoUsuarioLayout.createSequentialGroup()
                .addGroup(pnlSubMenuConfig_TipoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSubMenuConfig_TipoUsuarioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbIconoTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbSubMenuConfTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlSubMenuConfig.add(pnlSubMenuConfig_TipoUsuario);

        pnlML2.add(pnlSubMenuConfig);

        pnlMenuLateral.add(pnlML2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 290, 490));

        pnlVistaPrincipal.add(pnlMenuLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 288, 550));

        pnlContenido.setBackground(new java.awt.Color(102, 102, 102));
        pnlContenido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlContenidoLayout = new javax.swing.GroupLayout(pnlContenido);
        pnlContenido.setLayout(pnlContenidoLayout);
        pnlContenidoLayout.setHorizontalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );
        pnlContenidoLayout.setVerticalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        pnlVistaPrincipal.add(pnlContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 70, 710, 520));

        pnlMenuBar.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenuBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCerrarSesion.setBackground(new java.awt.Color(0, 0, 0));
        pnlCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));

        lbCerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        lbCerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        lbCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCerrarSesion.setText("Cerrar Sesión");
        lbCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCerrarSesionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCerrarSesionMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlCerrarSesionLayout = new javax.swing.GroupLayout(pnlCerrarSesion);
        pnlCerrarSesion.setLayout(pnlCerrarSesionLayout);
        pnlCerrarSesionLayout.setHorizontalGroup(
            pnlCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCerrarSesionLayout.setVerticalGroup(
            pnlCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        pnlMenuBar.add(pnlCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 80, 40));

        pnlMovimiento.setBackground(new java.awt.Color(255, 255, 255));
        pnlMovimiento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlMovimientoMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlMovimientoMouseMoved(evt);
            }
        });
        pnlMovimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlMovimientoMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1002, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlMovimientoLayout = new javax.swing.GroupLayout(pnlMovimiento);
        pnlMovimiento.setLayout(pnlMovimientoLayout);
        pnlMovimientoLayout.setHorizontalGroup(
            pnlMovimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMovimientoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlMovimientoLayout.setVerticalGroup(
            pnlMovimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMenuBar.add(pnlMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 40));

        pnlUserSesion.setBackground(new java.awt.Color(0, 0, 0));
        pnlUserSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUserSesion.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblUserSesion.setForeground(new java.awt.Color(255, 255, 255));
        pnlUserSesion.add(lblUserSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 11, 100, 18));
        pnlUserSesion.add(lbIconoSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 11, 16, 18));

        pnlMenuBar.add(pnlUserSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 140, 40));

        pnlVistaPrincipal.add(pnlMenuBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 40));

        pnlTitulo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pnlVistaPrincipal.add(pnlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 40, 710, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlVistaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlVistaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        
        
    }//GEN-LAST:event_formWindowActivated

    private void pnlMenuPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuPrincipalMouseEntered
        if(pnlMenuPrincipal.getBackground().getRGB()== -15574355)
            setColor(pnlMenuPrincipal);
    }//GEN-LAST:event_pnlMenuPrincipalMouseEntered

    private void pnlMenuPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuPrincipalMouseExited
        if(pnlMenuInventario.getBackground().getRGB() != -15574355 || pnlMenuCompra.getBackground().getRGB() != -15574355
                || pnlMenuConfiguracionUser.getBackground().getRGB() != -15574355)
            resetColor(pnlMenuPrincipal);
    }//GEN-LAST:event_pnlMenuPrincipalMouseExited

    private void pnlMenuPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuPrincipalMousePressed
        resetColor(pnlMenuInventario);
        resetColor(pnlMenuCompra);
        resetColor(pnlMenuConfiguracionUser);
        setColor(pnlMenuPrincipal);
        //elimina panel de menu configuracion
        
        pnlML2.remove(pnlSubMenuCompra);
        pnlML2.remove(pnlSubMenuInvetario1);
        pnlML2.remove(pnlSubMenuInventario2);
        pnlML2.remove(pnlSubMenuConfig);
        pnlML2.revalidate();
        pnlML2.repaint();

        
        
        
        
        
        cargar_ContenedorPrincipal(usserlogeado);
    }//GEN-LAST:event_pnlMenuPrincipalMousePressed

    private void pnlMenuInventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuInventarioMouseEntered
        if(pnlMenuInventario.getBackground().getRGB() == -15574355)
            setColor(pnlMenuInventario);
    }//GEN-LAST:event_pnlMenuInventarioMouseEntered

    private void pnlMenuInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuInventarioMouseExited
        if(pnlMenuPrincipal.getBackground().getRGB() != -15574355 || pnlMenuCompra.getBackground().getRGB() != -15574355
                || pnlMenuConfiguracionUser.getBackground().getRGB() != -15574355)
            resetColor(pnlMenuInventario);
        
    }//GEN-LAST:event_pnlMenuInventarioMouseExited

    private void pnlMenuInventarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuInventarioMousePressed
        resetColor(pnlMenuPrincipal);
        resetColor(pnlMenuCompra);
        resetColor(pnlMenuConfiguracionUser);
        setColor(pnlMenuInventario);
                
        pnlML2.remove(pnlMenuCompra);
        pnlML2.remove(pnlMenuConfiguracionUser);
        pnlML2.remove(pnlSubMenuCompra);
        pnlML2.remove(pnlSubMenuConfig);
        pnlML2.add(pnlSubMenuInvetario1);
        pnlML2.add(pnlSubMenuInventario2);
        pnlML2.add(pnlMenuCompra);
        pnlML2.add(pnlMenuConfiguracionUser);
        pnlML2.revalidate();
        pnlML2.repaint();

    }//GEN-LAST:event_pnlMenuInventarioMousePressed

    private void pnlMenuCompraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuCompraMouseEntered
        if(pnlMenuCompra.getBackground().getRGB() == -15574355)
            setColor(pnlMenuCompra);
        
    }//GEN-LAST:event_pnlMenuCompraMouseEntered

    private void pnlMenuCompraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuCompraMouseExited
        if(pnlMenuPrincipal.getBackground().getRGB() != -15574355 || pnlMenuInventario.getBackground().getRGB() != -15574355
                || pnlMenuConfiguracionUser.getBackground().getRGB() != -15574355)
            resetColor(pnlMenuCompra);
        
    }//GEN-LAST:event_pnlMenuCompraMouseExited

    private void pnlMenuCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuCompraMousePressed
        resetColor(pnlMenuPrincipal);
        resetColor(pnlMenuInventario);
        resetColor(pnlMenuConfiguracionUser);
        setColor(pnlMenuCompra);
                
        
        
        pnlML2.remove(pnlSubMenuInventario2);
        pnlML2.remove(pnlSubMenuInvetario1);
        pnlML2.remove(pnlMenuConfiguracionUser);
        pnlML2.remove(pnlSubMenuConfig);
        pnlML2.add(pnlSubMenuCompra);
        pnlML2.add(pnlMenuConfiguracionUser);
        pnlML2.revalidate();
        pnlML2.repaint();
                
        
    }//GEN-LAST:event_pnlMenuCompraMousePressed

    private void pnlMenuConfiguracionUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuConfiguracionUserMouseEntered
       if(pnlMenuConfiguracionUser.getBackground().getRGB() == -15574355)
            setColor(pnlMenuConfiguracionUser);
        
    }//GEN-LAST:event_pnlMenuConfiguracionUserMouseEntered

    private void pnlMenuConfiguracionUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuConfiguracionUserMouseExited
        if(pnlMenuPrincipal.getBackground().getRGB() != -15574355 || pnlMenuInventario.getBackground().getRGB() != -15574355
                || pnlMenuCompra.getBackground().getRGB() != -15574355)
            resetColor(pnlMenuConfiguracionUser);
        
    }//GEN-LAST:event_pnlMenuConfiguracionUserMouseExited

    private void pnlMenuConfiguracionUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuConfiguracionUserMousePressed
        resetColor(pnlMenuPrincipal);
        resetColor(pnlMenuInventario);
        resetColor(pnlMenuCompra);
        setColor(pnlMenuConfiguracionUser);
         
        
        pnlML2.remove(pnlSubMenuCompra);
        pnlML2.remove(pnlSubMenuInvetario1);
        pnlML2.remove(pnlSubMenuInventario2);
        pnlML2.add(pnlSubMenuConfig);
        pnlML2.revalidate();
        pnlML2.repaint();

        
            
        //cargar contenedor de vista de configuraciones
        //cargar_ContenedorConfiguracionUsuario();
        
    }//GEN-LAST:event_pnlMenuConfiguracionUserMousePressed

    private void lbCerrarSesionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarSesionMousePressed
        Vista_Login viewlog = new Vista_Login();
        viewlog.setVisible(true);
        viewlog.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lbCerrarSesionMousePressed

    private void lbCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarSesionMouseExited
        lbCerrarSesion.setForeground(new Color(255, 255, 255));
        pnlCerrarSesion.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_lbCerrarSesionMouseExited

    private void lbCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarSesionMouseEntered
        pnlCerrarSesion.setBackground(Color.RED);
        lbCerrarSesion.setForeground(Color.WHITE);
    }//GEN-LAST:event_lbCerrarSesionMouseEntered

    private void pnlMovimientoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMovimientoMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
        
    }//GEN-LAST:event_pnlMovimientoMouseDragged

    private void pnlMovimientoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMovimientoMouseMoved
        
        
    }//GEN-LAST:event_pnlMovimientoMouseMoved

    private void pnlMovimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMovimientoMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlMovimientoMousePressed

    private void pnlSubMenuInventario_ProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuInventario_ProductoMousePressed
        cargar_ContenedorProducto();
    }//GEN-LAST:event_pnlSubMenuInventario_ProductoMousePressed

    private void pnlSubMenuInventario_ProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuInventario_ProductoMouseExited
        resetColor(pnlSubMenuInventario_Producto);
    }//GEN-LAST:event_pnlSubMenuInventario_ProductoMouseExited

    private void pnlSubMenuInventario_ProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuInventario_ProductoMouseEntered
        setColor(pnlSubMenuInventario_Producto);
    }//GEN-LAST:event_pnlSubMenuInventario_ProductoMouseEntered

    private void pnlSubMenuInventario_CategoriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuInventario_CategoriaMousePressed
        cargar_ContenedorCategoria();
    }//GEN-LAST:event_pnlSubMenuInventario_CategoriaMousePressed

    private void pnlSubMenuInventario_CategoriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuInventario_CategoriaMouseExited
        resetColor(pnlSubMenuInventario_Categoria);
    }//GEN-LAST:event_pnlSubMenuInventario_CategoriaMouseExited

    private void pnlSubMenuInventario_CategoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuInventario_CategoriaMouseEntered
        setColor(pnlSubMenuInventario_Categoria);
    }//GEN-LAST:event_pnlSubMenuInventario_CategoriaMouseEntered

    private void pnlSubMenuCompra_CompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuCompra_CompraMousePressed
        cargar_ContenedorCompra();
    }//GEN-LAST:event_pnlSubMenuCompra_CompraMousePressed

    private void pnlSubMenuCompra_CompraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuCompra_CompraMouseExited
        resetColor(pnlSubMenuCompra_Compra);
    }//GEN-LAST:event_pnlSubMenuCompra_CompraMouseExited

    private void pnlSubMenuCompra_CompraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuCompra_CompraMouseEntered
        setColor(pnlSubMenuCompra_Compra);
    }//GEN-LAST:event_pnlSubMenuCompra_CompraMouseEntered

    private void pnlSubMenuCompra_ProveedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuCompra_ProveedorMousePressed
        cargar_ContenedorProveedor();
    }//GEN-LAST:event_pnlSubMenuCompra_ProveedorMousePressed

    private void pnlSubMenuCompra_ProveedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuCompra_ProveedorMouseExited
        resetColor(pnlSubMenuCompra_Proveedor);
    }//GEN-LAST:event_pnlSubMenuCompra_ProveedorMouseExited

    private void pnlSubMenuCompra_ProveedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuCompra_ProveedorMouseEntered
        setColor(pnlSubMenuCompra_Proveedor);
    }//GEN-LAST:event_pnlSubMenuCompra_ProveedorMouseEntered

    private void pnlSubMenuConfig_UsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuConfig_UsuarioMousePressed
        cargar_ContenedorUsuario();
    }//GEN-LAST:event_pnlSubMenuConfig_UsuarioMousePressed

    private void pnlSubMenuConfig_UsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuConfig_UsuarioMouseExited
        resetColor(pnlSubMenuConfig_Usuario);
    }//GEN-LAST:event_pnlSubMenuConfig_UsuarioMouseExited

    private void pnlSubMenuConfig_UsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuConfig_UsuarioMouseEntered
        setColor(pnlSubMenuConfig_Usuario);
    }//GEN-LAST:event_pnlSubMenuConfig_UsuarioMouseEntered

    private void pnlSubMenuConfig_TipoUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuConfig_TipoUsuarioMousePressed
        cargar_ContenedorTipoUsuario();
    }//GEN-LAST:event_pnlSubMenuConfig_TipoUsuarioMousePressed

    private void pnlSubMenuConfig_TipoUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuConfig_TipoUsuarioMouseExited
        resetColor(pnlSubMenuConfig_TipoUsuario);
    }//GEN-LAST:event_pnlSubMenuConfig_TipoUsuarioMouseExited

    private void pnlSubMenuConfig_TipoUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuConfig_TipoUsuarioMouseEntered
        setColor(pnlSubMenuConfig_TipoUsuario);
    }//GEN-LAST:event_pnlSubMenuConfig_TipoUsuarioMouseEntered

    private void pnlSubMenuInventario_UbicacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuInventario_UbicacionMousePressed
        cargar_ContenedorUbicacion();
    }//GEN-LAST:event_pnlSubMenuInventario_UbicacionMousePressed

    private void pnlSubMenuInventario_UbicacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuInventario_UbicacionMouseExited
        resetColor(pnlSubMenuInventario_Ubicacion);
    }//GEN-LAST:event_pnlSubMenuInventario_UbicacionMouseExited

    private void pnlSubMenuInventario_UbicacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSubMenuInventario_UbicacionMouseEntered
        setColor(pnlSubMenuInventario_Ubicacion);
    }//GEN-LAST:event_pnlSubMenuInventario_UbicacionMouseEntered

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
            java.util.logging.Logger.getLogger(Vista_MenuPrincipal_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_MenuPrincipal_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_MenuPrincipal_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_MenuPrincipal_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Vista_MenuPrincipal_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.ButtonGroup btnGrupo1;
    public static javax.swing.ButtonGroup btnGrupo2;
    public static javax.swing.ButtonGroup btnGrupo3;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel7;
    public javax.swing.JLabel lbCerrarSesion;
    public static javax.swing.JLabel lbIconoCategoria;
    public javax.swing.JLabel lbIconoCompra;
    public static javax.swing.JLabel lbIconoCompraLista;
    public javax.swing.JLabel lbIconoConfiguracion;
    public javax.swing.JLabel lbIconoInventario;
    public javax.swing.JLabel lbIconoPrincipal;
    public static javax.swing.JLabel lbIconoProducto;
    public static javax.swing.JLabel lbIconoProveedor;
    public static javax.swing.JLabel lbIconoSesion;
    public static javax.swing.JLabel lbIconoTipoUsuario;
    public static javax.swing.JLabel lbIconoUbicacion;
    public static javax.swing.JLabel lbIconoUsuario;
    public javax.swing.JLabel lbLogo;
    public static javax.swing.JLabel lbMenuCompra;
    public static javax.swing.JLabel lbMenuConfiguracion;
    public static javax.swing.JLabel lbMenuInventario;
    public static javax.swing.JLabel lbMenuPrincipal;
    public static javax.swing.JLabel lbSubMenuCompraLista;
    public static javax.swing.JLabel lbSubMenuConfTipoUsuario;
    public static javax.swing.JLabel lbSubMenuConfigUsuario;
    public static javax.swing.JLabel lbSubMenuInventarioCategoria;
    public static javax.swing.JLabel lbSubMenuInventarioProducto;
    public static javax.swing.JLabel lbSubMenuInventarioProveedor;
    public static javax.swing.JLabel lbSubMenuInventarioUbicacion;
    public static javax.swing.JLabel lblUserSesion;
    public javax.swing.JPanel pnlCerrarSesion;
    public static javax.swing.JPanel pnlContenido;
    public javax.swing.JPanel pnlML2;
    public static javax.swing.JPanel pnlMenuBar;
    public javax.swing.JPanel pnlMenuCompra;
    public javax.swing.JPanel pnlMenuConfiguracionUser;
    public javax.swing.JPanel pnlMenuInventario;
    public javax.swing.JPanel pnlMenuLateral;
    public static javax.swing.JPanel pnlMenuLogo;
    public javax.swing.JPanel pnlMenuPrincipal;
    public static javax.swing.JPanel pnlMovimiento;
    public javax.swing.JPanel pnlSubMenuCompra;
    public static javax.swing.JPanel pnlSubMenuCompra_Compra;
    public static javax.swing.JPanel pnlSubMenuCompra_Proveedor;
    public javax.swing.JPanel pnlSubMenuConfig;
    public static javax.swing.JPanel pnlSubMenuConfig_TipoUsuario;
    public static javax.swing.JPanel pnlSubMenuConfig_Usuario;
    public javax.swing.JPanel pnlSubMenuInventario2;
    public static javax.swing.JPanel pnlSubMenuInventario_Categoria;
    public static javax.swing.JPanel pnlSubMenuInventario_Producto;
    public static javax.swing.JPanel pnlSubMenuInventario_Ubicacion;
    public javax.swing.JPanel pnlSubMenuInvetario1;
    public static javax.swing.JPanel pnlTitulo;
    public static javax.swing.JPanel pnlUserSesion;
    public static javax.swing.JPanel pnlVistaPrincipal;
    // End of variables declaration//GEN-END:variables

}
