package com.SistemaAlmacen.Compra.DAO;

import com.SistemaAlmacen.Compra.Entidad.Compra;
import com.SistemaAlmacen.Compra.Entidad.Proveedor;
import com.SistemaAlmacen.Configuracion.Entidad.Tipo_usuario;
import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CompraDAO {
    CallableStatement cs;
    ResultSet rs;
    ArrayList<Compra> arrCompra;
    Compra compra = new Compra();
    
    public CompraDAO() {
        this.arrCompra = new ArrayList<>();
    }
    
    public boolean registrarCompra(Connection con, Compra comp){
        boolean res = false;

        try {
            cs=(CallableStatement) con.prepareCall("{call p_registrar_compra(?,?,?,?)}");
            
            cs.setDate(1, comp.getFecha_compra());
            cs.setDouble(2, comp.getPrecio_total());
            cs.setString(3, comp.getProv().getRazon_Social());
            cs.setString(4, comp.getUsu().getNombre());
            
            int consul=cs.executeUpdate();
            if(consul>0){
                res = true;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return res; 
    }
    
    public boolean eliminarCompra(Connection con, int id){
        boolean res = false;
        try {
            cs=(CallableStatement) con.prepareCall("{call p_eliminar_compra(?)}");
            cs.setInt(1, id);
            
            int consul=cs.executeUpdate();
            if(consul>0){
                res = true;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return res; 
    }
    
    public boolean modificarCompra(Connection con, Compra comp){
        boolean res = false;
        try {
            cs=(CallableStatement) con.prepareCall("{call p_eliminar_compra(?,?,?,?,?)}");
            cs.setInt(1, comp.getId_compra());
            cs.setDate(2, comp.getFecha_compra());
            cs.setDouble(3, comp.getPrecio_total());
            cs.setString(4, comp.getProv().getRuc());
            cs.setString(5, comp.getUsu().getNombre());
            
            int consul=cs.executeUpdate();
            if(consul>0){
                res = true;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return res; 
    }
    
    public ArrayList<Compra> listarCompra(Connection con){
        ArrayList<Compra> arr_compra = new ArrayList<>();
        Compra com;
        try {
            cs=(CallableStatement) con.prepareCall("{? = call f_listar_compra}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();
            rs=(ResultSet) cs.getObject(1);
            while(rs.next()){
                String razon_social,user_nombre;
                int id_compra;
                Date fecha_compra;
                double precio_total;
                
                id_compra = rs.getInt(1);
                fecha_compra=rs.getDate(2);
                precio_total=(double)rs.getInt(3);
                razon_social = rs.getString(4);
                user_nombre=rs.getString(5);
                
                
                com=new Compra(id_compra,fecha_compra,precio_total,new Proveedor(razon_social, "", "", ""),new Usuario(user_nombre, "", "", "", "", "", "",""),null);
                arr_compra.add(com);
                 
            }
            this.arrCompra=arr_compra;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        return this.arrCompra; 
    }
   
    
    public Compra obtenerCompra(Connection con,int id){
        try {
            cs=(CallableStatement) con.prepareCall("{? = call f_obtener_compra(?)}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.setInt(2, id);
            cs.execute();
            rs=(ResultSet) cs.getObject(1);

            if(rs.next()){
                String nombre,dni,ap_p,ap_m,usuar,contra,email,telf,tipo;
                int cod;
                
                cod = rs.getInt(1);
                nombre = rs.getString(2);
                ap_p = rs.getString(3);  
                ap_m = rs.getString(4);
                //fec_nac = rs.getDate(7);
                telf=rs.getString(5);
                email=rs.getString(6);
                dni=rs.getString(7);
                usuar=rs.getString(8);
                contra=rs.getString(9);
                tipo = rs.getString(10);
                /*
                Compra comp= new Compra(cod, nombre, ap_p, ap_m, telf, email, dni, usuar, contra, new Tipo_usuario(tipo));
                compra = comp;
                */
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return compra;
        
    }
    
    public ArrayList<Compra> buscarCompra(Connection con,String buscar){
        ArrayList<Compra> arr_comp = new ArrayList<>();
        Compra com;
        try {
            if(buscar.equalsIgnoreCase("")){
                cs=(CallableStatement) con.prepareCall("{? = call f_listar_compra}");
                cs.registerOutParameter(1, Types.REF_CURSOR);
            }else{
                cs=(CallableStatement) con.prepareCall("{? = call f_buscar_compra(?)}");
                cs.registerOutParameter(1, Types.REF_CURSOR);
                cs.setString(2, buscar);
            }
            cs.execute();
            rs=(ResultSet) cs.getObject(1);
            
            while(rs.next()){
                String razon_social,user_nombre;
                int id_compra;
                Date fecha_compra;
                double precio_total;
                
                id_compra = rs.getInt(1);
                fecha_compra=rs.getDate(2);
                precio_total=(double)rs.getInt(3);
                razon_social = rs.getString(4);
                user_nombre=rs.getString(5);
                
                
                com=new Compra(id_compra,fecha_compra,precio_total,new Proveedor(razon_social, "", "", ""),new Usuario(user_nombre, "", "", "", "", "", "",""),null);
                arr_comp.add(com);
                
            }
            this.arrCompra=arr_comp;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrCompra;
        
    }
    
    
    public int codigoActual(Connection con){
        int id=0;
        rs=null;
        //String sql="select MAX(cod_v) from venta"; 
        try{
            cs = (CallableStatement) con.prepareCall("{? = call f_obtener_codigocompra}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();
            rs=(ResultSet) cs.getObject(1);
            if(rs.next()){
                id=rs.getInt(1);
            }
        }catch(SQLException e ){
            System.out.println(e);
        }
        
        return id;
    }
 
}
