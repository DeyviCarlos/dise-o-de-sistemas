package com.SistemaAlmacen.Configuracion.DAO;


import com.SistemaAlmacen.Configuracion.Entidad.Tipo_usuario;
import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    CallableStatement cs = null;
    ResultSet rs = null; 
    ArrayList<Usuario> arrUsuario;
    Usuario usuario =null;
    
    public UsuarioDAO() {
        this.arrUsuario = new ArrayList<>();
    }
    
    public boolean registrarUsuario(Connection con,Usuario usuario){
        
        
        boolean res=false;
        try {
            cs=(CallableStatement) con.prepareCall("{call p_registrar_usuario(?,?,?,?,?,?,?,?,?)}");
            
            cs.setString(1, usuario.getNombre());
            cs.setString(2, usuario.getApelliP());
            cs.setString(3, usuario.getApellim());
            cs.setString(4, usuario.getTelefono());
            cs.setString(5, usuario.getEmail());
            cs.setString(6, usuario.getDni());
            cs.setString(7, usuario.getUser_nombre());
            cs.setString(8, usuario.getContra());
            cs.setString(9, usuario.getT_user().getNombre());

            int consul=cs.executeUpdate();
            if(consul>0){
                res = true;
            }/*
            else{
                return false;
            }*/
            //cs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return res;
        
    }
    
    public boolean modificarUsuario(Connection con,Usuario usuario){
        
        boolean res=false;
        try {
            cs=(CallableStatement) con.prepareCall("{call p_modificar_usuario(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, usuario.getId_usuario());
            cs.setString(2, usuario.getNombre());
            cs.setString(3, usuario.getApelliP());
            cs.setString(4, usuario.getApellim());
            cs.setString(5, usuario.getTelefono());
            cs.setString(6, usuario.getEmail());
            cs.setString(7, usuario.getDni());
            cs.setString(8, usuario.getUser_nombre());
            cs.setString(9, usuario.getContra());
            cs.setString(10, usuario.getT_user().getNombre());

            int consul=cs.executeUpdate();
            if(consul>0){
                res = true;
            }/*
            else{
                return false;
            }*/
            //cs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return res;
        
    }
    
    public boolean eliminarUsuario(Connection con,int id){
        System.out.println("elimina: "+id);
        boolean res=false;
        try {
            cs=(CallableStatement) con.prepareCall("{call p_eliminar_usuario(?)}");
            cs.setInt(1, id);
            
            int consul=cs.executeUpdate();
            if(consul>0){
                res = true;
            }/*
            else{
                return false;
            }*/
            //cs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return res;
        
    }
    
    public Usuario obtenerUsuario(Connection con,int id){
        try {
            cs=(CallableStatement) con.prepareCall("{? = call f_obtener_usuario(?)}");
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
                Usuario user= new Usuario(cod, nombre, ap_p, ap_m, telf, email, dni, usuar, contra, new Tipo_usuario(tipo));
                usuario = user;
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return usuario;
        
    }
    
    public ArrayList<Usuario> buscarUsuario(Connection con,String buscar){
        ArrayList<Usuario> arr_usu = new ArrayList<>();
        try {
            if(buscar.equalsIgnoreCase("")){
                cs=(CallableStatement) con.prepareCall("{? = call f_listar_usuario}");
                cs.registerOutParameter(1, Types.REF_CURSOR);
            }else{
                cs=(CallableStatement) con.prepareCall("{? = call f_buscar_usuario(?)}");
                cs.registerOutParameter(1, Types.REF_CURSOR);
                cs.setString(2, buscar);
            }
            cs.execute();
            rs=(ResultSet) cs.getObject(1);
            
            while(rs.next()){
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
                Usuario user= new Usuario(cod, nombre, ap_p, ap_m, telf, email, dni, usuar, contra, new Tipo_usuario(tipo));
                arr_usu.add(user);
            }
            this.arrUsuario=arr_usu;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrUsuario;
        
    }
    
    public ArrayList<Usuario> listarUsuarios(Connection con){
        
        ArrayList<Usuario> arr_usu = new ArrayList<>();
         
        Usuario  user;
        
        //Date fec_contra,fec_nac;
        //java.util.Date fec;
        try {
            cs=(CallableStatement) con.prepareCall("{? = call f_listar_usuario}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();
            rs=(ResultSet) cs.getObject(1);

            while(rs.next()){
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
                //fec_contra = rs.getDate(12);
                
                
                user=new Usuario(cod, nombre, ap_p, ap_m, telf, email, dni, usuar, contra,new Tipo_usuario(tipo));
                arr_usu.add(user);

            }
            this.arrUsuario=arr_usu;
      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return arrUsuario;
    }
    
}
