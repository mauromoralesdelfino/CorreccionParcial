package com.example.usuario.parcialagain;

public class Producto {

    private String nombre;
    private String precio;
    private String id;
    private String cantidad;

    public Producto() {

    }

    public Producto(String nombre, String precio, String id, String cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = id;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}