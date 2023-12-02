package com.example.proyectomobil.Video

import retrofit2.Call
import retrofit2.http.GET
interface ConsumirApi {

    @GET("Videos")
    fun getTraer(): Call<Videos>
}