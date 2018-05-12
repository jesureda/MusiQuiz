package com.example.jsureda.musiquiz;

import android.provider.BaseColumns;

public class TablaNivel {
    public static abstract class Columna implements BaseColumns {
        public static final String TABLE_NAME = "nivel";
        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String ORDEN = "orden";
        public static final String BLOQUEADO = "bloqueado";
        public static final String PROGRESO = "progreso";
    }
}
