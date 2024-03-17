package com.example.studentdatabase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        Thread.sleep(3000)
//        installSplashScreen()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.addstudentlist)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val username = findViewById<EditText>(R.id.username)
        val userPassword = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login)

        val savedUserName = "username"
        val savedPassword = "12345"

        loginButton.setOnClickListener {
            val enteredUserName = username.text.toString()
            val enteredPassword = userPassword.text.toString()
            if (enteredUserName != savedUserName) {
                Toast.makeText(this, "Username mismatch", Toast.LENGTH_LONG).show()
            } else if (enteredPassword != savedPassword) {
                Toast.makeText(this, "Wrong password", Toast.LENGTH_LONG).show()
            } else {
                Intent(this, MainActivityhome::class.java).also {
                    startActivity(it)
                    username.text.clear()
                    userPassword.text.clear()
                }
            }
        }
    }
}
