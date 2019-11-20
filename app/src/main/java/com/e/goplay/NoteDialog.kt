package com.e.goplay

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.e.goplay.model.Note
import kotlinx.android.synthetic.main.custom_list.view.*
import kotlinx.android.synthetic.main.form_note.view.*

class NoteDialog(
    private val viewGroup: ViewGroup,
    private val context: Context) {

    private val createdView = createView()
    private val titleField = createdView.form_note_title
    private val descriptionField = createdView.form_note_description

    fun alter(note: Note, altered: (alteredNote: Note) -> Unit) {
        //titleField.title.setText(note.title)
       // descriptionField.description.setText(note.description)
        AlertDialog.Builder(context)
            .setTitle("Alter note")
            .setView(createdView)
            .setPositiveButton("Save") { _, _ ->
                val title = titleField.title.toString()
                val description = descriptionField.description.toString()
                val alteredNote = note.copy(title = title, description = description)
                NoteWebClient().alter(alteredNote, {
                    altered(it)
                }, {
                    Toast.makeText(context, "Falha ao alterar nota", Toast.LENGTH_LONG).show()
                })
            }
            .show()
    }

    fun add(created: (createdNote: Note) -> Unit) {
        AlertDialog.Builder(context)
            .setTitle("Add note")
            .setView(createdView)
            .setPositiveButton("Save") { _, _ ->
                val title = titleField.title.toString()
                val description = descriptionField.description.toString()
                val note = Note(title = title, description = description)
                NoteWebClient().insert(note, {
                    created(it)
                }, {
                    Toast.makeText(context, "Falha ao salvar nota", Toast.LENGTH_LONG).show()
                })
            }
            .show()
    }

    private fun createView(): View {
        return LayoutInflater.from(context)
            .inflate(R.layout.form_note,
                viewGroup,
                false)
    }

}