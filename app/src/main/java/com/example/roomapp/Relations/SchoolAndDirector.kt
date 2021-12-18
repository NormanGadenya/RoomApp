package com.example.roomapp.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomapp.Entities.Director
import com.example.roomapp.Entities.School

data class SchoolAndDirector (
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director : Director
        )
