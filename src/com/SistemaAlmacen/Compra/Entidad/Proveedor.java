
package com.SistemaAlmacen.Compra.Entidad;


public class Proveedor {
    private int idProveedor;
    private String Razon_Social;
    private String ruc;
    private String direccion;
    private String telefono;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String Razon_Social, String ruc, String direccion, String telefono) {
        this.idProveedor = idProveedor;
        this.Razon_Social = Razon_Social;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public Proveedor(String Razon_Social, String ruc, String direccion, String telefono) {
        this.Razon_Social = Razon_Social;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazon_Social() {
        return Razon_Social;
    }

    public void setRazon_Social(String Razon_Social) {
        this.Razon_Social = Razon_Social;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    
    @Override
    public String toString() {
        return  Razon_Social;
    }

    
   


    
}
