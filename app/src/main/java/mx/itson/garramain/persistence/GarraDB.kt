package mx.itson.garramain.persistence

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class GarraDB(
    context: Context?,
    name : String?,
    factory : SQLiteDatabase.CursorFactory?,
    version : Int
) : SQLiteOpenHelper(context, name, factory, version){

    override fun onCreate(sqLiteDatabase: SQLiteDatabase){
        try {
            sqLiteDatabase.execSQL("CREATE TABLE animales (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, specie TEXT, ability TEXT)")
        }catch (ex: Exception){
            Log.e("Error al crear la base de datos", ex.message.toString())
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}