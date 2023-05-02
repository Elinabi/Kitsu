package com.geektech.kitsu.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.android4lesson1dz.R
import com.example.android4lesson1dz.databinding.ActivityMainBinding
import com.geektech.kitsu.data.local.preferences.PreferencesHelper
import com.geektech.kitsu.data.local.preferences.UserPreferencesData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
    }

    private fun setupNavigation(){
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container)as NavHostFragment
        navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        when{
            userPreferencesData.isAuthorized ->{
                navGraph.setStartDestination(R.id.mainFlowFragment)
            }
            else -> {
                navGraph.setStartDestination(R.id.signFlowFragment)
            }
        }
        navController.graph = navGraph

//        setStartDestination()
    }

//    private fun setStartDestination(){
//        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
//
//        when{
//            !preferencesHelper.isAuthorize -> {
//                navGraph.setStartDestination(R.id.signFlowFragment)
//            }
//            else -> {
//                navGraph.setStartDestination(R.id.mainFlowFragment)
//            }
//        }
//        navController.graph = navGraph
//    }
}