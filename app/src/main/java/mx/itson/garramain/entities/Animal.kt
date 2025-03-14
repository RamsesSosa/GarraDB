package mx.itson.garramain.entities

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.garramain.persistence.GarraDB

class Animal {

    var id = 0
    var nombre = ""
    var especie = ""
    var habilidad = ""

    constructor()

    constructor(id : Int, nombre : String, especie : String, habilidad : String){
        this.id = id
        this.nombre = nombre
        this.especie = especie
        this.habilidad = habilidad
    }

    fun get(context : Context) : List<Animal> {
        var animales: MutableList<Animal> = ArrayList()
        try {
            val garraDB = GarraDB(context, "GarraDB", null, 1)
            val dataBase: SQLiteDatabase = garraDB.readableDatabase

            val result = dataBase.rawQuery("SELECT id, name, specie, ability FROM animales", null)
            while (result.moveToNext()) {
                val animal = Animal(
                    result.getInt(0),
                    result.getString(1),
                    result.getString(2),
                    result.getString(3)
                )
                animales.add(animal)
            }
        } catch (ex: Exception) {
            Log.e("Error al recibir registros", ex.message.toString())
        }
        return animales
    }
    fun save(context: Context, name : String, specie : String, ability : String){
        try {
            val garraDB = GarraDB(context, "GarraDB", null, 1)
            val dataBase : SQLiteDatabase = garraDB.writableDatabase
            val values = ContentValues()
            values.put("name", name)
            values.put("specie", specie)
            values.put("ability", ability)

            dataBase.insert("animales", null, values)
        }catch (ex:Exception){
            Log.e("Error al intentar guardar el animal", ex.message.toString())
        }
    }

}