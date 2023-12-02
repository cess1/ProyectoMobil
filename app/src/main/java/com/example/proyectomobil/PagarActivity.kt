package com.example.proyectomobil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class PagarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagar)



        val btnPagar : Button = findViewById(R.id.btnPagar)

        btnPagar.setOnClickListener{
            val tiempoEntrega: Int = java.util.Random().nextInt(21) + 20
            val mensaje = "Su pedido llegará en $tiempoEntrega minutos."


            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()

            val intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        }

        val btnSalir : Button = findViewById(R.id.btnSalir)

        btnSalir.setOnClickListener{
            val coment = Intent(this, InicioActivity::class.java)
            startActivity(coment)
        }



    }
}