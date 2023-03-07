package com.example.noteapp.presentation.fragment.note

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.databinding.ItemNoteBinding
import com.example.noteapp.domain.model.Note

class NoteAdapter : ListAdapter<NoteViewModel, NoteAdapter.NotesViewHolder>(NotesCallback()) {

    private var list: ArrayList<Note> = arrayListOf()

    fun addNote(list: ArrayList<Note>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class NotesViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(notesModel: Note) {
            binding.itemTvTitle.text = notesModel.title
            binding.itemTvDes.text = notesModel.description
        }
    }

    class NotesCallback : DiffUtil.ItemCallback<NoteViewModel>() {
        override fun areItemsTheSame(oldItem: NoteViewModel, newItem: NoteViewModel) =
            oldItem == newItem

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: NoteViewModel, newItem: NoteViewModel) =
            oldItem == newItem
    }
}