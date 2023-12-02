package com.example.proyectomobil.MappkiiREST

import retrofit2.Response
import retrofit2.http.GET
interface AutoresApi {
    @GET("/mocks/f5998f79-27cb-45d7-9ab9-5cd0e9af2232/ListAutores")
    suspend fun getQuotes(): Response<String>
}