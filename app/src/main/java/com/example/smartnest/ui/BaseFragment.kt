package com.example.smartnest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.smartnest.R

open class BaseFragment<VB : ViewBinding>(
    private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(inflater, container, false)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            requireActivity().addMenuProvider(
                object : MenuProvider {
                    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                        menuInflater.inflate(R.menu.toolbar_menu, menu)
                    }

                    override fun onMenuItemSelected(item: MenuItem): Boolean {
                        return when (item.itemId) {
                            R.id.action_settings -> {
                                // Handle settings menu item click
                                true
                            }
                            R.id.action_light -> {
                                // Handle light menu item click
                                true
                            }
                            else -> false
                        }
                    }
                },
                viewLifecycleOwner // Make sure the provider is tied to the lifecycle of this fragment
            )
        }
        return binding.root
    }
    protected fun setupAppBar(
        toolbar: Toolbar,
        title: String? = null,
        showBackButton: Boolean = true,
        navigationIcon: Int? = null,
        onNavigationClick: (() -> Unit)? = null
    ) {
        val activity = (requireActivity() as AppCompatActivity)
        activity.setSupportActionBar(toolbar)

        activity.supportActionBar?.apply {
            this.title = title

            setDisplayHomeAsUpEnabled(showBackButton)

        }

        navigationIcon?.let {
            toolbar.navigationIcon = ContextCompat.getDrawable(requireContext(), it)
            toolbar.navigationIcon?.setTint(
                ContextCompat.getColor(
                    requireContext(),
                    android.R.color.white
                )
            )
        }

        toolbar.setNavigationOnClickListener {
            onNavigationClick?.invoke() ?: activity.onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
