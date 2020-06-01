package com.example.wooribankalarm.api


import com.example.wooribankalarm.data.request.ReqAutoTransfer
import com.example.wooribankalarm.data.response.ResAutoTranster
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
interface RequestInterface{
    /**사용자 기본 정보 출력**/
    @GET("/capital")
    fun autoTransfer(
         @Body body: ReqAutoTransfer
    ): Call<ResAutoTranster>
}