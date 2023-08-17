package com.example.dz12.ui

import android.widget.Toast
import com.example.dz12.R
import com.example.dz12.core.ui.BaseFragment
import com.example.dz12.databinding.FragmentFirstBinding
import com.example.dz12.ui.adapter.TaskAdapter
import com.example.dz12.data.TaskModel

class FirstFragment : BaseFragment<FragmentFirstBinding>(R.layout.fragment_first) {

    private lateinit var adapter: TaskAdapter

    override fun inflateViewBinding(): FragmentFirstBinding {
        return FragmentFirstBinding.inflate(layoutInflater)
    }

    override fun initView() {
        adapter = TaskAdapter(this::deleteClick,this::onClickOnCheckBox)
        binding.recyclerView.adapter = adapter
        binding.btnGet.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment()).commit()
        }
        setData()
    }

    private fun onClickOnCheckBox(taskModel: TaskModel) {
        viewModel.updateTask(taskModel)
        setData()
    }

    private fun deleteClick(taskModel: TaskModel){
        viewModel.deleteTask(taskModel)
        adapter.deleteData(taskModel)
        Toast.makeText(requireContext(), "is ololo", Toast.LENGTH_SHORT).show()
    }

    private fun setData() {
        viewModel.list.observe(requireActivity()) {
            adapter.addData(it)
            for (task in it) {
                if (task.check == true) {
                    adapter.addTrueCheckBox(task) // Добавляем элементы с true checkBox в начало списка
                }
            }
        }

    }

}
