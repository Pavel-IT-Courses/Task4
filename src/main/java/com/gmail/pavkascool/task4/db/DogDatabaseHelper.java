package com.gmail.pavkascool.task4.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gmail.pavkascool.task4.DogHandlerApplication;

import androidx.annotation.Nullable;

public class DogDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Dog Database";

    private static DogDatabaseHelper instance;

    public static DogDatabaseHelper getInstance() {
        if (instance == null) {
            instance = new DogDatabaseHelper(DogHandlerApplication.getDogContext());
        }
        return instance;
    }

    private DogDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table dogs ("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "age text,"
                + "breed text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
