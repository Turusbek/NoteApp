package com.example.noteapp.presentation.fragment.note

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.domain.usecase.GetAllNotesUseCase
import com.example.noteapp.domain.utils.ResultStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getAllNoteUseCase: GetAllNotesUseCase
) : ViewModel() {

    private val _noteState = MutableStateFlow<UiState<List<Note>>>(UiState.Empty())
    val noteState = _noteState.asStateFlow()

    fun getAllNote() {
        viewModelScope.launch {
            getAllNoteUseCase.getAllNotes().collect {
                when (it) {
                    is ResultStatus.Error -> {
                        _noteState.value = UiState.Error(it.error)
                    }
                    is ResultStatus.Loading -> {
                        _noteState.value = UiState.Loading()
                    }
                    is ResultStatus.Success -> {
                        if (it.data != null)
                            _noteState.value = UiState.Success()
                    }
                }
            }
        }
    }
}