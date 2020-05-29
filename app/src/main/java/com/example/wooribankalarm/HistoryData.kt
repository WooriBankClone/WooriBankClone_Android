package com.example.wooribankalarm

data class HistoryData (
// 정민언니가 아이템 만들어 주면, 구성 뷰에 따라 이후에 추가
    //val history_content : String,
    //뷰홀더에서 직어주는 값임 선언 필요 없음

    val history_content : String,
    val caseBy : Int // 입금0, 출금1, 취소2
)
