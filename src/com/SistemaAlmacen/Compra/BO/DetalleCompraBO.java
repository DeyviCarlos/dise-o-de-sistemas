
package com.SistemaAlmacen.Compra.BO;

import com.SistemaAlmacen.Compra.DAO.DetalleCompraDAO;
import com.SistemaAlmacen.Compra.Entidad.DetalleCompra;
import com.SistemaAlmacen.General.Entidad.Conexion;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DetalleCompraBO {
    
    Connection con;
    Conexion c;
    //ArrayList<Compra> arrcompra=null;
    DetalleCompraDAO detCompradao = new DetalleCompraDAO();
    public void registrarDetalle(DetalleCompra detcom){
       //boolean res = false;
        con = c.getconexion();
        
        try{
            detCompradao.registrarDetalle(con,detcom);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null," "+ e.getMessage());
        }finally{
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null," "+ e.getMessage());
            } 
        }
        //return res;
    }
    
    public void generarDetalle(int cod){
       //boolean res = false;
        con = c.getconexion();
        
        try{
            detCompradao.generarDetalle(con,cod);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null," "+ e.getMessage());
        }finally{
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null," "+ e.getMessage());
            } 
        }
        //return res;
    }
    
    
}
