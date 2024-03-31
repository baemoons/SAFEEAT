package com.example.safeeat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : Activity() {
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
//        var homeCamera = findViewById<ImageButton>(R.id.homeCamera)
        var homeMypage = findViewById<ImageButton>(R.id.homeMypage)

        homeMypage.setOnClickListener {
            var homeIntent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(homeIntent)
        }
    }
}