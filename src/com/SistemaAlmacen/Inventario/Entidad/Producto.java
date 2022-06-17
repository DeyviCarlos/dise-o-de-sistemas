package com.SistemaAlmacen.Inventario.Entidad;


public class Producto {
    
    private int idProducto;
    private String nombre;
     private String descripcion;
    private Double precio;
    private int stock;
    private String estado;
    private String imagen; 
    private String categoria;
    private String ubicacion;
    
    public Producto() {
    }

    public Producto(int idProducto, String nombre, String descripcion, Double precio, int stock, String estado, String imagen, String categoria, String ubicacion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.imagen = imagen;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
    }
    public Producto(String nombre) {
        this.nombre = nombre;
  
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

   
    @Override
    public String toString() {
        return nombre;
    }
    
    
}
