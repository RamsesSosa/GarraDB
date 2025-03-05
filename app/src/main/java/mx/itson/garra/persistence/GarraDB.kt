package mx.itson.garra.persistence

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class GarraDB(
    context : Context?,
    name : String?,
    factory : SQLiteDatabase.CursorFactory?,
    version : Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(sqliteDatabase: SQLiteDatabase) {
        try {
            sqliteDatabase.execSQL("CREATE TABLE animales (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)")
        } catch (ex : Exception){
            Log.e("Error al crear la base ded datos", ex.message.toString())
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}