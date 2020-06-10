package com.example.wooribankalarm.history

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wooribankalarm.R
import com.example.wooribankalarm.data.response.HistoMoneyCon

class HistoryAdapter(private val context: Context) : RecyclerView.Adapter<HistoryViewHolder>() {
    var mDatas = mutableListOf<HistoMoneyCon>()
//    var hDatas = mutableListOf<HistoryData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.history_value, parent, false)
        return HistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mDatas.size

    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {


        //케이스에 따라서 historyFragment에서 caseBy값 설정해주고,
        //여기서 if로 걸러서 각 케바케 뷰 홀더 작동 시킬 것임

        val caseBy = mDatas[position].flag

        holder.bind(mDatas[position], caseBy) //케바케로 바인딩 내용 메시지가 달라지도록 뷰홀더에서 설정

//        if (caseBy == 0){ //입금
//
//
//        }else if ( caseBy == 1){ // 출금
//
//        }else{ // caseBy == 2로 취소이거나 버그
//
//        }


    }
}
