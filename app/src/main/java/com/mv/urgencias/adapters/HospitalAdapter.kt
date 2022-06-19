package com.mv.urgencias.adapters

import SistemaUrgencias.Hospital
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mv.urgencias.R
import ean.collections.TArrayList

class HospitalAdapter (private val lista_hospitales:TArrayList<Hospital>): RecyclerView.Adapter<HospitalViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HospitalViewHolder(layoutInflater.inflate(R.layout.item_hospital,parent,false))
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        val item = lista_hospitales[position]
        holder.render(item)
    }

    override fun getItemCount(): Int =lista_hospitales.size

}