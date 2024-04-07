package com.example.safeeat

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
//            val loginIntent = Intent(this,LoginActivity::class.java)
            val loginIntent = Intent(this,LoginActivity::class.java)
            startActivity(loginIntent)
            finish()
        }, 2000)

    }
}