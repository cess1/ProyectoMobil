package com.example.proyectomobil.MappkiiREST

import retrofit2.Response
import retrofit2.http.GET

interface ProductosApi {

    @GET("/mocks/865c373e-2d71-44b6-a7aa-3047e16d4837/ListProd")
    suspend fun getQuotes(): Response<ProductosList>
}