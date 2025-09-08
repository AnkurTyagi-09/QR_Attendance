package com.example.qrattendance.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qrattendance.R;

public class StudentDashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        String sid = getIntent().getStringExtra("student_id");
        TextView tvWelcome = findViewById(R.id.tvWelcome);
        Button btnScan = findViewById(R.id.btnScanNow);

        if (sid != null && !sid.isEmpty()) {
            tvWelcome.setText("Logged in as: " + sid);
        }

        btnScan.setOnClickListener(v -> startActivity(new Intent(this, ScanQRActivity.class)));
    }
}
