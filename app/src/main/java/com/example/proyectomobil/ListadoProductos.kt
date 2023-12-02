package com.example.proyectomobil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomobil.MappkiRecylerView.ItemsProductos
import com.example.proyectomobil.MappkiRecylerView.RestAdapterProductos
import com.example.proyectomobil.MappkiiREST.ProductosApi
import com.example.proyectomobil.MappkiiREST.RetrofitHelperProduc
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListadoProductos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_productos)

        val productosApi = RetrofitHelperProduc.getRetrofitInstance().create(ProductosApi::class.java)

        GlobalScope.launch {
            val response = productosApi.getQuotes()

            if (response.isSuccessful) {
                val quotesList = response.body()
                val list = quotesList?.ListaProductos

                val items = list?.map { prod ->
                    ItemsProductos(prod.combo, prod.nombre, prod.descripcion,
                        prod.platoPrincipal, prod.acompanamientos, prod.ensaladas, prod.postre,
                        prod.precio, prod.tamano, prod.disponibilidad, prod.categoriaComidaRapida)
                }

                runOnUiThread {
                    val recyclerView: RecyclerView = findViewById(R.id.list_prod)
                    recyclerView.layoutManager = LinearLayoutManager(this@ListadoProductos)
                    val adapter = RestAdapterProductos(items.orEmpty())
                    recyclerView.adapter = adapter
                }
            } else {
                Log.e("CIBER REST ERROR", "Respuesta no exitosa")
            }
        }



    }
}