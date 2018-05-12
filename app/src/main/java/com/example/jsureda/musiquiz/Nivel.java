package com.example.jsureda.musiquiz;

import android.content.ContentValues;
import android.database.Cursor;
import com.example.jsureda.musiquiz.TablaNivel.Columna;
import java.util.UUID;

public class Nivel {

    private String  nombre;
    private Integer id, orden, bloqueado, progreso;

    public Nivel()
    {
        super();
    }

    public Nivel(String nombre, Integer orden, Integer bloqueado, Integer progreso)
    {
        this.nombre=nombre;
        this.orden=orden;
        this.bloqueado=bloqueado;
        this.progreso=progreso;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Integer bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Integer getProgreso() {
        return progreso;
    }

    public void setProgreso(Integer progreso) {
        this.progreso = progreso;
    }

}
