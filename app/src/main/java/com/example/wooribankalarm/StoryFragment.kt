package com.example.wooribankalarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_story.*

class StoryFragment : Fragment() {

    lateinit var storyAdapter : StoryAdapter
    val datas = mutableListOf<StoryData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_story, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storyAdapter = StoryAdapter(view.context)
        rv_story.adapter = storyAdapter
        loadDatas()
    }

    private fun loadDatas() {
        datas.apply {
            add(
                StoryData(
                    info_small = "자동이체 안내",
                    info_big = "자동이체 종료예정",
                    today_date = "5월 26일",
                    contents = "박세곤 고객님 12-1234-5678 계좌에서 00-1111-8888 박지혜 계좌로 연결된 [핸드폰 요금] 자동이체가 2020.5.30 종료예정입니다."
                ))
            add(
                StoryData(
                    info_small = "적금 만기 안내",
                    info_big = "적금 만기 예정",
                    today_date = "5월 27일",
                    contents = "박세곤 고객님 9916-3757-950 계좌에서 자유적금 만료일이 30일 남았습니다."
                ))
            add(
                StoryData(
                    info_small = "자동이체 안내",
                    info_big = "자동이체 예정",
                    today_date = "5월 27일",
                    contents = "박세곤 고객님 5월 29일에 한국장학재단 학자금 대출 이자 자동 납입이 있습니다"
                )
            )
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyPageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StoryFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
