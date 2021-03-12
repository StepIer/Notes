package com.justnotes.foryou.domain.repository

import com.justnotes.foryou.domain.entity.Note

interface NotesRepository {
    fun insert(note: Note)
    fun update(note: Note)
    fun delete(note: Note)
    fun getNotes(id: Int? = null, title: String? = null, text: String? = null): List<Note>
}