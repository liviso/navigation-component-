package com.android.example.navigation_component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            .setupWithNavController(navHostFragment.navController)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

        // Custom navigation listener allows me to change the title
        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            toolbar.title = destination.label
        }
        return view;
    }

}
