E-Commerce Product Management System

A Java-based console application designed to manage product information and inventory using Core Java, Data Structures and Algorithms (DSA), and File Handling.

📌 About the Project

The E-Commerce Product Management System is a simple and efficient application that helps users manage product records. It allows users to add, view, search, sort, and update product stock through a menu-driven interface.

The application uses "HashMap" and "ArrayList" for product management and stores records permanently in a text file using file handling.

✨ Features

- Add Product: Add new products with automatically generated product IDs.
- View Products: Display all available product records.
- Search Products: Search products using product ID or category.
- Sort Products: Sort products by price in ascending order.
- Update Stock: Modify the stock quantity of an existing product.
- File Handling: Save and load product information using "products.txt".
- Input Validation: Handle invalid inputs and prevent incorrect product details.

🛠️ Technologies Used

Technology| Purpose
Java| Programming language
HashMap| Store and access products
ArrayList| Manage product collections
Collections Framework| Sorting product records
File Handling| Permanent data storage
Scanner| User input

📂 Project Structure

E-Commerce-Product-Management-System/
│
├── ECommerceProductManagement.java
├── products.txt
└── README.md

⚙️ System Requirements

- Java JDK 8 or above
- VS Code, Eclipse, or any Java-supported IDE
- Windows, Linux, or macOS
- Minimum 4 GB RAM

🖥️ Application Menu

===== E-COMMERCE PRODUCT MANAGEMENT SYSTEM =====

1. Add Product
2. View All Products
3. Search Product
4. Sort Products by Price
5. Update Stock
6. Exit

Enter your choice:

📊 Data Storage Format

Product records are stored in "products.txt" using the following format:

ProductID|ProductName|Category|Price|Stock

Example:

P101|Wireless Mouse|Electronics|799.0|20
P102|Keyboard|Electronics|999.0|15

⏱️ Time Complexity

Operation| Average Time Complexity
Add Product| O(1)
View Products| O(N)
Search by ID| O(1)
Search by Category| O(N)
Sort Products| O(N log N)
Update Stock by ID| O(1)

Note: File loading and saving take O(N) time.

🔮 Future Enhancements

- Database integration using MySQL or PostgreSQL.
- Graphical User Interface (GUI).
- User authentication and admin dashboard.
- Online payment integration.
- Product image management.
- Web-based product management system.

🎯 Learning Outcomes

Through this project, I gained practical experience in:

- Object-Oriented Programming in Java.
- Implementing HashMap and ArrayList.
- Searching and sorting algorithms.
- File handling and data persistence.
- Input validation and modular programming.
- Developing a menu-driven application.

👨‍💻 Author

Gaganjeet Singh

- Course: B.Tech – Computer Science and Engineering
- Specialization: Artificial Intelligence and Machine Learning

📄 License

This project is developed for educational and learning purposes.
