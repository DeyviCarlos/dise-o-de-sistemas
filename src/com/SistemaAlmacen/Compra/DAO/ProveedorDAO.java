package com.SistemaAlmacen.Compra.DAO;
//import GestionAlmacen.entity.Proveedor;
import com.SistemaAlmacen.Compra.Entidad.Proveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class ProveedorDAO {
   CallableStatement cs = null;
    ResultSet rs = null; 
    ArrayList<Proveedor> arrProveedor;
    Proveedor proveed = new Proveedor();
    
   public boolean registrarProveedor(Connection con, Proveedor proveedor) {

        boolean res=false;
        try {
            
            cs=(CallableStatement) con.prepareCall("{call p_registrar_proveedor(?,?,?,?)}");
            
            cs.setString(1, proveedor.getRazon_Social());
            cs.setString(2, proveedor.getRuc());
            cs.setString(3, proveedor.getDireccion());
            cs.setString(4, proveedor.getTelefono());
            

            int consul=cs.executeUpdate();
            if(consul>0){
                res = true;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
   
        return res;
   
    }

    public boolean modificarProveedor(Connection con, Proveedor proveedor) {
        CallableStatement cs = null;
         
        boolean res=false;
        try {
            cs=(CallableStatement) con.prepareCall("{call p_modificar_proveedor(?,?,?,?,?)}");
            cs.setInt(1, proveedor.getIdProveedor());
            cs.setString(2, proveedor.getRazon_Social());
            cs.setString(3, proveedor.getRuc());
            cs.setString(4, proveedor.getDireccion());
            cs.setString(5, proveedor.getTelefono());

            int consul=cs.executeUpdate();
            if(consul>0){
                res = true;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return res;
        
    }

    public boolean eliminarProveedor(Connection con, int id) {

        boolean res=false;
        try {
            cs=(CallableStatement) con.prepareCall("{call p_eliminar_proveedor(?)}");
            cs.setInt(1, id);
            
            int consul=cs.executeUpdate();
            if(consul>0){
                res = true;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return res;

    }
    
    public ArrayList<Proveedor> listarProveedores(Connection con){
        ArrayList<Proveedor> arr_prov = new ArrayList<>();
         
        Proveedor  prov;
        
        try {
            cs=(CallableStatement) con.prepareCall("{? = call f_listar_proveedor}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();
            rs=(ResultSet) cs.getObject(1);

            while(rs.next()){
                String razon_social,ruc,direc,telf;
                int cod;
                
                cod = rs.getInt(1);
                razon_social = rs.getString(2);
                ruc = rs.getString(3);  
                direc = rs.getString(4);
                telf=rs.getString(5);
               
                prov=new Proveedor(cod, razon_social, ruc, direc, telf);
                arr_prov.add(prov);

            }
            this.arrProveedor=arr_prov;
      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return arrProveedor;
    } 
    
    
    
   public void listarComboProveedor(Connection con,JComboBox cbox){
        DefaultComboBoxModel model= new DefaultComboBoxModel();
        CallableStatement cs = null;
       
        Statement st=null; //Ejecuta nuestro Query
        ResultSet rs=null; //Obtiene los resultados 
        try {
            //
            cs = (CallableStatement) con.prepareCall("{? = call F_LISTAR_PROVEEDOR}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();
            rs = (ResultSet)cs.getObject(1);
            
            model.addElement("Seleccione el Proveedor");
            while(rs.next()){
                Proveedor proveedor=new Proveedor();
                proveedor.setIdProveedor(rs.getInt(1));
                proveedor.setRazon_Social(rs.getString(2));
                proveedor.setRuc(rs.getString(3));
                proveedor.setDireccion(rs.getString(4));
                proveedor.setTelefono(rs.getString(5));
                
                model.addElement(proveedor.toString());
            }
            cbox.setModel(model);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 
   
   public Proveedor obtenerProveedor(Connection con,int id){
        try {
            cs=(CallableStatement) con.prepareCall("{? = call f_obtener_proveedor(?)}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.setInt(2, id);
            cs.execute();
            rs=(ResultSet) cs.getObject(1);

            if(rs.next()){
                
                
                Proveedor prov = new Proveedor();
                prov.setIdProveedor(rs.getInt(1));
                prov.setRazon_Social(rs.getString(2));
                prov.setRuc(rs.getString(3));
                prov.setDireccion(rs.getString(4));
                prov.setTelefono(rs.getString(5));
                proveed = prov;
                
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return proveed;
        
    }
    
    public ArrayList<Proveedor> buscarProveedor(Connection con,String buscar){
        ArrayList<Proveedor> arr_prov = new ArrayList<>();
        try {
            if(buscar.equalsIgnoreCase("")){
                cs=(CallableStatement) con.prepareCall("{? = call f_listar_proveedor}");
                cs.registerOutParameter(1, Types.REF_CURSOR);
            }else{
                cs=(CallableStatement) con.prepareCall("{? = call f_buscar_proveedor(?)}");
                cs.registerOutParameter(1, Types.REF_CURSOR);
                cs.setString(2, buscar);
            }
            cs.execute();
            rs=(ResultSet) cs.getObject(1);
            
            while(rs.next()){
                Proveedor prov = new Proveedor();
                prov.setIdProveedor(rs.getInt(1));
                prov.setRazon_Social(rs.getString(2));
                prov.setRuc(rs.getString(3));
                prov.setDireccion(rs.getString(4));
                prov.setTelefono(rs.getString(5));
                proveed = prov;
                arr_prov.add(prov);
                
            }
            this.arrProveedor=arr_prov;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrProveedor;
        
    }
   
   
}
