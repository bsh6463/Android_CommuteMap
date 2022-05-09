package com.example.pathfinder.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pathfinder.R
import com.example.pathfinder.adapter.PathListViewAdapter
import com.example.pathfinder.adapter.SubPathListViewAdapter
import com.example.pathfinder.fragment.viewmodel.JsonResultViewModel
import com.example.pathfinder.model.json.*


class ResultFragment : Fragment() {

   private lateinit var jsonResult: JsonResult

   private val viewModel: JsonResultViewModel by activityViewModels()

    private val pathList: MutableList<MutableList<Path>> = mutableListOf()

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
        val pathListView = view.findViewById<ListView>(R.id.pathListView)

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


        if (jsonResult.result2 != null){
            val path1: MutableList<Path> = mutableListOf(
                jsonResult.result1?.pathList?.get(0) as Path,
                jsonResult.result2?.pathList?.get(0) as Path
            )


            val path2 = mutableListOf(
                jsonResult.result1?.pathList?.get(0) as Path,
                jsonResult.result2?.pathList?.get(1) as Path
            )
            val path3 = mutableListOf(
                jsonResult.result1?.pathList?.get(1) as Path,
                jsonResult.result2?.pathList?.get(0) as Path
            )

            val path4= mutableListOf(
                jsonResult.result1?.pathList?.get(1) as Path,
                jsonResult.result2?.pathList?.get(1) as Path
            )

            pathList.add(path1)
            pathList.add(path2)
            pathList.add(path3)
            pathList.add(path4)

        }else{
            if(jsonResult.result1 != null){
                val path1: MutableList<Path> = mutableListOf(
                    jsonResult.result1?.pathList?.get(0) as Path
                )
                pathList.add(path1)

                val path2: MutableList<Path> = mutableListOf(
                    jsonResult.result1?.pathList?.get(1) as Path
                )
                pathList.add(path1)
            }else{
                findNavController().navigate(R.id.action_resultFragment_to_searchFragment)
                Toast.makeText(requireContext(), "잠시 후 다시 시도하세요", Toast.LENGTH_SHORT ).show()
            }
        }


        val pathListViewAdapter = PathListViewAdapter(pathList)
        pathListView.adapter = pathListViewAdapter
        pathListViewAdapter.notifyDataSetChanged()
        //setListViewHeight(pathListViewAdapter, pathListView)


        return view
    }


}

