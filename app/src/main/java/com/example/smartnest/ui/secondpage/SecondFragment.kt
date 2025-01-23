package com.example.smartnest.ui.secondpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartnest.R
import com.example.smartnest.databinding.FragmentSecondBinding
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        setupToolbar()
    }

    private fun setupClickListeners() {
        binding.apply {
            favorilerCard.setOnClickListener { handleCardClick("Favoriler") }
            aydinlatmaCard.setOnClickListener { handleCardClick("Aydınlatma") }
        }
    }

    private fun handleCardClick(cardName: String) {
        Toast.makeText(requireContext(), "$cardName tıklandı", Toast.LENGTH_SHORT).show()
    }

    private fun setupToolbar() {
        binding.toolbar.toolbar.apply {
            setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action_settings -> {
                        Toast.makeText(context, "Settings clicked", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}