package com.example.studentdatabase.Data

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.studentdatabase.R
import com.example.studentdatabase.databinding.ActivityAdddataBinding
import com.example.studentdatabase.recyclerview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class adddata : AppCompatActivity() {

    private lateinit var binding: ActivityAdddataBinding
    lateinit var database: StudentDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
            binding= ActivityAdddataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database= StudentDataBase.getDatabase(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        binding.save.setOnClickListener {
//            writeData()
//            val intent= Intent(this,recyclerview::class.java)
//            intent.putExtra("NAME",name)
//            startActivity(intent)
//        }
        binding.delete.setOnClickListener {
            GlobalScope.launch {
                database.getDaoData().deleteAll()
            }
        }
        binding.update.setOnClickListener {
            updateData()
        }
        binding.searchID.setOnClickListener {
            readData()
        }
        binding.save.setOnClickListener {
            val data = writeData()
            data?.let { values ->
                val intent = Intent(this, recyclerview::class.java)
                intent.putExtra("NAME", values[0])
                intent.putExtra("AGE", values[1])
                intent.putExtra("ROLLNO", values[2])
                intent.putExtra("EMAIL", values[3])
                startActivity(intent)
            }
        }
    }
    private fun writeData(): List<String>?{
        val name=binding.name.text.toString()
        val age=binding.age.text.toString()
        val rollno=binding.rollNo.text.toString()
        val email=binding.email.text.toString()
        if (name.isNotEmpty()&&age.isNotEmpty()&&rollno.isNotEmpty()&&email.isNotEmpty()){
            val student=StudentData(null,name,age,rollno.toInt(),email)
            GlobalScope.launch (Dispatchers.IO){
                database.getDaoData().addData(student)
            }
            binding.name.text.clear()
            binding.age.text.clear()
            binding.rollNo.text.clear()
            binding.email.text.clear()
            Toast.makeText(this@adddata, "Successfully added", Toast.LENGTH_SHORT).show()
            return listOf(name, age, rollno, email)

        }else{
            Toast.makeText(this@adddata, "Please enter details", Toast.LENGTH_SHORT).show()
            return null
        }

    }
    private fun updateData() {
        val name=binding.name.text.toString()
        val age=binding.age.text.toString()
        val rollno=binding.rollNo.text.toString()
        val email=binding.email.text.toString()
        if (name.isNotEmpty()&&age.isNotEmpty()&&rollno.isNotEmpty()&&email.isNotEmpty()){
            GlobalScope.launch (Dispatchers.IO){
                database.getDaoData().update(name,age,email,rollno.toInt())
            }
            binding.name.text.clear()
            binding.age.text.clear()
            binding.rollNo.text.clear()
            binding.email.text.clear()
            Toast.makeText(this@adddata, "Successfully updated", Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this@adddata, "Please enter details", Toast.LENGTH_SHORT).show()
        }

    }
    private suspend fun displayData(student:StudentData?){
//        withContext(Dispatchers.Main) {
//            binding.tvFirstName.text = student.firstName
//            binding.tvLastName.text = student.lastName
//            binding.tvRollNo.text = student.rollNo.toString()
//        }
        student?.let {
            withContext(Dispatchers.Main) {
                binding.shname.text = it.name
                binding.shage.text = it.age
                binding.shemail.text = it.emailId
            }
        } ?: run {
            // Handle case where student is null, for example, clear text views
            withContext(Dispatchers.Main) {
                binding.shname.text = "No data"
                binding.shage.text = "No data"
                binding.shemail.text = "No data"
            }
        }
    }
    private fun readData(){
        val rollNo=binding.enterRoll.text.toString()
        if (rollNo.isNotEmpty()){
            var student:StudentData
            GlobalScope.launch(Dispatchers.IO) {
                student=database.getDaoData().findByRoll(rollNo.toInt())
                displayData(student)
            }
        }

    }
}