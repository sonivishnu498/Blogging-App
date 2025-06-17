# 📝 Personal Blogging App

A simple personal blogging web application built using **Java**, **Spring Boot**, **Thymeleaf**, and **file-based JSON storage**.

---

## 🚀 Features

### 👥 Guest Section
- ✅ View all published articles on the homepage
- ✅ Read full article with publication date

### 🔐 Admin Section
- ✅ Login with hardcoded credentials
- ✅ Add new articles
- ✅ Edit existing articles
- ✅ Delete articles
- ✅ Logout session

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Thymeleaf**
- **Lombok**
- **Jackson**
- **HTML & CSS**
- **File-based JSON storage** (no database used)

---

## 🗂 Project Structure

blogging-app/
├── model/ # Article model
├── controller/ # Guest, Admin, Login controllers
├── util/ # File-based Article storage utility
├── templates/ # Thymeleaf HTML templates
├── static/css/ # CSS styles
└── application.properties


---

## 🔧 Setup & Run

### 1. Clone the repo
```bash
git clone https://github.com/sonivishnu498/Blogging-App.git
cd Blogging-App

Build the project
./mvnw clean install

Run the app
./mvnw spring-boot:run

🔑** Admin Login**
Username: admin
Password: password

