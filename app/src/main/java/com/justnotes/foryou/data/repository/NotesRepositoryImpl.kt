package com.justnotes.foryou.data.repository

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteQueryBuilder
import androidx.core.content.contentValuesOf
import com.justnotes.foryou.data.db.DbHelper
import com.justnotes.foryou.data.db.NotesContract
import com.justnotes.foryou.domain.entity.Note
import com.justnotes.foryou.domain.repository.NotesRepository
import kotlinx.coroutines.selects.select

class NotesRepositoryImpl(private val db: DbHelper) : NotesRepository {
    override fun insert(note: Note) {
        val contentValues = ContentValues()
        contentValues.put(NotesContract.NotesEntry.COLUMN_ID, note.id)
        contentValues.put(NotesContract.NotesEntry.COLUMN_TITLE, note.title)
        contentValues.put(NotesContract.NotesEntry.COLUMN_TEXT, note.text)

        db.insert(NotesContract.NotesEntry.TABLE, contentValues)
    }

    override fun update(note: Note) {

    }

    override fun delete(note: Note) {
        db.delete(
            NotesContract.NotesEntry.TABLE,
            NotesContract.NotesEntry.ID_CLAUSE,
            arrayOf(note.id.toString())
        )
    }

    override fun getNotes(id: Int?, title: String?, text: String?): List<Note> {
        val builder = SQLiteQueryBuilder()
        builder.tables = NotesContract.NotesEntry.TABLE
        id?.let { builder.appendWhere(NotesContract.NotesEntry.COLUMN_ID + "=" + it) }
        title?.let { builder.appendWhere(NotesContract.NotesEntry.COLUMN_TITLE + "=" + it) }
        text?.let { builder.appendWhere(NotesContract.NotesEntry.COLUMN_TEXT + "=" + it) }
        val cursor = builder.query(
            db.readableDatabase,
            null,
            null,
            null,
            null,
            null,
            null
        )
        return cursorToNotesList(cursor)
    }

    private fun cursorToNotesList(cursor: Cursor?): List<Note> {
        val result = arrayListOf<Note>()
        cursor?.let { c ->
            c.moveToFirst()
            repeat(c.count) {
                result.add(
                    Note(
                        c.getInt(0),
                        c.getString(1),
                        c.getString(2)
                    )
                )
                c.moveToNext()
            }
        }
        return result
    }


}