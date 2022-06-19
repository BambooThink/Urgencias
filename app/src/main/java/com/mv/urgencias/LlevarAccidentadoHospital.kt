package com.mv.urgencias

import SistemaUrgencias.SistemaUrgencias
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LlevarAccidentadoHospital : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_llevar_accidentado_hospital)

        var codigoAmbulancia = findViewById<EditText>(R.id.editTextNumber_codigo_ambulancia_punto5)
        var informacion = findViewById<TextView>(R.id.text_info_punto5)
        var botonEnviar = findViewById<Button>(R.id.button_enviar_punto5)
        var botonRegresar = findViewById<Button>(R.id.button_regresar_punto5)

        botonEnviar.setOnClickListener{
            try {
                val ambulancia = SistemaUrgencias.lista_ambulancias.find {
                                        it.codigo == codigoAmbulancia.text.toString().toInt() }

                if (ambulancia == null)
                    throw Exception("Ambulancia no existe")

                if (ambulancia!!.estado.equals("LIBRE"))
                    throw Exception("Ambulancia Libre")

                val hospital = SistemaUrgencias.buscar_hospital_para_ambulancia(ambulancia)

                if (hospital == null)
                    throw Exception("No se encontro hospital")

                val texto = "Código Hospital: ${hospital.codigo}, Nombre ${hospital.nombre}"
                informacion.text = texto
                SistemaUrgencias.llegada_ambulancia_hospital(ambulancia)
                Toast.makeText(this, "Se llevó al accidentado", Toast.LENGTH_LONG).show()

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