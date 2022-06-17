
package com.SistemaAlmacen.General.BO;


import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import com.SistemaAlmacen.General.DAO.LoginDAO;
import com.SistemaAlmacen.General.Entidad.Conexion;
import com.SistemaAlmacen.General.Entidad.Login;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class LoginBO {
    
    Conexion c;
    Connection con = null;
    
    //private String mensaje = "";
    private LoginDAO logdao = new LoginDAO();
    private Usuario user = null;
    
    public LoginBO(){
        this.c = new Conexion();
        
    }
    
    public Usuario iniciarSesion(Login log){
        con = c.getconexion();     
        try{
            user = logdao.iniciarSesion(con,log);
            //con.rollback();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null," "+e.getMessage());
        }finally{
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null," "+e.getMessage());
            }
        }

        return user;
    }
    
    
    
    
}
