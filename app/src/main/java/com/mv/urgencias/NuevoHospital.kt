package com.mv.urgencias

import SistemaUrgencias.SistemaUrgencias
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class NuevoHospital : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_hospital)

        var codigoHospital = findViewById<EditText>(R.id.editTextNumber_codigo_punto2)
        var nombreHospital = findViewById<EditText>(R.id.editTextNumber_nombre_punto2)
        var calle = findViewById<EditText>(R.id.editTextNumber_calle_punto2)
        var carrera = findViewById<EditText>(R.id.editTextNumber_carrera_punto2)
        var accidente1 = findViewById<EditText>(R.id.editText_accidente1_punto2)
        var accidente2 = findViewById<EditText>(R.id.editText_accidente2_punto2)
        var botonEnviar = findViewById<Button>(R.id.button_enviar_punto2)
        var botonRegresar = findViewById<Button>(R.id.button_regresar_punto2)

        botonEnviar.setOnClickListener{
            try {
                SistemaUrgencias.agregar_hospital(codigoHospital.text.toString().toInt(),
                    nombreHospital.text.toString(), calle.text.toString().toInt(),
                    carrera.text.toString().toInt(), accidente1.text.toString(),
                    accidente2.text.toString())
                Toast.makeText(this, "Se creó el hospital", Toast.LENGTH_LONG).show()
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