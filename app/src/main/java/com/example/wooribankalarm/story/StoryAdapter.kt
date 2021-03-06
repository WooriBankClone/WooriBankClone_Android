package com.example.wooribankalarm.story

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wooribankalarm.R
import com.example.wooribankalarm.data.response.StoCon


class StoryAdapter(private val context : Context) : RecyclerView.Adapter<StoryViewHolder>() {
    var datas = mutableListOf<StoCon>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.story_value, parent, false)
        return StoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}