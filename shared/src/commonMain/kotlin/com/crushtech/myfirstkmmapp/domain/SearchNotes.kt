package com.crushtech.myfirstkmmapp.domain

import com.crushtech.myfirstkmmapp.domain.note.Note
import com.crushtech.myfirstkmmapp.domain.time.DateTimeUtil

class SearchNotes {

    fun execute(notes: List<Note>, query: String): List<Note> {
        if (query.isBlank()) return notes
        return notes.filter {
            it.title.trim().lowercase().contains(query.lowercase()) ||
                it.content.trim().lowercase().contains(query.lowercase())
        }.sortedBy {
            DateTimeUtil.toEpochMillis(it.created)
        }
    }
}
