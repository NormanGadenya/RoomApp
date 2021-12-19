package com.example.roomapp.Dao

import androidx.room.*
import com.example.roomapp.Entities.Director
import com.example.roomapp.Entities.School
import com.example.roomapp.Entities.Student
import com.example.roomapp.Relations.SchoolAndDirector
import com.example.roomapp.Relations.SchoolWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school : School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director : Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName : String): List<SchoolAndDirector>
    @Transaction
    @Query ("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName : String) : List<SchoolWithStudents>
}