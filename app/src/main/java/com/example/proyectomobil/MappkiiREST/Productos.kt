package com.example.proyectomobil.MappkiiREST

data class Productos(

    val combo: String,
    val nombre: String,
    val descripcion: String,
    val platoPrincipal: String,
    val acompanamientos: String,
    val ensaladas: String,
    val postre: String,
    val precio: Double,
    val tamano: String,
    val disponibilidad: String,
    val categoriaComidaRapida: String
)
