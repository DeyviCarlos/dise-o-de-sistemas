package com.SistemaAlmacen.Compra.DAO;

import com.SistemaAlmacen.Compra.Entidad.DetalleCompra;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class DetalleCompraDAO {
    
    
    CallableStatement cs;
    ResultSet rs;
    ArrayList<DetalleCompra> arrDet;
    //Compra compra = new Compra();
    private static JasperReport reportjasper;
    private static JasperPrint reporFillejasper;
    private static JasperViewer viewerjasper;
    
    
    
    public DetalleCompraDAO() {
        this.arrDet = new ArrayList<>();
    }
    
    public void registrarDetalle(Connection con, DetalleCompra decomp){
        //boolean res = false;

        try {
            
            cs=(CallableStatement) con.prepareCall("{call p_registrar_detallecompra(?,?,?,?)}");
            
            cs.setString(1, decomp.getProd().getNombre());
            cs.setInt(2, decomp.getCom().getId_compra());
            cs.setInt(3,(int)decomp.getCantidad());
            cs.setInt(4, (int)decomp.getPrecio());
            
            cs.execute();
            /*
            int consul=cs.executeUpdate();
            if(consul>0){
                res = true;
            }
            */
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        //return res; 
    }
    
    public void generarDetalle(Connection con, int cod_compra){
        //boolean res = false;
        try {
            //D:\\proyectos netbeans\\SistemaGestionAlmacénv2\\src\\com\\SistemaAlmacen\\Compra\\Entidad\\RDetalleCompra.jasper
            Map parametro = new HashMap();
            //se le pasa el valor del parametro del jasper y también el valor de la variable ingresada
            parametro.put("cod_compra", cod_compra);
            
            reportjasper=(JasperReport)JRLoader.loadObjectFromFile("D:\\proyectos netbeans\\SistemaGestionAlmacénv2\\src\\com\\SistemaAlmacen\\Compra\\Entidad\\RDetalleCompra.jasper");
            reporFillejasper=JasperFillManager.fillReport(reportjasper,parametro,con);
            viewerjasper=new JasperViewer(reporFillejasper,false);
            viewerjasper.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            viewerjasper.setVisible(true);

            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }
    
    
    
    
}
