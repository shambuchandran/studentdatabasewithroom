package com.example.studentdatabase.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StudentData::class], version = 1, exportSchema = true)
abstract class StudentDataBase : RoomDatabase() {
    abstract fun getDaoData(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: StudentDataBase? = null
        fun getDatabase(context: Context): StudentDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentDataBase::class.java,
                    "stud_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}