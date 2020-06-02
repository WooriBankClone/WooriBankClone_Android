package com.example.wooribankalarm.data.response

data class ResAutoTransfer(
    val status: String,
    val success:Boolean,
    val message: String,
    val data: MutableList<StoCon>
)

data class StoCon(
    val date: String, // story_date
    val userName: String, //contents
    val userAccount: String, //1
    val otherName: String, //1
    val otherAccount:String,
    val flag: Int,
    val dueDate: String, // 1, today_date
    val content: String // 1
)