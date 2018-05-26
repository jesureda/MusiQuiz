package com.example.jsureda.musiquiz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Logcat tag
    private static final String LOG = "DatabaseHelper";
    String crearNiveles, crearPreguntas;
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Musiquiz.db";

    // Table Names
    private static final String TABLE_TODO = "niveles";
    private static final String TABLE_TAG = "preguntas";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        crearNiveles ="CREATE TABLE niveles (";
        crearNiveles += "_id INTEGER PRIMARY KEY AUTOINCREMENT,";
        crearNiveles += "nombre TEXT,";
        crearNiveles += "orden INTEGER,";
        crearNiveles += "bloqueado INTEGER,";
        crearNiveles += "progreso INTEGER);";

        crearPreguntas ="CREATE TABLE preguntas (";
        crearPreguntas += "_id INTEGER PRIMARY KEY AUTOINCREMENT,";
        crearPreguntas += "enunciado TEXT,";
        crearPreguntas += "refAudio TEXT,";
        crearPreguntas += "respuestaA TEXT,";
        crearPreguntas += "respuestaB TEXT,";
        crearPreguntas += "respuestaC TEXT,";
        crearPreguntas += "respuestaD TEXT,";
        crearPreguntas += "correcta TEXT,";
        crearPreguntas += "nivel INTEGER,";
        crearPreguntas += "FOREIGN KEY(nivel) REFERENCES niveles(_id));";

       // crearPreguntas="CREATE TABLE `preguntas` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `enunciado` TEXT, `refAudio` TEXT, `respuestaA` TEXT, `respuestaB` TEXT, `respuestaC` TEXT, `respuestaD` TEXT, `respuestaCorrecta` TEXT, `nivelFK` INTEGER);";
        // creating required tables
        db.execSQL(crearPreguntas);
        db.execSQL(crearNiveles);

        insertarNiveles(db);
        insertarPreguntas(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
//        db.execSQL("DROP TABLE IF EXISTS niveles");
//        db.execSQL("DROP TABLE IF EXISTS preguntas");
//
//        // create new tables
//        onCreate(db);
    }

    public void insertarNiveles(SQLiteDatabase db) {
        String sql   = "INSERT INTO niveles(nombre,orden,bloqueado,progreso) ";
        sql  += "VALUES ('Nivel 1',1,0,0),";
        sql  += "('Nivel 2',2,1,0),";
        sql  += "('Nivel 3',3,1,0),";
        sql  += "('Nivel 4',4,1,0);";
        db.execSQL(sql);
        //db.close();
    }

    public void insertarPreguntas(SQLiteDatabase db) {
        String sql   = "INSERT INTO preguntas(enunciado,refAudio,respuestaA,respuestaB,respuestaC,respuestaD,correcta,nivel)";
        //Nivel 1
        sql  += "VALUES ('Indica el título de la canción','holiday.mp3','Holiday','No Giving Up','No Roads Left','Still Waiting','Holiday',1),";
        //sql  += "('¿En qué película suena esta canción?','timearechanging.mp3','Sin City ','Capitán América','Watchmen','Terminator','Watchmen',1),";
        sql  += "('¿De qué grupo es esta canción?','smellsliketeen.mp3','Nirvana','The Beatles','Rolling Stones','Abba','Nirvana',1),";
        sql  += "('Indica el título de la canción','sweetchild.mp3','Hell Bells','Losing My Religion','Wake Up','Sweet Child O Mine','Sweet Child O Mine',1),";
        sql  += "('¿De qué grupo es esta canción?','harderbetter.mp3','Imagine Dragons','Artic Monkeys','Daft Punk','Two Steps From Hell','Daft Punk',1),";
        sql  += "('¿En qué película suena esta canción?','infinitywar.mp3','Batman','The Punisher','Deadpool','Avengers','Avengers',1),";
        sql  += "('Indica el título de la canción','avici_wakemeup.mp3','The Gambler','Wonderwall','Wake Me Up','Right Round','Wake Me Up',1),";
        sql  += "('¿En qué película suena esta canción?','survivor_eyeofthetiger.mp3','Depredador','Warrior','Rocky','Rambo','Rocky',1),";
        sql  += "('Indica el título de la canción','loverocknroll.mp3','Hot Blooded','Rock Of Ages','Gasoline','I Love Rock N Roll','I Love Rock N Roll',1),";
        sql  += "('¿De qué grupo es esta canción?','houserisingsun.mp3','Gorillaz','The Animals','Bee Gees','Darkseed','The Animals',1),";
        //Nivel 2
        sql  += "('Indica el título de la canción','aha-takeonme.mp3','Dirty Boots','Take On Me','Mad World','Fun Fun Fun','Take On Me',2),";
        sql  += "('¿En qué película suena este tema?','batmanbso.mp3','Rain man','Superman','Batman','Spiderman','Batman',2),";
        sql  += "('Identifica al cantante de este tema','billyjeans.mp3','Craig David','Michael Jackson','Bruno Mars','George Michael','Michael Jackson',2),";
        sql  += "('Identifica al cantante de este tema','dayparadise.mp3','Kurt Cobain','Bono','Gary Jules','Phil Collins','Phil Collins',2),";
        sql  += "('¿En qué película suena este tema?','ghostbusters.mp3','Casper','La Familia Adams','Los Cazafantasmas','Beetlejuice','Los Cazafantasmas',2),";
        sql  += "('¿De qué grupo es esta canción?','inmigrantsong.mp3','Led Zeppelin','Rolling Stones','Foo Fighters','Europe','Led Zeppelin',2),";
        sql  += "('¿En qué serie suena este tema?','wontgetfooledagain.mp3','Castle','NCIS','Caso Abierto','CSI','CSI',2),";
        sql  += "('Indica el título de la canción','imaman.mp3','Like a Virgin','I´m A Man','I´m Alive','Katchi','I´m A Man',2),";
        sql  += "('¿De qué grupo es esta canción?','wonderwall.mp3','Oasis','Metallica','Coldplay','U2','Oasis',2),";
        sql  += "('¿Qué actor da nombre a este tema?','clinteastwood.mp3','George Clooney','Brad Pitt','Clint Eastwood','Sean Connery','Clint Eastwood',2),";

        //Nivel 3
        sql  += "('Indica el título de la canción','aha-takeonme.mp3','Dirty Boots','Take On Me','Mad World','Fun Fun Fun','Take On Me',2),";
        sql  += "('¿En qué película suena este tema?','batmanbso.mp3','Rain man','Superman','Batman','Spiderman','Batman',2),";
        sql  += "('Identifica al cantante de este tema','billyjeans.mp3','Craig David','Michael Jackson','Bruno Mars','George Michael','Michael Jackson',2),";
        sql  += "('Identifica al cantante de este tema','dayparadise.mp3','Kurt Cobain','Bono','Gary Jules','Phil Collins','Phil Collins',2),";
        sql  += "('¿En qué película suena este tema?','ghostbusters.mp3','Casper','La Familia Adams','Los Cazafantasmas','Beetlejuice','Los Cazafantasmas',2),";
        sql  += "('¿De qué grupo es esta canción?','inmigrantsong.mp3','Led Zeppelin','Rolling Stones','Foo Fighters','Europe','Led Zeppelin',2),";
        sql  += "('¿En qué serie suena este tema?','wontgetfooledagain.mp3','Castle','NCIS','Caso Abierto','CSI','CSI',2),";
        sql  += "('Indica el título de la canción','imaman.mp3','Like a Virgin','I´m A Man','I´m Alive','Katchi','I´m A Man',2),";
        sql  += "('¿De qué grupo es esta canción?','wonderwall.mp3','Oasis','Metallica','Coldplay','U2','Oasis',2),";
        sql  += "('¿Qué actor da nombre a este tema?','clinteastwood.mp3','George Clooney','Brad Pitt','Clint Eastwood','Sean Connery','Clint Eastwood',2),";

        //Nivel 4
        sql  += "('Indica el título de la canción','aha-takeonme.mp3','Dirty Boots','Take On Me','Mad World','Fun Fun Fun','Take On Me',2),";
        sql  += "('¿En qué película suena este tema?','batmanbso.mp3','Rain man','Superman','Batman','Spiderman','Batman',2),";
        sql  += "('Identifica al cantante de este tema','billyjeans.mp3','Craig David','Michael Jackson','Bruno Mars','George Michael','Michael Jackson',2),";
        sql  += "('Identifica al cantante de este tema','dayparadise.mp3','Kurt Cobain','Bono','Gary Jules','Phil Collins','Phil Collins',2),";
        sql  += "('¿En qué película suena este tema?','ghostbusters.mp3','Casper','La Familia Adams','Los Cazafantasmas','Beetlejuice','Los Cazafantasmas',2),";
        sql  += "('¿De qué grupo es esta canción?','inmigrantsong.mp3','Led Zeppelin','Rolling Stones','Foo Fighters','Europe','Led Zeppelin',2),";
        sql  += "('¿En qué serie suena este tema?','wontgetfooledagain.mp3','Castle','NCIS','Caso Abierto','CSI','CSI',2),";
        sql  += "('Indica el título de la canción','imaman.mp3','Like a Virgin','I´m A Man','I´m Alive','Katchi','I´m A Man',2),";
        sql  += "('¿De qué grupo es esta canción?','wonderwall.mp3','Oasis','Metallica','Coldplay','U2','Oasis',2),";
        sql  += "('¿Qué actor da nombre a este tema?','clinteastwood.mp3','George Clooney','Brad Pitt','Clint Eastwood','Sean Connery','Clint Eastwood',2);";
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
        //db.close();
    }

    public void insertarPregunta(String[] datos) {
        String sql   = "INSERT INTO preguntas(enunciado,refAudio,respuestaA,respuestaB,respuestaC,respuestaD,correcta,nivel)";
        sql  += "VALUES ('"+datos[0]+"','"+datos[1]+"','"+datos[2]+"','"+datos[3]+"','"+datos[4]+"','"+datos[5]+"','"+datos[6]+"',"+Integer.parseInt(datos[7])+");";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
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

    public ArrayList<Pregunta> listaPreguntas(int cantidad, int nivel) {
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        String sql = "SELECT * FROM preguntas WHERE nivel="+nivel+" ORDER BY _id ASC LIMIT " + cantidad;
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
