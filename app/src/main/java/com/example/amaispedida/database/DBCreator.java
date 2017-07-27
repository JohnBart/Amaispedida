package com.example.amaispedida.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by erick on 26/07/17.
 */

class DBCreator extends SQLiteOpenHelper {

    private static final String USERS_TABLE = "users";
    private static final String EVENTS_TABLE = "events";
    private static final String SONGS_TABLE = "songs";

    private static final String TABLE_CREATE_USERS = "create table if not exists "+USERS_TABLE+"(" +
            "_id integer primary key autoincrement, " +
            "name text not null, login text not null, " +
            "password text not null, profile text not null);";

    private static final String TABLE_CREATE_EVENTS = "create table if not exists "+EVENTS_TABLE+"(" +
            "_id_event integer primary key autoincrement, "+
            "name_event text not null, id_artist integer, " +
            "name_artist text not null, music_style text not null," +
            " date text not null, hour text not null);";

    private static final String TABLE_CREATE_MUSICS = "create table if not exists "+SONGS_TABLE+"(" +
            "_id_music integer primary key autoincrement, "+
            "song text not null, composer text not null, " +
            "id_artist integer);";
    //composer é o que compôs a musica, id_artist é o artista que cadastrou a musica no seu repertório

    DBCreator(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE_USERS);
        sqLiteDatabase.execSQL(TABLE_CREATE_EVENTS);
        sqLiteDatabase.execSQL(TABLE_CREATE_MUSICS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+USERS_TABLE+";");
        sqLiteDatabase.execSQL("drop table if exists "+EVENTS_TABLE+";");
        sqLiteDatabase.execSQL("drop table if exists "+SONGS_TABLE+";");
        onCreate(sqLiteDatabase);
    }
}
