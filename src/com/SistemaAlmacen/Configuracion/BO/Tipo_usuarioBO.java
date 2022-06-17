/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaAlmacen.Configuracion.BO;



import com.SistemaAlmacen.Configuracion.DAO.Tipo_usuarioDAO;
import com.SistemaAlmacen.Configuracion.Entidad.Tipo_usuario;
import com.SistemaAlmacen.General.Entidad.Conexion;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author GINO
 */
public class Tipo_usuarioBO {
    private String mensaje;
    private Tipo_usuarioDAO tipoUsuarioDao = new Tipo_usuarioDAO();
    
    public boolean agregarTipoUsuario(Tipo_usuario tipoUsuario){
        //Creamos nuestra conexion
        boolean result = false;
        Connection conn = Conexion.getconexion();
        try {
            result=tipoUsuarioDao.agregarTipoUsuario(conn, tipoUsuario);
            //conn.rollback();
            
        } catch (Exception e) {
            mensaje=mensaje + " " + e.getMessage();
            //conn.commit()
        }finally{
            try {
                if(conn !=null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje=mensaje + " " + e.getMessage();
            }
        }
        return result;
    }
    
    public boolean eliminarTipoUsuario(int id){
        //Creamos nuestra conexion
        boolean result = false;
        Connection conn = Conexion.getconexion();
        try {
            result=tipoUsuarioDao.eliminarTipoUsuario(conn, id);
            //conn.rollback();
            
        } catch (Exception e) {
            mensaje=mensaje + " " + e.getMessage();
            //conn.commit()
        }finally{
            try {
                if(conn !=null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje=mensaje + " " + e.getMessage();
            }
        }
        return result;
    }
    
    public boolean modificarTipoUsuario(Tipo_usuario tipoUsuario){
        //Creamos nuestra conexion
        boolean result = false;
        Connection conn = Conexion.getconexion();
        try {
            result=tipoUsuarioDao.modificarTipoUsuario(conn,tipoUsuario);
            
            //conn.rollback();
            
        } catch (Exception e) {
            mensaje=mensaje + " " + e.getMessage();
            //conn.commit()
        }finally{
            try {
                if(conn !=null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje=mensaje + " " + e.getMessage();
            }
        }
        return result;
    }
    
    public ArrayList<Tipo_usuario> listarTipoUsuario(){
        Connection con = Conexion.getconexion();
        ArrayList<Tipo_usuario> arrTipoUsuario = null;
        try{
            arrTipoUsuario = tipoUsuarioDao.listarTipoUsuario(con);
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
        
        return arrTipoUsuario;
    }
 
    public void listaComboTipoUsuario(JComboBox box){
        Connection conn = Conexion.getconexion();
        tipoUsuarioDao.listarComboTipoUsuario(conn, box);
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion: \n"+e.getMessage());
        }
    }
    
    public Tipo_usuario obtenerTipoUsuario(int id){
        Connection con = Conexion.getconexion();
         Tipo_usuario tipoUsuario = null;
        try{
            tipoUsuario = tipoUsuarioDao.obtenerTipoUsuario(con, id);  
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
        
        return tipoUsuario;
    }
    
    
    public ArrayList<Tipo_usuario> buscarTipoUsuario(String buscar){
        Connection con = Conexion.getconexion();
        ArrayList<Tipo_usuario> arrTipoUsuario = null;
        try{
            arrTipoUsuario = tipoUsuarioDao.buscarTipoUsuario(con, buscar);
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
        
        return arrTipoUsuario;
    }
    
}
