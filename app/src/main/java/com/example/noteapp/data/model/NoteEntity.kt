package com.example.noteapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val createAt: Long
)
