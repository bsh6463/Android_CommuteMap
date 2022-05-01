package com.example.pathfinder.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.pathfinder.R
import com.example.pathfinder.fragment.viewmodel.JsonResultViewModel
import com.example.pathfinder.model.json.JsonResult
import com.example.pathfinder.network.PathClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {

    private val viewModel: JsonResultViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view  = inflater.inflate(R.layout.fragment_search, container, false)

        val startTextView = view.findViewById<TextView>(R.id.start)
        val middleTextView = view.findViewById<TextView>(R.id.middle)
        val endTextView = view.findViewById<TextView>(R.id.end)

        view.findViewById<Button>(R.id.searchBtn).setOnClickListener {


            val callGetPathData = PathClient.pathService.getData(startTextView.text.toString(),
                middleTextView.text.toString(),
                endTextView.text.toString()
            )

            callGetPathData.enqueue(object : Callback<JsonResult>{
                override fun onResponse(call: Call<JsonResult>, response: Response<JsonResult>) {
                    if(response.isSuccessful){
                        //성공처리
                            val result = response.body() as JsonResult

                        viewModel.setResultDate(result)

                        it.findNavController().navigate(R.id.action_searchFragment_to_resultFragment)

                    }else{
                        Log.d("[Retrofit-response]", response.message().toString())
                        Toast.makeText(requireContext(), "응답을 가져오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<JsonResult>, t: Throwable) {
                    Log.d("[Retrofit-fail]", t.message.toString())
                    Toast.makeText(requireContext(), "요청에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            })


        }


        return view
    }



}