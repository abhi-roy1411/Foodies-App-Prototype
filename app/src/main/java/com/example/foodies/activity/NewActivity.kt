package com.example.foodies.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.foodies.AboutAppFragment
import com.example.foodies.DashboardFragment
import com.example.foodies.FavouritesFragment
import com.example.foodies.ProfileFragment
import com.example.foodies.R
import com.google.android.material.navigation.NavigationView
import android.view.MenuItem as MenuItem1

class NewActivity : AppCompatActivity() {
    lateinit var  drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationBarView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinator_layout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationBarView = findViewById(R.id.navigationView)
        setUpToolbar()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, DashboardFragment())
            .addToBackStack("Dashboard")
            .commit()
        supportActionBar?.title = "Dashboard"

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@NewActivity, drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

       openDashboard()

        navigationBarView.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.dashboard -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        DashboardFragment()
                    ).commit()
                    supportActionBar?.title = "Dashboard"
                    drawerLayout.closeDrawers()
                }

                R.id.favourites -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        FavouritesFragment()
                    ).commit()
                    supportActionBar?.title = "Favourites"
                    drawerLayout.closeDrawers()
                }

                R.id.profile -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        ProfileFragment()
                    ).commit()
                    supportActionBar?.title = "Profile"
                    drawerLayout.closeDrawers()
                }

                R.id.about_app -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        AboutAppFragment()
                    ).commit()
                    supportActionBar?.title = "AboutApp"
                    drawerLayout.closeDrawers()
                }
            }
            return@setNavigationItemSelectedListener true

        }




    }
     fun setUpToolbar() {

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Toolbar title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onOptionsItemSelected(item: MenuItem1): Boolean {
        val id = item.itemId
        if(id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    fun openDashboard() {
        val fragment = DashboardFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
        supportActionBar?.title = "Dashboard"

    }

    override fun onBackPressed() {

        when(supportFragmentManager.findFragmentById(R.id.frame)){
            !is DashboardFragment -> openDashboard()
        }
    }
}