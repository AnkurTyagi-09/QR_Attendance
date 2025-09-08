package com.example.qrattendance.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qrattendance.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etUser = findViewById(R.id.etUser);
        EditText etPass = findViewById(R.id.etPass);
        ToggleButton roleToggle = findViewById(R.id.toggleRole);
        Button btnLogin = findViewById(R.id.btnLogin);

        etPass.setEnabled(false);

        roleToggle.setOnCheckedChangeListener((button, checked) -> {
            if (checked) {
                etPass.setEnabled(true);
            } else {
                etPass.setEnabled(false);
                etPass.setText("");
            }
        });

        btnLogin.setOnClickListener(v -> {
            boolean admin = roleToggle.isChecked();
            String user = etUser.getText().toString().trim();
            String pass = etPass.getText().toString().trim();

            if (admin) {
                if ("admin".equalsIgnoreCase(user) && "admin123".equals(pass)) {
                    startActivity(new Intent(this, AdminDashboardActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, "Invalid admin credentials", Toast.LENGTH_SHORT).show();
                }
            } else {
                if (user.isEmpty()) {
                    Toast.makeText(this, "Enter Student ID", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(this, StudentDashboardActivity.class);
                    i.putExtra("student_id", user);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
