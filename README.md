# 📱 Android Multi-Module Application

A modular Android application developed using **Android Studio, Kotlin, XML, Firebase, and SQLite**.

The project brings together multiple independently developed Android modules into a single application, demonstrating authentication, local database management, cloud services, real-time data synchronization, device settings integration, and interactive application features.

---

## 📌 Project Overview

The application was developed as a collection of independent modules and later integrated into a common dashboard.

The major modules include:

- 🔐 Firebase Login & Registration
- 🗄️ SQLite Login & Registration
- 🧮 Calculator
- 📶 WiFi Settings Integration
- 📝 Quiz
- ☁️ Firebase Realtime Database
- 🏠 Integrated Dashboard

Each module was developed and tested independently before being integrated into the final application.

---

## ✨ Features

### 🔐 Firebase Authentication

Provides cloud-based user authentication using Firebase Authentication.

Users can:

- Register using email and password
- Log in using existing credentials
- Receive validation and authentication error messages
- Maintain authentication state between app launches

Firebase handles authentication and password storage on the server side rather than storing Firebase authentication passwords directly in the application.

---

### 🗄️ SQLite Authentication

Provides an offline/local authentication mechanism using SQLite.

Features include:

- User registration
- Local user storage
- Login verification
- Unique email constraint
- SQLite database management using `SQLiteOpenHelper`
- Parameterized SQL queries

This module demonstrates local database-based authentication without requiring an internet connection.

---

### 🧮 Calculator

A basic arithmetic calculator supporting:

- Addition
- Subtraction
- Multiplication
- Division

The module also handles invalid input and division-by-zero situations without crashing the application.

---

### 📶 WiFi Module

Provides quick access to the device's WiFi settings.

The implementation takes Android version differences into account:

- Android 10 (API 29) and above use the system WiFi settings panel
- Older Android versions use the WiFi settings screen

This demonstrates working with Android system settings and API-level compatibility.

---

### 📝 Quiz Module

A multiple-choice quiz engine that:

- Displays questions sequentially
- Provides multiple answer options
- Checks selected answers
- Maintains the score
- Displays the final result

Questions are represented using a model structure containing question text, options, and the correct answer index.

---

### ☁️ Firebase Realtime Database

Allows user profile information such as:

- Name
- Phone number

to be stored in Firebase Realtime Database.

The module demonstrates:

- Writing data using `setValue()`
- Reading data using listeners
- Firebase database references
- User-specific data paths
- Real-time synchronization

---

### 🏠 Integrated Dashboard

All modules are connected through a common dashboard.

After authentication, users can select the required module and navigate to the corresponding Activity.

The dashboard uses a shared navigation approach so additional modules can be integrated without duplicating large amounts of navigation code.

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| **Kotlin** | Application development |
| **Android Studio** | Development environment |
| **XML** | UI layouts |
| **Android SDK** | Android platform APIs |
| **Firebase Authentication** | Cloud authentication |
| **Firebase Realtime Database** | Cloud data synchronization |
| **SQLite** | Local database and authentication |
| **Gradle** | Project and dependency management |

---

## 🏗️ Application Architecture

The application follows a modular Activity-based structure.

```text
                     ┌──────────────────────┐
                     │   Login / Register   │
                     └──────────┬───────────┘
                                │
                 ┌──────────────┴──────────────┐
                 │                             │
                 ▼                             ▼
        ┌─────────────────┐          ┌─────────────────┐
        │ Firebase Auth   │          │ SQLite Auth     │
        └────────┬────────┘          └────────┬────────┘
                 │                             │
                 └──────────────┬──────────────┘
                                ▼
                     ┌──────────────────────┐
                     │      Dashboard       │
                     └──────────┬───────────┘
                                │
          ┌─────────────┬───────┼────────┬─────────────┐
          ▼             ▼       ▼        ▼             ▼
      Calculator       Quiz    WiFi   Realtime DB   SQLite
