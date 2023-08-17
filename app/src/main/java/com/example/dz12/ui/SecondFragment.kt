package com.example.dz12.ui

import com.example.dz12.R
import com.example.dz12.core.ui.BaseFragment
import com.example.dz12.databinding.FragmentSecondBinding
import com.example.dz12.data.TaskModel

class SecondFragment : BaseFragment<FragmentSecondBinding>(R.layout.fragment_second) {
    override fun inflateViewBinding(): FragmentSecondBinding {
        return FragmentSecondBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.btnSave.setOnClickListener {
            val result = TaskModel(binding.etTitle.text.toString(), binding.etDesc.text.toString())
            viewModel.addTask(result)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, FirstFragment()).commit()
        }
    }

}