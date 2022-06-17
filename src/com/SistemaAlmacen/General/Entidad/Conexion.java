package com.SistemaAlmacen.General.Entidad;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexion {
    private static Connection con=null;
    /*
    private static String url="jdbc:oracle:thin:@//localhost:1521/xepdb1";
    private static String user="deyvi";
    */
    private static String url="jdbc:oracle:thin:@//localhost:1521/xe";
    private static String user="carlos";
    private static String pass="piaget199";
    
    
    public static Connection getconexion(){
        
        try{ 
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            con=DriverManager.getConnection(url,user,pass);
            
            if(con!=null){
                //JOptionPane.showMessageDialog(null, "Bienvenido");
                System.out.println("Conexion");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión");
                System.out.println("No se pudo establecer la conexion");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    
    //metodo dinamico de conexion
    //metodo para abrir sesión en la BD con otra usuario creado por implementar
    public static Connection getconexion(String user, String pass){
        
        
        try{ 
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            con=DriverManager.getConnection(url,user,pass);
            
            if(con!=null){
                //JOptionPane.showMessageDialog(null, "Bienvenido");
                System.out.println("Conexion");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión");
                System.out.println("No se pudo establecer la conexion");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    
}
