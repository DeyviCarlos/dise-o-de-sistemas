/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaAlmacen.Inventario.BO;

//import inventarios.dao.UbicacionDAO;
//import inventarios.db.Conexion;
//import inventarios.entidades.Ubicacion;
import com.SistemaAlmacen.General.Entidad.Conexion;
import com.SistemaAlmacen.Inventario.DAO.UbicacionDAO;
import com.SistemaAlmacen.Inventario.Entidad.Ubicacion;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author GINO
 */
public class UbicacionBO {
    private String mensaje;
    private UbicacionDAO ubicacionDao = new UbicacionDAO();
    private ArrayList<Ubicacion> arrUbicacion = new ArrayList<>();
    public boolean agregarUbicacion(Ubicacion ubicacion){
        //Creamos nuestra conexion
        boolean result = false;
        Connection conn = Conexion.getconexion();
        try {
            result=ubicacionDao.agregarUbicacion(conn, ubicacion);
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
    
    public boolean eliminarUbicacion(int id){
        //Creamos nuestra conexion
        boolean result = false;
        Connection conn = Conexion.getconexion();
        try {
            result=ubicacionDao.eliminarUbicacion(conn, id);
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
    
    public boolean modificarrUbicacion(Ubicacion ubicacion){
        //Creamos nuestra conexion
        boolean result = false;
        Connection conn = Conexion.getconexion();
        try {
            result=ubicacionDao.modificarUbicacion(conn, ubicacion);
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
    
 
    public void listaComboUbicacion(JComboBox box){
        Connection conn = Conexion.getconexion();
        ubicacionDao.listarComboUbicacion(conn, box);
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion: \n"+e.getMessage());
        }
    }
    
    public ArrayList<Ubicacion> listarUbicacion(){
        Connection con = Conexion.getconexion();
        ArrayList<Ubicacion> arrUbicacion = null;
        try{
            arrUbicacion = ubicacionDao.listarUbicacion(con);
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
        
        return arrUbicacion;
    }
    
    public Ubicacion obtenerUbicacion(int id){
        Connection con = Conexion.getconexion();
         Ubicacion ubicacion = null;
        try{
            ubicacion = ubicacionDao.obtenerUbicacion(con, id);  
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
        
        return ubicacion;
    }
    
     public ArrayList<Ubicacion> buscarUbicacion(String buscar){
        Connection con = Conexion.getconexion();
        ArrayList<Ubicacion> arrUbicacion = null;
        try{
            arrUbicacion = ubicacionDao.buscarUbicacion(con, buscar);
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
        
        return arrUbicacion;
    }
    
    
    
}
