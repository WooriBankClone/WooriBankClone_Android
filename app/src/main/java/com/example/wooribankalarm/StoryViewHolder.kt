package com.example.wooribankalarm

import android.media.MediaPlayer
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wooribankalarm.api.RequestInterface
import com.example.wooribankalarm.api.RequestToServer
import com.example.wooribankalarm.data.response.ResAutoTranster

class StoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val info_small = itemView.findViewById<TextView>(R.id.info_small)
    val info_big = itemView.findViewById<TextView>(R.id.info_big)
    val today_date = itemView.findViewById<TextView>(R.id.today_date)
    val contents = itemView.findViewById<TextView>(R.id.contents)
    val checkcheck = itemView.findViewById<TextView>(R.id.checkcheck)
    val postpone = itemView.findViewById<TextView>(R.id.postpone)
    private var date:String=""
    private var transacType:Int?=0
    private var dueDate:String=""
    private var name:String=""
    private var myAccount:String=""
    private var receiver:String=""
    private var info:String=""

    private var contentstring:String=""
    val requestToServer = RequestToServer

    fun bind(storyData : StoryData, resAutoTranster: ResAutoTranster) {
        info_small.text = storyData.info_small
        info_big.text = storyData.info_big
        today_date.text = storyData.today_date
        contents.text = storyData.contents
        checkcheck.text = storyData.checkcheck
        postpone.text = storyData.postpone



        //TODO: 데이터 서버에 요청 어떻게 하지..?

        // transacType = resAutoTranster.data?.flag?.toInt()
        if (transacType == 0) { //종료예정
            //종료
            contentstring = resAutoTranster.data?.userName.toString()
        } else { // 예정

        }
    }
}