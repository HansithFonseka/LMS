Library Management System

This is a simple Library Management System developed in Java. It allows users to manage books, members, and book lending operations efficiently. The system provides basic functionalities such as adding and removing books, registering members, lending and returning books, viewing lending information, and calculating overdue fines.

Features
Add and remove books
Register and remove members
Lend and return books
Search books and members by ID
View lending information for members
Calculate overdue fines
Classes
The system consists of three main classes:

LibraryManagementSystem: Manages the books, members, and lending operations.
Book: Represents a book with properties such as ID, title, author, and lending status.
Member: Represents a library member with properties like ID, name, and a list of borrowed books.
Getting Started
Prerequisites
Java Development Kit (JDK) installed.
IDE (such as IntelliJ IDEA, Eclipse) or a text editor with Java support.
Running the Application
Clone the repository to your local machine:
bash
Copy code
git clone https://github.com/your-username/library-management-system.git
Open the project in your preferred IDE.
Compile and run the LibraryManagementSystem.java file.
Follow the instructions in the console to manage the library.
Usage
When running the application, a menu will be displayed with options to manage books, members, and lending operations. You can interact with the system by entering the corresponding option number for each operation.

Example Operations
Add a Book: Input book ID, title, and author.
Register a Member: Input member ID and name.
Lend a Book: Input book ID and member ID to lend a book.
Return a Book: Input book ID and member ID to return a book.
Fine Calculation
The system calculates fines based on the number of overdue days:

50 units per day for the first 7 days.
100 units per day for additional days beyond 7.
Future Enhancements
Implement displaying overdue books.
Add graphical user interface (GUI) support.
Integrate database functionality for persistent storage.
License
This project is open source and available under the MIT License.
