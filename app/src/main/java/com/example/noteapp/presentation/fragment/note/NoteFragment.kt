package com.example.noteapp.presentation.fragment.note

import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentNoteBinding
import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.base.BaseFragment
import com.example.noteapp.presentation.extension.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment :
    BaseFragment<NoteViewModel, FragmentNoteBinding>(FragmentNoteBinding::inflate) {
    override val vm: NoteViewModel by viewModels()
    private val adapter by lazy { NoteAdapter(this::onItemClick, this::onLongItemClick) }

    private fun onItemClick(note: Note) {
        val bundle = bundleOf().apply {
            putSerializable(ARG_ADD_EDIT, note)
        }
        findNavController().navigate(R.id.action_noteFragment_to_addNoteFragment, bundle)
    }

    private fun onLongItemClick(note: Note) {
        vm.deleteNote(note)
    }

    override fun initialize() {
        binding.rvNote.adapter = adapter
    }

    override fun listeners() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_addNoteFragment)
        }
    }

    override fun setupRequest() {
        vm.noteState.collectState(onLoading = {
            binding.noteProgress.isVisible = true

        }, onError = {
            binding.noteProgress.isVisible = false
            showToast(it)
        }, onSuccess = {
            binding.noteProgress.isVisible = false
            adapter.updateList(it)
        })

        vm.deleteNoteState.collectState(
            onLoading = {
                binding.noteProgress.isVisible = true
            },
            onError = {
                binding.noteProgress.isVisible = false
                showToast(it)

            },
            onSuccess = {
                binding.noteProgress.isVisible = false
                showToast(R.string.delete)

            }
        )

    }
    companion object {
        const val ARG_ADD_EDIT = "edit note"
    }


}