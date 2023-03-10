package com.example.noteapp.presentation.fragment.note

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.databinding.ItemNoteBinding
import com.example.noteapp.domain.model.Note

class NoteAdapter(
    private val onItemClickListener: (Note) -> Unit,
    private val onLongItemClickListener: (Note) -> Unit
) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var list = listOf<Note>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(notes: List<Note>) {
        list = notes
        notifyDataSetChanged()

    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(note: Note) {
            with(binding) {
                itemTvTitle.text = note.title
                itemTvDes.text = note.description

                root.setOnClickListener {
                    onItemClickListener(note)
                }
                root.setOnLongClickListener {
                    onLongItemClickListener(note)

                    true
                }

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}