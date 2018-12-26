package com.rya.rye.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Cancha {
    @SerializedName("id")
    private String id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("direccion")
    private String direccion;
    @SerializedName("parqueo")
    private String parqueo;
    @SerializedName("telefono")
    private String telefono;
    @SerializedName("imgfoto")
    private String imgfoto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getParqueo() {
        return parqueo;
    }

    public void setParqueo(String parqueo) {
        this.parqueo = parqueo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImgfoto() {
        return imgfoto;
    }

    public void setImgfoto(String imgfoto) {
        this.imgfoto = imgfoto;
    }

    public Cancha(String id, String nombre, String direccion, String parqueo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.parqueo = parqueo;
        this.telefono = telefono;
    }
}
