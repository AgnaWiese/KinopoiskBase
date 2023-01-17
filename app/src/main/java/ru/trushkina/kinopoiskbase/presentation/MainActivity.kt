package ru.trushkina.kinopoiskbase.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.updatePadding
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import ru.trushkina.kinopoiskbase.R
import ru.trushkina.kinopoiskbase.databinding.ActivityMainBinding
import ru.trushkina.kinopoiskbase.presentation.utils.doOnApplyWindowInsets

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupInsets()

        navView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)
    }

    fun showBottomNav() {
        navView.visibility = View.VISIBLE
    }

    fun hideBottomNav() {
        navView.visibility = View.GONE
    }

    fun switchBottomNavigation(navigationId: Int) {
        navView.selectedItemId = navigationId
    }

    private fun setupInsets() {
        WindowCompat.setDecorFitsSystemWindows(window, false)

        binding.navView.doOnApplyWindowInsets { view, insets, padding ->
            view.updatePadding(
                bottom = padding.bottom + insets.systemWindowInsetBottom
            )
        }
    }
}
