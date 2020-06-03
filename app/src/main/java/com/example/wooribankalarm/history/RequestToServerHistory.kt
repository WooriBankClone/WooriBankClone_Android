package com.example.wooribankalarm.history

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestToServerHistory {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://54.180.18.5:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: RequestInterfaceHistory = retrofit.create(RequestInterfaceHistory::class.java)
}