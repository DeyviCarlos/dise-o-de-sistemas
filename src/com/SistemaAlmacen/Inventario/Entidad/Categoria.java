package com.SistemaAlmacen.Inventario.Entidad;

public class Categoria {


   private int idCtegoria;
   private String nombre;

    public Categoria() {
    }

    public Categoria(int idCtegoria, String nombre) {
        this.idCtegoria = idCtegoria;
        this.nombre = nombre;

    }
    public Categoria(String nombre) {
        this.nombre = nombre;

    }
    

    public int getIdCtegoria() {
        return idCtegoria;
    }

    public void setIdCtegoria(int idCtegoria) {
        this.idCtegoria = idCtegoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return nombre;
    }
   
   
}
