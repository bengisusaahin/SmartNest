package com.example.smartnest.ui.firstpage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.smartnest.databinding.FragmentFirstBinding
import com.example.smartnest.domain.util.RootResult
import com.example.smartnest.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val webSocketViewModel: WebSocketViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAccounts.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            val url = "wss://85.105.107.53:9095"
            webSocketViewModel.connect(url)
            webSocketViewModel.sendAuthRequest("demo", "123456")

            webSocketViewModel.observeMessages()

            lifecycleScope.launch {
                webSocketViewModel.messages.collect { result ->
                    when (result) {
                        is RootResult.Loading -> {
                            Log.d("Loading", "onViewCreated: Loading... ")
                            Toast.makeText(requireContext(), "Loading...", Toast.LENGTH_SHORT)
                                .show()
                        }

                        is RootResult.Success -> {
                            Log.d("Success", "onViewCreated: ${result.data} ")
                            Toast.makeText(requireContext(), result.data, Toast.LENGTH_SHORT).show()
                        }

                        is RootResult.Error -> {
                            Log.d("Error", "onViewCreated: ${result.message} ")
                            Toast.makeText(
                                requireContext(),
                                "Error: ${result.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        webSocketViewModel.closeConnection()
    }
}