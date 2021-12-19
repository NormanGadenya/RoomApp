package com.example.roomapp.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomapp.entities.School
import com.example.roomapp.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students : List<Student>
    )
