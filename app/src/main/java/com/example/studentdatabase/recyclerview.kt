package com.example.studentdatabase

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentdatabase.Data.StudentDataBase

class recyclerview : AppCompatActivity() {

    private lateinit var myRecyclerView:RecyclerView
    private lateinit var adapter: rcadaptor
    private lateinit var database: StudentDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recyclerview)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.addstudentlist)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        myRecyclerView = findViewById(R.id.rvstudent)
        myRecyclerView.layoutManager=LinearLayoutManager(this)

//        val name=intent.getStringExtra("Name")
//        val age=intent.getStringExtra("AGE")
//        val rollno=intent.getStringExtra("AGE")
//        val email=intent.getStringExtra("EMAIL")
//         val datalist= arrayListOf<String>()
//        datalist.add(name.toString())
        //datalist.add(age.toString())
        //datalist.add(rollno.toString())
        //datalist.add(email.toString())

        adapter=rcadaptor(this)
        myRecyclerView.adapter=adapter
        database = StudentDataBase.getDatabase(applicationContext)
        fetchData()


    }
    private fun fetchData() {
//        Thread {
//            val studentList = database.getDaoData().showStudData().getValue()
//            runOnUiThread {
//                if (studentList != null) {
//                    adapter.updateStudentList(studentList)
//                }
//            }
//        }.start()
//    }
    database.getDaoData().showStudData().observe(this) { studentList ->
        studentList?.let {
            adapter.updateStudentList(it)
        }
    }
}
}