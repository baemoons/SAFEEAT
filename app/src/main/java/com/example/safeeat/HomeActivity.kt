package com.example.safeeat

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.WindowManager
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

        homeCamera.setOnClickListener {
            var resultpopupIntent = Intent(applicationContext, resultpopupActivity::class.java)
            startActivity(resultpopupIntent)
        }
        homeMypage.setOnClickListener {
            var mypageIntent = Intent(applicationContext, MypageActivity::class.java)
            startActivity(mypageIntent)
        }
    }
}