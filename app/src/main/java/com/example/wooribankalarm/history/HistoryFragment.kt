package com.example.wooribankalarm.history

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wooribankalarm.R
import com.example.wooribankalarm.api.RequestToServer
import com.example.wooribankalarm.data.request.RequestMoney
import com.example.wooribankalarm.data.request.RequestUser
import com.example.wooribankalarm.data.response.*
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_history_radio.*
import kotlinx.android.synthetic.main.history_value.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryFragment : Fragment() {
    lateinit var historyAdapter: HistoryAdapter
    val hData = mutableListOf<HistoryData>()
    var mData= mutableListOf<HistoMoneyCon>()
    lateinit var topData : HistoCon
    lateinit var bottomData : HistoMoneyCon


    private fun requestData() {
        val call: Call<ResponseUser> = RequestToServer.service.requestUser(body =  RequestUser(0))
        call.enqueue(object : Callback<ResponseUser> {
            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                Log.e("requestUser 통신실패",t.toString())
            }
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if (response.isSuccessful){
                    response.body().let { body->
                        Log.e("history 통신응답바디", "status: ${body!!.status} data : ${body!!.data}")
                        this@HistoryFragment.topData = response.body()?.data!!
                        myAccount.text=topData.account
                        balance.text=topData.balance
                    }
                }

            }
        })
    }
    private fun requestData2() {
        val call: Call<ResponseMoney> = RequestToServer.service.requestMoney(body = RequestMoney(0, 1))
        call.enqueue(object : Callback<ResponseMoney> {
            override fun onFailure(call: Call<ResponseMoney>, t: Throwable) {
                Log.e("requestMoney 통신실패",t.toString())
            }
            override fun onResponse(call: Call<ResponseMoney>, response: Response<ResponseMoney>) {
                if (response.isSuccessful){
                    response.body().let{ body->
                        Log.e("historymoney 통신응답바디", "status: ${body!!.status} data : ${body!!.data}")
                        historyAdapter.mDatas = body.data
                        historyAdapter.notifyDataSetChanged()

//                        historyAdapter.mDatas=body.data
//                        historyAdapter.notifyDataSetChanged()

                    }
                }
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //requestData()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // myAccount.text=topData.account.toString()

        historyAdapter = HistoryAdapter(view.context)
        rv_history.adapter = historyAdapter
        requestData()
        requestData2()


//        rv_history.layoutManager = LinearLayoutManager(context)
//        rv_history.setHasFixedSize(false)

        //loadDummyDatas()
    }


    /*private fun loadDummyDatas(){
        //뭔가 여기서 서버 통신 결과에 따른 caseBy를 설정해줘서 이후 뷰홀더, 어뎁터 동작하도록 해야할 듯
        //일단 caseBy 하드코딩 함
        hData.apply {
            add(
                HistoryData(
                    // history_content = "입금",
                    history_content1 = "박세곤님이",
                    history_content2 = "10,000원 입금했습니다.",
                    caseBy = 0 //입금
                )
            )
            add(
                HistoryData(
                    // history_content = "입금",
                    history_content1 = "박세란님이",
                    history_content2 = "35,000원 입금했습니다.",
                    caseBy = 0 //입금
                )
            )
            add(
                HistoryData(
                    //history_content = "출금",
                    history_content1 = "박세곤님이",
                    history_content2 = "20,000원 출금했습니다.",
                    caseBy = 1 //출금
                )
            )
            add(
                HistoryData(
                    // history_content = "취소",
                    history_content1 = "박세곤님이",
                    history_content2 = "입금을 취소했습니다.",
                    caseBy = 2 //취소
                )
            )
            add(
                HistoryData(
                    //history_content = "출금",
                    history_content1 = "박세곤님이",
                    history_content2 = "10,000원 출금했습니다.",
                    caseBy = 1 //출금
                )
            )
            add(
                HistoryData(
                    // history_content = "취소",
                    history_content1 = "박세곤님이",
                    history_content2 = "출금을 취소했습니다.",
                    caseBy = 2 //취소
                )
            )
            add(
                HistoryData(
                    // history_content = "입금",
                    history_content1 = "이정민님이",
                    history_content2 = "70,000원 입금했습니다.",
                    caseBy = 0 //입금
                )
            )
        }
        historyAdapter.hDatas = hData
        historyAdapter.notifyDataSetChanged()
    }*/

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
