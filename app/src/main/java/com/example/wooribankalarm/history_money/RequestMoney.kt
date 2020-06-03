package com.example.wooribankalarm.history_money

import com.example.wooribankalarm.history.HistoCon

data class RequestMoney(
    val userIdx : Int,
    val periodFlag : Int
)