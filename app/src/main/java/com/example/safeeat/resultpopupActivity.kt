package com.example.safeeat

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import java.net.HttpURLConnection
import java.net.URL
import java.io.FileOutputStream
import java.text.SimpleDateFormat

val CAMERA = arrayOf(android.Manifest.permission.CAMERA)
val STORAGE = arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE)
val CAMERA_CODE = 98
val STORAGE_CODE = 99

class resultpopupActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resultpopup)

        val takepicture = findViewById<Button>(R.id.takepicture)

        var camerahome = findViewById<ImageButton>(R.id.camerahome)
        var cameramypage = findViewById<ImageButton>(R.id.cameramypage)

        camerahome.setOnClickListener {
            var homeIntent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(homeIntent)
        }
        cameramypage.setOnClickListener {
            var mypageIntent = Intent(applicationContext, MypageActivity::class.java)
            startActivity(mypageIntent)
        }

        takepicture.setOnClickListener {
            CallCamera()
        }
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
    {
        when(requestCode) {
            CAMERA_CODE -> {
                for (grant in grantResults) {
                    if (grant != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "카메라 권한을 승인해 주세요.", Toast.LENGTH_LONG).show()
                    }
                }
            }

            STORAGE_CODE -> {
                for (grant in grantResults) {
                    if (grant != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "저장소 권한을 승인해 주세요.", Toast.LENGTH_LONG).show()
                        //finish() 앱을 종료함
                    }
                }
            }
        }
    }
    fun checkPermission(permissions: Array<out String>, type: Int): Boolean
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (permission in permissions) {
                if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, permissions, type)
                    return false;
                }
            }
        }

        return true;
    }
    fun CallCamera()
    {
        if (checkPermission(CAMERA, CAMERA_CODE) && checkPermission(STORAGE, STORAGE_CODE)) {
            val itt = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(itt, CAMERA_CODE)
        }
    }
    fun saveFile(fileName: String, mimeType: String, bitmap: Bitmap): Uri?
    {
        var CV = ContentValues()
        CV.put(MediaStore.Images.Media.DISPLAY_NAME, fileName)
        CV.put(MediaStore.Images.Media.MIME_TYPE, mimeType)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            CV.put(MediaStore.Images.Media.IS_PENDING, 1)
        }

        val uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, CV)

        if (uri != null) {
            var scriptor = contentResolver.openFileDescriptor(uri, "w")

            if (scriptor != null) {
                val fos = FileOutputStream(scriptor.fileDescriptor)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
                fos.close()

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    CV.clear()
                    CV.put(MediaStore.Images.Media.IS_PENDING, 0)
                    contentResolver.update(uri, CV, null, null)
                }
            }
        }

        return uri;
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var Allergie_capture = findViewById<ImageView>(R.id.Allergie_capture)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                CAMERA_CODE -> {
                    if (data?.extras?.get("data") != null) {
                        val img = data?.extras?.get("data") as Bitmap
                        val uri = saveFile(RandomFileName(), "image/jpg", img)
                        Allergie_capture.setImageURI(uri)
                    }
                }
            }
        }
    }
    fun RandomFileName() : String
    {
        val fineName = SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())
        return fineName
    }

    fun sendOpenAIRequest(apiKey: String, question: String): String {
        val url = URL("https://api.openai.com/v1/engines/davinci/completions")

        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "POST"
        connection.setRequestProperty("Content-Type", "application/json")
        connection.setRequestProperty("Authorization", "Bearer $apiKey")

        connection.doOutput = true
        val postData = "{\"prompt\": \"$question\", \"max_tokens\": 150}"
        connection.outputStream.use { it.write(postData.toByteArray()) }

        val responseCode = connection.responseCode
        if (responseCode == HttpURLConnection.HTTP_OK) {
            val response = connection.inputStream.bufferedReader().readText()
            connection.disconnect()
            return response
        } else {
            println("Error: HTTP $responseCode")
            connection.disconnect()
            return ""
        }
    }
    fun foodsearch() {
        val Allergie_result = findViewById<TextView>(R.id.Allergie_result)
        val apiKey = "api 키를 적으세요"
        print("음식을 입력하세요: ")
        val food = readLine() ?: ""
        val question = "'$food'의 레시피 속 재료 단어로 나열해줘"
        Allergie_result.text = sendOpenAIRequest(apiKey, question)
    }
}