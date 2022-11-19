package com.example.ambulance

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.example.ambulance.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private var _binding: ActivityMainBinding? = null
    val binding get() = _binding!!
    private val HOME_FRAGMENT = "homeFragment"
    private val SEARCH_FRAGMENT = "searchFragment"
    private val SHARE_FRAGMENT = "shareFragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHost.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->

            if (destination.id == R.id.homeFragment||destination.id == R.id.infoFragment || destination.id == R.id.phoneFragment) {
                binding.bottomNav.visibility = View.VISIBLE
            }else {

                binding.bottomNav.visibility = View.GONE
            }
        }
        getBottomNavigation()
    }
    fun getBottomNavigation() {
        binding.bottomNav.setItemIconTintList(null)
        //  isBackPressed = true
        setNavigation()
    }
    fun setNavigation() {

        // setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNav.setupWithNavController(navController)

        binding.bottomNav.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.home -> {

                        setFragment(R.id.homeFragment, HOME_FRAGMENT)
//                        binding.tvMainName.text = getString(R.string.app_name)
                        return true
                    }
                    R.id.explore -> {

                        setFragment(R.id.infoFragment, SEARCH_FRAGMENT)
//                        binding.tvMainName.text = getString(R.string.app_name)
                        return true
                    }
                    R.id.live -> {
                        setFragment(R.id.phoneFragment, SHARE_FRAGMENT)
//                        binding.tvMainName.text = getString(R.string.live)
                        return true
                    }
                    else -> {
                        return false
                    }
                }
            }
        })
    }
    fun setFragment(fragment: Int, tag: String) {

        navController.navigate(fragment)

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    override fun onBackPressed() {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        super.onBackPressed()
    }
}