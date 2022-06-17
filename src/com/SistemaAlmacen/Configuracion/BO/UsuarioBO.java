package com.SistemaAlmacen.Configuracion.BO;


import com.SistemaAlmacen.Configuracion.DAO.UsuarioDAO;
import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import com.SistemaAlmacen.General.Entidad.Conexion;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioBO {
    Connection con;
    Conexion c;
    ArrayList<Usuario> arrUsuario = null;
    UsuarioDAO userdao = new UsuarioDAO();
    Usuario usua = null;
    public UsuarioBO(){
        this.c = new Conexion();
    }
    
    public boolean registrarUsuario(Usuario usuario){
        boolean result = false;
        con = c.getconexion();
        try{
            result = userdao.registrarUsuario(con, usuario);  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null," "+e.getMessage());
            }
        }
        return result;
    }
    
    public boolean modificarUsuario(Usuario usuario){
        boolean result = false;
        con = c.getconexion();
        try{
            result = userdao.modificarUsuario(con, usuario);  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null," "+e.getMessage());
            }
        }
        return result;
    }
    
    public boolean eliminarUsuario(int id){
        boolean result = false;
        con = c.getconexion();
        try{
            result = userdao.eliminarUsuario(con, id);  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null," "+e.getMessage());
            }
        }
        return result;
    }
    public Usuario obtenerUsuario(int id){
        con = c.getconexion();
        try{
            usua = userdao.obtenerUsuario(con, id);  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null," "+e.getMessage());
            }
        }
        
        return usua;
    }
    
    public ArrayList<Usuario> buscarUsuario(String buscar){
        con = c.getconexion();
        try{
            arrUsuario = userdao.buscarUsuario(con, buscar);  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null," "+e.getMessage());
            }
        }
        
        return arrUsuario;
    }
    
    
    public ArrayList<Usuario> listarUsuario(){
        con = c.getconexion();
        try{
            arrUsuario = userdao.listarUsuarios(con);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null," "+e.getMessage());
            }
        }
        
        return arrUsuario;
    }
         
}
    
    
    

