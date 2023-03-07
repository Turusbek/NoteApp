package com.example.noteapp.presentation.fragment.addNote

import android.provider.ContactsContract
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.usecase.CreateNoteUseCase
import com.example.noteapp.domain.utils.ResultStatus
import com.example.noteapp.presentation.fragment.note.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase
) : ViewModel() {

    private val _addNoteState =
        MutableStateFlow<UiState<List<ContactsContract.CommonDataKinds.Note>>>(
            UiState.Empty()
        )
    val addNoteState = _addNoteState.asStateFlow()

    fun createNote(note: Note) {
        viewModelScope.launch {
            createNoteUseCase.createNote(note).collect {
                when (it) {
                    is ResultStatus.Error -> {
                        _addNoteState.value = UiState.Error(it.error)
                    }
                    is ResultStatus.Loading -> {
                        _addNoteState.value = UiState.Loading()
                    }
                    is ResultStatus.Success -> {
                        if (it.data != null) {
                            _addNoteState.value = UiState.Success()
                        }
                    }
                }
            }
        }
    }

}