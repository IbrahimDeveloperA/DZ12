package com.example.dz12.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dz12.data.TaskModel

class ViewModels : ViewModel() {

    private val _list = MutableLiveData<MutableList<TaskModel>>()
    val list: LiveData<MutableList<TaskModel>>
        get() = _list

    private val listTask = mutableListOf<TaskModel>()

    fun addTask(lists: TaskModel) {
        listTask.add(lists)
        _list.value = listTask
    }

    fun deleteTask(lists: TaskModel) {
        listTask.remove(lists)
        _list.value = listTask
    }

    fun updateTask(taskModel: TaskModel) {
//        val index = listTask.indexOfFirst { it.title == taskModel.title }
//        if (index != -1) {
//            val updatedTaskModel = taskModel.copy(check = taskModel.check)
//            listTask[index] = updatedTaskModel
//            listTask.toList().also { _list.value = it.toMutableList() }
//        }
//        }
        val updatedTaskModel = taskModel.copy(check = taskModel.check)
        listTask.add(updatedTaskModel)
        //listTask.distinctBy { it.check }
        listTask.toSet()
        _list.value = listTask
    }

}