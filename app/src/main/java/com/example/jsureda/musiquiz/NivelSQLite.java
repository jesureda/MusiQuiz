package com.example.jsureda.musiquiz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


public class NivelSQLite extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Musiquiz.db";

    public NivelSQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="CREATE TABLE niveles (";
        sql += "_id INTEGER PRIMARY KEY AUTOINCREMENT,";
        sql += "nombre TEXT,";
        sql += "orden INTEGER,";
        sql += "bloqueado INTEGER,";
        sql += "progreso INTEGER)";
        db.execSQL(sql);
        insertarNiveles(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void insertarNiveles(SQLiteDatabase db) {
        String sql   = "INSERT INTO niveles(nombre,orden,bloqueado,progreso) ";
        sql  += "VALUES ('Nivel 1',1,0,0),";
        sql  += "('Nivel 2',2,1,0),";
        sql  += "('Nivel 3',3,1,0),";
        sql  += "('Nivel 4',4,1,0)";
        db.execSQL(sql);
        //db.close();
    }

    public void actualizarNivel(int id, int bloqueado, int progreso) {
        String sql  = "UPDATE niveles ";
        sql += " SET ";
        sql += "bloqueado = '"+bloqueado+"', ";
        sql += "progreso ='"+progreso+"' ";
        sql += "WHERE _id = " + id;

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    public ArrayList<Nivel> listaNiveles(int cantidad) {
        ArrayList<Nivel> niveles = new ArrayList<>();
        String sql = "SELECT * FROM niveles ";
        sql+= "ORDER BY orden ASC ";
        sql+= "LIMIT " + cantidad;
        // Obtenemos la base de datos en solo lectura
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        for (int i=0;i<cantidad;i++)
        {
            cursor.moveToNext();
            niveles.add(new Nivel(cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4)));
        }
        cursor.close();
        //db.close();
        return niveles;
    }
}
