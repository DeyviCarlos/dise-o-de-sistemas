/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaAlmacen.Inventario.DAO;

import com.SistemaAlmacen.Inventario.Entidad.Categoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class CategoriaDAO {
    private boolean mensaje;
    public ArrayList<Categoria> arrCategoria = new ArrayList<>();
    
    public boolean agregarCategoria(Connection con, Categoria cat){
        
        boolean result = false;
        System.out.println(con);
        CallableStatement cs = null;
        try {
            //recibe la conexion 
            cs = (CallableStatement) con.prepareCall("call P_REGISTRAR_CATEGORIA(?)");
            cs.setString(1, cat.getNombre());

            cs.execute();

            result = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return result;
    }
    public boolean modificarCategoria(Connection con, Categoria cat){
        boolean result = false;
        System.out.println(con);
        CallableStatement cs = null;
        try {
            //recibe la conexion 
            cs = (CallableStatement) con.prepareCall("call P_MODIFICAR_CATEGORIA(?,?)");
            cs.setInt(1, cat.getIdCtegoria());
            cs.setString(2, cat.getNombre());
            cs.execute();
            result = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return result;
    }
    public boolean eliminarCategoria(Connection con, int ID){
        boolean result = false;
        System.out.println(con);
        CallableStatement cs = null;
        try {
            //recibe la conexion 
            cs = (CallableStatement) con.prepareCall("call P_ELIMINAR_CATEGORIA(?)");
            cs.setInt(1, ID);

            cs.execute();
            result = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return result;
    }

    public ArrayList<Categoria> listarCategoria(Connection con){
        CallableStatement cs = null;
        ArrayList<Categoria> arrCat = new ArrayList<>();
        ResultSet rs=null; //Obtiene los resultados del Query
        try {
            //
            cs = (CallableStatement) con.prepareCall("{? = call F_LISTAR_CATEGORIA}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();
            rs = (ResultSet)cs.getObject(1);
            
            while(rs.next()){
                Categoria categoria=new Categoria();
                categoria.setIdCtegoria(rs.getInt(1));
                categoria.setNombre(rs.getString(2));
                
                arrCat.add(categoria);
            }
            arrCategoria = arrCat;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arrCategoria;
    }
    
    public Categoria obtenerCategoria(Connection con,int id){
        CallableStatement cs = null;
        Categoria categoria = null;
        ResultSet rs=null;
        try {
            cs=(CallableStatement) con.prepareCall("{? = call f_obtener_categoria(?)}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.setInt(2, id);
            cs.execute();
            rs=(ResultSet) cs.getObject(1);

            if(rs.next()){
                String nom;
                int cod;
                
                cod = rs.getInt(1);
                nom = rs.getString(2);
                categoria =new Categoria(cod,nom);
               
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return categoria;
    }
    
    public ArrayList<Categoria> buscarCategoria(Connection con,String buscar){
         ArrayList<Categoria> arrCat = new ArrayList<>();
        CallableStatement cs = null;
        ResultSet rs=null;
        try {
            if(buscar.equalsIgnoreCase("")){
                cs=(CallableStatement) con.prepareCall("{? = call f_listar_categoria}");
                cs.registerOutParameter(1, Types.REF_CURSOR);
            }else{
                cs=(CallableStatement) con.prepareCall("{? = call f_buscar_categoria(?)}");
                cs.registerOutParameter(1, Types.REF_CURSOR);
                cs.setString(2, buscar);
            }
            cs.execute();
            rs=(ResultSet) cs.getObject(1);
            
            while(rs.next()){
                Categoria categoria=new Categoria();
                categoria.setIdCtegoria(rs.getInt(1));
                categoria.setNombre(rs.getString(2));
                
                arrCat.add(categoria);
            }
            arrCategoria = arrCat;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrCategoria;
        
    }
    
}
