package com.example.lindapokorny.sqliteappfromscratch.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.lindapokorny.sqliteappfromscratch.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteDataBase extends SQLiteOpenHelper {
    private static NoteDataBase noteDataBaseInstance;
    private static final String TABLE_NAME = "Notes";
    private static final String DATABASE_NAME = "Notes.db";
    private static final int SCHEMA_VERSION = 1;

//    private NoteDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

    //        super(context, name, factory, version);
    private NoteDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    public static synchronized NoteDataBase getInstance(Context context) {
        if (noteDataBaseInstance == null) {
            noteDataBaseInstance = new NoteDataBase(context.getApplicationContext());
        }
        return noteDataBaseInstance;
    }
    //    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, message TEXT);");

    }

    public void addNote(Note note){
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE name =" +
                note.getName() + " AND message =" + note.getMessage() + ";", null);
        if (cursor.getCount() == 0){
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(name, message VALUES('" +
                    note.getName() + "','" +
                    note.getMessage() + "','");
        }
        cursor.close();
    }
    public List<Note> getNoteList(){
        List<Note> noteList = new ArrayList<>();
        Note note = null;
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);
        if (cursor != null){
            if (cursor.moveToFirst()){
                do {
                    note = new Note(
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("message")));
                    noteList.add(note);
                } while (cursor.moveToNext());
            }
        }
        return noteList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
