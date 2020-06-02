package com.example.wooribankalarm.history_money

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


var retrofit = Retrofit.Builder()
    .baseUrl("https://54.180.18.5:3000")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var service: RequestInterfaceMoney = retrofit.create(RequestInterfaceMoney::class.java)