package com.mv.urgencias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class NuevaAmbulancia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_ambulancia)

        var codigoAmbulancia = findViewById<EditText>(R.id.editTextNumber_codigo_punto1)
        var calle = findViewById<EditText>(R.id.editTextNumber_calle_punto1)
        var carrera = findViewById<EditText>(R.id.editTextNumber_carrera_punto1)
        var botonEnviar = findViewById<Button>(R.id.button_enviar_punto1)
        var botonRegresar = findViewById<Button>(R.id.button_regresar_punto1)

        botonEnviar.setOnClickListener{
            try {

                Toast.makeText(this, "Se creó la ambulancia", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }

        botonRegresar.setOnClickListener{
            try {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }

    }

}