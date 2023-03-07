package com.example.noteapp.domain.usecase

import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.repository.NoteRepository
import com.example.noteapp.domain.utils.ResultStatus
import kotlinx.coroutines.flow.Flow

class GetAllNotesUseCase(
    private val noteRepository: NoteRepository
) {

    fun getAllNotes(): Flow<ResultStatus<List<Note>>> {
        return noteRepository.getAllNotes()
    }

}