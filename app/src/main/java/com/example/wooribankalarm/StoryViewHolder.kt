package com.example.wooribankalarm

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val info_small = itemView.findViewById<TextView>(R.id.info_small)
    val info_big = itemView.findViewById<TextView>(R.id.info_big)
    val today_date = itemView.findViewById<TextView>(R.id.today_date)
    val contents = itemView.findViewById<TextView>(R.id.contents)

    fun bind(storyData : StoryData) {
        info_small.text = storyData.info_small
        info_big.text = storyData.info_big
        today_date.text = storyData.today_date
        contents.text = storyData.contents
    }
}