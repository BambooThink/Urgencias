package com.mv.urgencias

import SistemaUrgencias.Accidentado
import SistemaUrgencias.SistemaUrgencias
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class InformarAccidente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informar_accidente)

        var nombreAccidentado = findViewById<EditText>(R.id.editTextNumber_accidentado_punto4)
        var nombreAccidente = findViewById<EditText>(R.id.editTextNumber_accidente_punto4)
        var calle = findViewById<EditText>(R.id.editTextNumber_calle_punto4)
        var carrera = findViewById<EditText>(R.id.editTextNumber_carrera_punto4)
        var informacion = findViewById<TextView>(R.id.text_info_punto4)
        var botonEnviar = findViewById<Button>(R.id.button_enviar_punto4)
        var botonRegresar = findViewById<Button>(R.id.button_regresar_punto4)

        botonEnviar.setOnClickListener{
            try {
                var accidentado = Accidentado(nombreAccidentado.text.toString(), nombreAccidente.text.toString())
                val ambulancia = SistemaUrgencias.ocurrio_accidente(accidentado, calle.text.toString().toInt(),
                carrera.text.toString().toInt())!!
                SistemaUrgencias.asignar_accidentado_a_ambulancia(accidentado, ambulancia)
                informacion.text = "El código de la ambulancia es ${ambulancia.codigo}"
                Toast.makeText(this, "Se informó accidente", Toast.LENGTH_LONG).show()
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