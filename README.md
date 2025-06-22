Student Placement Tracker – Java Console Application
A robust and beginner-friendly Java console application designed to help students efficiently track and manage their placement journey. Built using Object-Oriented Programming principles and core Java features like file handling, collections, and command-line interaction.

Developed by Md Fahim (Alex) — B.Tech Final Year Student, Information Technology
Project Overview
The Student Placement Tracker provides a simple yet effective way for students to record placement opportunities, manage application statuses, and keep an overview of their progress — all through a command-line interface.
Key Features
•	• Secure admin login with password protection (default: admin123)
•	• Add new placement records with company, role, package, date, and status
•	• View all placement entries in a clean tabular format
•	• Update the status of existing applications (Applied / Selected / Rejected)
•	• Delete unwanted or incorrect records
•	• Search placements by company name
•	• Filter placements based on current status
•	• View summary statistics (total count, selection rate, average package)
•	• Export placement data to .csv format
•	• Generate sample data for testing and demonstration
•	• Save and retrieve records using plain text file storage
Tech Stack
•	• Language: Java (JDK 8+)
•	• Concepts Used: OOP, Collections (ArrayList), File I/O, Date parsing
•	• Environment: Console/Terminal
•	• File Formats: .txt, .csv
Folder Structure
student-placement-tracker/
├── model/                         # Contains Placement.java (data model)
├── util/                          # Contains FileManager.java (file handling utilities)
├── Main.java                      # Main controller class
├── Student.java                   # Optional student record handler
├── *.txt / *.csv                  # Data files
├── Student Placement Tracker.pdf  # Documentation
├── README.md                      # This file
How to Run This Project
•	• Clone or download the repository.
•	• Open terminal or command prompt in the project directory.
•	• Compile the main file: javac Main.java
•	• Run the application: java Main
•	• Ensure all .java files are in the correct folder structure.
Sample Output
==== MENU ====
1. Add Placement
2. View All Placements
3. Exit

--- All Placements ---
Company              Role            Package    Interview Date  Status
--------------------------------------------------------------------------
Google               SDE             12.50       10/07/2025      Selected
Future Enhancements
•	• Develop a GUI version using Java Swing or JavaFX
•	• Extend to web-based version using Spring Boot or MERN
•	• Add user authentication with roles (Student/Admin)
•	• Connect to a relational database like MySQL/PostgreSQL
•	• Enable analytics dashboard with charts and placement insights
Project Motivation
This project was created as part of my final year placement preparation to:
- Strengthen Java fundamentals
- Solve a real student problem
- Demonstrate practical application of OOP and file handling



## 📫 Connect with Me

**Md Fahim (Alex)**  
- 📍 B.Tech IT, Final Year  
- 🌐 [GitHub](https://github.com/alexfahim10)  
- 💬 DM me for collaboration or feedback!

---

⭐ If you liked this project, give it a star and share!
