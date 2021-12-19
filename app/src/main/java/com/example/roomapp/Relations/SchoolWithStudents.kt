package com.example.roomapp.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomapp.Entities.School
import com.example.roomapp.Entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students : List<Student>
    )
