package com.example.wooribankalarm.history_money

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterfaceMoney {
    @POST("/user/moneyList")
    fun requestMoney(@Body body : RequestMoney) : Call<ResponseMoney>
}