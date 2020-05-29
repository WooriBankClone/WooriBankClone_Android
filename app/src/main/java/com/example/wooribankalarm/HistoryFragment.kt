package com.example.wooribankalarm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_history_radio.*

class HistoryFragment : Fragment() {
    lateinit var historyAdapter: HistoryAdapter
    val hData = mutableListOf<HistoryData>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*val toolbar =
            findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)*/

        radioClicked(this.requireView())

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        historyAdapter = HistoryAdapter(view.context)
        rv_history.adapter = historyAdapter
        rv_history.layoutManager = LinearLayoutManager(context)
        rv_history.setHasFixedSize(false)
        loadDatas()
    }

    private fun loadDatas(){
        hData.apply {
            add(
                HistoryData(
                    history_content = "hundred",
                    history_content2 = "dollar bill"
                ))
            add(
                HistoryData(
                    history_content = "hundred hundred",
                    history_content2 = "dollar bill"
                ))
            add(
                HistoryData(
                    history_content = "YEAH",
                    history_content2 = "다시 돌아왔지 내 이름 sery HO!"
                ))
        }
        historyAdapter.hDatas = hData
        historyAdapter.notifyDataSetChanged()
    }

    private fun radioClicked(view: View){

        if (btn_radio1.isChecked) {
            //TODO: radio button 클릭시 데이터 분기 처리
            Toast.makeText(context, "1개월", Toast.LENGTH_SHORT).show()
        }else if (btn_radio2.isChecked) {
            Toast.makeText(context, "3개월", Toast.LENGTH_SHORT).show()

        }else if (btn_radio3.isChecked) {
            Toast.makeText(context, "6개월", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "12개월", Toast.LENGTH_SHORT).show()
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
            HistoryFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
