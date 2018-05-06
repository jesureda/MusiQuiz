package com.example.jsureda.musiquiz;

public class Nivel {

    private String nombre;
    private int id,orden;
    private boolean bloqueado;

    public Nivel()
    {
        super();
    }
    public Nivel(String nombre, int orden, boolean bloqueado)
    {
        super();
        this.nombre=nombre;
        this.orden=orden;
        this.bloqueado=bloqueado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}
