//package com.example.studentdatabase.Data
//
//import androidx.lifecycle.LiveData
//
//class StudentRepository(private val studentDao: StudentDao) {
//    val readalldata:LiveData<List<StudentData>> = studentDao.showStudData()
//
//    suspend fun addStudent(studentData: StudentData){
//        studentDao.addData(studentData)
//    }
//}