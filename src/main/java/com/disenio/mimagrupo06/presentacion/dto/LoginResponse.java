package com.disenio.mimagrupo06.presentacion.dto;

public class LoginResponse {

    private String idSesion;

    public LoginResponse(String idSesion) {
        this.idSesion = idSesion;
    }

    public String getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(String idSesion) {
        this.idSesion = idSesion;
    }
}
