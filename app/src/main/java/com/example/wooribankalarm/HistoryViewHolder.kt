package com.example.wooribankalarm

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.toColor
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView


class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //이게 입금 출금 취소 내용이 들어가는 곳
    val tv_case_left = itemView.findViewById<TextView>(R.id.history_case_left)
    val tv_case_right = itemView.findViewById<TextView>(R.id.history_case_right)
    //그냥 내용
    val tv_content_left = itemView.findViewById<TextView>(R.id.history_content_left)
    val tv_content_right = itemView.findViewById<TextView>(R.id.history_content_right)


    fun bind(historyData: HistoryData, caseBy: Int){

        //케이스에 따라 입금 출금 취소 내용 정하기
        if (caseBy == 0){ //입금
            tv_case_left.text = "입금"
            //금액 등등 내 추가
            tv_content_left.text = historyData.history_content
            itemView.findViewById<TextView>(R.id.history_case_right).visibility = View.GONE
            itemView.findViewById<TextView>(R.id.history_content_right).visibility = View.GONE





        }else if ( caseBy == 1){ // 출금
            tv_case_right.text = "출금"
            //금액 등등 내용 추가
            tv_content_right.text = historyData.history_content
            itemView.findViewById<TextView>(R.id.history_case_left).visibility = View.GONE
            itemView.findViewById<TextView>(R.id.history_content_left).visibility = View.GONE

        }else{ // caseBy == 2로 취소이거나 버그
            tv_case_left.text = "취소"
            //금액 등등 내용 추가
            tv_content_left.text = historyData.history_content
            itemView.findViewById<TextView>(R.id.history_case_right).visibility = View.GONE
            itemView.findViewById<TextView>(R.id.history_content_right).visibility = View.GONE


        }






    }
}