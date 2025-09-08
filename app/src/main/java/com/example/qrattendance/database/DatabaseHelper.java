package com.example.qrattendance.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "qr_attendance.db";
    private static final int DB_VERSION = 1;

    public static final String TBL_STUDENTS = "students";
    public static final String COL_STUDENT_ID = "student_id";
    public static final String COL_STUDENT_NAME = "name";

    public static final String TBL_ATTENDANCE = "attendance";
    public static final String COL_ATT_ID = "id";
    public static final String COL_ATT_STUDENT_ID = "student_id";
    public static final String COL_ATT_TIMESTAMP = "timestamp";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TBL_STUDENTS + " (" +
                COL_STUDENT_ID + " TEXT PRIMARY KEY, " +
                COL_STUDENT_NAME + " TEXT NOT NULL)"
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TBL_ATTENDANCE + " (" +
                COL_ATT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_ATT_STUDENT_ID + " TEXT NOT NULL, " +
                COL_ATT_TIMESTAMP + " TEXT NOT NULL, " +
                "FOREIGN KEY(" + COL_ATT_STUDENT_ID + ") REFERENCES " + TBL_STUDENTS + "(" + COL_STUDENT_ID + ")" +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_ATTENDANCE);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_STUDENTS);
        onCreate(db);
    }

    public boolean addStudent(String id, String name) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_STUDENT_ID, id);
        cv.put(COL_STUDENT_NAME, name);
        long res = db.insertWithOnConflict(TBL_STUDENTS, null, cv, SQLiteDatabase.CONFLICT_IGNORE);
        return res != -1;
    }

    public boolean studentExists(String id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(TBL_STUDENTS, new String[]{COL_STUDENT_ID}, COL_STUDENT_ID + "=?", new String[]{id}, null, null, null);
        boolean exists = c.moveToFirst();
        c.close();
        return exists;
    }

    public String getStudentName(String id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(TBL_STUDENTS, new String[]{COL_STUDENT_NAME}, COL_STUDENT_ID + "=?", new String[]{id}, null, null, null);
        String name = c.moveToFirst() ? c.getString(0) : null;
        c.close();
        return name;
    }

    public void markAttendance(String studentId, String timestamp) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_ATT_STUDENT_ID, studentId);
        cv.put(COL_ATT_TIMESTAMP, timestamp);
        db.insert(TBL_ATTENDANCE, null, cv);
    }

    public List<String> getAttendanceRows() {
        List<String> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT a." + COL_ATT_TIMESTAMP + ", a." + COL_ATT_STUDENT_ID + ", s." + COL_STUDENT_NAME +
                " FROM " + TBL_ATTENDANCE + " a LEFT JOIN " + TBL_STUDENTS + " s ON a." + COL_ATT_STUDENT_ID + "=s." + COL_STUDENT_ID +
                " ORDER BY a." + COL_ATT_ID + " DESC";
        Cursor c = db.rawQuery(sql, null);
        while (c.moveToNext()) {
            String ts = c.getString(0);
            String id = c.getString(1);
            String name = c.getString(2) != null ? c.getString(2) : "Unknown";
            list.add(ts + " • " + id + " • " + name);
        }
        c.close();
        return list;
    }
}
