package com.example.proyectomobil.Video

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitViComidas {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://demo3782254.mockable.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val consumirApi = retrofit.create(ConsumirApi::class.java)
}