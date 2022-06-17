package com.SistemaAlmacen.General.Utiles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class Render extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        JComponent jcomponent = null;
        
        if(value instanceof JButton){
            JButton btn = (JButton)value;
             //btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            //btn.setBorder(javax.swing.BorderFactory.createBevelBorder());
            
            
            return btn;
        }
        /*
        if(value instanceof JLabel){
            JLabel label = (JLabel) value;
            return label;
        }
        */

        return super.getTableCellRendererComponent(jtable, value, 
                isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
