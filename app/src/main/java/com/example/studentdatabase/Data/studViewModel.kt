//package com.example.studentdatabase.Data
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class studViewModel(application: Application):AndroidViewModel(application) {
//
//    private val readAllData:LiveData<List<StudentData>>
//    private val repository:StudentRepository
//
//    init {
//        val studentDao=StudentDataBase.getDatabase(application).getDaoData()
//        repository= StudentRepository(studentDao)
//        readAllData=repository.readalldata
//    }
//    fun addStud(studentData: StudentData){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.addStudent(studentData)
//        }
//    }
//}