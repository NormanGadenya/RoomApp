package com.example.roomapp.dao

import androidx.room.*
import com.example.roomapp.entities.Director
import com.example.roomapp.entities.School
import com.example.roomapp.entities.Student
import com.example.roomapp.relations.SchoolAndDirector
import com.example.roomapp.relations.SchoolWithStudents

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