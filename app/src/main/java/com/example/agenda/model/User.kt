package com.example.agenda.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user_table") data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val task: String,
    val description: String,
    val date: String,
    val hour: String
): Parcelable