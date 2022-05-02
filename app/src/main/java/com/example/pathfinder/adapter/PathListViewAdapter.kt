package com.example.pathfinder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.example.pathfinder.R
import com.example.pathfinder.model.json.Path
import com.example.pathfinder.model.json.SubPath
import org.w3c.dom.Text

class PathListViewAdapter(val list: MutableList<MutableList<Path>>): BaseAdapter() {
    var totalTime = 0
    var totalDistance = 0
    lateinit var subPathListViewAdapter: SubPathListViewAdapter

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        val subPathListView = convertView?.findViewById<ListView>(R.id.subPath_listView)

        if(convertView == null){
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.listview_item, parent,false)
        }



        list[position].forEach {   path ->
            totalTime += path.totalTime!!
            totalDistance += path.totalDistance!!
            subPathListViewAdapter = SubPathListViewAdapter(path.subPathList as MutableList<SubPath>)
            subPathListView?.adapter = subPathListViewAdapter
        }


        convertView!!.findViewById<TextView>(R.id.time).text = "약 ${totalTime} 분"
        convertView.findViewById<TextView>(R.id.distance).text = "약 ${totalDistance}m"

        totalTime = 0
        totalDistance = 0

        subPathListViewAdapter.notifyDataSetChanged()
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