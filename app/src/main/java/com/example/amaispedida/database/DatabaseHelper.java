package com.example.amaispedida.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.example.amaispedida.domain.Evento;
import com.example.amaispedida.domain.User;

/**
 * Created by João Paulo Bart Dias on 20/07/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "Contacts.db";
    SQLiteDatabase db;
    private static final String TABLE_CREATE_USERS =   "create table users(_id integer primary key autoincrement, "+
            "name text not null, login text not null, password text not null, profile text not null);";

    private static final String TABLE_CREATE_EVENTS =   "create table events(_id_event integer primary key autoincrement, "+
            "name_event text not null, id_artist text foreign key not null, name_artist text not null, music_style text not null," +
            " date text not null, hour text not null);";

    private static final String TABLE_CREATE_MUSICS =   "create table musics(_id_music integer primary key autoincrement, "+
            "song text not null, composer text not null, id_artist text foreign key not null);";
    //composer é o que compôs a musica, id_artist é o artista que cadastrou a musica no seu repertório

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_USERS);
        /*db.execSQL(TABLE_CREATE_EVENTS);
        db.execSQL(TABLE_CREATE_MUSICS);*/
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table users");
        db.execSQL("drop table events");
        db.execSQL("drop table musics");
        this.onCreate(db);
    }

    public void insertUser(User s){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", s.getName());
        values.put("login", s.getLogin());
        values.put("password", s.getPassword());
        values.put("profile", s.getProfile());
        db.insert("users", null, values);
        db.close();
    }

    public void insertEvento(Evento e, long id_artista){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name_event", e.getNomeEvento());
        values.put("id_artist", id_artista);
        values.put("name_artist", e.getNomeArtista());
        values.put("music_style", e.getGeneroMusical());
        values.put("date", e.getData());
        values.put("hour", e.getHora());
        db.insert("events", null, values);
        db.close();
    }


    public String searchPass(String login){
        db = this.getReadableDatabase();
        Cursor cursor;
        cursor = db.rawQuery("select login, password from users", null);
        String a,b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                if(a.equals(login)){
                    b = cursor.getString(1);
                    break;
                }

            }while(cursor.moveToNext());
        }
        db.close();
        return b;
    }

    public String searchProfile(String login){
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select login, profile from users", null);
        String a,b = null;
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                if(a.equals(login)){
                    b = cursor.getString(1);
                    break;
                }

            }while(cursor.moveToNext());
        }

        db.close();
        return b;
    }

}
