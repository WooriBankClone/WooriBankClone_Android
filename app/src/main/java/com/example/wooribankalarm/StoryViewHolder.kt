package com.example.wooribankalarm

import android.media.MediaPlayer
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wooribankalarm.api.RequestInterface
import com.example.wooribankalarm.api.RequestToServer
import com.example.wooribankalarm.data.response.ResAutoTransfer
import com.example.wooribankalarm.data.response.StoCon


class StoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val story_date = itemView.findViewById<TextView>(R.id.story_date)
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

    fun bind(stoCon: StoCon) {
        story_date.text = stoCon.date
        today_date.text=stoCon.dueDate
        contents.text=""
        checkcheck.text = ""
        postpone.text = ""


        if (stoCon.flag==0){
            contents.text=stoCon.otherName+"고객님 "+
                    stoCon.userAccount+"계좌에서 "+stoCon.otherAccount+" "+stoCon.otherName+" 계좌로 연결된 ["+stoCon.content+"] 자동이체가 "+
                    stoCon.dueDate+"에 종료예정입니다."
            checkcheck.text="납부일 변경"
            postpone.text="납부일 연장"
        }else{

        }
    }
}