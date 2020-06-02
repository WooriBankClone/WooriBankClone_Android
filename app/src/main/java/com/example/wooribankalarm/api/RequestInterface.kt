package com.example.wooribankalarm.api


import com.example.wooribankalarm.data.request.ReqAutoTransfer
import com.example.wooribankalarm.data.response.ResAutoTransfer
import retrofit2.Call
import retrofit2.http.*
interface RequestInterface{
    /**사용자 기본 정보 출력**/
    @POST("/capital")
    fun autoTransfer(
        @Body body: ReqAutoTransfer
    ): Call<ResAutoTransfer>
}