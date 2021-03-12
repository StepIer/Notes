package com.justnotes.foryou.domain.usecase


import com.justnotes.foryou.domain.entity.Note
import com.justnotes.foryou.domain.repository.NotesRepository

class InsertNoteUseCase(private val notesRepository: NotesRepository) {
    fun insert(note: Note){
        notesRepository.insert(note)
    }
}