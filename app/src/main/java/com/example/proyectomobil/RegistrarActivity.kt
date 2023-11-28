package com.example.proyectomobil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.proyectomobil.SQLite.BDHelper

class RegistrarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        val btnGrabar : Button = findViewById(R.id.btnGrabarUsuario)

        btnGrabar.setOnClickListener {
            val inputCorreo : EditText = findViewById(R.id.txtCorreo)
            val inputNombres : EditText = findViewById(R.id.txtNombres)
            val inputApellidos : EditText = findViewById(R.id.txtApellidos)
            val inputTelefono : EditText = findViewById(R.id.txtTelefono)
            val inputContrasena : EditText = findViewById(R.id.txtContraseña)


            val correo = inputCorreo.text.toString()
            val nombres = inputNombres.text.toString()
            val apellidos = inputApellidos.text.toString()
            val telefono = inputTelefono.text.toString()
            val contrasena = inputContrasena.text.toString()

            val db = BDHelper(this, null)

            db.CrearRegistro(correo, nombres, apellidos,telefono, contrasena )
            Toast.makeText(this, "Se registro el usuario de manera exitosa", Toast.LENGTH_LONG).show()

            inputCorreo.text.clear()
            inputNombres.text.clear()
            inputApellidos.text.clear()
            inputTelefono.text.clear()
            inputContrasena.text.clear()
        }


    }
}