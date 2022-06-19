package com.mv.urgencias

import SistemaUrgencias.Ambulancia
import SistemaUrgencias.SistemaUrgencias
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mv.urgencias.databinding.ActivityMostrarAmbulanciasBinding
import com.mv.urgencias.adapters.AmbulanciaAdapter
import ean.collections.TArrayList

class MostrarAmbulanciasActivity(): AppCompatActivity() {

    private lateinit var binding: ActivityMostrarAmbulanciasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarAmbulanciasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initMostrarAmbulancias(getIntent().getExtras()!!.getString("estado_ambulancia"))
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