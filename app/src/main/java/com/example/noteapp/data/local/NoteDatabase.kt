package com.example.noteapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        private lateinit var INSTANCE: NoteDatabase

        fun getDbInstance(context: Context): NoteDatabase {

            INSTANCE = Room.databaseBuilder(
                context,
                NoteDatabase::class.java,
                "DB NAME"
            ).allowMainThreadQueries()
                .fallbackToDestructiveMigration().allowMainThreadQueries().build()

            return INSTANCE
        }
    }

}