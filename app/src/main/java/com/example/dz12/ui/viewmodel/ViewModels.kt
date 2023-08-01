package com.example.dz12.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dz12.ui.adapter.TaskModel

class ViewModels : ViewModel() {

    private val _list = MutableLiveData<MutableList<TaskModel>>()
    val list:LiveData<MutableList<TaskModel>>
        get() = _list

    val listTask = mutableListOf<TaskModel>()

    fun addTask(lists :TaskModel){
        listTask.add(lists)
        _list.value = listTask
    }

    fun deleteTask(lists: TaskModel){
        listTask.remove(lists)
        _list.value = listTask
    }
}