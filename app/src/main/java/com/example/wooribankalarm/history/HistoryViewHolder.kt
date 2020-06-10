package com.example.wooribankalarm.history

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.wooribankalarm.R
import com.example.wooribankalarm.data.response.HistoMoneyCon


class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //이게 입금 출금 취소 내용이 들어가는 곳
    val tv_case_left = itemView.findViewById<TextView>(R.id.transacType1)
    val tv_case_left2 = itemView.findViewById<TextView>(R.id.transacType2)
    val tv_case_right = itemView.findViewById<TextView>(R.id.transacType3)

    // 계좌
    val tv_content_myAccount1 = itemView.findViewById<TextView>(R.id.myAccount1)
    val tv_content_myAccount2 = itemView.findViewById<TextView>(R.id.myAccount2)
    val tv_content_myAccount3 = itemView.findViewById<TextView>(R.id.myAccount3)

    // 내용
    val tv_content_left1 = itemView.findViewById<TextView>(R.id.from1)
    val tv_content_left1_1 = itemView.findViewById<TextView>(R.id.amount1)

    val tv_content_left2 = itemView.findViewById<TextView>(R.id.from2)
    val tv_content_left2_2 = itemView.findViewById<TextView>(R.id.amount2)

    val tv_content_right = itemView.findViewById<TextView>(R.id.from3)
    val tv_content_right2 = itemView.findViewById<TextView>(R.id.amount3)

    // 잔액(balance)
    val tv_content_balance1 = itemView.findViewById<TextView>(R.id.balance1)
    val tv_content_balance2 = itemView.findViewById<TextView>(R.id.balance2)
    val tv_content_balance3 = itemView.findViewById<TextView>(R.id.balance3)

    // 시간
    val tv_content_time1 = itemView.findViewById<TextView>(R.id.time1)
    val tv_content_time2 = itemView.findViewById<TextView>(R.id.time2)
    val tv_content_time3 = itemView.findViewById<TextView>(R.id.time3)

    // 날짜
    val tv_content_date = itemView.findViewById<TextView>(R.id.date)



    private var flag: Int?=0
    private var account: String=""
    private var other: String=""
    private var amount: String=""
    private var balance: String=""
    private var time: String=""
    private var date: String=""

    fun bind(
        histoMoneyCon: HistoMoneyCon,
        caseBy: Int
    ){
        tv_case_left.text = ""
        tv_case_left2.text = ""
        tv_case_right.text = ""
        tv_content_myAccount1.text = ""
        tv_content_myAccount2.text = ""
        tv_content_myAccount3.text = ""
        tv_content_left1.text = ""
        tv_content_left1_1.text = ""
        tv_content_left2.text = ""
        tv_content_left2_2.text = ""
        tv_content_right.text = ""
        tv_content_right2.text = ""
        tv_content_balance1.text = ""
        tv_content_balance2.text = ""
        tv_content_balance3.text = ""
        tv_content_time1.text = ""
        tv_content_time2.text = ""
        tv_content_time3.text = ""
        tv_content_date.text = histoMoneyCon.date



        //케이스에 따라 입금 출금 취소 내용 정하기
        if (histoMoneyCon.flag == 0){ //입금
            tv_case_left.text = "입금"
            //금액 등등 내 추가
            tv_content_myAccount1.text = histoMoneyCon.account
            tv_content_left1.text =histoMoneyCon.other + "님이"
            tv_content_left1_1.text = histoMoneyCon.amount+"원 입금했습니다."
            tv_content_time1.text = histoMoneyCon.time
            tv_content_balance1.text = histoMoneyCon.balance


            val deposit : ConstraintLayout = itemView.findViewById(R.id.history_item_left)
            val withdrawal : ConstraintLayout = itemView.findViewById(R.id.history_item_right)
            val cancel : ConstraintLayout = itemView.findViewById(R.id.history_item_left2)


            deposit.visibility = ConstraintLayout.VISIBLE
            withdrawal.visibility = ConstraintLayout.INVISIBLE
            cancel.visibility = ConstraintLayout.INVISIBLE





        }else if (histoMoneyCon.flag == 1){ // 출금
            tv_case_right.text = "출금"
            //금액 등등 내용 추가
            tv_content_right.text = histoMoneyCon.other + "님이"
            tv_content_right2.text = histoMoneyCon.amount+"원 출금했습니다."
            tv_content_myAccount2.text = histoMoneyCon.account
            tv_content_time2.text = histoMoneyCon.time
            tv_content_balance2.text = histoMoneyCon.balance


            val deposit : ConstraintLayout = itemView.findViewById(R.id.history_item_left)
            val withdrawal : ConstraintLayout = itemView.findViewById(R.id.history_item_right)
            val cancel : ConstraintLayout = itemView.findViewById(R.id.history_item_left2)

            deposit.visibility = ConstraintLayout.INVISIBLE
            withdrawal.visibility = ConstraintLayout.VISIBLE
            cancel.visibility = ConstraintLayout.INVISIBLE

        }else{ // flag == 2로 취소이거나 버그
            tv_case_left2.text = "취소"
            //금액 등등 내용 추가
            tv_content_left2.text = histoMoneyCon.other + "님이"
            tv_content_left2_2.text = histoMoneyCon.amount+"원 취소했습니다."
            tv_content_myAccount3.text = histoMoneyCon.account
            tv_content_time3.text = histoMoneyCon.time
            tv_content_balance3.text = histoMoneyCon.balance


            val deposit : ConstraintLayout = itemView.findViewById(R.id.history_item_left)
            val withdrawal : ConstraintLayout = itemView.findViewById(R.id.history_item_right)
            val cancel : ConstraintLayout = itemView.findViewById(R.id.history_item_left2)

            deposit.visibility = ConstraintLayout.INVISIBLE
            withdrawal.visibility = ConstraintLayout.INVISIBLE
            cancel.visibility = ConstraintLayout.VISIBLE


        }






    }
}
