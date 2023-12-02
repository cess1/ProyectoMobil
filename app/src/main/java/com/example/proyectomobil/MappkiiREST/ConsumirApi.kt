package com.example.proyectomobil

import retrofit2.Call
import retrofit2.http.GET

interface ConsumirApi {
    @GET("Videos")
    fun getTraer(): Call<Videos>
}