/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaAlmacen.Configuracion.DAO;

//import inventarios.entidades.Tipo_usuario;
import com.SistemaAlmacen.Configuracion.Entidad.Tipo_usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author GINO
 */
public class Tipo_usuarioDAO {
    private String mensaje;
    ArrayList<Tipo_usuario> arrTpUsuario = new ArrayList<>(); 
    
    public boolean agregarTipoUsuario(Connection con,Tipo_usuario tipoUsuario){
        boolean result = false;
        System.out.println(con);
        CallableStatement cs = null;
        try {
            //recibe la conexion 
            cs = (CallableStatement) con.prepareCall("call P_REGISTRAR_TIPOUSUARIO(?)");
            cs.setString(1, tipoUsuario.getNombre());
            cs.execute();
            cs.close();
            mensaje="GUARDADO CORRECTAMENTE";
            result = true;
        } catch (Exception e) {
            mensaje="NO SE PUDO GUARDAR \n"+e.getMessage();
        }
        return result;
    }
    public boolean eliminarTipoUsuario(Connection con, int id){//
        boolean result = false;
        CallableStatement cs = null;
        try {
            //recibe la conexion 
            cs = (CallableStatement) con.prepareCall("call P_ELIMINAR_TIPOUSUARIO(?)");
            cs.setInt(1,id );
            cs.execute();
            cs.close();
            mensaje="ELIMINADO CORRECTAMENTE";
            result = true;
        } catch (Exception e) {
            mensaje="NO SE PUDO ELIMINAR:  \n"+e.getMessage();
        }
        return result;
    }
    
    public boolean modificarTipoUsuario(Connection con, Tipo_usuario tipoUsuario){ 
        boolean result = false;
        CallableStatement cs = null;
        try {
            //recibe la conexion 
            cs = (CallableStatement) con.prepareCall("call P_MODIFICAR_TIPOUSUARIO(?,?)");
            
            cs.setInt(1,tipoUsuario.getTipouser());
            cs.setString(2,tipoUsuario.getNombre());
            cs.execute();
            cs.close();
            mensaje="MODIFICADO CORRECTAMENTE";
            result = true;
        } catch (Exception e) {
            mensaje="NO SE PUDO MODIFICAR:  \n"+e.getMessage();
        }
        return result;
    }
    
    public void listarComboTipoUsuario(Connection con,JComboBox cbox){
        DefaultComboBoxModel model= new DefaultComboBoxModel();
        CallableStatement cs = null;

        ResultSet rs=null; //Obtiene los resultados del Query
        try {
            //
            cs = (CallableStatement) con.prepareCall("{? = call F_LISTAR_TIPOUSUARIO}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();
            rs = (ResultSet)cs.getObject(1);
            
            while(rs.next()){
                Tipo_usuario tipoUsuario=new Tipo_usuario();
                tipoUsuario.setTipouser(rs.getInt(1));
                tipoUsuario.setNombre(rs.getString(2));
                
                
                model.addElement(tipoUsuario.getNombre());
            }
            cbox.setModel(model);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Tipo_usuario> listarTipoUsuario(Connection con){
        
        ArrayList<Tipo_usuario> arr_tipoUsuario = new ArrayList<>();
         
        Tipo_usuario  tipoUsuario;
        CallableStatement cs = null;
        ResultSet rs=null; 

        try {
            cs=(CallableStatement) con.prepareCall("{? = call f_listar_tipousuario}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();
            rs=(ResultSet) cs.getObject(1);

            while(rs.next()){
                String nombre;
                int cod;
                
                cod = rs.getInt(1);
                nombre = rs.getString(2);
                tipoUsuario=new Tipo_usuario(cod,nombre);
                arr_tipoUsuario.add(tipoUsuario);

            }
            
            return arr_tipoUsuario;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        return arr_tipoUsuario;
      
    }
    
    public Tipo_usuario obtenerTipoUsuario(Connection con,int id){
        CallableStatement cs = null;
        Tipo_usuario  tipoUsuario = null;
        ResultSet rs=null;
        try {
            cs=(CallableStatement) con.prepareCall("{? = call f_obtener_tipousuario(?)}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.setInt(2, id);
            cs.execute();
            rs=(ResultSet) cs.getObject(1);

            if(rs.next()){
                String nombre;
                int cod;
                
                cod = rs.getInt(1);
                nombre = rs.getString(2);
               
               tipoUsuario =new Tipo_usuario(cod,nombre);
               
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return tipoUsuario;
        
    }
    
     public ArrayList<Tipo_usuario> buscarTipoUsuario(Connection con,String buscar){
        ArrayList<Tipo_usuario> arr_tipoUsuario = new ArrayList<>();
        CallableStatement cs = null;
        ResultSet rs=null;
        try {
            if(buscar.equalsIgnoreCase("")){
                cs=(CallableStatement) con.prepareCall("{? = call f_listar_tipousuario}");
                cs.registerOutParameter(1, Types.REF_CURSOR);
            }else{
                cs=(CallableStatement) con.prepareCall("{? = call f_buscar_tipousuario(?)}");
                cs.registerOutParameter(1, Types.REF_CURSOR);
                cs.setString(2, buscar);
            }
            cs.execute();
            rs=(ResultSet) cs.getObject(1);
            
            while(rs.next()){
                String nombre;
                int cod;
                
                cod = rs.getInt(1);
                nombre = rs.getString(2);
                
                Tipo_usuario tipoUsuario = new Tipo_usuario(cod, nombre);
                arr_tipoUsuario.add(tipoUsuario);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arr_tipoUsuario;
        
    }
    
    
}
