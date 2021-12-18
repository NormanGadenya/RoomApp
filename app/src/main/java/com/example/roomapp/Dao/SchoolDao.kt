package com.example.roomapp.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomapp.Entities.Director
import com.example.roomapp.Entities.School
import com.example.roomapp.Relations.SchoolAndDirector

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school : School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director : Director)

    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName : String): List<SchoolAndDirector>

}