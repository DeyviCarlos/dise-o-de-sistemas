package com.SistemaAlmacen.Compra.Entidad;

import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import com.SistemaAlmacen.Inventario.Entidad.Producto;

public class DetalleCompra {
    private Compra com;
    private Producto prod;
    private double precio;
    private int cantidad;  

    public DetalleCompra(Compra com, Producto prod, int cantidad,double precio) {
        this.precio = precio;
        this.com = com;
        this.prod = prod;
        this.cantidad = cantidad;
    }


    public Compra getCom() {
        return com;
    }

    public void setCom(Compra com) {
        this.com = com;
    }

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
