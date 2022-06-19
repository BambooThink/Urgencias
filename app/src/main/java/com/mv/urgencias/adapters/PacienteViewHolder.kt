package com.mv.urgencias.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mv.urgencias.databinding.ItemPacienteBinding

class PacienteViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val binding = ItemPacienteBinding.bind(view)

    fun render(pacienteModel: String) {
        binding.tvNombrePaciente.text = pacienteModel
    }

}