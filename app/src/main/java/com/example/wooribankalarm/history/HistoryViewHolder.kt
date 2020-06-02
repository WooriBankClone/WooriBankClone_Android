package com.example.wooribankalarm.history

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.wooribankalarm.R


class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //이게 입금 출금 취소 내용이 들어가는 곳
    val tv_case_left = itemView.findViewById<TextView>(R.id.transacType1)
    val tv_case_left2 = itemView.findViewById<TextView>(R.id.transacType2)
    val tv_case_right = itemView.findViewById<TextView>(R.id.transacType3)

    //그냥 내용
    val tv_content_left1 = itemView.findViewById<TextView>(R.id.from1)
    val tv_content_left1_1 = itemView.findViewById<TextView>(R.id.amount1)
    val tv_content_left2 = itemView.findViewById<TextView>(R.id.from2)
    val tv_content_left2_2 = itemView.findViewById<TextView>(R.id.amount2)
    val tv_content_right = itemView.findViewById<TextView>(R.id.from3)
    val tv_content_right2 = itemView.findViewById<TextView>(R.id.amount3)



    fun bind(historyData: HistoryData, caseBy: Int){


        //케이스에 따라 입금 출금 취소 내용 정하기
        if (caseBy == 0){ //입금
            tv_case_left.text = "입금"
            //금액 등등 내 추가
            tv_content_left1.text = historyData.history_content1
            tv_content_left1_1.text = historyData.history_content2


            val deposit : ConstraintLayout = itemView.findViewById(R.id.history_item_left)
            val withdrawal : ConstraintLayout = itemView.findViewById(R.id.history_item_right)
            val cancel : ConstraintLayout = itemView.findViewById(R.id.history_item_left2)


            deposit.visibility = ConstraintLayout.VISIBLE
            withdrawal.visibility = ConstraintLayout.INVISIBLE
            cancel.visibility = ConstraintLayout.INVISIBLE





        }else if ( caseBy == 1){ // 출금
            tv_case_right.text = "출금"
            //금액 등등 내용 추가
            tv_content_right.text = historyData.history_content1
            tv_content_right2.text = historyData.history_content2

            val deposit : ConstraintLayout = itemView.findViewById(R.id.history_item_left)
            val withdrawal : ConstraintLayout = itemView.findViewById(R.id.history_item_right)
            val cancel : ConstraintLayout = itemView.findViewById(R.id.history_item_left2)

            deposit.visibility = ConstraintLayout.INVISIBLE
            withdrawal.visibility = ConstraintLayout.VISIBLE
            cancel.visibility = ConstraintLayout.INVISIBLE

        }else{ // caseBy == 2로 취소이거나 버그
            tv_case_left2.text = "취소"
            //금액 등등 내용 추가
            tv_content_left2.text = historyData.history_content1
            tv_content_left2_2.text = historyData.history_content2

            val deposit : ConstraintLayout = itemView.findViewById(R.id.history_item_left)
            val withdrawal : ConstraintLayout = itemView.findViewById(R.id.history_item_right)
            val cancel : ConstraintLayout = itemView.findViewById(R.id.history_item_left2)

            deposit.visibility = ConstraintLayout.INVISIBLE
            withdrawal.visibility = ConstraintLayout.INVISIBLE
            cancel.visibility = ConstraintLayout.VISIBLE


        }






    }
}