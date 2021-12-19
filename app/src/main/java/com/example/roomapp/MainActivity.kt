package com.example.roomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.roomapp.entities.Director
import com.example.roomapp.entities.School
import com.example.roomapp.entities.Student
import com.example.roomapp.entities.Subject
import com.example.roomapp.relations.StudentSubjectCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf(
            Director("Mike Buffon","Seeta High School"),
            Director("Obbo Steven","Namugongo High School"),
            Director("Obbo Patrick","Naalya High School")
        )

        val schools = listOf(
            School("Seeta High School"),
            School("Namugongo High School"),
            School("Naayla High School")
        )

        val subjects = listOf(
            Subject("German"),
            Subject("French"),
            Subject("Italian"),
            Subject("Swahili"),
            Subject("English"),
        )

        val students = listOf(
            Student("Wolimbwa",1,"Seeta High School"),
            Student("Gadenya",1,"Naalya High School"),
            Student("Steven",2,"Seeta High School"),
            Student("Wamboga",1,"Namugongo High School"),
            Student("Namarome",3,"Seeta High School"),
            Student("Muduwa",1,"Naalya High School"),
            Student("Tegulwa",2,"Namugongo High School")
        )

        val studentSubjectRel = listOf(
            StudentSubjectCrossRef("Wolimbwa","French"),
            StudentSubjectCrossRef("Gadenya","French"),
            StudentSubjectCrossRef("Steven","German"),
            StudentSubjectCrossRef("Wamboga","German"),
            StudentSubjectCrossRef("Muduwa","English"),
            StudentSubjectCrossRef("Namarome","Italian"),
            StudentSubjectCrossRef("Tegulwa","English")
        )
        lifecycleScope.launch{
            directors.forEach{dao.insertDirector(it)}
            schools.forEach{dao.insertSchool(it)}
            subjects.forEach{dao.insertSubject(it)}
            students.forEach{dao.insertStudent(it)}
            studentSubjectRel.forEach{dao.insertStudentSubjectCrossRef(it)}

            val schoolWithDirector = dao.getSchoolAndDirectorWithSchoolName("Seeta High School")

            Log.d(TAG, "onCreate: ${schoolWithDirector[0].director}")

            val studentWithSubjects = dao.getStudentsOfSubject("French")
            Log.d(TAG, "onCreate: ${studentWithSubjects[0].students}")
        }
    }
}