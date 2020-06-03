package com.example.wooribankalarm.history

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterfaceHistory {
    @POST("/user")
    fun requestUser(@Body body : RequestUser) : Call<ResponseUser>
}