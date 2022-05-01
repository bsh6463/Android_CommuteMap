package com.example.pathfinder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.pathfinder.R
import com.example.pathfinder.model.json.Path

class PathListViewAdapter(val list: MutableList<MutableList<Path?>>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView

        if(convertView == null){
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.listview_item, parent,false)
        }


       list.forEach { pathList ->
           pathList.forEach{ _path ->
               val path = _path as Path
               convertView!!.findViewById<TextView>(R.id.time).text = path.totalTime.toString() + "분"
               convertView.findViewById<TextView>(R.id.distance).text = path.totalDistance.toString() + "m"
           }
       }

        //subPath 처리


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