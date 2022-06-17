package com.SistemaAlmacen.Compra.BO;

import com.SistemaAlmacen.Compra.DAO.CompraDAO;
import com.SistemaAlmacen.Compra.Entidad.Compra;
import com.SistemaAlmacen.General.Entidad.Conexion;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CompraBO {
    Connection con;
    Conexion c;
    Compra compra;
    CompraDAO compradao;
    ArrayList<Compra> arrcompra=null;
    
    public CompraBO() {
        c = new Conexion();
        compradao = new CompraDAO();
    }
    
    public boolean registrarCompra(Compra comp){
        boolean res = false;
        con = c.getconexion();
        
        try{
            res = compradao.registrarCompra(con,comp);
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
        return res;
    }
    
    public boolean modificarCompra(Compra comp){
        boolean res = false;
        con = c.getconexion();
        
        try{
            res = compradao.modificarCompra(con,comp);
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
        return res;
    }
    
    public boolean eliminarCompra(int id){
        boolean res = false;
        con = c.getconexion();
        
        try{
            res = compradao.eliminarCompra(con, id);
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
        return res;
    }
    
    public ArrayList<Compra> listarCompra(){
        con = c.getconexion();
        try{
            arrcompra = compradao.listarCompra(con);
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
        return arrcompra;
    }
    
    
    public Compra obtenerCompra(int id){
        con = c.getconexion();
        try{
            compra = compradao.obtenerCompra(con, id);  
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
        
        return compra;
    }
    
    public ArrayList<Compra> buscarCompra(String buscar){
        con = c.getconexion();
        try{
            arrcompra = compradao.buscarCompra(con, buscar);  
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
        
        return arrcompra;
    }
    
    
    
    
    public int codigoActual(){
        int codigo = 0;
        con = c.getconexion();
        try{
            codigo = compradao.codigoActual(con);  
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
        
        return codigo;
    }
    
}
