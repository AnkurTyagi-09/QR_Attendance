# 📱 QR Attendance App

QR Attendance is an **Android-based attendance management system** that
uses QR codes for quick, secure, and efficient student or employee
check-ins. It eliminates manual attendance tracking and provides an
easy-to-use digital solution.

------------------------------------------------------------------------

## 🚀 Features

-   🔐 **Login System** -- Admin and student login functionality (via
    `LoginActivity`).\
-   📊 **Admin Dashboard** -- Manage students, generate QR codes, and
    view attendance reports.\
-   🎓 **Student Dashboard** -- Students can scan QR codes to mark
    attendance.\
-   📷 **QR Code Scanner** -- Real-time scanning using the device
    camera.\
-   📝 **Attendance Reports** -- Admin can view and export attendance
    records.\
-   📱 **Modern UI** -- Built with Material Design for a clean and
    simple interface.

------------------------------------------------------------------------

## 🛠️ Tech Stack

-   **Language:** Java (Android)\
-   **Framework:** Android SDK\
-   **QR Code Library:** ZXing / ML Kit (depending on implementation)\
-   **Database:** SQLite / Firebase (depending on implementation)

------------------------------------------------------------------------

## 📂 App Structure

Main Activities in the app: - `LoginActivity` → User authentication
(Admin/Student)\
- `AdminDashboardActivity` → Admin control panel\
- `GenerateQRActivity` → Generate unique QR codes\
- `StudentDashboardActivity` → Student home screen\
- `ScanQRActivity` → Scan QR codes to mark attendance\
- `AttendanceReportActivity` → View attendance records\
- `CustomCaptureActivity` → Camera customization for scanning

------------------------------------------------------------------------

## 🔑 Default Login Credentials

Use the following credentials to log in for testing:

-   **Admin Login**
    -   Username/ID: `admin`\
    -   Password: `admin123`
-   **Student Login**
    -   Username/ID: `student`\

*(You can modify these credentials in the `LoginActivity.java` file or
database as needed.)*

------------------------------------------------------------------------

## ⚙️ Installation & Setup

1.  Clone the repository:

    ``` bash
    git clone https://github.com/yourusername/qr-attendance.git
    ```

2.  Open in **Android Studio**.\

3.  Sync Gradle files.\

4.  Connect a device or use an emulator.\

5.  Run the project:

    ``` bash
    ./gradlew installDebug
    ```

------------------------------------------------------------------------

## 👨‍💻 Author

Developed by **Ankur Tyagi**

------------------------------------------------------------------------

## 📜 License

This project is licensed under the MIT License -- feel free to use and
modify.
