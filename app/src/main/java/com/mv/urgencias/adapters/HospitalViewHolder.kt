package com.mv.urgencias.adapters

import SistemaUrgencias.Hospital
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mv.urgencias.databinding.ItemHospitalBinding

class HospitalViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemHospitalBinding.bind(view)

    fun render(hospitalModel: Hospital) {
        binding.tvNombreHospital.text = hospitalModel.nombre
        binding.tvCodigo.text = "Codigo: ${hospitalModel.codigo.toString()}"
        binding.tvEspecialidad1.text = "Especialidad 1: ${hospitalModel.accidente1}"
        binding.tvEspecialidad2.text = "Especialidad 2: ${hospitalModel.accidente2}"
        binding.tvDireccion.text = "Direccion: Calle ${hospitalModel.ubicacion.calle} Carrera ${hospitalModel.ubicacion.carrera}"
    }

}