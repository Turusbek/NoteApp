package com.example.noteapp.domain.usecase

import android.provider.ContactsContract.CommonDataKinds.Note
import com.example.noteapp.domain.repository.NoteRepository

class EditNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun editNote(note: Note) = noteRepository.editNote(note)
}