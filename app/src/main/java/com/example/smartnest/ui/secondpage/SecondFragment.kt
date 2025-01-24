package com.example.smartnest.ui.secondpage

import android.os.Bundle
import android.view.View
import com.example.smartnest.R
import com.example.smartnest.databinding.FragmentSecondBinding
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController
import com.example.smartnest.ui.BaseFragment

@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()

        setupAppBar(
            toolbar = binding.appBar.toolbar,
            title = getString(R.string.inohom),
            showBackButton = false,
            rightIcon = R.drawable.outline_settings_24,
            onRightIconClick = {
                Toast.makeText(requireContext(), "Settings clicked", Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun setupClickListeners() {
        binding.apply {
            favorilerCard.setOnClickListener { handleCardClick("Favoriler") }
            aydinlatmaCard.setOnClickListener { handleCardClick("Aydınlatma")
                findNavController().navigate(R.id.action_secondFragment_to_lightFragment)
            }
        }
    }

    private fun handleCardClick(cardName: String) {
        Toast.makeText(requireContext(), "$cardName tıklandı", Toast.LENGTH_SHORT).show()
    }
}