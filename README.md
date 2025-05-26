# 🎓 Student Management System (Java + Swing + MySQL)

A simple **Student Management System** built using **Java (Swing GUI)** and **MySQL database**, applying core Object-Oriented Programming (OOP), JDBC integration, and real GUI forms.

> 🚧 This project is currently in development. More features are being added regularly.

---

## 🧰 Features (Built So Far)

✅ View all students from MySQL using a `JTable`  
✅ Add a new student through a Swing form (`StudentForm.java`)  
✅ Delete a student by ID (`StudentDeleteForm.java`)  
✅ Object-oriented design using inheritance and composition  
✅ JDBC integration for MySQL (via `Database.java`)

---

## 📁 Project Structure

universitysystem/
│
├── db/ # MySQL DB connection and logic
│ └── Database.java
│
├── gui/ # Java Swing forms (GUI)
│ ├── StudentForm.java
│ ├── StudentListView.java
│ └── StudentDeleteForm.java
│
├── manager/ # Business logic (e.g., Honor Roll)
│ └── HonorRollManager.java
│
├── model/ # OOP entities
│ ├── Student.java
│ ├── HonorStudent.java
│ ├── Professor.java
│ ├── Course.java
│ └── Person.java
│
└── main/ # Entry point and system setup
└── Main.java
