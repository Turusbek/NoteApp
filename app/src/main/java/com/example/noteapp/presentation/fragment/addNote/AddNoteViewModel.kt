package com.example.noteapp.presentation.fragment.addNote

import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.usecase.CreateNoteUseCase
import com.example.noteapp.domain.usecase.EditNoteUseCase
import com.example.noteapp.presentation.base.BaseViewModel
import com.example.noteapp.presentation.fragment.note.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase
) : BaseViewModel() {

    private val _createState = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val createNote = _createState.asStateFlow()

    private val _editState = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val editState = _editState.asStateFlow()


    fun create(title: String, desc: String) {
        if (title.isNotEmpty() && title.isNotBlank()) {
            createNoteUseCase(
                Note(
                    title = title,
                    description = desc,
                    createAt = System.currentTimeMillis()
                )
            ).collectFlow(_createState)
        } else {
            _createState.value = UiState.Error("Title is empty!")
        }
    }

    fun update(id:Int,title:String,desc: String) {
        if (id != null && title.isNotEmpty() && desc.isNotEmpty()) {
            editNoteUseCase (Note(
                id = id,
                title = title,
                description = desc,
                createAt = System.currentTimeMillis()
            )

            ).collectFlow(_editState)
        } else {
            _editState.value = UiState.Error("Title is empty")
        }

    }

}