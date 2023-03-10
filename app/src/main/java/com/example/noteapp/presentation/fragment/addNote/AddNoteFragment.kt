package com.example.noteapp.presentation.fragment.addNote

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentAddNoteBinding
import com.example.noteapp.presentation.base.BaseFragment
import com.example.noteapp.presentation.extension.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment :
    BaseFragment<AddNoteViewModel, FragmentAddNoteBinding>(FragmentAddNoteBinding::inflate) {
    override val vm: AddNoteViewModel by viewModels()


    override fun listeners() {
        with(binding) {
            btnSaveNote.setOnClickListener {
                vm.create(
                    etTitle.text.toString(),
                    etDes.text.toString()
                )

            }
        }
    }

    override fun setupRequest() {
        vm.createNote.collectState(
            onLoading = {

            },
            onError = {
                showToast(it)
            },
            onSuccess = {
                showToast(getString(R.string.created))
                findNavController().navigateUp()
            }
        )
    }
}