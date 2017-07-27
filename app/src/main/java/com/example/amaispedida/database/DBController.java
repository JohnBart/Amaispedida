package com.example.amaispedida.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.amaispedida.domain.Evento;
import com.example.amaispedida.domain.Musica;
import com.example.amaispedida.domain.User;

import java.util.ArrayList;

/**
 * Created by erick on 26/07/17.
 */

public class DBController {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "Contacts.db";

    private SQLiteDatabase db;
    private DBCreator dbCreator;

    public DBController(Context context) {
        dbCreator = new DBCreator(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = dbCreator.getWritableDatabase();
    }


    /*--------------------------------Usuarios--------------------------------------*/

    public Boolean isLoginInDatabase(String login){
        db = dbCreator.getReadableDatabase();
        Cursor cursor;
        cursor = db.rawQuery("select login from users", null);
        String a;
        Boolean b = false;
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                if(a.equals(login)){
                    b = true;
                    break;
                }

            }while(cursor.moveToNext());
        }
        db.close();
        return b;
    }


    public long returnIdUser(String login){
        db = dbCreator.getReadableDatabase();
        Cursor cursor;
        cursor = db.rawQuery("select login, _id from users", null);
        String a;
        long b = 0;
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                if(a.equals(login)){
                    b = cursor.getLong(1);
                    break;
                }

            }while(cursor.moveToNext());
        }
        db.close();
        return b;
    }

    public void insertUser(User s){
        db = dbCreator.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", s.getName());
        values.put("login", s.getLogin());
        values.put("password", s.getPassword());
        values.put("profile", s.getProfile());
        db.insert("users", null, values);
        db.close();
    }

    public String searchPass(String login){
        db = dbCreator.getReadableDatabase();
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
        db = dbCreator.getReadableDatabase();
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

    /*--------------------------------Eventos--------------------------------------*/

    public void insertEvento(Evento e, long id_artista){
        db = dbCreator.getWritableDatabase();
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

    /*--------------------------------Musicas--------------------------------------*/

    public Boolean isMusicInDatabase(String song, String composer, long id){
        db = dbCreator.getReadableDatabase();
        Cursor cursor;
        cursor = db.rawQuery("select song, composer, id_artist from songs", null);
        String a,b;
        long c;
        Boolean aux = false;
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                b = cursor.getString(1);
                c = cursor.getLong(2);
                if(a.equals(song)&&b.equals(composer)&&(c == id)){
                    aux = true;
                    break;
                }

            }while(cursor.moveToNext());
        }
        db.close();
        return aux;
    }

    public void insertMusica(Musica m, long id_artista){
        db = dbCreator.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("song", m.getMusica());
        values.put("composer", m.getCompositor());
        values.put("id_artist", id_artista);
        db.insert("songs", null, values);
        db.close();
    }

    public ArrayList<Musica> returnMusicsFromArtist(long id){
        db = dbCreator.getReadableDatabase();
        Cursor cursor;
        cursor = db.rawQuery("select song, composer from songs where id_artist = "+id, null);
        ArrayList<Musica> mList = new ArrayList<Musica>();
        Musica musica = new Musica();
        if(cursor.moveToFirst()){
            do{
                musica.setMusica(cursor.getString(0));
                musica.setCompositor(cursor.getString(1));
                mList.add(musica);
            }while(cursor.moveToNext());
        }
        db.close();
        return mList;
    }



    public int countLinesFromTable(String table){
        db = dbCreator.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+table, null);
        int i = cursor.getCount();
        return i;
    }
}
