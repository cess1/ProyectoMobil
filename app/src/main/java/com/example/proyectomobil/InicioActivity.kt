package com.example.proyectomobil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectomobil.MainActivity


class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val buttonVideos: Button = findViewById(R.id.buttonVideos)

        // Asignar un evento clic al botón
        buttonVideos.setOnClickListener {
            // Llamar a la actividad MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
