package com.crushtech.myfirstkmmapp.data.note

import com.crushtech.myfirstkmmapp.database.NoteDatabase
import com.crushtech.myfirstkmmapp.domain.note.Note
import com.crushtech.myfirstkmmapp.domain.note.NoteDataSource
import com.crushtech.myfirstkmmapp.domain.time.DateTimeUtil

class SqlDelightNoteDataSource(db: NoteDatabase) : NoteDataSource {

    private val queries = db.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            colorHex = note.colorHex,
            created = DateTimeUtil.toEpochMillis(note.created)
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries
            .getNoteById(id)
            .executeAsOneOrNull()
            ?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries.getAllNotes()
            .executeAsList()
            .map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: Long) {
        return queries.deleteNote(id)
    }
}
