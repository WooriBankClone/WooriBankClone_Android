package com.example.wooribankalarm

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv_contents = itemView.findViewById<TextView>(R.id.history_content)
    val tv_contents2 = itemView.findViewById<TextView>(R.id.history_content2)


    fun bind(historyData: HistoryData){
        tv_contents.text = historyData.history_content
        tv_contents2.text = historyData.history_content2
    }
}