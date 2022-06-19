package com.mv.urgencias

import SistemaUrgencias.Ambulancia
import SistemaUrgencias.SistemaUrgencias
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mv.urgencias.databinding.ActivityMostrarAmbulanciasBinding
import com.mv.urgencias.adapters.AmbulanciaAdapter
import ean.collections.TArrayList
import java.lang.Exception

class MostrarAmbulanciasActivity(): AppCompatActivity() {

    private lateinit var binding: ActivityMostrarAmbulanciasBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        try {
            super.onCreate(savedInstanceState)
            binding = ActivityMostrarAmbulanciasBinding.inflate(layoutInflater)
            setContentView(binding.root)
            initMostrarAmbulancias(getIntent().getExtras()!!.getString("estado_ambulancia"))

            binding.ibAtrasAmbulancias.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }
        catch(e: Exception) {
            Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
        }

    }

    private fun initMostrarAmbulancias(estado_ambulancia: String?) {
        binding.recyclerAmbulancia.layoutManager = LinearLayoutManager(this)
        binding.recyclerAmbulancia.adapter = when (estado_ambulancia) {
            "LIBRE" -> AmbulanciaAdapter(SistemaUrgencias.lista_ambulancias.filter { it.estado.equals("LIBRE") })
            "OCUPADA" -> AmbulanciaAdapter(SistemaUrgencias.lista_ambulancias.filter { it.estado.equals("OCUPADA") })
            else -> AmbulanciaAdapter(SistemaUrgencias.lista_ambulancias)
        }
    }

}