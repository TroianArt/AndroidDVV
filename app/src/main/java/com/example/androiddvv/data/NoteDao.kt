package com.example.androiddvv.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note): Long

    @Update
    fun update(note: Note)

    @Query("delete from notes where id = :id")
    fun deleteById(id: Int)

    @Delete
    fun delete(note: Note)

    @Query("select * from notes")
    fun getAllNotes():LiveData<List<Note>>
}