package com.example.qrattendance.models;

public class Attendance {
    public String studentId;
    public String timestamp;
    public String name;

    public Attendance(String studentId, String timestamp, String name) {
        this.studentId = studentId;
        this.timestamp = timestamp;
        this.name = name;
    }
}
