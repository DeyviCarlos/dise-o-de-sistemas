package com.SistemaAlmacen.Inventario.DAO;


import com.SistemaAlmacen.Inventario.Entidad.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ProductoDAO {

    private String mensaje;

    public String agregarProducto(Connection con, Producto prod) {

        Statement st = null;
        CallableStatement cst= null;
        
        try {
            st = con.createStatement();
            cst = con.prepareCall("{call p_registrar_producto(?,?,?,?,?,?,?,?)}");
            cst.setString(1,prod.getNombre());
            cst.setString(2,prod.getDescripcion());
            cst.setDouble(3,prod.getPrecio());
            cst.setInt(4,prod.getStock());
            cst.setString(5,prod.getEstado());
            cst.setString(6,prod.getImagen());
            cst.setString(7,prod.getCategoria());
            cst.setString(8,prod.getUbicacion());
            cst.execute();
            cst.close();
            mensaje = "GUARDADO CORRECTAMENTE";
        } catch (Exception e) {
            mensaje = "NO SE PUDO GUARDAR \n" + e.getMessage();
        }
        return mensaje;
    }

    public String modificarProducto(Connection con, Producto prod) {
        CallableStatement cs = null;
        try {
            //recibe la conexion 
            cs = (CallableStatement) con.prepareCall("call P_MODIFICAR_PRODUCTO(?,?,?,?,?,?,?,?)");
            
            cs.setInt(1, prod.getIdProducto());
            cs.setString(2, prod.getNombre());
            cs.setString(3, prod.getDescripcion());
            cs.setDouble(4, prod.getPrecio());
            cs.setInt(5, prod.getStock());
            cs.setString(6, prod.getImagen());
            cs.setString(7, prod.getCategoria());
            cs.setString(8, prod.getUbicacion());
            cs.execute();
            cs.close();

            mensaje = "ACTUALIZADO CORRECTAMENTE";
        } catch (Exception e) {
            mensaje = "NO SE PUDO ACTUALIZAR \n" + e.getMessage();
        }

        return mensaje;
    }

    public boolean eliminarProducto(Connection con, int codigo) {
        CallableStatement cs = null;
        boolean isdelete = false;
        try {
            //recibe la conexion 
            cs = (CallableStatement) con.prepareCall("call P_ELIMINAR_PRODUCTO(?)");
            cs.setInt(1,codigo);
            int consul=cs.executeUpdate();
            if(consul==0){
                isdelete = true;
            }
            cs.close();
            mensaje = "ELIMINADO CORRECTAMENTE";
            
        } catch (Exception e) {
            mensaje = "NO SE PUDO ELIMINAR:  \n" + e.getMessage();
        }
        return isdelete;
    }
    
    public Producto obtenerProducto(Connection con, int codigo) {

        CallableStatement cs = null;
        Producto producto=new Producto();
        ResultSet rs=null; //Obtiene los resultados del Query
        try {
            //recibe la conexion "{? = call f_obtener_usuario(?)}"
            cs = (CallableStatement) con.prepareCall("{? = call F_OBTENER_PRODUCTO(?)}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.setInt(2,codigo);
            cs.execute();
            rs = (ResultSet)cs.getObject(1);
            if(rs.next()){
                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setDescripcion(rs.getString(3));
                producto.setPrecio(rs.getDouble(4));
                producto.setStock(rs.getInt(5));
                producto.setEstado(rs.getString(6));
                producto.setImagen(rs.getString(7));
                producto.setCategoria(rs.getString(8));
                producto.setUbicacion(rs.getString(9));
            }
            cs.close();
            mensaje = "PRODUCTO ENCONTRADO";

        } catch (Exception e) {
            mensaje = "PRODUCTO NO ENCONTRADO:  \n" + e.getMessage();
        }
        return producto;
    }

    public ArrayList<Producto> buscarProducto(Connection con,String buscar){
        ArrayList<Producto> arr_pro = new ArrayList<>();
        CallableStatement cs = null;
        ResultSet rs=null; //Obtiene los resultados del Query
        try {
            if(buscar.equalsIgnoreCase("")){
                cs=(CallableStatement) con.prepareCall("{? = call f_listar_producto}");
                cs.registerOutParameter(1, Types.REF_CURSOR);
            }else{
                cs=(CallableStatement) con.prepareCall("{? = call f_buscar_producto(?)}");
                cs.registerOutParameter(1, Types.REF_CURSOR);
                cs.setString(2, buscar);
            }
            cs.execute();
            rs=(ResultSet) cs.getObject(1);
            
            while(rs.next()){
                Producto producto=new Producto();
                
                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setDescripcion(rs.getString(3));
                producto.setPrecio(rs.getDouble(4));
                producto.setStock(rs.getInt(5));
                producto.setEstado(rs.getString(6));
                producto.setImagen(rs.getString(7));
                producto.setCategoria(rs.getString(8));
                producto.setUbicacion(rs.getString(9));
                arr_pro.add(producto);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arr_pro;
        
    }
    
    
    public ArrayList<Producto> listarProducto(Connection con){
        ArrayList<Producto> lista =new ArrayList<>();
        CallableStatement cs = null;
       
        ResultSet rs=null; //Obtiene los resultados del Query
        try {
            //
            cs = (CallableStatement) con.prepareCall("{? = call F_LISTAR_PRODUCTO}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();
            rs = (ResultSet)cs.getObject(1);
            
            while(rs.next()){
                Producto producto=new Producto();
                
                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setDescripcion(rs.getString(3));
                producto.setPrecio((double)rs.getInt(4));
                producto.setStock(rs.getInt(5));
                producto.setEstado(rs.getString(6));
                producto.setImagen(rs.getString(7));
                producto.setCategoria(rs.getString(8));
                producto.setUbicacion(rs.getString(9));
                lista.add(producto);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }   
    
    public void listarComboProducto(Connection con,JComboBox cbox){
        DefaultComboBoxModel model= new DefaultComboBoxModel();
        CallableStatement cs = null;
       
        Statement st=null; //Ejecuta nuestro Query
        ResultSet rs=null; //Obtiene los resultados del Query
        try {
            //
            cs = (CallableStatement) con.prepareCall("{? = call F_LISTAR_PRODUCTO}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();
            rs = (ResultSet)cs.getObject(1);
            
            model.addElement("Seleccione un Producto");
            while(rs.next()){
                Producto producto=new Producto();   
                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setDescripcion(rs.getString(3));
                producto.setPrecio(rs.getDouble(4));
                producto.setStock(rs.getInt(5));
                producto.setEstado(rs.getString(6));
                producto.setImagen(rs.getString(7));
                producto.setCategoria(rs.getString(8));
                producto.setUbicacion(rs.getString(9));
                model.addElement(producto.toString());
            }
            cbox.setModel(model);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    

}
