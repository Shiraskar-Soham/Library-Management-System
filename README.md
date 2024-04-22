# Library-Management-System
# Java Assignment Problem Statement

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

**Deadline:**

**5** days from receiving this assignment.

### **How to submit this:**

Put it on Github and share the repository link at [tech@olik.in](mailto:tech@olik.in)