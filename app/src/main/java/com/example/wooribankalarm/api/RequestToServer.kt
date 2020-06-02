package com.example.wooribankalarm.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RequestToServer{
    private const val BASE_URL = "http://54.180.18.5:3000"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: RequestInterface = retrofit.create( // RequestInterface의 객체 생성
        RequestInterface::class.java)
}