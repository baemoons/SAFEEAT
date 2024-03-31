package com.example.safeeat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MypageActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage)

        var mypageMyprofile = findViewById<Button>(R.id.mypageMyprofile)
//        var mypageShare = findViewById<Button>(R.id.mypageShare)
//        var mypagePhoto = findViewById<ImageView>(R.id.mypagePhoto)
//        var mypageProfile = findViewById<TextView>(R.id.mypageProfile)
//        var mypageAllergie = findViewById<TextView>(R.id.mypageAllergie)
//        var mypageRecentstore = findViewById<Button>(R.id.mypageRecentstore)
//        var mypageRecentfood = findViewById<Button>(R.id.mypageRecentfood)
//        var mypageStarlist = findViewById<Button>(R.id.mypageStarlist)
//        var mypageSetting = findViewById<Button>(R.id.mypageSetting)
//        var mypageUse = findViewById<Button>(R.id.mypageUse)
//        var mypageQuestion = findViewById<Button>(R.id.mypageQuestion)
        var mypageCamera = findViewById<ImageButton>(R.id.mypageCamera)
        var mypageHome = findViewById<ImageButton>(R.id.mypageHome)

        mypageMyprofile.setOnClickListener {
            var profileIntent = Intent(applicationContext, ProfileActivity::class.java)
            startActivity(profileIntent)
        }
        mypageCamera.setOnClickListener {
            var signupIntent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(signupIntent)
        }
        mypageHome.setOnClickListener {
            var mypageIntent = Intent(applicationContext, MypageActivity::class.java)
            startActivity(mypageIntent)
        }
    }
}