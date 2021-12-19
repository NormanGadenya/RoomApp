package com.example.roomapp.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomapp.entities.Director
import com.example.roomapp.entities.School

data class SchoolAndDirector (
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director : Director
        )
