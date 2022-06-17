package com.SistemaAlmacen.Inventario.DAO;

//import inventarios.entidades.Ubicacion;
import com.SistemaAlmacen.Inventario.Entidad.Ubicacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
public class UbicacionDAO {
    private String mensaje;
    ArrayList<Ubicacion> arrUbicacion = new ArrayList<>();
    
    public boolean agregarUbicacion(Connection con,Ubicacion ubicacion){
        boolean result = false;
        System.out.println(con);
        CallableStatement cs = null;
        try {
            //recibe la conexion 
            cs = (CallableStatement) con.prepareCall("call P_REGISTRAR_UBICACION(?,?)");
            cs.setString(1, ubicacion.getBloque());
            cs.setDate(2, ubicacion.getFecha_ubicacion());

            cs.execute();
            result = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return result;
    }
    public boolean eliminarUbicacion(Connection con, int id){//
        boolean result = false;
        CallableStatement cs = null;
        try {
            //recibe la conexion 
            cs = (CallableStatement) con.prepareCall("call P_ELIMINAR_UBICACION(?)");
            cs.setInt(1,id );
            cs.execute();
            result = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return result;
    }
    
    public boolean modificarUbicacion(Connection con, Ubicacion ubicacion){ 
        boolean result = false;
        CallableStatement cs = null;
        try {
            //recibe la conexion 
            cs = (CallableStatement) con.prepareCall("call P_MODIFICAR_UBICACION(?,?,?)");
            
            cs.setInt(1,ubicacion.getIdUbicacion());
            cs.setString(2, ubicacion.getBloque());
            cs.setDate(3, ubicacion.getFecha_ubicacion());
            cs.execute();

            result = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return result;
    }
    
    public void listarComboUbicacion(Connection con,JComboBox cbox){
        DefaultComboBoxModel model= new DefaultComboBoxModel();
        CallableStatement cs = null;
       
        Statement st=null; //Ejecuta nuestro Query
        ResultSet rs=null; //Obtiene los resultados del Query
        try {
            //
            cs = (CallableStatement) con.prepareCall("{? = call F_LISTAR_UBICACION}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();
            rs = (ResultSet)cs.getObject(1);
            
            while(rs.next()){
                Ubicacion ubicacion=new Ubicacion();
                ubicacion.setIdUbicacion(rs.getInt(1));
                ubicacion.setBloque(rs.getString(2));
                ubicacion.setFecha_ubicacion(rs.getDate(3));
                model.addElement(ubicacion);
            }
            cbox.setModel(model);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Ubicacion> listarUbicacion(Connection con){
        DefaultComboBoxModel model= new DefaultComboBoxModel();
        CallableStatement cs = null;
        ArrayList<Ubicacion> arrUbi = new ArrayList<>();
        Statement st=null; //Ejecuta nuestro Query
        ResultSet rs=null; //Obtiene los resultados del Query
        try {
            //
            cs = (CallableStatement) con.prepareCall("{? = call F_LISTAR_UBICACION}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();
            rs = (ResultSet)cs.getObject(1);
            
            while(rs.next()){
                Ubicacion ubicacion=new Ubicacion();
                ubicacion.setIdUbicacion(rs.getInt(1));
                ubicacion.setBloque(rs.getString(2));
                ubicacion.setFecha_ubicacion(rs.getDate(3));
                
                arrUbi.add(ubicacion);
            }
            arrUbicacion = arrUbi;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arrUbicacion;
    }
    
    public Ubicacion obtenerUbicacion(Connection con,int id){
        CallableStatement cs = null;
        Ubicacion ubicacion = null;
        ResultSet rs=null;
        try {
            cs=(CallableStatement) con.prepareCall("{? = call f_obtener_ubicacion(?)}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.setInt(2, id);
            cs.execute();
            rs=(ResultSet) cs.getObject(1);

            if(rs.next()){
                String bloque;
                Date fecha;
                int cod;
                
                cod = rs.getInt(1);
                bloque = rs.getString(2);
               fecha = rs.getDate(3);
               ubicacion =new Ubicacion(cod,bloque, fecha);
               
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return ubicacion;
        
    }
    
     public ArrayList<Ubicacion> buscarUbicacion(Connection con,String buscar){
         ArrayList<Ubicacion> arrUbicacion = new ArrayList<>();
        CallableStatement cs = null;
        ResultSet rs=null;
        try {
            if(buscar.equalsIgnoreCase("")){
                cs=(CallableStatement) con.prepareCall("{? = call f_listar_ubicacion}");
                cs.registerOutParameter(1, Types.REF_CURSOR);
            }else{
                cs=(CallableStatement) con.prepareCall("{? = call f_buscar_ubicacion(?)}");
                cs.registerOutParameter(1, Types.REF_CURSOR);
                cs.setString(2, buscar);
            }
            cs.execute();
            rs=(ResultSet) cs.getObject(1);
            
            while(rs.next()){
                String bloque;
                Date  fecha_ubicacion;
                int cod;
                
                cod = rs.getInt(1);
                bloque = rs.getString(2);
                fecha_ubicacion = rs.getDate(3);
                Ubicacion ubicacion = new Ubicacion(cod, bloque, fecha_ubicacion);
                arrUbicacion.add(ubicacion);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrUbicacion;
        
    }
    
    
}
