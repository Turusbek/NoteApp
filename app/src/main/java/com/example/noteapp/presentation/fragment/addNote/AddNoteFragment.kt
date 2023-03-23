package com.example.noteapp.presentation.fragment.addNote

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentAddNoteBinding
import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.base.BaseFragment
import com.example.noteapp.presentation.extension.showToast
import com.example.noteapp.presentation.fragment.note.NoteFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment :
    BaseFragment<AddNoteViewModel, FragmentAddNoteBinding>(FragmentAddNoteBinding::inflate) {
    override val vm: AddNoteViewModel by viewModels()
    private val note by lazy { arguments?.getSerializable(NoteFragment.ARG_ADD_EDIT) as Note? }

    override fun initialize() {
        if (arguments != null) {
            binding.etTitle.setText(note!!.title)
            binding.etDes.setText(note!!.description)
        }
    }
    override fun listeners() {
        with(binding) {
            btnSaveNote.setOnClickListener {
                if (arguments != null)
                    vm.update(
                        id = note?.id!!,
                        etTitle.text.toString(),
                        etDes.text.toString()
                    )
                else vm.create(
                    etTitle.text.toString(),
                    etDes.text.toString()
                )

            }
        }
    }

    override fun setupRequest() {
        vm.createNote.collectState(
            onLoading = {
                binding.addNoteProgress.isVisible = true
            },
            onError = {
                showToast(it)
            },
            onSuccess = {
                showToast(getString(R.string.created))
                findNavController().navigateUp()
            }
        )
        vm.editState.collectState(
            onLoading = {

            },
            onError = {
                showToast(it)
            },
            onSuccess = {
                showToast("Note successfully created!")
                findNavController().navigateUp()
            }
        )
    }
}