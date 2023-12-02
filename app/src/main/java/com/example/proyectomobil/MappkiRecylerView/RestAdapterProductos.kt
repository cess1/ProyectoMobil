package com.example.proyectomobil.MappkiRecylerView

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.content.Intent
import android.net.Uri
import android.view.ViewParent
import android.widget.Button
import android.widget.TextView
import com.example.proyectomobil.R

class RestAdapterProductos (private val mList: List<ItemsProductos>):
    RecyclerView.Adapter<RestAdapterProductos.ViewHolder>()
{
    class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView) {
        val combo: TextView = ItemView.findViewById(R.id.lblComb)
        val nom: TextView = ItemView.findViewById(R.id.lblNombre)
        val descrip: TextView = ItemView.findViewById(R.id.lblDesc)
        val plato: TextView = ItemView.findViewById(R.id.lblPlatoPrincipal)
        val acompa: TextView = ItemView.findViewById(R.id.lblAcomp)
        val ensa: TextView = ItemView.findViewById(R.id.lblEnsaladas)
        val postre: TextView = ItemView.findViewById(R.id.lblPostre)
        val precio: TextView = ItemView.findViewById(R.id.lblPrecio)
        val tamano: TextView = ItemView.findViewById(R.id.lblTamano)
        val dispo: TextView = ItemView.findViewById(R.id.lblDisp)
        val cate: TextView = ItemView.findViewById(R.id.lblCat)
        
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_productos, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return mList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsRest = mList[position]
        holder.combo.text = itemsRest.combo
        holder.nom.text = itemsRest.nombre
        holder.descrip.text = itemsRest.descripcion
        holder.plato.text = itemsRest.platoPrincipal
        holder.acompa.text = itemsRest.acompanamientos
        holder.ensa.text = itemsRest.ensaladas
        holder.postre.text = itemsRest.postre
        holder.precio.text = itemsRest.precio
        holder.tamano.text = itemsRest.tamano
        holder.dispo.text = itemsRest.disponibilidad
        holder.cate.text = itemsRest.categoriaComidaRapida
    }


}