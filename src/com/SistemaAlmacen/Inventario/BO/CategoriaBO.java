/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaAlmacen.Inventario.BO;



import com.SistemaAlmacen.General.Entidad.Conexion;
import com.SistemaAlmacen.Inventario.DAO.CategoriaDAO;
import com.SistemaAlmacen.Inventario.Entidad.Categoria;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class CategoriaBO {
    private boolean mensaje;
    private CategoriaDAO catDao= new CategoriaDAO();
    Conexion c = new Conexion();
    Connection conn = null;
    ArrayList<Categoria> arrCategoria = new ArrayList<>();
    

    public boolean agregarCategoria(Categoria cat){
        //Creamos nuestra conexion
        Connection conn = Conexion.getconexion();
        try {
            mensaje=catDao.agregarCategoria(conn, cat);
            //conn.rollback();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            //conn.commit()
        }finally{
            try {
                if(conn !=null){
                    conn.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return mensaje;
    }
    public boolean modificarCategoria( Categoria cat){
        Connection conn = Conexion.getconexion();
        try {
            mensaje=catDao.modificarCategoria(conn, cat);
            //conn.rollback();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            //conn.commit()
        }finally{
            try {
                if(conn !=null){
                    conn.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return mensaje;
    }
    public boolean eliminarCategoria(int ID){
        Connection conn = Conexion.getconexion();
        try {
            mensaje=catDao.eliminarCategoria(conn, ID);
            //conn.rollback();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            //conn.commit()
        }finally{
            try {
                if(conn !=null){
                    conn.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return mensaje;
    }
 
    
    public ArrayList<Categoria> listarCategoria(){
        Connection conn = Conexion.getconexion();
        try {
            arrCategoria=catDao.listarCategoria(conn);
            //conn.rollback();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            //conn.commit()
        }finally{
            try {
                if(conn !=null){
                    conn.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return arrCategoria;
    }
    
    public Categoria obtenerCategoria(int id){
        Connection con = Conexion.getconexion();
         Categoria categoria = null;
        try{
            categoria = catDao.obtenerCategoria(con, id);  
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
        
        return categoria;
    }
    
    public ArrayList<Categoria> buscarCategoria(String buscar){
        Connection con = Conexion.getconexion();
        ArrayList<Categoria> arrCategoria = null;
        try{
            arrCategoria = catDao.buscarCategoria(con, buscar);
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
        
        return arrCategoria;
    }
}
