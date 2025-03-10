package mx.itson.garra.persistence

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class GarraDB(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    companion object {
        private const val DATABASE_VERSION = 2  // Incrementa la versión
    }

    override fun onCreate(sqliteDatabase: SQLiteDatabase) {
        try {
            sqliteDatabase.execSQL("CREATE TABLE animales (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)")
        } catch (ex: Exception) {
            Log.e("Error al crear la base de datos", ex.message.toString())
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion < newVersion) {
            // Verifica que db no sea nulo
            db?.let { safeDb ->
                // Elimina la tabla si existe (solo para desarrollo, no en producción)
                safeDb.execSQL("DROP TABLE IF EXISTS animales")
                // Vuelve a crear la tabla
                onCreate(safeDb)
            } ?: run {
                Log.e("GarraDB", "Error: SQLiteDatabase es nulo en onUpgrade")
            }
        }
    }
}