package com.mv.urgencias.adapters

import SistemaUrgencias.Ambulancia
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ean.collections.TArrayList
import android.view.LayoutInflater
import com.mv.urgencias.R
import ean.collections.IList

class AmbulanciaAdapter (private val lista_ambulancias: IList<Ambulancia>): RecyclerView.Adapter<AmbulanciaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmbulanciaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AmbulanciaViewHolder(layoutInflater.inflate(R.layout.item_ambulancia, parent,false))
    }

    override fun onBindViewHolder(holder: AmbulanciaViewHolder, position: Int) {
        val item = lista_ambulancias[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = lista_ambulancias.size

}