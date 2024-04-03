package com.example.safeeat

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class ResultActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)

        var resultFoodphoto = findViewById<ImageView>(R.id.resultFoodphoto)
//        var resultresultFoodname = findViewById<TextView>(R.id.resultresultFoodname)
//        var resultMaterialchart = findViewById<ImageView>(R.id.resultMaterialchart)
//        var resultMaterialname = findViewById<TextView>(R.id.resultMaterialname)
        var resultHome = findViewById<ImageButton>(R.id.resultHome)
        var resultMypage = findViewById<ImageButton>(R.id.resultMypage)
        var resultBack = findViewById<Button>(R.id.resultBack)
//        var resultFoodmore = findViewById<Button>(R.id.resultFoodmore)
//        var resultMaterialmore = findViewById<Button>(R.id.resultMaterialmore)

        resultHome.setOnClickListener {
            var homeIntent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(homeIntent)
        }
        resultMypage.setOnClickListener {
            var mypageIntent = Intent(applicationContext, MypageActivity::class.java)
            startActivity(mypageIntent)
        }
        resultBack.setOnClickListener {
            val cameraPermissionCheck = ContextCompat.checkSelfPermission(
                this@ResultActivity,
                android.Manifest.permission.CAMERA
            )
            if (cameraPermissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    1000
                )
            } else {
                val REQUEST_IMAGE_CAPTURE = 1
                Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                    takePictureIntent.resolveActivity(packageManager)?.also {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                    }
                }
            }
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1000) {
            if(grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@ResultActivity, "거부", Toast.LENGTH_SHORT).show()
            }
        }
    }
}