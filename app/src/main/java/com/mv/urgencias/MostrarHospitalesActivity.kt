package com.mv.urgencias

import SistemaUrgencias.SistemaUrgencias
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mv.urgencias.adapters.HospitalAdapter
import com.mv.urgencias.databinding.ActivityMostrarHospitalesBinding

class MostrarHospitalesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMostrarHospitalesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarHospitalesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initMostrarHospitales()
    }

    private fun initMostrarHospitales() {
        binding.recyclerHospital.layoutManager = LinearLayoutManager(this)
        binding.recyclerHospital.adapter = HospitalAdapter(SistemaUrgencias.lista_hospitales)
    }

}