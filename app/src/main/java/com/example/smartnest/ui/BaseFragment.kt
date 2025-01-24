package com.example.smartnest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
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
        return binding.root
    }

    protected fun setupAppBar(
        toolbar: Toolbar,
        title: String? = null,
        showBackButton: Boolean = true,
        navigationIcon: Int? = null,
        onNavigationClick: (() -> Unit)? = null,
        rightIcon: Int? = null,
        onRightIconClick: (() -> Unit)? = null
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

        rightIcon?.let {
            toolbar.menu.clear()
            toolbar.inflateMenu(R.menu.toolbar_menu)
            val menuItem = toolbar.menu.findItem(R.id.action_settings)
            menuItem?.icon = ContextCompat.getDrawable(requireContext(), it)
            toolbar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_settings -> {
                        onRightIconClick?.invoke() ?: run {
                            // Varsayılan olarak bir işlem yapılabilir
                        }
                        true
                    }

                    else -> false
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
