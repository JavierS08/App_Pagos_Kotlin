package com.teoria.hito_programacin_javier_sanchez

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.collections.ArrayList

class DbHelper (context: Context): SQLiteOpenHelper(context,"pagos.db",null,1) {

    companion object {
        private val TABLE = "pagos"

        private val ID = "id"
        private val NOMBRE = "nombre"
        private val CONTEXTO = "contexto"
        private val PRECIO = "precio"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val CREAR_TABLA_pagos = ("CREATE TABLE " + TABLE + "(" + ID + " INTEGER PRIMARY KEY" +
                " AUTOINCREMENT," + NOMBRE + " TEXT," + CONTEXTO + " TEXT,"
                + PRECIO + " INTEGER" + ")")
        p0?.execSQL(CREAR_TABLA_pagos)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS " + TABLE)
        onCreate(p0)
    }

    fun insertData(nombre: String, contexto: String, precio: Int) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NOMBRE, nombre)
        contentValues.put(CONTEXTO, contexto)
        contentValues.put(PRECIO, precio)
        db.insert("pagos", null, contentValues)
    }

    fun ver(): ArrayList<Pago> {
        var sql = "select * from $TABLE"
        val db = this.writableDatabase
        val store = ArrayList<Pago>()
        val cursor = db.rawQuery(sql, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(0).toInt()
                val nombre = cursor.getString(1)
                val contexto = cursor.getString(2)
                val pago = cursor.getString(3).toInt()
                store.add(Pago(id, nombre, contexto, pago))
            } while (cursor.moveToNext())

        }
        cursor.close()
        return store
    }
    fun delete(pago: Pago){
        var db = this.writableDatabase
        val selectionArgs = arrayOf(pago.id.toString())
        db.delete("pagos", ID+" = ? ",selectionArgs);
    }
    fun edit(id: Int,nombre: String, contexto: String, precio: Int ){
        val db = this.writableDatabase
        val values=ContentValues()
        values.put(ID,id)
        values.put(NOMBRE,nombre)
        values.put(CONTEXTO,contexto)
        values.put(PRECIO,precio)
        db.update("pagos",values, ID +"=?", arrayOf(id.toString()))
    }
}
