package com.example.daricom.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.daricom.databinding.FragmentEstimmoBinding
import com.example.daricom.viewModel.EstimmoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EstimmoFragment : Fragment() {
    private lateinit var binding: FragmentEstimmoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEstimmoBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val estimmoViewModel: EstimmoViewModel by viewModels()

        binding.estimmoButton.setOnClickListener(){

        }
        estimmoViewModel.estimmoResult.observe(viewLifecycleOwner) {}




    }
}




