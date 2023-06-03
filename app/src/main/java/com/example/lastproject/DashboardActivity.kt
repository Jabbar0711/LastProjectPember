package com.example.lastproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container,HomeFragment()).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.User -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, UserFragment()).commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_LastProject)
        setContentView(R.layout.activity_dashboard)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navbar)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction().replace(R.id.frame_container, HomeFragment()).commit()

    }
}