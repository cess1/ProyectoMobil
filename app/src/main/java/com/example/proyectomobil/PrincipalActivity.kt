package com.example.proyectomobil

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
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
            val titulo:String = "Salir"
            val mensaje:String = "¿Está seguro que desea salir de la App?"
            exitModalConfirm(titulo, mensaje)
        }

        btnAutores.setOnClickListener {
            val autoresScreen = Intent(this, AutoresActivity::class.java)
            startActivity(autoresScreen)
        }
    }

    private fun exitModalConfirm(titulo:String, mensaje:String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.exit_modal_dialog)

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tituloModal : TextView = dialog.findViewById(R.id.salirTitulo)
        val mensajeModal : TextView = dialog.findViewById(R.id.salirMensaje)

        val btnSalir : Button = dialog.findViewById(R.id.salirbtnSalir)
        val btnCancelar : Button = dialog.findViewById(R.id.salirbtnCancelar)

        tituloModal.text = titulo
        mensajeModal.text = mensaje

        btnSalir.setOnClickListener {
            finishAffinity()
        }

        btnCancelar.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}