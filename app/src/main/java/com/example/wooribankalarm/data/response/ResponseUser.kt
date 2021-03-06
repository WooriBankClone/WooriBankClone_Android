package com.example.wooribankalarm.data.response

data class ResponseUser(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : HistoCon? //nullable
)

data class HistoCon (
    val account: String,
    val balance: String
)
