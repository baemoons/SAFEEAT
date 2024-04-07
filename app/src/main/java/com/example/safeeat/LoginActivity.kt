package com.example.safeeat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : Activity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        var myId = findViewById<EditText>(R.id.myId)
        var myPw = findViewById<EditText>(R.id.myPw)
        val login = findViewById<Button>(R.id.login)
//        var findAccount = findViewById<Button>(R.id.findAccount)
        val makeAccount = findViewById<Button>(R.id.makeAccount)
//        var startKakao = findViewById<Button>(R.id.startKakao)
//        var startGoogle = findViewById<Button>(R.id.startGoogle)

        login.setOnClickListener {
            signIn(myId.text.toString(),myPw.text.toString())
        }
        makeAccount.setOnClickListener {
            val signupIntent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(signupIntent)
        }
    }
    private fun signIn(email: String, password: String) {
        auth?.signInWithEmailAndPassword(email, password)?.addOnCompleteListener{ task ->
            if(task.isSuccessful) {
                goToMain(task.result?.user)
            }
        }
    }
    private fun goToMain(user: FirebaseUser?) {
        if (user != null) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}