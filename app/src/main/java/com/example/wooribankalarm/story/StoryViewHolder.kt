package com.example.wooribankalarm.story

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wooribankalarm.R
import com.example.wooribankalarm.api.RequestToServer
import com.example.wooribankalarm.data.response.StoCon
import kotlinx.android.synthetic.main.story_value.view.*


class StoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val story_date = itemView.findViewById<TextView>(R.id.story_date)
    val today_date = itemView.findViewById<TextView>(R.id.today_date)
    val contents = itemView.findViewById<TextView>(R.id.contents)
    val checkcheck = itemView.findViewById<TextView>(R.id.checkcheck)
    val postpone = itemView.findViewById<TextView>(R.id.postpone)
    val infoSmall = itemView.findViewById<TextView>(R.id.info_small)
    val infoBig = itemView.findViewById<TextView>(R.id.info_big)

    private var date:String=""
    private var transacType:Int?=0
    private var dueDate:String=""
    private var name:String=""
    private var myAccount:String=""
    private var receiver:String=""
    private var info:String=""

    fun bind(stoCon: StoCon) {
        story_date.text = stoCon.date
        today_date.text=stoCon.dueDate
        contents.text=""
        checkcheck.text = ""
        postpone.text = ""
        infoBig.text = ""
        infoSmall.text = ""


        if (stoCon.flag==0){
            infoBig.text = "[" + stoCon.content + "] 자동이체 종료 예정일"
            infoSmall.text = "자동이체 종료 안내"
            contents.text=stoCon.otherName+"고객님의 "+
                    stoCon.userAccount+" 계좌에서 "+stoCon.otherAccount+" "+stoCon.otherName+" 계좌로 연결된 ["+stoCon.content+"] 자동이체가 "+
                    stoCon.dueDate+"에 종료예정입니다."
            checkcheck.text="납부일 변경"
            postpone.text="납부일 연장"
        }else{
            infoBig.text = "[" + stoCon.content + "] 자동이체 완료"
            infoSmall.text = "자동이체 안내"
            contents.text=stoCon.otherName+"고객님의 "+
                    stoCon.userAccount+" 계좌에서 "+stoCon.otherAccount+" "+stoCon.otherName+" 계좌로 연결된 ["+stoCon.content+"] 자동이체가 완료되었습니다."
            checkcheck.text="상세 정보 확인"
            postpone.text="납부일 변경"

        }
    }
}