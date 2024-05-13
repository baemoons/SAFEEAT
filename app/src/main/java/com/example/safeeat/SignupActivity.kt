package com.example.safeeat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

class SignupActivity : Activity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        auth = Firebase.auth
//        var newName = findViewById<EditText>(R.id.newName)
        var newId = findViewById<EditText>(R.id.newId)
        var newPw = findViewById<EditText>(R.id.newPw)
//        var checkNewpw = findViewById<EditText>(R.id.checkNewpw)
//        var btnCheckNewpw = findViewById<Button>(R.id.btnCheckNewpw)
        var newAccount = findViewById<Button>(R.id.newAccount)
        var otherAccount = findViewById<Button>(R.id.otherAccount)
//        var makeKakao = findViewById<Button>(R.id.makeKakao)
//        var makeGoogle = findViewById<Button>(R.id.makeGoogle)

        newAccount.setOnClickListener {
            signup(newId.text.toString(),newPw.text.toString())
        }
        otherAccount.setOnClickListener {
            var loginIntent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }
    private fun signup(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if(task.isSuccessful) {
                goToHome(task.result?.user)
            } else if(task.exception?.message.isNullOrEmpty()) {
                Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "존재하는 계정이거나 이메일 형식이 아닙니다.", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun goToHome(user: FirebaseUser?) {
        if (user != null) {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

}