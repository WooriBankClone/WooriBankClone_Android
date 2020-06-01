package com.example.wooribankalarm.data.response

data class ResAutoTranster(
    val status: String,
    val success:Boolean,
    val message: String,
    val data: StoCon?
)

data class StoCon(
    val date: String,
    val userName: String,
    val userAccount: String,
    val otherName: String,
    val flag: Int,
    val dueDate: String,
    val content: String
)