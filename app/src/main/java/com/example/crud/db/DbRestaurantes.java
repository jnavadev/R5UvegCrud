package com.example.crud.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.crud.entities.Restaurantes;

import java.util.ArrayList;

public class DbRestaurantes extends DbHelper{

    Context context;

    public DbRestaurantes(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertaRestaurante(String name){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("name", name);

            id = db.insert(TABLE_RESTAURANT, null, values);
        } catch (Exception ex){
            ex.toString();
        }
       return id;
    }

    public ArrayList<Restaurantes> mostrarRestaurantes(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Restaurantes> listaRestaurantes = new ArrayList<>();
        Restaurantes restaurante = null;
        Cursor cursorRestaurante = null;

        cursorRestaurante = db.rawQuery("SELECT * FROM "+ TABLE_RESTAURANT, null);

        if(cursorRestaurante.moveToFirst()){
           /* do{

            }*/
        }
        return null;
    }
}
