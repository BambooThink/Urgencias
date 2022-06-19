package com.mv.urgencias

import SistemaUrgencias.SistemaUrgencias
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MostrarInfoHospitalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_mostrar_info_hospital)

            val btn_atras = findViewById<ImageView>(R.id.ib_atras_infoHospital)
            val btn_buscar = findViewById<Button>(R.id.bt_buscar_hospitalInfo)

            val txt_codigo = findViewById<EditText>(R.id.tn_codigo_hospitalInfo)
            val txt_nombre = findViewById<TextView>(R.id.tv_nombre_hospitalInfo)
            val txt_direccion = findViewById<TextView>(R.id.tv_direccion_hospitalInfo)
            val txt_especialidad1 = findViewById<TextView>(R.id.tv_especialidad1_hospitalInfo)
            val txt_especialidad2 = findViewById<TextView>(R.id.tv_especialidad2_hospitalInfo)

            btn_atras.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            btn_buscar.setOnClickListener {
                val codigo = txt_codigo.text.toString().toInt()
                val hospital = SistemaUrgencias.lista_hospitales.find { it.codigo.equals(codigo) }

                if (hospital != null) {
                    txt_nombre.text = hospital!!.nombre
                    txt_direccion.text = "Calle ${hospital!!.ubicacion.calle} Carrera ${hospital!!.ubicacion.carrera}"
                    txt_especialidad1.text = "Especialidad 1: ${hospital.accidente1}"
                    txt_especialidad2.text = "Especialidad 2: ${hospital.accidente2}"
                }
                else {
                    txt_nombre.text = ""
                    txt_direccion.text = ""
                    txt_especialidad1.text = ""
                    txt_especialidad2.text = ""
                    Toast.makeText(this, "Codigo no existe", Toast.LENGTH_LONG).show()
                }

            }
        }
        catch(e: Exception) {
            Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
        }

    }

}