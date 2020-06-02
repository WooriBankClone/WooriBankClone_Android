package com.example.wooribankalarm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wooribankalarm.api.RequestToServer
import com.example.wooribankalarm.data.request.ReqAutoTransfer
import com.example.wooribankalarm.data.response.ResAutoTransfer
import com.example.wooribankalarm.data.response.StoCon
import kotlinx.android.synthetic.main.fragment_story.*
import kotlinx.android.synthetic.main.story_value.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body

class StoryFragment : Fragment() {

    lateinit var storyAdapter : StoryAdapter
    val datas = mutableListOf<StoCon>()
    val resauto_data = mutableListOf<ResAutoTransfer>()
    //val serverService =RequestToServer.service // 싱글톤으로 그대로 가져오기

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
        //loadDatas()
        requestData()
    }


    private fun requestData() {
        val call: Call<ResAutoTransfer> =RequestToServer.service.autoTransfer(body =  ReqAutoTransfer(0))
        call.enqueue(object :Callback<ResAutoTransfer>{
            override fun onFailure(call: Call<ResAutoTransfer>, t: Throwable) {
                Log.e("autoTransfer",t.toString())
            }

            override fun onResponse(
                call: Call<ResAutoTransfer>,
                response: Response<ResAutoTransfer>
            ) {
                if (response.isSuccessful){
                    response.body().let { body ->
                        Log.e("통신 응답 바디", "status: ${body!!.status} data : ${body!!.data}")
                        storyAdapter.datas=body.data
                        storyAdapter.notifyDataSetChanged()
                        }
                    }
                }

        })
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
