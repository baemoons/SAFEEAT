package com.example.safeeat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class ProfileActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profil)

        var myprofileBack = findViewById<Button>(R.id.myprofileBack)
        var myprofileStore = findViewById<Button>(R.id.myprofileStore)
//        var myprofilePhto = findViewById<ImageButton>(R.id.myprofilePhto)
//        var myprofileName = findViewById<EditText>(R.id.myprofileName)
//        var myprofileNamestore = findViewById<Button>(R.id.myprofileNamestore)
//        var myprofilePw = findViewById<EditText>(R.id.myprofilePw)
//        var myprofilePwstore = findViewById<Button>(R.id.myprofilePwstore)
//        var myprofileShrimp = findViewById<Button>(R.id.myprofileShrimp)
//        var myprofileNoodle = findViewById<Button>(R.id.myprofileNoodle)
//        var myprofileWheat = findViewById<Button>(R.id.myprofileWheat)
//        var myprofileSoybean = findViewById<Button>(R.id.myprofileSoybean)
//        var myprofilePeanut = findViewById<Button>(R.id.myprofilePeanut)
//        var myprofileWalnut = findViewById<Button>(R.id.myprofileWalnut)
//        var myprofilePinenut = findViewById<Button>(R.id.myprofilePinenut)
//        var myprofileTomato = findViewById<Button>(R.id.myprofileTomato)
//        var myprofilePeach = findViewById<Button>(R.id.myprofilePeach)
//        var myprofileEgg = findViewById<Button>(R.id.myprofileEgg)
//        var myprofileMilk = findViewById<Button>(R.id.myprofileMilk)
//        var myprofileFish = findViewById<Button>(R.id.myprofileFish)
//        var myprofileSquid = findViewById<Button>(R.id.myprofileSquid)
//        var myprofileCrab = findViewById<Button>(R.id.myprofileCrab)
//        var myprofileClam = findViewById<Button>(R.id.myprofileClam)
//        var myprofilePork = findViewById<Button>(R.id.myprofilePork)
//        var myprofileBeef = findViewById<Button>(R.id.myprofileBeef)
//        var myprofileChicken = findViewById<Button>(R.id.myprofileChicken)
//        var myprofileMelon = findViewById<Button>(R.id.myprofileMelon)
//        var myprofileCorn = findViewById<Button>(R.id.myprofileCorn)
//        var myprofileCamera = findViewById<ImageButton>(R.id.myprofileCamera)
        var myprofileHome = findViewById<ImageButton>(R.id.myprofileHome)

        myprofileBack.setOnClickListener {
            var mypageIntent = Intent(applicationContext, MypageActivity::class.java)
            startActivity(mypageIntent)
        }
        myprofileStore.setOnClickListener {
            var mypageIntent = Intent(applicationContext, MypageActivity::class.java)
            startActivity(mypageIntent)
        }
        myprofileHome.setOnClickListener {
            var homeIntent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(homeIntent)
        }
    }
}