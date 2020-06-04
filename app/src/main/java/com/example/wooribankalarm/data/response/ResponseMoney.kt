package com.example.wooribankalarm.data.response

data class ResponseMoney(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : MutableList<HistoMoneyCon>
)

data class HistoMoneyCon(
    val flag : Int,
    val account : String,
    val other : String,
    val amount : String,
    val balance : String,
    val time : String,
    val date : String
)