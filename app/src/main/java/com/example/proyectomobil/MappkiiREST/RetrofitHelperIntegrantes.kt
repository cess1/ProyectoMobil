package com.example.proyectomobil.MappkiiREST

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelperIntegrantes {

    val baseUrl ="https://api.mockfly.dev/"
    fun getRetrofitInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(RetrofitHelperProduc.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}