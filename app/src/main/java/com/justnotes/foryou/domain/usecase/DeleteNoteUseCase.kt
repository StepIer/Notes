package com.justnotes.foryou.domain.usecase


import com.justnotes.foryou.domain.entity.Note
import com.justnotes.foryou.domain.repository.NotesRepository

class DeleteNoteUseCase(private val notesRepository: NotesRepository) {
    fun delete(note: Note){
        notesRepository.delete(note)
    }
}