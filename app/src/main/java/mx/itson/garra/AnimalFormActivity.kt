package mx.itson.garra

import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.itson.garra.entities.Animal

class AnimalFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_animal_form)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar el botón de guardar
        val btnSave = findViewById<Button>(R.id.btn_save)
        btnSave.setOnClickListener {
            val nombre = findViewById<EditText>(R.id.txt_name).text.toString()

            if (nombre.isNotEmpty()) {
                // Guardar el animal en la base de datos
                Animal().save(this, nombre)

                // Regresar a la actividad principal
                finish()
            } else {
                // Mostrar un mensaje de error si el campo está vacío
                Toast.makeText(this, "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show()
            }
        }
    }
}