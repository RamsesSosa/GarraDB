package mx.itson.garramain.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.BaseAdapter
import android.widget.TextView
import mx.itson.garramain.R
import mx.itson.garramain.entities.Animal

class AnimalAdapter(
    context: Context,
    animales : List<Animal>
) : BaseAdapter(){

    var context : Context = context
    var animalesList : List<Animal> = animales

    override fun getCount(): Int {
        return animalesList.size
    }

    override fun getItem(position: Int): Any {
        return animalesList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView : View?, parent: ViewGroup?): View{
        var elemento = LayoutInflater.from(context).inflate(R.layout.elem_animal, null)
        try {
            val animal = getItem(position) as Animal
            val txtName: TextView = elemento.findViewById(R.id.animal_nombre)
            val txtSpecie: TextView = elemento.findViewById(R.id.animal_specie)
            val txtAbility: TextView = elemento.findViewById(R.id.animal_ability)
            txtName.text = animal.nombre
            txtSpecie.text = animal.especie
            txtAbility.text = animal.habilidad
        }catch (ex : Exception){
            Log.e("Error al renderizar animales", ex.message.toString())
        }
        return elemento
    }


}