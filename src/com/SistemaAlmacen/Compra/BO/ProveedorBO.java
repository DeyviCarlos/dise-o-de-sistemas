package com.SistemaAlmacen.Compra.BO;

//import GestionAlmacen.db.Conexion;
//import GestionAlmacen.dao.ProveedorDAO;
//import GestionAlmacen.entity.Proveedor;
import com.SistemaAlmacen.Compra.DAO.ProveedorDAO;
import com.SistemaAlmacen.Compra.Entidad.Proveedor;
import com.SistemaAlmacen.General.Entidad.Conexion;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class ProveedorBO {
    Connection con;
    Conexion c;
    ArrayList<Proveedor> arrProveedor = null;
    ProveedorDAO proveedordao = new ProveedorDAO();
    Proveedor proveedor = new Proveedor();
    
    public boolean registrarProveedor(Proveedor proveedor){
        
        boolean result = false;
        con = c.getconexion();
        try{
            result = proveedordao.registrarProveedor(con, proveedor);  
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
    public boolean modificarProveedor( Proveedor proveedor) {
       boolean result = false;
        con = c.getconexion();
        try{
            result = proveedordao.modificarProveedor(con, proveedor);  
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
    public boolean eliminarProveedor(int id){
         boolean result = false;
        con = c.getconexion();
        try{
            result = proveedordao.eliminarProveedor(con, id);  
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
    public ArrayList<Proveedor> listarProveedor(){
        con = c.getconexion();
        try{
            arrProveedor = proveedordao.listarProveedores(con);
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
        
        return arrProveedor;
    }
    
    
    
    public void listarComboProveedor(JComboBox box){
        Connection conn = Conexion.getconexion();
        proveedordao.listarComboProveedor(conn, box);
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion: \n"+e.getMessage());
        }
    }
    
    
    public Proveedor obtenerProveedor(int id){
        con = c.getconexion();
        try{
            proveedor = proveedordao.obtenerProveedor(con, id);  
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
        
        return proveedor;
    }
    
    public ArrayList<Proveedor> buscarProveedor(String buscar){
        con = c.getconexion();
        try{
            arrProveedor = proveedordao.buscarProveedor(con, buscar);  
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
        
        return arrProveedor;
    }
    
    
    
}
