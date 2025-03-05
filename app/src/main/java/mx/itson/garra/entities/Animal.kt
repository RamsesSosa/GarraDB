package mx.itson.garra.entities

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.garra.persistence.GarraDB

class Animal {

    var id = 0
    var nombre : String = ""

    constructor()

    constructor(id: Int, nombre: String){
        this.id = id
        this.nombre = nombre
    }

    fun save(context: Context, nombre: String){
        try {
            val garraDB = GarraDB(context, "GarraDB", null, 1)
            val dataBase : SQLiteDatabase = garraDB.writableDatabase
            val values = ContentValues()
            values.put("name", nombre)

            dataBase.insert("animales", null, values)

        }catch (ex: Exception){
            Log.e("Error al intentar guardar un animal", ex.message.toString())
        }
    }


}