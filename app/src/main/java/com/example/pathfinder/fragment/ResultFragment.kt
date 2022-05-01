package com.example.pathfinder.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.example.pathfinder.R
import com.example.pathfinder.adapter.PathListViewAdapter
import com.example.pathfinder.fragment.viewmodel.JsonResultViewModel
import com.example.pathfinder.model.json.*


class ResultFragment : Fragment() {

   private lateinit var jsonResult: JsonResult

   private val viewModel: JsonResultViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        jsonResult = viewModel.resultData.value!!

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_result, container, false)

        //view에 data 입력.
        val resultStartTextView = view?.findViewById<TextView>(R.id.startResult)
        val resultMiddleTextView = view?.findViewById<TextView>(R.id.middleResult)
        val resultEndTextView = view?.findViewById<TextView>(R.id.endResult)

        //시작, 경유, 도착
        jsonResult.run {
            resultStartTextView?.text = this.start
            resultMiddleTextView?.text = this.middle
            resultEndTextView?.text = this.end
        }


        return view
    }




}

