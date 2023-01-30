package com.example.myapplication20230130;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHAndler extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "RECORD";

    static final String TABLE_NAME = "STUDENT";
    static final String STUDENT_NAME = "NAME";
    static final String COLUMN_DATE = "DATE";
    static final String COLUMN_FAJAR = "FAJAR";
    static final String COLUMN_FAJAR_COUNT = "FAJAR_COUNT";
    static final String COLUMN_ZUHR = "ZUHR";
    static final String COLUMN_ZUHR_COUNT = "ZUHR_COUNT";
    static final String COLUMN_ASR = "ASR";
    static final String COLUMN_ASR_COUNT = "ASR_COUNT";
    static final String COLUMN_MAGHRIB = "MAGHRIB";
    static final String COLUMN_MAGHRIB_COUNT = "MAGHRIB_COUNT";
    static final String COLUMN_ISHA = "ISHA";
    static final String COLUMN_ISHA_COUNT = "ISHA_COUNT";

    public DBHAndler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "( "
                + STUDENT_NAME + " TEXT, "
                + COLUMN_DATE + " TEXT, "
                + COLUMN_FAJAR + " TEXT, "
                + COLUMN_FAJAR_COUNT + " TEXT, "
                + COLUMN_ZUHR + " TEXT, "
                + COLUMN_ZUHR_COUNT + " TEXT, "
                + COLUMN_ASR + " TEXT, "
                + COLUMN_ASR_COUNT + " TEXT, "
                + COLUMN_MAGHRIB + " TEXT, "
                + COLUMN_MAGHRIB_COUNT + " TEXT, "
                + COLUMN_ISHA + " TEXT, "
                + COLUMN_ISHA_COUNT + " TEXT "
                + ") ";

        sqLiteDatabase.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);

        onCreate(sqLiteDatabase);
    }

    private void add(Student std) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_DATE, std.getDate());

        values.put(COLUMN_FAJAR, std.getFajar());
        values.put(COLUMN_ZUHR, std.getZuhr());
        values.put(COLUMN_ASR, std.getAsar());
        values.put(COLUMN_MAGHRIB, std.getMaghrib());
        values.put(COLUMN_ISHA, std.getIsha());

        values.put(COLUMN_FAJAR_COUNT, std.getF_count());
        values.put(COLUMN_ZUHR_COUNT, std.getZ_count());
        values.put(COLUMN_ASR_COUNT, std.getA_count());
        values.put(COLUMN_MAGHRIB_COUNT, std.getM_count());
        values.put(COLUMN_ISHA_COUNT, std.getI_count());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    private void update(Student std) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_FAJAR, std.getFajar());
        values.put(COLUMN_ZUHR, std.getZuhr());
        values.put(COLUMN_ASR, std.getAsar());
        values.put(COLUMN_MAGHRIB, std.getMaghrib());
        values.put(COLUMN_ISHA, std.getIsha());

        values.put(COLUMN_FAJAR_COUNT, std.getF_count());
        values.put(COLUMN_ZUHR_COUNT, std.getZ_count());
        values.put(COLUMN_ASR_COUNT, std.getA_count());
        values.put(COLUMN_MAGHRIB_COUNT, std.getM_count());
        values.put(COLUMN_ISHA_COUNT, std.getI_count());

        db.update(TABLE_NAME, values, COLUMN_DATE + " = ?", new String[] {std.getDate()});
        db.close();
    }

    public void AddStudentRecord(Student std) {
        int exist = 0;

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                    COLUMN_DATE + " = '" + std.getDate() + "' ";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                exist++;
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        if(exist==0) {
            add(std);
        }
        else {
            update(std);
        }

//        Log.d("ADD", "AddStudentRecord: ");
    }

    public List<Student> getData() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                String date = cursor.getString(cursor.getColumnIndex(COLUMN_DATE));

                String fajar = cursor.getString(cursor.getColumnIndex(COLUMN_FAJAR));
                String zuhr = cursor.getString(cursor.getColumnIndex(COLUMN_ZUHR));
                String asar = cursor.getString(cursor.getColumnIndex(COLUMN_ASR));
                String maghrib = cursor.getString(cursor.getColumnIndex(COLUMN_MAGHRIB));
                String isha = cursor.getString(cursor.getColumnIndex(COLUMN_ISHA));

                String fc = cursor.getString(cursor.getColumnIndex(COLUMN_FAJAR_COUNT));
                String zc = cursor.getString(cursor.getColumnIndex(COLUMN_ZUHR_COUNT));
                String ac = cursor.getString(cursor.getColumnIndex(COLUMN_ASR_COUNT));
                String mc = cursor.getString(cursor.getColumnIndex(COLUMN_MAGHRIB_COUNT));
                String ic = cursor.getString(cursor.getColumnIndex(COLUMN_ISHA_COUNT));

                Student ns = new Student(date, fajar, zuhr, asar, maghrib, isha, fc, zc, ac, mc, ic);
                students.add(ns);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }
}
