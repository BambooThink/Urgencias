package com.mv.urgencias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var botonNuevaAmbulancia = findViewById<Button>(R.id.button_1_main)
        var botonNuevoHospital = findViewById<Button>(R.id.button_2_main)
        var botonActualizarAmbulancia = findViewById<Button>(R.id.button_3_main)
        var botonInformarAccidente = findViewById<Button>(R.id.button_4_main)
        var botonLlevarAccidentadoHospital = findViewById<Button>(R.id.button_5_main)
        var botonDarAltaAccidentado = findViewById<Button>(R.id.button_6_main)
        var botonMostrarAmbulancias = findViewById<Button>(R.id.button_7_main)
        var botonMostrarHospitales = findViewById<Button>(R.id.button_8_main)
        var botonMostrarPacientes = findViewById<Button>(R.id.button_9_main)
        var botonMostrarAmbulanciasLibres = findViewById<Button>(R.id.button_10_main)
        var botonMostrarAmbulanciasOcupadas = findViewById<Button>(R.id.button_11_main)
        var botonMostrarHospital = findViewById<Button>(R.id.button_12_main)


        botonNuevaAmbulancia.setOnClickListener{
            try {
                val intent = Intent(this, NuevaAmbulancia::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        botonNuevoHospital.setOnClickListener{
            try {
                val intent = Intent(this, NuevoHospital::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        botonActualizarAmbulancia.setOnClickListener{
            try {
                val intent = Intent(this, ActualizarUbicacionAmbulancia::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        botonInformarAccidente.setOnClickListener{
            try {
                val intent = Intent(this, InformarAccidente::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        botonLlevarAccidentadoHospital.setOnClickListener{
            try {
                val intent = Intent(this, LlevarAccidentadoHospital::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        botonDarAltaAccidentado.setOnClickListener{
            try {
                val intent = Intent(this, DarAltaAccidentado::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        botonMostrarAmbulancias.setOnClickListener{
            try {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        botonMostrarHospitales.setOnClickListener{
            try {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        botonMostrarPacientes.setOnClickListener{
            try {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        botonMostrarAmbulanciasLibres.setOnClickListener{
            try {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        botonMostrarAmbulanciasOcupadas.setOnClickListener{
            try {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
        botonMostrarHospital.setOnClickListener{
            try {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }

    }
}