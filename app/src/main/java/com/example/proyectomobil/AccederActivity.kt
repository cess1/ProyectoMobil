package com.example.proyectomobil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.proyectomobil.SQLite.BDHelper

class AccederActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acceder)

        val inputTelefono: EditText = findViewById(R.id.txtTelefono)
        val inputContrasena: EditText = findViewById(R.id.txtContraseña)
        val btnIngresar: Button = findViewById(R.id.LoginbtnIngresar)

        btnIngresar.setOnClickListener {

            val telefono = inputTelefono.text.toString()
            val contrasena = inputContrasena.text.toString()

            val bd = BDHelper(this, null)
            val cursor = bd.Acceder(telefono , contrasena)

            if (cursor!!.count <= 0) {
                Toast.makeText(this, "Usuario y/o contraseña incorrecta", Toast.LENGTH_LONG).show()
            } else {
                cursor!!.moveToFirst()
                val usuarioIndex = cursor.getColumnIndex("TELEFONO");
                val telefono = cursor.getString(usuarioIndex)

                val productScreen = Intent(this, InicioActivity::class.java)
                startActivity(productScreen)
            }


        }
        val btnCancelar: Button = findViewById(R.id.LoginbtnVolver)
        btnCancelar.setOnClickListener {
            val productScreen = Intent(this, PrincipalActivity::class.java)
            startActivity(productScreen)
        }

    }
}