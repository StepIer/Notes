package com.justnotes.foryou.data.db

import android.provider.BaseColumns

object NotesContract {

    object NotesEntry: BaseColumns{
        //values
        const val TABLE = "notes"
        const val COLUMN_ID = "id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_TEXT = "text"

        //commands
        const val COMMAND_DROP_TABLE = "DROP TABLE IF EXISTS $TABLE"
        const val COMMAND_CREATE_TABLE = "CREATE TABLE $TABLE (" +
                "$COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_TITLE TEXT, $COLUMN_TEXT TEXT)"
        const val ID_CLAUSE = "$COLUMN_ID = ?"
    }

}

