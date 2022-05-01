package com.example.pathfinder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.pathfinder.R
import com.example.pathfinder.model.json.Path
import com.example.pathfinder.model.json.SubPath

class SubPathListViewAdapter(val list: MutableList<SubPath>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView

        if(convertView == null){
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.subpath_listview_item, parent,false)
        }


        for (subPath in list) {
           when(subPath.trafficType){
               1 -> { //지하철
                   convertView!!.findViewById<TextView>(R.id.getOn).text = subPath.startName
                   convertView!!.findViewById<TextView>(R.id.getOnInfo).text = subPath.sectionTime.toString() + "분 걷기"
               }
               2 -> {// 버스
                   convertView!!.findViewById<TextView>(R.id.getOn).text = subPath.startName + "정류장" + subPath.lane?.busNo.toString() + "번 버스 승차"
                   //convertView!!.findViewById<TextView>(R.id.getOnInfo).text = subPath.lane[0]
                   convertView!!.findViewById<TextView>(R.id.getOff).text = subPath.endName + "정류장 하차"
                   convertView!!.findViewById<TextView>(R.id.getOnInfo).text = subPath.sectionTime.toString() + "분 걷기"
               }

               3 -> {// 도보
                   convertView!!.findViewById<TextView>(R.id.getOn).text = subPath.startName
                   convertView!!.findViewById<TextView>(R.id.getOnInfo).text = subPath.sectionTime.toString() + "분 걷기"

               }

           }
        }


        return convertView
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