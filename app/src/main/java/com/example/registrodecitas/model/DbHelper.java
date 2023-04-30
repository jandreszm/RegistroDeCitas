package com.example.registrodecitas.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "citas.db";
    public static final String TABLE_CITAS = "tbl_cita";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CITAS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "identificacion TEXT NOT NULL," +
                "nombre TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "fecha TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CITAS);
        onCreate(sqLiteDatabase);
    }
}
