package com.brannn86.losautos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "LosAutos.db";
    private static final int DB_VER = 1;

    private static final String TABLE_NAME = "garage";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_MODEL = "car_model";
    private static final String COLUMN_MAKE = "car_make";
    private static final String COLUMN_YEAR = "car_year";

    public DBhelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_MODEL + " TEXT, " +
                        COLUMN_MAKE + " TEXT, " +
                        COLUMN_YEAR + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
