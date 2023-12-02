package com.example.proyectomobil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectomobil.MainActivity
import com.example.proyectomobil.MappkiiREST.Comentarios


class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val buttonVideos: Button = findViewById(R.id.buttonVideos)
        val btnComentarios: Button = findViewById(R.id.btnComentarios)

        // Asignar un evento clic al botón
        buttonVideos.setOnClickListener {
            // Llamar a la actividad MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnComentarios.setOnClickListener {
            val comment = Intent(this, Comentarios::class.java)
            startActivity(comment)
        }

        val btnMenu : Button = findViewById(R.id.btnProductos)

        btnMenu.setOnClickListener{
            val coment = Intent(this, ListadoProductos::class.java)
            startActivity(coment)
        }
    }



}
