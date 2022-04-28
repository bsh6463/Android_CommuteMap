package com.example.pathfinder

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.pathfinder.model.JsonResult
import com.example.pathfinder.network.RetrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view  = inflater.inflate(R.layout.fragment_search, container, false)

        setRetrofit()
        val service= retrofit.create(RetrofitApi::class.java)

        view.findViewById<Button>(R.id.searchBtn).setOnClickListener {

            val callGetPathData = service.getData("서울역", "공덕역", "송파역")
            callGetPathData.enqueue(object: Callback<JsonResult>{

                override fun onResponse(call: Call<JsonResult>, response: Response<JsonResult>) {
                    val resultData = response.body()
                    Log.d("myApi", "성공")

                }

                override fun onFailure(call: Call<JsonResult>, t: Throwable) {
                    Log.d("myApi","실패")
                }
            })

            it.findNavController().navigate(R.id.action_searchFragment_to_resultFragment)

        }

        return view
    }

    private fun setRetrofit(){
        retrofit = retrofit2.Retrofit.Builder().baseUrl("http://15.164.162.177:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


}