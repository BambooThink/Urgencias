package com.mv.urgencias

import SistemaUrgencias.SistemaUrgencias
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mv.urgencias.adapters.HospitalAdapter
import com.mv.urgencias.databinding.ActivityMostrarHospitalesBinding

class MostrarHospitalesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMostrarHospitalesBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        try {
            super.onCreate(savedInstanceState)
            binding = ActivityMostrarHospitalesBinding.inflate(layoutInflater)
            setContentView(binding.root)
            initMostrarHospitales()

            binding.ibAtrasHospitales.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }
        catch(e: Exception) {
            Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun initMostrarHospitales() {
        binding.recyclerHospital.layoutManager = LinearLayoutManager(this)
        binding.recyclerHospital.adapter = HospitalAdapter(SistemaUrgencias.lista_hospitales)
    }

}