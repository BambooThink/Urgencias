package com.mv.urgencias

import SistemaUrgencias.SistemaUrgencias
import SistemaUrgencias.UbicacionGeografica
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ActualizarUbicacionAmbulancia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_ubicacion_ambulancia)

        var codigoAmbulancia = findViewById<EditText>(R.id.editTextNumber_codigo_punto3)
        var calle = findViewById<EditText>(R.id.editTextNumber_calle_punto3)
        var carrera = findViewById<EditText>(R.id.editTextNumber_carrera_punto3)
        var botonEnviar = findViewById<Button>(R.id.button_enviar_punto3)
        var botonRegresar = findViewById<Button>(R.id.button_regresar_punto3)

        botonEnviar.setOnClickListener{
            try {
                SistemaUrgencias.actualizar_ubicacion_ambulancia(codigoAmbulancia.text.toString().toInt(),
                    UbicacionGeografica(calle.text.toString().toInt(), carrera.text.toString().toInt()))
                Toast.makeText(this, "Se actualizó la ubicación de la ambulancia", Toast.LENGTH_LONG).show()
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