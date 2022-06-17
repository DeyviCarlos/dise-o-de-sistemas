package com.SistemaAlmacen.General.Entidad;


public class Login {
    public String user;
    public String contra;
    
    public Login(){        
    }
    
    public Login(String user, String contra) {
        this.user = user;
        this.contra = contra;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    } 
}
