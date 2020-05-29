package com.example.wooribankalarm

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(private val context: Context) : RecyclerView.Adapter<HistoryViewHolder>() {

    var hDatas = mutableListOf<HistoryData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.history_value, parent, false)
        return HistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hDatas.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(hDatas[position])

    }
}