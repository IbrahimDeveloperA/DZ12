package com.example.dz12.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.dz12.databinding.ItemListBinding

class TaskAdapter(val deleteClick:(TaskModel)->Unit):Adapter<TaskAdapter.TaskViewHolder>() {

    var list = mutableListOf<TaskModel>()

    fun addData(lists : List<TaskModel>){
        list.clear()
        list.addAll(lists)
        notifyDataSetChanged()
    }

    fun deleteData(lists: TaskModel){
        list.remove(lists)
        notifyItemChanged(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class TaskViewHolder(private val binding: ItemListBinding):ViewHolder(binding.root) {
        fun onBind(taskModel: TaskModel) {
            binding.tvTitle.text = taskModel.title
            binding.tvDesc.text = taskModel.description
            itemView.setOnLongClickListener {
                deleteClick(taskModel)
                false
            }
        }

    }
}