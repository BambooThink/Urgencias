package com.mv.urgencias

import SistemaUrgencias.SistemaUrgencias
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mv.urgencias.adapters.PacienteAdapter
import com.mv.urgencias.databinding.ActivityMostrarPacientesBinding
import java.lang.Exception

class MostrarPacientesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMostrarPacientesBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        try {

            super.onCreate(savedInstanceState)
            binding = ActivityMostrarPacientesBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.btBuscarPacientes.setOnClickListener {
                val codigoHospital = binding.tnCodigoPacientes.text.toString().toInt()
                binding.recyclerPaciente.layoutManager = LinearLayoutManager(this)
                binding.recyclerPaciente.adapter =
                    PacienteAdapter(SistemaUrgencias.lista_hospitales.find { it.codigo.equals(codigoHospital) }!!.pacientes)
            }

            binding.ibAtrasPacientes.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            
        }
        catch(e: Exception) {
            Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
        }

    }

}