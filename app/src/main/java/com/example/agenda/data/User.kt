package com.example.agenda.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table") data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val task: String,
    val description: String,
    val date: String,
    val hour: String
)