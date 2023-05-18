package com.example.parcial4_cristian_alvarez.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class SQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

    public SQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MD_Clientes (ID_Cliente INTEGER PRIMARY KEY," +
                " sNombreCliente TEXT, sApellidosClientes TEXT, sDireccionClientes TEXT, sCiudadCliente TEXT)");

        db.execSQL("CREATE TABLE MD_Vehiculos (ID_Vehiculos INTEGER PRIMARY KEY," +
                " sMarca TEXT, sModelo TEXT)");

        db.execSQL("CREATE TABLE MD_ClienteVehiculo (ID_Cliente INTEGER, ID_Vehiculo INTEGER, sMatricula TEXT, iKilometros INTEGER, "+
                        "PRIMARY KEY (ID_Cliente, ID_Vehiculo), " +
                        "FOREIGN KEY (ID_Cliente) REFERENCES MD_Clientes(ID_Cliente)," +
                        "FOREIGN KEY (ID_Vehiculo) REFERENCES MD_Vehiculo(ID_Vehiculo))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
