package mx.itson.garramain

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.itson.garramain.entities.Animal

class AnimalFormActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_animal_form)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSave = findViewById<Button>(R.id.btn_save)
        btnSave.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_save -> {
                val animalName = findViewById<EditText>(R.id.txt_name).text.toString()
                val animalSpecie = findViewById<EditText>(R.id.txt_specie).text.toString()
                val animalAbility = findViewById<EditText>(R.id.txt_ability).text.toString()
                Animal().save(this, animalName, animalSpecie, animalAbility)
                Toast.makeText(this,"Animal guardado correctamente", Toast.LENGTH_SHORT).show()

                finish()
            }
        }
    }
}