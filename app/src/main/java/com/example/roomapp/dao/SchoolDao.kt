package com.example.roomapp.dao

import androidx.room.*
import com.example.roomapp.entities.Director
import com.example.roomapp.entities.School
import com.example.roomapp.entities.Student
import com.example.roomapp.entities.Subject
import com.example.roomapp.relations.*

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school : School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director : Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(studentSubjectCrossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName : String): List<SchoolAndDirector>
    @Transaction
    @Query ("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName : String) : List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName : String): List<SubjectWithStudent>

    @Transaction
    @Query ("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun getSubjectsOfStudent(studentName : String) : List<StudentWithSubject>
}