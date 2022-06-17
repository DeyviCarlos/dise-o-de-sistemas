package com.SistemaAlmacen.General.DAO;


import com.SistemaAlmacen.Configuracion.Entidad.Tipo_usuario;
import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import com.SistemaAlmacen.General.Entidad.Login;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

public class LoginDAO {
    CallableStatement cs = null;
    ResultSet rs=null;
 
    public LoginDAO() {   
    }

    public Usuario iniciarSesion(Connection con,Login log){
        Usuario usuarioaux = null; 
        try {
            cs=(CallableStatement) con.prepareCall("{? = call f_iniciarsesion(?,?)}");
            cs.registerOutParameter(1,Types.REF_CURSOR);
            cs.setString(2, log.getUser());
            cs.setString(3, log.getContra());
            cs.execute();
            rs=(ResultSet) cs.getObject(1);

            if(rs.next()){
                String nombre, apellidoP,apellidom,telefono,email,dni,user,contra;
                int id,id_tipo;
                id = rs.getInt(1);
                nombre = rs.getString(2);
                apellidoP = rs.getString(3);
                apellidom = rs.getString(4);
                telefono = rs.getString(5);
                email = rs.getString(6);
                dni = rs.getString(7);
                user = rs.getString(8);
                contra = rs.getString(9);
                id_tipo = rs.getInt(10);
                
                
                usuarioaux = new Usuario(id,nombre, apellidoP, apellidom, telefono, email, dni, user, contra,new Tipo_usuario(id_tipo));
                
            } 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        return usuarioaux;
    }
    
}
