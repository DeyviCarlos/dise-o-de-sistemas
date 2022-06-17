package com.SistemaAlmacen.Inventario.BO;


import com.SistemaAlmacen.General.Entidad.Conexion;
import com.SistemaAlmacen.Inventario.DAO.ProductoDAO;
import com.SistemaAlmacen.Inventario.Entidad.Producto;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Luis Enrique Carbajal Tinecela
 */
public class ProductoBO {
    private String mensaje;
    private ProductoDAO prodDao= new ProductoDAO();
    
    public String agregarProducto(Producto prod){
        
        Connection conn = Conexion.getconexion();
        try {
            mensaje=prodDao.agregarProducto(conn, prod);
            
            
        } catch (Exception e) {
            mensaje=mensaje + " " + e.getMessage();
            
        }finally{
            try {
                if(conn !=null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje=mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    public String modificarProducto( Producto prod) {
        Connection conn = Conexion.getconexion();
        try {
            mensaje=prodDao.modificarProducto(conn, prod);
        } catch (Exception e) {
            mensaje=mensaje + " " + e.getMessage();
            
        }finally{
            try {
                if(conn !=null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje=mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    public boolean eliminarProducto(int codigo){
        Connection conn = Conexion.getconexion();
        boolean isdelete=false;
        try {
            isdelete=prodDao.eliminarProducto(conn, codigo);
        } catch (Exception e) {
            mensaje=mensaje + " " + e.getMessage();
            
        }finally{
            try {
                if(conn !=null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje=mensaje + " " + e.getMessage();
            }
        }
        return isdelete;
    }
    
    public Producto obtenerProducto(int codigo){
        Connection conn = Conexion.getconexion();
        Producto producto = new Producto();
        producto=prodDao.obtenerProducto(conn, codigo);
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion: \n"+e.getMessage());
        }
        return producto;
    }
    
    public ArrayList<Producto> buscarProducto(String buscar){
        Connection conn = Conexion.getconexion();
        ArrayList<Producto> lista =new ArrayList<>();
        lista = prodDao.buscarProducto(conn, buscar);
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion: \n"+e.getMessage());
        }
        return lista;
    }
    
    
    public ArrayList<Producto> listarProducto(){
        Connection conn = Conexion.getconexion();
        ArrayList<Producto> lista =new ArrayList<>();
        lista = prodDao.listarProducto(conn);
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion: \n"+e.getMessage());
        }
        return lista;
    }
    
    
    public void listarComboProducto(JComboBox cbox){
        Connection conn = Conexion.getconexion();
        
        try {
            prodDao.listarComboProducto(conn,cbox);
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion: \n"+e.getMessage());
        }
    }
    
    /*
    public void listaCombo(JComboBox box){
        Connection conn = Conexion.getconexion();
        empDao.listarComboEmp(conn, box);
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion: \n"+e.getMessage());
        }
    }*/
    
    
}
