package com.example.studentdatabase.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [StudentData::class], version = 2, exportSchema = true)
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
                )
                    .addMigrations(MIGRATION_1_2)
                    .build()
                INSTANCE = instance
                return instance
            }
        }
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS newStudent_temp " +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT NOT NULL, " +
                        "profileImage TEXT NOT NULL DEFAULT '', " +
                        "age TEXT NOT NULL, " +
                        "rollNo INTEGER NOT NULL, " +
                        "emailId TEXT NOT NULL)")

                database.execSQL("INSERT INTO newStudent_temp (id, name, profileImage, age, rollNo, emailId) " +
                        "SELECT id, name,'', age, rollNo, emailId FROM newStudent")

                database.execSQL("DROP TABLE IF EXISTS newStudent")

                database.execSQL("ALTER TABLE newStudent_temp RENAME TO newStudent")

            }
        }

    }
}