package com.example.proyectomobil.MappkiiREST

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.proyectomobil.InicioActivity
import com.example.proyectomobil.MainActivity
import com.example.proyectomobil.R
import com.example.proyectomobil.SQLite.BDHelper

class Comentarios : AppCompatActivity() {

    private lateinit var editTextComentario: EditText
    private lateinit var btnRegresarComentarios: Button
    private lateinit var btnEnviarComentario: Button
    private lateinit var bdHelper: BDHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comentarios)

        // Inicializar BDHelper
        bdHelper = BDHelper(this, null)

        // Obtener referencias de los elementos de la interfaz
        editTextComentario = findViewById(R.id.editTextComentario)
        btnRegresarComentarios = findViewById(R.id.btnRegresarComentario)
        btnEnviarComentario = findViewById(R.id.btnEnviarComentario)

        // Asignar un evento clic al botón de regresar
        btnRegresarComentarios.setOnClickListener {
            // Llamar a la actividad MainActivity
            val intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        }

        // Asignar un evento clic al botón de enviar comentario
        btnEnviarComentario.setOnClickListener {
            // Obtener el comentario del EditText
            val comentario = editTextComentario.text.toString()

            // Verificar que el comentario no esté vacío antes de guardarlo
            if (comentario.isNotEmpty()) {
                // Guardar el comentario en la base de datos
                bdHelper.CrearRegistroComentario(comentario)

                // Mostrar un mensaje de éxito con un Toast
                Toast.makeText(this, "Comentario enviado", Toast.LENGTH_SHORT).show()

                // Puedes realizar otras acciones según tus necesidades
            } else {
                // Mostrar un mensaje si el comentario está vacío
                Toast.makeText(this, "Por favor, ingresa un comentario", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
