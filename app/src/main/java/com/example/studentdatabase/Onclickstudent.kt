package com.example.studentdatabase

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Onclickstudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onclickstudent)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bitmap = intent.getParcelableExtra<Bitmap>("BITMAPIMAGE")
        //val image=intent.getIntExtra("IMAGE",R.drawable.world_5075229)
        val name=intent.getStringExtra("NAME")
        val age=intent.getStringExtra("AGE")
        val rollno=intent.getStringExtra("ROLLNO")
        val email=intent.getStringExtra("EMAIL")

        val rcimage=findViewById<ImageView>(R.id.rcshowimg)
        val rcname=findViewById<TextView>(R.id.rcshowname)
        val rcage=findViewById<TextView>(R.id.rcshowage)
        val rcrollno=findViewById<TextView>(R.id.rcshowroll)
        val rcemail=findViewById<TextView>(R.id.rcshowemail)

        rcimage.setImageBitmap(bitmap)
        rcname.setText(name)
        rcrollno.setText(rollno)
        rcage.setText(age)
        rcemail.setText(email)
    }
}