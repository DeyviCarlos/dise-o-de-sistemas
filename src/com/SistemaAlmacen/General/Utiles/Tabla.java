package com.SistemaAlmacen.General.Utiles;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class Tabla {
    
    public void mostrar_tabla(JTable tabla,Object[][] elementos,Object[] cabecera ){
        
        tabla.setDefaultRenderer(Object.class, new Render());

        DefaultTableModel model = new DefaultTableModel(
                elementos, 
                cabecera
        )
        {
            public boolean isCellEditable(int row,int column){
                return false;
            }    
        };
        tabla.setModel(model);
        //ancho de la celda        
        tabla.setRowHeight(30);
        //tabla.getTableHeader().setCursor(new Cursor(Cursor.HAND_CURSOR));
        //que el encabezado no se pueda ordenar
        tabla.getTableHeader().setReorderingAllowed(false);
        //pintado del enccabezado
        //tabla.getTableHeader().setMinimumSize(new Dimension(30, 50));
        tabla.getTableHeader().setBackground(new Color(79, 84, 86 ));
        tabla.getTableHeader().setForeground(new Color(255, 255, 255));
        //FONT tipo, estilo en numero, tamaño 
        tabla.getTableHeader().setFont(new Font("Tahoma", Font.BOLD,12));
        
    }
    
}
