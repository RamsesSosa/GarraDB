package mx.itson.garramain

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
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
                val animalName = findViewById<EditText>(R.id.txt_name).text.toString().trim()
                val animalSpecie = findViewById<EditText>(R.id.txt_specie).text.toString().trim()
                val animalAbility = findViewById<EditText>(R.id.txt_ability).text.toString().trim()

                // if para validar que los campos no esten vacios
                if(animalName.isEmpty() || animalSpecie.isEmpty() || animalAbility.isEmpty()){
                    Toast.makeText(this, getString(R.string.text_empty_message), Toast.LENGTH_SHORT).show()
                }else{
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        val vibratorAdmin = applicationContext.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                        val vibrator = vibratorAdmin.defaultVibrator
                        vibrator.vibrate(VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE))
                    }else{
                        val vibrator = applicationContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                        vibrator.vibrate(300)
                    }
                    Animal().save(this, animalName, animalSpecie, animalAbility)
                    Toast.makeText(this,getString(R.string.text_save_message), Toast.LENGTH_SHORT).show()

                    finish()
                }
            }
        }
    }
}