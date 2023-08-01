package com.example.dz12.ui

import android.widget.Toast
import com.example.dz12.R
import com.example.dz12.core.ui.BaseFragment
import com.example.dz12.databinding.FragmentFirstBinding
import com.example.dz12.ui.adapter.TaskAdapter

class FirstFragment : BaseFragment<FragmentFirstBinding>(R.layout.fragment_first) {

    private val adapter by lazy { TaskAdapter() }

    override fun inflateViewBinding(): FragmentFirstBinding {
        return FragmentFirstBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.recyclerView.adapter = adapter
        binding.btnGet.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment()).commit()
        }
        viewModel._list.observe(requireActivity()) {
            adapter.addData(it)
            binding.recyclerView.adapter = adapter
        }
    }

}