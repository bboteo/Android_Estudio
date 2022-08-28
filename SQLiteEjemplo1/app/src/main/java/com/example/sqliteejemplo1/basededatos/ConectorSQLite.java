package com.example.sqliteejemplo1.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sqliteejemplo1.complementos.ConstantesSQL;

//Paso#1: Extenser SQLiteOpenHelper
public class ConectorSQLite extends SQLiteOpenHelper {

    //Paso#3: Generar el primer Constructor
    public ConectorSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Paso#2: Implementar metodos abstractos
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Paso#4: Crar la tabla
        db.execSQL(ConstantesSQL.CREAR_TBL_BEBIDA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Paso#5: Crar la funcion para borrar
        db.execSQL(ConstantesSQL.BORRAR_TBL_BEBIDA);
        onCreate(db);
    }
}
