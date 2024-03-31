package com.example.safeeat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SignupActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

//        var newName = findViewById<EditText>(R.id.newName)
//        var newId = findViewById<EditText>(R.id.newId)
//        var btnCheckNewId = findViewById<Button>(R.id.btnCheckNewId)
//        var newPw = findViewById<EditText>(R.id.newPw)
//        var checkNewpw = findViewById<EditText>(R.id.checkNewpw)
//        var btnCheckNewpw = findViewById<Button>(R.id.btnCheckNewpw)
        var newAccount = findViewById<Button>(R.id.newAccount)
        var otherAccount = findViewById<Button>(R.id.otherAccount)
//        var makeKakao = findViewById<Button>(R.id.makeKakao)
//        var makeGoogle = findViewById<Button>(R.id.makeGoogle)

        newAccount.setOnClickListener {
            var loginIntent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(loginIntent)
        }
        otherAccount.setOnClickListener {
            var loginIntent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }
}