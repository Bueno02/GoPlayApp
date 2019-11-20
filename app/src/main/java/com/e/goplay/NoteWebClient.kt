package com.e.goplay

import com.e.goplay.RetrofitInitializer
import com.e.goplay.model.Note


class NoteWebClient {

    fun list(success: (notes: List<Note>) -> Unit,
             failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().noteService().list()
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

    fun insert(note: Note, success: (note: Note) -> Unit,
               failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().noteService().insert(note)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

    fun alter(note: Note, success: (note: Note) -> Unit,
              failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().noteService().alter(note, note.id)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

}