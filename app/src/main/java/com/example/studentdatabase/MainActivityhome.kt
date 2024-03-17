package com.example.studentdatabase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.studentdatabase.Data.adddata

class MainActivityhome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activityhome)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val studentlist=findViewById<TextView>(R.id.studdata)
        studentlist.setOnClickListener{
            val intent=Intent(this,recyclerview::class.java)
            startActivity(intent)
        }
        val addstudent=findViewById<TextView>(R.id.updtdata)
        addstudent.setOnClickListener {
            val intent=Intent(this,adddata::class.java)
            startActivity(intent)
        }
        val logut=findViewById<Button>(R.id.logout)
        logut.setOnClickListener {
            val alertBox = AlertDialog.Builder(this)
            alertBox.setTitle("Sign out!!")
            alertBox.setMessage("Do you want to proceed?")
            alertBox.setIcon(R.drawable.baseline_add_alert_24)
            alertBox.setPositiveButton("Yes") { dialogInterface, which ->
                Intent(this, MainActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
            alertBox.setNegativeButton("No") { dialogInterface, which ->
                return@setNegativeButton
            }
            val alertShow: AlertDialog = alertBox.create()
            alertShow.setCancelable(false)
            alertShow.show()

        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val alertBox = AlertDialog.Builder(this@MainActivityhome)
                alertBox.setTitle("Sign out!!")
                alertBox.setMessage("Do you want to proceed?")
                alertBox.setIcon(R.drawable.baseline_add_alert_24)
                alertBox.setPositiveButton("Yes") { dialogInterface, which ->
                    Intent(this@MainActivityhome, MainActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                }
                alertBox.setNegativeButton("No") { dialogInterface, which ->
                    return@setNegativeButton
                }
                val alertShow: AlertDialog = alertBox.create()
                alertShow.setCancelable(false)
                alertShow.show()
            }
        })
    }
}