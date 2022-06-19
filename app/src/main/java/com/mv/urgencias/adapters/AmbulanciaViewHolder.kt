package com.mv.urgencias.adapters

import SistemaUrgencias.Ambulancia
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mv.urgencias.databinding.ItemAmbulanciaBinding

class AmbulanciaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemAmbulanciaBinding.bind(view)

    fun render(ambulanciaModel: Ambulancia) {
        binding.tvCodigoAmbulancia.text = ambulanciaModel.codigo.toString()
        binding.tvEstado.text = "Estado: ${ambulanciaModel.estado}"
        binding.tvUbicacion.text = "Ubicacion: Calle ${ambulanciaModel.ubicacion!!.calle} Carrera ${ambulanciaModel.ubicacion!!.carrera}"
        binding.tvPaciente.text = "Paciente: ${ambulanciaModel.accidentado?.nombre}"
    }

}