📘 Employee Management System – Java Servlets & JDBC

This is a simple and beginner-friendly Employee Management System built using
Java Servlets, JSP, JDBC, HTML, CSS, JavaScript, and Apache Tomcat.

The main goal of this project is to understand how a web application works using:

Java Servlets (backend logic)

JSP/HTML (frontend pages)

JDBC (database connection to MySQL)

Tomcat server (application deployment)

🚀 What This Project Does
✔ User Features

Create Account (User Registration)

Login with Email & Password

View your details

Update your details

Logout

✔ Admin Features

Login as Admin

View all employees

Update employee details

Delete employee

Add new employee

Logout

✔ Backend Features

Secure database connection using JDBC + PreparedStatement

Proper Servlet routing for each operation

Validations and error handling

Clean folder structure under src/main/java & src/main/webapp

🛠️ Tech Stack Used
Layer	Technology
Backend Logic	Java Servlets
Database	MySQL + JDBC
Server	Apache Tomcat
Frontend	HTML, CSS, JavaScript
Build Structure	Maven-style folder structure
IDE Supported	Eclipse / IntelliJ / NetBeans
📂 Project Structure (Simple Overview)
employee-management-servlet
│
├── src/main/java/employemanagement
│       └── All .java servlet files
│
├── src/main/webapp
│       ├── HTML pages (login, create account, home…)
│       ├── WEB-INF/web.xml
│       └── WEB-INF/lib (JDBC Drivers)
│
└── README.md

🔧 How to Run This Project
1️⃣ Install the requirements

JDK 8 or above

Apache Tomcat (8, 9, or 10)

MySQL

Add MySQL Connector JAR to WEB-INF/lib

2️⃣ Import project into your IDE

Open Eclipse / IntelliJ

Select: Import → Existing Project → Select folder

3️⃣ Configure Database

Create a MySQL database:

CREATE DATABASE employeedb;


Create tables based on your project logic
(Users, Admin, Employee table, etc.)

Update database URL, username, password in your servlet code.

4️⃣ Run on Tomcat

Right-click project → Run As → Run on Server

Choose Tomcat

Project starts automatically

5️⃣ Open in Browser
http://localhost:8080/employemanagement/index.html

📌 Why This Project is Useful

Helps understand core Java web development

Shows how Servlets, JSP, JDBC work together

Good practice for mini-projects / academic submissions

Great for beginners learning Java web applications

🙌 Author

Gowtham Teja
Java Developer | Servlet & JDBC Projects | Learning Full Stack
