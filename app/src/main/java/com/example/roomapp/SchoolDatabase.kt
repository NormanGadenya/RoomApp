package com.example.roomapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomapp.dao.SchoolDao
import com.example.roomapp.entities.Director
import com.example.roomapp.entities.School
import com.example.roomapp.entities.Student
import com.example.roomapp.entities.Subject
import com.example.roomapp.relations.StudentSubjectCrossRef

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {
    abstract val schoolDao: SchoolDao

    companion object{
        @Volatile
        private var INSTANCE :SchoolDatabase? = null

        fun getInstance(context : Context) : SchoolDatabase{
            synchronized(this){
                return  INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "schoolDatabase"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}