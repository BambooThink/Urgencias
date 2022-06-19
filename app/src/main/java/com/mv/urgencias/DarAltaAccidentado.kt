package com.mv.urgencias

import SistemaUrgencias.SistemaUrgencias
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class DarAltaAccidentado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dar_alta_accidentado)

        var codigoHospital = findViewById<EditText>(R.id.editTextNumber_codigo_hospital_punto6)
        var nombrePaciente = findViewById<EditText>(R.id.editText_nombre_paciente_punto6)
        var informacion = findViewById<TextView>(R.id.text_info_punto6)
        var botonEnviar = findViewById<Button>(R.id.button_enviar_punto6)
        var botonRegresar = findViewById<Button>(R.id.button_regresar_punto6)

        botonEnviar.setOnClickListener{
            try {
                SistemaUrgencias.dar_alta_accidentado(codigoHospital.text.toString().toInt(), nombrePaciente.text.toString())
                informacion.text = "La operación fue posible"
                Toast.makeText(this, "Se dio de alta al paciente", Toast.LENGTH_LONG).show()
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