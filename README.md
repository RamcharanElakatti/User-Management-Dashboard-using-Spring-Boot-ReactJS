# 👤 User Management Dashboard using Spring Boot & ReactJS

Full-stack application using Spring Boot and ReactJS that fetches user data from an external API, stores it in a database, and provides a responsive UI with search, sort, and popup detail views.

---

## 🚀 Project Overview

This project demonstrates integration between a **Spring Boot backend** and a **ReactJS frontend**. It fetches data from an external API ([DummyJSON Users API](https://dummyjson.com/users)), stores it in a local database, and provides user-friendly interfaces to:

- View all users
- Search users by name or email
- Sort users by ID, name, or email
- View detailed information in a popup modal

---

## 🧰 Tech Stack

### 🔹 Frontend
- ReactJS
- HTML/CSS (Bootstrap)
- Axios

### 🔸 Backend
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL / PostgreSQL / H2
- REST APIs

---

## ✅ Features

### 🔙 Spring Boot Backend
- Fetches users from `https://dummyjson.com/users` and stores them in the database
- Exposes REST APIs:
  - `GET /api/users` – Fetch all users
  - `GET /api/users/search?query=` – Search users by name or email
  - `GET /api/users/{id}` – Get user details by ID

### 🖥️ ReactJS Frontend
- Loads and displays all users on page load
- Implements sorting (ID, name, email – UI-side)
- Search functionality by name or email
- Clickable user ID that opens a modal popup with full details

---

## 📸 Screenshots

![image](https://github.com/user-attachments/assets/55118b0d-ceb4-456f-863f-7d6084bd9c16)
![image](https://github.com/user-attachments/assets/b7404f4e-a0c2-48db-8126-db73f92172c7)
![image](https://github.com/user-attachments/assets/95b17594-0ad4-4748-9164-44c2b23b707d)
![image](https://github.com/user-attachments/assets/8421c61c-ce59-445d-a297-da48f515fd5b)



![image](https://github.com/user-attachments/assets/d6dbce24-8ce7-4365-8a09-dddd8bddfb06)



---

## 🔧 Getting Started

### 📥 Prerequisites

- Java 17+
- Node.js & npm
- MySQL / PostgreSQL / H2 Database

---

### 🛠️ Backend Setup (Spring Boot)

1. Clone the repository and navigate to the backend folder
2. Configure `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Run the backend application:

bash
Copy
Edit
./mvnw spring-boot:run
💻 Frontend Setup (ReactJS)
Navigate to the frontend directory:

bash
Copy
Edit
cd frontend
Install dependencies:

bash
Copy
Edit
npm install
Start the development server:

bash
Copy
Edit
npm start

🙌 Acknowledgements
DummyJSON API for sample user data

Spring Boot and ReactJS open-source communities

📬 Contact
For queries or collaboration:

📧 ramcharanelakatti@gmail.com

