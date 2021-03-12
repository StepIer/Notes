package com.justnotes.foryou.domain.usecase


import com.justnotes.foryou.domain.entity.Note
import com.justnotes.foryou.domain.repository.NotesRepository

class GetNoteUseCase(private val notesRepository: NotesRepository) {
    fun getNotes(){
        notesRepository.getNotes()
    }
}