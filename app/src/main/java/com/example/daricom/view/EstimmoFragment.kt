package com.example.daricom.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.daricom.data.EstimmoResult
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

        binding.Appartement.setOnClickListener() {
            binding.TerrainSurface.visibility = View.GONE
        }
        binding.Maison.setOnClickListener() {
            binding.TerrainSurface.visibility = View.VISIBLE
        }

        binding.estimmoButton.setOnClickListener(){
            val proprety = if (binding.Appartement.isChecked) "Appartement" else "Maison"
            val section = binding.Region.selectedItem.toString()
            val terrain = binding.TerrainSurface.text.toString().toFloatOrNull()
            val surface = binding.Surface.text.toString().toFloatOrNull()
            val piece = binding.HomePieces.text.toString().toIntOrNull()
            estimmoViewModel.estimmo(proprety, section, terrain, surface, piece)
        }
        estimmoViewModel.estimmoResult.observe(viewLifecycleOwner) { value ->
            when(value) {
                is EstimmoResult.Empty -> {
                    binding.estimmoResult.visibility = View.GONE
                }
                is EstimmoResult.Estimated -> {
                    binding.estimmoResult.visibility = View.VISIBLE
                    binding.estimmoResult.text = value.float.toString()
                }
                is EstimmoResult.Failed -> {
                    binding.estimmoResult.visibility = View.VISIBLE
                    binding.estimmoResult.text = value.message
                }
            }

        }




    }
}




