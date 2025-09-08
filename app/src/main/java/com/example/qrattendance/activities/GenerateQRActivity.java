package com.example.qrattendance.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qrattendance.R;
import com.example.qrattendance.database.DatabaseHelper;
import com.example.qrattendance.utils.QRUtils;

public class GenerateQRActivity extends AppCompatActivity {
    private ImageView ivQR;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);
        db = new DatabaseHelper(this);

        EditText etId = findViewById(R.id.etStudentId);
        EditText etName = findViewById(R.id.etStudentName);
        Button btnGenerate = findViewById(R.id.btnGenerate);
        ivQR = findViewById(R.id.ivQR);

        btnGenerate.setOnClickListener(v -> {
            String id = etId.getText().toString().trim();
            String name = etName.getText().toString().trim();
            if (id.isEmpty() && name.isEmpty()) {
                Toast.makeText(this, "Enter ID & Name", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean added = db.addStudent(id, name);
            if (!added && !db.studentExists(id)) {
                Toast.makeText(this, "Error saving student", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                Bitmap bmp = QRUtils.generateQRCode(id, 900);
                ivQR.setImageBitmap(bmp);
                Toast.makeText(this, "QR Generated for " + name, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
