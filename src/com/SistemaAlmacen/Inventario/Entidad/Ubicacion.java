/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaAlmacen.Inventario.Entidad;

import java.sql.Date;

/**
 *
 * @author GINO
 */
public class Ubicacion {
    private int idUbicacion;
    private String bloque;
    private Date fecha_ubicacion;

    public Ubicacion(){
        
    }
    
    public Ubicacion(String bloque,Date fecha){
        this.bloque = bloque;
        this.fecha_ubicacion = fecha;
    }
    
    public Ubicacion(int cod,String bloque,Date fecha){
        this.idUbicacion = cod;
        this.bloque = bloque;
        this.fecha_ubicacion = fecha;
    }
    
    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public Date getFecha_ubicacion() {
        return fecha_ubicacion;
    }

    public void setFecha_ubicacion(Date fecha_ubicacion) {
        this.fecha_ubicacion = fecha_ubicacion;
    }

    @Override
    public String toString() {
        return bloque;
    }
    
}
