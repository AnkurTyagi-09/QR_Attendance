package com.example.qrattendance.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qrattendance.R;

public class AdminDashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        Button btnGen = findViewById(R.id.btnGenerateQR);
        Button btnReport = findViewById(R.id.btnReport);

        btnGen.setOnClickListener(v -> startActivity(new Intent(this, GenerateQRActivity.class)));
        btnReport.setOnClickListener(v -> startActivity(new Intent(this, AttendanceReportActivity.class)));
    }
}
