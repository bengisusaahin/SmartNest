package com.example.smartnest.ui.light

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.smartnest.R
import com.example.smartnest.databinding.FragmentLightBinding
import com.example.smartnest.ui.BaseFragment

class LightFragment : BaseFragment<FragmentLightBinding>(FragmentLightBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAppBar(
            toolbar = binding.appBar.toolbar,
            title = getString(R.string.light),
            showBackButton = true,
            navigationIcon = R.drawable.outline_arrow_back_24
        )
    }

}