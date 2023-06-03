package com.example.lastproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.textfield.TextInputEditText

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val nama = intent.getStringExtra("nama")
        val nim = intent.getStringExtra("nim")
        val imageResource = intent.getIntExtra("imageResource", R.drawable.hacker) // Default image resource ID if not found

        val nameEditText = findViewById<TextInputEditText>(R.id.nameEditText)
        val usernameEditText = findViewById<TextInputEditText>(R.id.usernameEditText)
        val profileImageView = findViewById<ImageView>(R.id.imageView)

        nameEditText.setText(nama)
        usernameEditText.setText(nim)
        profileImageView.setImageResource(imageResource)
    }
}