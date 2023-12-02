package com.example.proyectomobil.MappkiRecylerView

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import com.example.proyectomobil.R

class AutoresCustomAdapter(private val mList: List<AutoresViewModel>): RecyclerView.Adapter<AutoresCustomAdapter.ViewHolder>() {
    class ViewHolder(AutoresView :View) :RecyclerView.ViewHolder(AutoresView){
        val Codigo: TextView = AutoresView.findViewById(R.id.lbl_Codigo)
        val Nombre: TextView = AutoresView.findViewById(R.id.lbl_Nombre)
        val Apellido: TextView = AutoresView.findViewById(R.id.lbl_Apellido)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_autores, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return mList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemViewModel = mList[position]

        holder.Codigo.text = itemViewModel.Codigo
        holder.Nombre.text = itemViewModel.Nombre
        holder.Apellido.text = itemViewModel.Apellido

    }

}