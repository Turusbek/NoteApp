package com.example.noteapp.presentation.fragment.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentNoteBinding
import kotlinx.coroutines.launch

class NoteFragment : Fragment() {
    private lateinit var binding:FragmentNoteBinding
    private val viewModel: NoteViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNoteBinding.bind(view)
        //listeners()
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addNoteFragment)
        }
    }

//    private fun listeners() {
//        viewLifecycleOwner.lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED){
//                viewModel.noteState.collect{
//                    when(it){
//                        is UiState.Empty -> {
//
//                        }
//                        is UiState.Error -> {
//
//                        }
//                        is UiState.Loading -> {
//
//                        }
//                        is UiState.Success -> {
//
//                        }
                    }
//                }
//            }
//        }
//    }
// }