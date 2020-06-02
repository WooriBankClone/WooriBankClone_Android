package com.example.wooribankalarm.history

data class ResponseUser(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : MutableList<HistoCon>

)

data class HistoCon(
    val account : String,
    val balance : String
)