package com.example.safeeat

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class HomeActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

//        var homePhoto = findViewById<ImageView>(R.id.homePhoto)
//        var homeProfile = findViewById<TextView>(R.id.homeProfile)
//        var homeAllergie = findViewById<TextView>(R.id.homeAllergie)
//        var homeUse = findViewById<Button>(R.id.homeUse)
//        var homeStarlist = findViewById<Button>(R.id.homeStarlist)
//        var homeCalender = findViewById<Button>(R.id.homeCalender)
//        var homeCommunity = findViewById<Button>(R.id.homeCommunity)
//        var homeFoodsearch = findViewById<Button>(R.id.homeFoodsearch)
//        var homeRecentfood = findViewById<Button>(R.id.homeRecentfood)
        var homeCamera = findViewById<ImageButton>(R.id.homeCamera)
        var homeMypage = findViewById<ImageButton>(R.id.homeMypage)

        homeMypage.setOnClickListener {
            var homeIntent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(homeIntent)
        }
        homeCamera.setOnClickListener {
            val cameraPermissionCheck = ContextCompat.checkSelfPermission(
                this@HomeActivity,
                android.Manifest.permission.CAMERA
            )
            if(cameraPermissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    1000
                )
            } else {
                val REQUEST_IMAGE_CAPTURE = 1
                Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                    takePictureIntent -> takePictureIntent.resolveActivity(packageManager)?.also {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                    }
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1000) {
            if(grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@HomeActivity, "거부", Toast.LENGTH_SHORT).show()
            }
        }
    }
}