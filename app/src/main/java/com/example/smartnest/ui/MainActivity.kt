package com.example.smartnest.ui

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.smartnest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import com.example.smartnest.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment =
            supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        navController = navHostFragment.findNavController()

        navController.addOnDestinationChangedListener { _, destination, _ ->
            window.decorView.setOnApplyWindowInsetsListener { view, insets ->
                val destination = navController.currentDestination?.id
                val statusBarInsets = insets.getInsets(WindowInsets.Type.statusBars())

                when (destination) {
                    R.id.secondFragment, R.id.lightFragment -> {
                        view.setBackgroundColor(ContextCompat.getColor(this, R.color.status_bar_color))
                        view.setPadding(0, statusBarInsets.top, 0, 0)
                    }
                    else -> {
                        view.setBackgroundColor(ContextCompat.getColor(this, R.color.default_status_bar_color))
                        view.setPadding(0, 0, 0, 0)
                    }
                }
                insets
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}