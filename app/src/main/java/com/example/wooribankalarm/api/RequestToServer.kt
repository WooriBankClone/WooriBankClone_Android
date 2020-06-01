package com.example.wooribankalarm.api

import android.app.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RequestToServer{
private const val BASE_URL = "http://52.79.52.4:3000"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: Service = retrofit.create(
        Service::class.java)
}