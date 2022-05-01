package com.example.pathfinder.fragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pathfinder.model.json.JsonResult

class JsonResultViewModel: ViewModel() {

    private val mutableResultData = MutableLiveData<JsonResult>()

    val resultData: LiveData<JsonResult> get() = mutableResultData

    fun setResultDate(resultData: JsonResult){
        mutableResultData.value = resultData
    }
}