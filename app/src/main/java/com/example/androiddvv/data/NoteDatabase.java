package com.example.androiddvv.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Note.class}, version = 1)
abstract class NoteDatabase extends RoomDatabase {
        public abstract NoteDao noteDao();
}