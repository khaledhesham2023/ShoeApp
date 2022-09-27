package com.udacity.shoestore

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    // instance of navController
    private lateinit var navController: NavController

    // instance of appBarConfiguration
    private lateinit var configuration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding the MainActivity with the layout
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        // Timber
        Timber.plant(Timber.DebugTree())

        // setting up the navController to set the start destination in navGraph
        navController = this.findNavController(R.id.myNavHostFragment)
        // setting the appBarConfiguration to interact with implementation of toolbar
        configuration = AppBarConfiguration(navController.graph)
        // make the toolbar an action bar
        setSupportActionBar(binding.toolbar)
        // setting up toolbar with appBarConfiguration and navController
        NavigationUI.setupActionBarWithNavController(this, navController, configuration)

        //  setting the color of navigation bar color when app is running
        val window: Window = this.window
        window.navigationBarColor = resources.getColor(R.color.navigationGrey)

        // setting the input method manager to cancel the keyboard once we select done button in keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken,0)
    }

    // To enable the up button in the toolbar
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}

