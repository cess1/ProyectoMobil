package com.example.proyectomobil.MappkiiREST

import retrofit2.Response
import retrofit2.http.GET

interface ProductosApi {

    @GET("/mocks/97da0bc9-ef42-4ad8-9567-6146102212f1/ListProd")
    suspend fun getQuotes(): Response<String>
}