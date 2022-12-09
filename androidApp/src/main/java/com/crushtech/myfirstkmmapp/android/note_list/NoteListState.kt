package com.crushtech.myfirstkmmapp.android.note_list

import com.crushtech.myfirstkmmapp.domain.note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false
)
