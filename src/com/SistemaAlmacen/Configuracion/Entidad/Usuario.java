package com.SistemaAlmacen.Configuracion.Entidad;



public class Usuario {
    private int id_usuario;
    private String nombre;
    private String apelliP;
    private String apellim;
    private Tipo_usuario t_user;
    private String telefono;
    private String email;
    private String dni;
    private String user_nombre;
    private String contra;
    
    //para verificar el acceso del login
    public Usuario( String user, String contra) {
        this.user_nombre = user;
        this.contra = contra;
    }
    
    //para el nuevo usuario que agrega el administrador
    public Usuario(String nombre, String apelliP, String apellim, String telefono, String email, String dni, String user, String contra) {
        this.nombre = nombre;
        this.apelliP = apelliP;
        this.apellim = apellim;
        this.telefono = telefono;
        this.email = email;
        this.dni = dni;
        this.user_nombre = user;
        this.contra = contra;
    }
    //inserciones o modifi
    public Usuario(String nombre, String apelliP, String apellim, String telefono, String email, String dni, String user, String contra,Tipo_usuario tip) {
        this.nombre = nombre;
        this.apelliP = apelliP;
        this.apellim = apellim;
        this.telefono = telefono;
        this.email = email;
        this.dni = dni;
        this.user_nombre = user;
        this.contra = contra;
        this.t_user = tip;
    }
    //litar o mostrar
    public Usuario(int id,String nombre, String apelliP, String apellim, String telefono, String email, String dni, String user, String contra,Tipo_usuario tip ) {
        this.id_usuario=id;
        this.nombre = nombre;
        this.apelliP = apelliP;
        this.apellim = apellim;
        this.telefono = telefono;
        this.email = email;
        this.dni = dni;
        this.user_nombre = user;
        this.contra = contra;
        this.t_user = tip;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelliP() {
        return apelliP;
    }

    public void setApelliP(String apelliP) {
        this.apelliP = apelliP;
    }

    public String getApellim() {
        return apellim;
    }

    public void setApellim(String apellim) {
        this.apellim = apellim;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Tipo_usuario getT_user() {
        return t_user;
    }

    public void setT_user(Tipo_usuario t_user) {
        this.t_user = t_user;
    }

    public String getUser_nombre() {
        return user_nombre;
    }

    public void setUser_nombre(String user_nombre) {
        this.user_nombre = user_nombre;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    
    
    
    
    
}
