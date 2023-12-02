package com.example.proyectomobil.MappkiiREST

import retrofit2.Response
import retrofit2.http.GET
interface AutoresApi {
    @GET("/mocks/8200cdd3-ddd0-4230-87ef-750126a610ba/ListAutores")
    suspend fun getAutores(): Response<AutoresList>
}