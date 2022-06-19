package com.mv.urgencias.adapters

import SistemaUrgencias.Accidentado
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mv.urgencias.R
import ean.collections.TArrayList

class PacienteAdapter(private val lista_pacientes: TArrayList<Accidentado>): RecyclerView.Adapter<PacienteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacienteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PacienteViewHolder(layoutInflater.inflate(R.layout.item_paciente, parent,false))
    }

    override fun onBindViewHolder(holder: PacienteViewHolder, position: Int) {
        val item = lista_pacientes[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = lista_pacientes.size

}