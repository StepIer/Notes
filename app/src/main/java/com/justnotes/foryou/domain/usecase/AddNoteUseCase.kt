package com.justnotes.foryou.domain.usecase

import com.justnotes.foryou.data.db.DbHelper
import com.justnotes.foryou.data.db.NotesContract
import com.justnotes.foryou.domain.entity.Note
import com.justnotes.foryou.domain.repository.NotesRepository

class AddNoteUseCase(private val notesRepository: NotesRepository) {
    operator fun invoke(note: Note){
        notesRepository.insert(note)

    }
}