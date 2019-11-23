package com.academy.hackathonapp.view

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProviders

import com.academy.hackathonapp.dependency.DataStorage
import com.academy.hackathonapp.mvvm.viewModel.ActivityViewModel
import com.academy.hackathonapp.mvvm.viewModel.ActivityViewModelFactory
import kotlinx.android.synthetic.main.activity_main.drawer
import kotlinx.android.synthetic.main.activity_main.my_toolbar


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private val activityViewModel: ActivityViewModel by lazy {
        ViewModelProviders.of(
            this,
            ActivityViewModelFactory(
                DataStorage.categoryRepository,
                DataStorage.currencyRepository

            )
        ).get(ActivityViewModel::class.java)
    }
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.academy.hackathonapp.R.layout.activity_main)

        activityViewModel = ViewModelProviders.of(this).get(ActivityViewModel::class.java)
        supportFragmentManager.beginTransaction().replace(linLay.id,MainFragment()).commit()

        drawer.closeDrawer(GravityCompat.START)
        nav_view.setNavigationItemSelectedListener(this)
        setSupportActionBar(my_toolbar)
//        activityViewModel.currencies.observe(this, Observer { it.forEach { Log.d(TAG, "onCreate: ${it.name}") } })
        activityViewModel.categories.observe(this, Observer { it.forEach { Log.d(TAG, "onCreate: ${it.categoryName} ${it.id}") } })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(com.academy.hackathonapp.R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawer.isDrawerOpen(GravityCompat.START)) drawer.closeDrawer(GravityCompat.START)
        else drawer.openDrawer(GravityCompat.START)
        return super.onOptionsItemSelected(item)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.categories){
            return true
        }


        return false
    }
}
