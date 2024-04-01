package com.example.safeeat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

//        var myId = findViewById<EditText>(R.id.myId)
//        var myPw = findViewById<EditText>(R.id.myPw)
        val login = findViewById<Button>(R.id.login)
//        var findAccount = findViewById<Button>(R.id.findAccount)
        val makeAccount = findViewById<Button>(R.id.makeAccount)
//        var startKakao = findViewById<Button>(R.id.startKakao)
//        var startGoogle = findViewById<Button>(R.id.startGoogle)

        login.setOnClickListener {
            val homeIntent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(homeIntent)
        }
        makeAccount.setOnClickListener {
            val signupIntent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(signupIntent)
        }
    }
}