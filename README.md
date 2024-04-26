# Library-Management-System
# Java Assignment Problem Statement

### **Steps to Run**
1) Open the file .run/Local.run.xml 
2) Its a Configuration file so Run it in order to start the server or Directly run the Application file : com/example/libraryManagementSystem/LibraryManagementSystemApplication.java from IDE (IntelliJ used by me)
3) JDK 21 is used for this project
4) Mysql Data base is used and should be running on port 3306 on your local machine
5) lmsdb database will be created on server startup
6) Postman Collection of APIs are shared : API Collection - https://api.postman.com/collections/33561225-fe71e962-a850-4eff-aa48-66023d97f1ee?access_key=PMAT-01HWB1YWN137F5EREQ32RV7WPS



### **Task**

Create a Spring Boot application that provides RESTful endpoints to manage a book library. The application should support CRUD operations for books, authors, and book rentals.

### **Requirements**

1. **Data Models**:
    - **`Book`**: Contains fields like **`id`**, **`title`**, **`author`**, **`isbn`**, and **`publicationYear`**.
    - **`Author`**: Contains fields like **`id`**, **`name`**, and **`biography`**.
    - **`Rental`**: Represents a book rental, with fields **`id`**, **`bookId`**, **`renterName`**, **`rentalDate`**, and **`returnDate`**.
2. **RESTful Endpoints**:
    - CRUD operations for **`Book`**.
    - CRUD operations for **`Author`**.
    - Create and retrieve **`Rental`** records.
    - Endpoints to retrieve books by author, books available for rent, and books currently rented.
3. **Business Logic**:
    - When renting a book, ensure the book is not already rented.
    - When returning a book, mark it as available.
    - Implement a method to check for overdue rentals (rental periods exceeding a set time, e.g., 14 days).
4. **Testing**:
    - Write basic unit tests to verify core business logic and RESTful endpoints.
    - Consider integration tests to ensure endpoints work as expected with the database.
5. **Error Handling and Validation**:
    - Implement proper error handling for invalid requests.
    - Validate inputs to ensure required fields are provided, and values are in the correct format (e.g., ISBN, dates).
6. **Documentation**:
    - Provide a README file with setup instructions, how to run the application, and sample requests to test the endpoints.
    - Include any additional documentation explaining design decisions or assumptions made during development.

### **Tech:**
Spring Boot, Any Database
