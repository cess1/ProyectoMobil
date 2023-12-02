package com.example.proyectomobil.SQLite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDHelper (context: Context, factory: SQLiteDatabase.CursorFactory?)
    : SQLiteOpenHelper (context, DATABASE_NAME, factory, DATABASE_VERSION) {

        companion object {
            private val DATABASE_NAME = "BD_Mappkii"
            private val DATABASE_VERSION = 2
            private val TABLA_USUARIOS = "USUARIO"
            private val COLUMN_ID = "IDUSER"
            private val COLUMN_NOMBRES = "NOMBRES"
            private val COLUMN_APELLIDOS = "APELLIDOS"
            private val COLUMN_TELEFONO = "TELEFONO"
            private val COLUMN_CORREO = "CORREO"
            private val COLUMN_CONTRASENA = "CONTRASENA"

        }

    override fun onCreate(db: SQLiteDatabase) {
        var queryCreateTable =
            ("CREATE TABLE " + TABLA_USUARIOS + " ( " +
                    COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NOMBRES + " TEXT, " +
                    COLUMN_APELLIDOS + " TEXT, " +
                    COLUMN_TELEFONO + " TEXT, "+
                    COLUMN_CORREO + " TEXT, "+
                    COLUMN_CONTRASENA + " TEXT" + ")"
                    )
        db.execSQL(queryCreateTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun CrearRegistro(nombres:String, apellidos:String, telefono: String,correo:String, contrasena:String ){
        val values = ContentValues();
        values.put(COLUMN_NOMBRES,nombres)
        values.put(COLUMN_APELLIDOS,apellidos)
        values.put(COLUMN_TELEFONO,telefono)
        values.put(COLUMN_CORREO,correo)
        values.put(COLUMN_CONTRASENA,contrasena)
        val db = this.writableDatabase
        db.insert(TABLA_USUARIOS, null, values)
        db.close()
    }
    fun Acceder(telefono: String, contrasena: String) : Cursor? {
        val db = this.readableDatabase
        val sql = "SELECT * FROM " + TABLA_USUARIOS + " WHERE " + COLUMN_TELEFONO + " = '" + telefono + "' AND " +
                COLUMN_CONTRASENA + " = '" + contrasena + "' "

        return db.rawQuery(sql, null)
    }
}