package com.example.amaispedida.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.example.amaispedida.domain.User;

/**
 * Created by João Paulo Bart Dias on 20/07/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Contacts.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_LOGIN = "login";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_PROFILE = "profile";
    SQLiteDatabase db;
    private static final String TABLE_CREATE =   "create table users(_id integer primary key autoincrement, "+
            "name text not null, login text not null, password text not null, profile text not null);";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "drop table " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertUser(User s){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from "+TABLE_NAME;

        values.put(COLUMN_NAME, s.getName());
        values.put(COLUMN_LOGIN, s.getLogin());
        values.put(COLUMN_PASSWORD, s.getPassword());
        values.put(COLUMN_PROFILE, s.getProfile());

        db.insert("users", null, values);
        db.close();
    }

    public String searchPass(String login){
        db = this.getReadableDatabase();
        String query = "select login, password from "+TABLE_NAME;
        Cursor cursor;
        cursor = db.rawQuery(query, null);
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
        String query = "select login, profile from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
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
