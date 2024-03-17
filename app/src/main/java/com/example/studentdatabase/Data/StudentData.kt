package com.example.studentdatabase.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="newStudent")
data class StudentData(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name:String,
//    val profileImage:Int,
    val age: String,
    val rollNo:Int,
    val emailId:String)
