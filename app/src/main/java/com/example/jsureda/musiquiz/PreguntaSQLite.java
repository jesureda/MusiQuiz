package com.example.jsureda.musiquiz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class PreguntaSQLite extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Musiquiz.db";

    public PreguntaSQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="CREATE TABLE preguntas (";
        sql += "_id INTEGER PRIMARY KEY AUTOINCREMENT,";
        sql += "enunciado TEXT,";
        sql += "refAudio TEXT,";
        sql += "respuestaA TEXT,";
        sql += "respuestaB TEXT,";
        sql += "respuestaC TEXT,";
        sql += "respuestaD TEXT,";
        sql += "correcta TEXT,";
        sql += "nivel INTEGER,";
        sql += "FOREIGN KEY (nivel) REFERENCES niveles(_id));";
        db.execSQL(sql);
        insertarPreguntas(db);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void insertarPreguntas(SQLiteDatabase db) {
        String sql   = "INSERT INTO preguntas(enunciado,refAudio,respuestaA,respuestaB,respuestaC,respuestaD,correcta,nivel)";
        sql  += "VALUES ('Indica el título de la canción','url','asdf','asdf','asdf','asdf','asdf',1),";
        sql  += "('¿De qué película es esta banda sonora?','url','asdf','asdf','asdf','asdf','asdf',1),";
        sql  += "('¿A qué grupo pertenece esta canción?','url','asdf','asdf','asdf','asdf','asdf',1),";
        sql  += "('Indica el título de la canción','url','asdf','asdf','asdf','asdf','asdf',1)";
        sql  += "('¿A qué grupo pertenece esta canción?','url','asdf','asdf','asdf','asdf','asdf',1)";
        sql  += "('¿De qué película es esta banda sonora?','url','asdf','asdf','asdf','asdf','asdf',1)";
        sql  += "('Indica el título de la canción','url','asdf','asdf','asdf','asdf','asdf',1)";
        sql  += "('¿De qué película es esta banda sonora?','url','asdf','asdf','asdf','asdf','asdf',1)";
        sql  += "('Indica el título de la canción','url','asdf','asdf','asdf','asdf','asdf',1)";
        sql  += "('¿A qué grupo pertenece esta canción?','url','asdf','asdf','asdf','asdf','asdf',1)";

        db.execSQL(sql);
        //db.close();
    }

    public ArrayList<Pregunta> listaPreguntas(int cantidad) {
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        String sql = "SELECT * FROM preguntas ";
        sql+= "ORDER BY _id ASC ";
        sql+= "LIMIT " + cantidad;
        // Obtenemos la base de datos en solo lectura
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        for (int i=0;i<cantidad;i++)
        {
            cursor.moveToNext();
            preguntas.add(new Pregunta(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getInt(8)));
        }
        cursor.close();
        //db.close();
        return preguntas;
    }

}
