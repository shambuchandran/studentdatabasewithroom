package com.example.studentdatabase.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDao  {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addData(studData: StudentData)
    @Query("SELECT * FROM newStudent WHERE rollNo LIKE :roll LIMIT 1")
    suspend fun findByRoll(roll:Int):StudentData
    @Query("UPDATE newStudent SET name=:firstname,age=:age,emailId=:email WHERE rollNo LIKE :roll")
    suspend fun update(firstname:String,age:String,email:String,roll: Int)
    @Query("DELETE FROM newStudent")
    suspend fun deleteAll()
    @Query("SELECT * FROM newStudent ORDER BY id ASC")
    fun showStudData():LiveData<List<StudentData>>

}