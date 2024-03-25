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

        var etSql: EditText
        val ip = "192.168.0.1"
        val port = "49670"
        val Classes = "net.sourceforge.jtds.jdbc.Driver"
        val database = "MyDataBase"
        val username = "Kim"
        val password = "qwer"
        val url = "jdbc:jtds:sqlserver://$ip:$port/$database"
        val connection: Connection? = null

        Handler(Looper.getMainLooper()).postDelayed({
            val loginIntent = Intent(this,LoginActivity::class.java)
            val homeIntent = Intent(this,HomeActivity::class.java)
            startActivity(homeIntent)
            finish()
        })

    }
}