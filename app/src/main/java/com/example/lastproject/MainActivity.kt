package com.example.lastproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstance: Bundle?){
        super.onCreate(savedInstance)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        // Menggunakan Handler untuk menunda pemindahan ke MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@MainActivity, DashboardActivity::class.java))
            finish()
        }, 3000)
    }
}