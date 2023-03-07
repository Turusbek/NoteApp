package com.example.noteapp.data.repository

import com.example.noteapp.data.local.NoteDao
import com.example.noteapp.data.mappers.toNote
import com.example.noteapp.data.mappers.toNoteEntity
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.repository.NoteRepository
import com.example.noteapp.domain.utils.ResultStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao) : NoteRepository {

    override fun createNote(note: Note): Flow<ResultStatus<Unit>> = flow {
        emit(ResultStatus.Loading())
        try {
            val data = noteDao.createNote(note.toNoteEntity())

            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override fun editNote(note: Note): Flow<ResultStatus<Unit>> = flow {
        emit(ResultStatus.Loading())
        try {
            val data = noteDao.editNote(note.toNoteEntity())
            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)


    override fun deleteNote(note: Note): Flow<ResultStatus<Unit>> = flow {
        emit(ResultStatus.Loading())
        try {
            val data = noteDao.deleteNote(note.toNoteEntity())
            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override fun getAllNotes(): Flow<ResultStatus<List<Note>>> = flow {
        emit(ResultStatus.Loading())
        try {
            val data = noteDao.getAllNotes().map { it.toNote() }
            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}

