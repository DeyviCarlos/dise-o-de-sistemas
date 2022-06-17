package com.SistemaAlmacen.Compra.Entidad;

import com.SistemaAlmacen.Configuracion.Entidad.Usuario;
import java.sql.Date;
import java.util.ArrayList;

public class Compra {
    private int id_compra;
    private Date fecha_compra;
    private double precio_total;
    private Proveedor prov;
    private Usuario usu;
    private ArrayList<DetalleCompra> arrdetcom;

    public Compra() {
    }
    public Compra(int id_compra, Date fecha_compra, double precio_total, Proveedor prov, Usuario usu,ArrayList<DetalleCompra> arrdetcomp) {
        this.id_compra = id_compra;
        this.fecha_compra = fecha_compra;
        this.precio_total = precio_total;
        this.prov = prov;
        this.usu = usu;
        this.arrdetcom = arrdetcomp;
    }
    public Compra(Date fecha_compra, double precio_total, Proveedor prov, Usuario usu,ArrayList<DetalleCompra> arrdetcomp) {
        this.fecha_compra = fecha_compra;
        this.precio_total = precio_total;
        this.prov = prov;
        this.usu = usu;
        this.arrdetcom = arrdetcomp;
    }
    public Compra(int  codigo,Date fecha,Proveedor prov, Usuario usu,double precio) {
        this.id_compra = codigo;
        this.fecha_compra = fecha;
        this.precio_total = precio;
        this.prov = prov;
        this.usu = usu;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public Proveedor getProv() {
        return prov;
    }

    public void setProv(Proveedor prov) {
        this.prov = prov;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public ArrayList<DetalleCompra> getDetcom() {
        return arrdetcom;
    }

    public void setDetcom(ArrayList<DetalleCompra> arrdetcom) {
        this.arrdetcom = arrdetcom;
    }
    
    
    
    
    
    
    
    
    
}
