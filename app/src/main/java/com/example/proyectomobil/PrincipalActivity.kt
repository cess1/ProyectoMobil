package com.example.proyectomobil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        var btnAcceder : Button = findViewById(R.id.btnAcceder)
        var btnRegistrar : Button = findViewById(R.id.btnRegistrar)
        var btnSalir : Button = findViewById(R.id.btnSalir)
        var btnAutores : Button = findViewById(R.id.btnAutores)

        btnAcceder.setOnClickListener {
            val accederScreen = Intent(this, AccederActivity::class.java)
            startActivity(accederScreen)
        }

        btnRegistrar.setOnClickListener {
            val registrarScreen = Intent(this, RegistrarActivity::class.java)
            startActivity(registrarScreen)
        }

        btnSalir.setOnClickListener {

        }

        btnAutores.setOnClickListener {
            val autoresScreen = Intent(this, AutoresActivity::class.java)
            startActivity(autoresScreen)
        }
    }
}