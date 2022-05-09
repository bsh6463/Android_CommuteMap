package com.example.pathfinder.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import com.example.pathfinder.R
import com.example.pathfinder.model.json.Path
import com.example.pathfinder.model.json.SubPath
import org.w3c.dom.Text
import kotlin.coroutines.coroutineContext

class PathListViewAdapter(val list: MutableList<MutableList<Path>>, val start: String,val middle: String?, val end: String): BaseAdapter() {
    var totalTime = 0
    var totalDistance = 0


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        val startMessageTextView = convertView?.findViewById<TextView>(R.id.startMessage).apply {
            this!!.text = start + "출발"
            this.setTextColor(Color.parseColor("#ff0066"))
        }
        val endMessageTextView = convertView?.findViewById<TextView>(R.id.endMessage).apply {
            this!!.text = end + "도착"
            this.setTextColor(Color.parseColor("#ff0066"))
        }
        val subPathLinearLayout = convertView?.findViewById<LinearLayout>(R.id.subPathLinearLayout)

        if(convertView == null){
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.listview_item2, parent,false)
        }



        val subPathListView = convertView?.findViewById<ListView>(R.id.subPath_listView)
        //list[position] = MutablaList<Path> path1, path2있음.
        list[position].forEach {   path ->
            val subPathList = path.subPathList
            totalTime += path.totalTime!!
            totalDistance += path.totalDistance!!


            subPathList?.forEach { subPath->

                setSubPathLinearView(subPath, parent, subPathLinearLayout)
            }

            //경유지 있는 경우
            if (list[position].size > 1){
                val middleMessageTextView  = TextView(parent?.context).apply {
                    this.text = "경유지(${middle}) 도착"
                    this.setTextColor(Color.parseColor("#ff0066"))
                }.let {
                    subPathLinearLayout?.addView(it)
                }


            }

        }


        convertView!!.findViewById<TextView>(R.id.time).text = "약 ${totalTime} 분"
        convertView.findViewById<TextView>(R.id.distance).text = "약 ${totalDistance}m"

        totalTime = 0
        totalDistance = 0

        return convertView
    }


    private fun setSubPathLinearView(
        subPath: SubPath,
        parent: ViewGroup?,
        subPathLinearLayout: LinearLayout?
    ) {
        when (subPath.trafficType) {
            1 -> { //지하철
                val getOnTextView = TextView(parent?.context).apply {
                    this.text =
                        subPath.startName.toString() + "역" + subPath.lane!!.name + subPath.updnLine + "탑승"
                }.let {
                    subPathLinearLayout!!.addView(it)
                }
                val getOnInfoTextView = TextView(parent?.context).apply {
                    this.text = subPath.arrivalMessage.toString()
                }.let {
                    subPathLinearLayout!!.addView(it)
                }

                val getOffTextView = TextView(parent?.context).apply {
                    this.text = subPath.endName + "역 하차"
                }.let {
                    subPathLinearLayout!!.addView(it)
                }

            }
            2 -> {// 버스

                val getOnTextView = TextView(parent?.context).apply {
                    this.text =
                        subPath.startName.toString() + "정류장" + subPath.lane?.busNo.toString() + "번 버스 승차"
                }.let {
                    subPathLinearLayout!!.addView(it)
                }
                val getOnInfoTextView = TextView(parent?.context).apply {
                    this.text = subPath.arrivalMessage.toString()
                }.let {
                    subPathLinearLayout!!.addView(it)
                }

                val getOffTextView = TextView(parent?.context).apply {
                    this.text = subPath.endName.toString() + "정류장 하차"
                }.let {
                    subPathLinearLayout!!.addView(it)
                }

                val getOffInfoTextView = TextView(parent?.context).apply {
                    this.text = subPath.sectionTime.toString() + "분 소요"
                }.let {
                    subPathLinearLayout!!.addView(it)
                }
            }

            3 -> {// 도보

                val getOnInfoTextView = TextView(parent?.context).apply {
                    this.text = subPath.sectionTime?.toString() + "분 걷기"
                    //this.setTextColor(R.color.design_default_color_primary_dark)
                }.let {
                    subPathLinearLayout!!.addView(it)

                }

            }

        }
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


}