package com.example.proyectomobil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomobil.MappkiRecylerView.AutoresCustomAdapter
import com.example.proyectomobil.MappkiRecylerView.AutoresViewModel
import com.example.proyectomobil.MappkiiREST.AutoresApi
import com.example.proyectomobil.MappkiiREST.RetrofitHelperIntegrantes
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AutoresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autores)

        val autoresApi = RetrofitHelperIntegrantes.getRetrofitInstance().create(AutoresApi::class.java)

        GlobalScope.launch {
            val response = autoresApi.getAutores()

            if (response.isSuccessful) {
                val autoresList = response.body()
                val list = autoresList?.List

                val items = list?.map { autor ->
                    AutoresViewModel(autor.Codigo, autor.Nombre, autor.Apellido)
                }

                runOnUiThread {
                    val recyclerView: RecyclerView = findViewById(R.id.recycleViewAutores)
                    recyclerView.layoutManager = LinearLayoutManager(this@AutoresActivity)
                    val adapter = AutoresCustomAdapter(items.orEmpty())
                    recyclerView.adapter = adapter
                }
            } else {
                Log.e("CIBER REST ERROR", "Respuesta no exitosa")
            }
        }
    }
}