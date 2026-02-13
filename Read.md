🚗 Vehicle Rental System (Java + SQLite)
👥 Team Members

Afin Sabu

Adithyan PM

📌 Problem Statement

Manual vehicle rental calculation is time-consuming and error-prone.
This project provides an automated Vehicle Rental System with database support to manage rental records efficiently.

🎯 Objective

To develop a Java application that demonstrates:

Object-Oriented Programming (OOP)

Java Swing GUI

Exception Handling

Multithreading

Database Connectivity using JDBC (SQLite)

🛠 Technologies Used

Java

Java Swing

SQLite Database

JDBC (SQLite JDBC Driver)

OOP Concepts

🧱 OOP Concepts Used

Encapsulation

Inheritance

Polymorphism

Abstraction

Separate classes for:

Vehicle

Car

Bike

DBConnection

VehicleRentalSystem

🗄 Database Details

Database: SQLite

File Name: vehicle_rental.db

Table Name: rentals

Table Structure:
Column Name	Data Type
id	INTEGER (Primary Key)
customer_name	TEXT
vehicle_type	TEXT
days	INTEGER
total_rent	REAL

The database file is automatically created when the program runs.

✨ Features

Vehicle selection (Car / Bike)

Rent calculation based on number of days

Input validation with error messages

Data stored in SQLite database

Automatic table creation

User-friendly GUI

▶ How to Run the Program
Step 1: Compile
javac -cp ".;sqlite-jdbc-3.51.2.0.jar" *.java

Step 2: Run
java -cp ".;sqlite-jdbc-3.51.2.0.jar" VehicleRentalSystem


(Use : instead of ; for Mac/Linux)

🧪 Sample Input

Customer Name: John
Vehicle Type: Car
Rental Days: 3

📤 Sample Output

Customer: John
Vehicle: Car
Days: 3
Total Rent: ₹3000

Data is saved in SQLite database automatically.

📸 Screenshots

Add your screenshots inside a screenshots folder.

Example:

Home Screen

Output Screen

Database View

📚 Course Outcome (CO5)

This project satisfies:

Object-Oriented Design

GUI Development

Exception Handling

Multithreading

Database Connectivity using JDBC