package com.example.wooribankalarm.api


import com.example.wooribankalarm.data.request.ReqAutoTransfer
import com.example.wooribankalarm.data.request.RequestMoney
import com.example.wooribankalarm.data.request.RequestUser
import com.example.wooribankalarm.data.response.ResAutoTransfer
import com.example.wooribankalarm.data.response.ResponseMoney
import com.example.wooribankalarm.data.response.ResponseUser
import retrofit2.Call
import retrofit2.http.*

interface RequestInterface{
    /**사용자 기본 정보 출력**/
    @POST("/capital")
    fun autoTransfer(
        @Body body: ReqAutoTransfer
    ): Call<ResAutoTransfer>

    @POST("/user")
    fun requestUser(
        @Body body : RequestUser
    ) : Call<ResponseUser>

    @POST("/user/moneyList")
    fun requestMoney(@Body body : RequestMoney) : Call<ResponseMoney>
}