Library Management System
Overview
The Library Management System is a Java-based project that simulates basic library operations such as adding books, searching books, borrowing books, and returning books. The system is designed to handle different types of users like students and faculty members, each having their own functionalities.

This system provides a command-line interface to interact with the library and includes JUnit tests to verify the functionality of core operations.

Features
Book Management: Add, search, sort, and manage books in the library.
User Management: Handles different user types (Students and Faculty) with unique capabilities.
Borrowing/Returning Books: Allows users to borrow and return books.
Sorting Functionality: Sorts books by title, author, or ISBN.
Exception Handling: Includes custom exceptions such as InvalidBookException and BookNotFoundException.
System Requirements
Java JDK 8 or higher
JUnit 3.8+ (for testing purposes)
Project Structure
library_management_system/
│
├── src/
│   ├── Book.java
│   ├── Faculty.java
│   ├── InvalidBookException.java
│   ├── Library.java
│   ├── LibraryUser.java
│   ├── Student.java
│   └── Main.java
│
├── test/
│   └── LibraryTest.java
│
└── README.md
How to Run
Clone the repository:


git clone https://github.com/niteboy17/Library-Management-System
Compile the source code: Navigate to the src/ directory and compile all the Java files:


javac *.java
Run the application: Execute the Main class to start the system:

java library_management_system.Main
How to Test
JUnit is used for unit testing. The tests cover various scenarios, such as adding, searching, borrowing, and returning books.

Steps to Run Tests:
Compile the tests: Navigate to the test/ directory and compile the LibraryTest class:


javac -cp .:/path-to-junit/junit.jar LibraryTest.java
Run the tests: Use the following command to execute the JUnit tests:


java -cp .:/path-to-junit/junit.jar junit.textui.TestRunner library_management_system.LibraryTest
Test Cases
testAddBook(): Verifies that a new book can be added without errors.
testSearchBook(): Ensures that searching for an existing book returns the correct result.
testSearchNonExistentBook(): Ensures searching for a non-existent book returns null.
testBorrowBook(): Tests that borrowing a book removes it from the available list.
testReturnBook(): Ensures that returning a book adds it back to the available list.
testSortBookByTitle(): Verifies that books are sorted correctly by title.
testSortBookByAuthor(): Verifies that books are sorted correctly by author.
testSortBookByIsbn(): Verifies that books are sorted correctly by ISBN.
Exception Handling
InvalidBookException
This exception is thrown when a book has invalid details such as missing title or author.

BookNotFoundException
Thrown when a requested book is not found in the library catalog (during borrowing operations).

Future Improvements
Implement a graphical user interface (GUI) for better user experience.
Add more user roles with varying privileges.
Integrate a database to persist data beyond runtime.
