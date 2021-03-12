package com.justnotes.foryou.data.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(
    context, DATABASE_NAME, factory,
    DATABASE_VERSION
) {

    companion object {
        const val DATABASE_NAME = "notes.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {

        createTables(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        dropTables(db)
        createTables(db)
    }

    fun createTables(db: SQLiteDatabase?) {
        db?.execSQL(NotesContract.NotesEntry.COMMAND_CREATE_TABLE)
    }

    fun dropTables(db: SQLiteDatabase?) {
        db?.execSQL(NotesContract.NotesEntry.COMMAND_DROP_TABLE)
    }

    fun insert(table: String, contentValues: ContentValues) {
        val db = writableDatabase
        db.insert(table, null, contentValues)
        db.close()
    }

    fun update(table: String, contentValues: ContentValues, where: String, params: Array<String>) {
        val db = writableDatabase
        db.update(table, contentValues, where, params)
        db.close()
    }

    fun delete(table: String, where: String, params: Array<String>) {
        val db = writableDatabase
        db.delete(table,  where, params)
        db.close()
    }
}