package com.SistemaAlmacen.Configuracion.Entidad;



public class Tipo_usuario {
    private int tipouser;
    private String nombre;

    public Tipo_usuario() {
    }

    public Tipo_usuario(int tipouser, String nombre) {
        this.tipouser = tipouser;
        this.nombre = nombre;
    }
    
    public Tipo_usuario(int tipouser) {
        this.tipouser = tipouser;
    }
    
    public Tipo_usuario(String nombre) {
        this.nombre = nombre;
    }
    public int getTipouser() {
        return tipouser;
    }

    public void setTipouser(int tipouser) {
        this.tipouser = tipouser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  this.nombre;
    }
    
    
    
}
