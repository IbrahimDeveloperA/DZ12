package com.example.dz12.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dz12.ui.adapter.TaskModel

class ViewModels : ViewModel() {

    private val list = MutableLiveData<MutableList<TaskModel>>()
    val _list:LiveData<MutableList<TaskModel>>
        get() = list
    val listTask = mutableListOf<TaskModel>()

    fun addTask(lists :TaskModel){
        listTask.add(lists)
        list.value = listTask
    }
}