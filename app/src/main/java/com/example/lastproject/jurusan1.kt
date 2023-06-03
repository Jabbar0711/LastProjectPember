package com.example.lastproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class jurusan1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jurusan1)
        val judul = intent.getStringExtra("tif_judul")
        val subJudul = intent.getStringExtra("subJudul")
        val deskripsi = intent.getStringExtra("deskripsi")
        val imageResource = intent.getIntExtra("gambar", R.drawable.hacker) // Default image resource ID if not found

        val Judul = findViewById<TextView>(R.id.tif_judul)
        val SubJudul = findViewById<TextView>(R.id.tif_subjudul)
        val Deskripsi = findViewById<TextView>(R.id.description_a)
        val profileImageView = findViewById<ImageView>(R.id.tif_image)

        val bShare = findViewById<Button>(R.id.button_share)
        bShare.setOnClickListener {
            val jurusan = findViewById<TextView>(R.id.tif_judul)
            val subJudul = findViewById<TextView>(R.id.tif_subjudul)
            val description = findViewById<TextView>(R.id.description_a)
            val bagi_Jurusan = jurusan.text.toString()
            val bagi_taglineWhats = subJudul.text.toString()
            val bagi_desc = description.text.toString()
            val message = "$bagi_Jurusan \n" +
                    "$bagi_taglineWhats\n" +
                    "$bagi_desc"

            shareData(message)
        }
        Judul.setText(judul)
        SubJudul.setText(subJudul)
        Deskripsi.setText(deskripsi)
        profileImageView.setImageResource(imageResource)
    }


    private fun shareData(message: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, message)

        val whatsappUrl = "https://api.whatsapp.com/send?phone=6285785258785&text=$message"
        intent.data = Uri.parse(whatsappUrl)
        intent.setPackage("com.whatsapp")

        startActivity(intent)
    }


}
