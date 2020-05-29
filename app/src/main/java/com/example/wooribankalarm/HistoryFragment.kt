package com.example.wooribankalarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {

    lateinit var historyAdapter: HistoryAdapter
    val hData = mutableListOf<HistoryData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history,container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        historyAdapter = HistoryAdapter(view.context)
        rv_history.adapter = historyAdapter
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
                    history_content = "hundred",
                    history_content2 = "dollar bill"
                ))
            add(
                HistoryData(
                    history_content = "hundred",
                    history_content2 = "dollar bill"
                ))
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
