package com.example.qrattendance.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qrattendance.R;
import com.example.qrattendance.adapters.AttendanceAdapter;
import com.example.qrattendance.database.DatabaseHelper;

import java.util.ArrayList;

public class AttendanceReportActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_report);

        RecyclerView rv = findViewById(R.id.rvAttendance);
        rv.setLayoutManager(new LinearLayoutManager(this));

        DatabaseHelper db = new DatabaseHelper(this);
        AttendanceAdapter adapter = new AttendanceAdapter(new ArrayList<>(db.getAttendanceRows()));
        rv.setAdapter(adapter);
    }
}
