# Spring Boot JWT Authentication API

This project is a complete and ready-to-use REST API for **user registration** and **login**, built with **Spring Boot**.  
It uses **JSON Web Tokens (JWT)** for securing endpoints and follows modern best practices for API development.

---

## 🚀 Features

- **User Registration** – Securely register new users with encrypted passwords.
- **User Login** – Authenticate users and issue a stateless JWT for accessing protected routes.
- **JWT Security** – Endpoints are protected using a JWT authentication filter.
- **Password Encryption** – Passwords are hashed using BCrypt before being stored.
- **DTO Pattern** – Uses Data Transfer Objects (DTOs) to separate API logic from the data model.
- **Global Exception Handling** – Consistent and clean error responses for all API exceptions.
- **Validation** – Implements request validation for incoming data.

---

## 🛠 Technologies Used

- Java 21  
- Spring Boot 3.1.4  
- Spring Web  
- Spring Data JPA  
- Spring Security  
- MySQL – Relational database for storing user data  
- Hibernate – JPA implementation for data persistence  
- [jjwt](https://github.com/jwtk/jjwt) – Java library for creating and parsing JSON Web Tokens  
- Lombok – Reduces boilerplate code for model classes  
- ModelMapper – Simplifies object mapping between entities and DTOs  
- Maven – Dependency management  

---

## 📋 Prerequisites

Before you begin, ensure you have installed:

- JDK 21 or later  
- Maven 3.2+  
- MySQL Server  

---

## ⚙️ Setup and Installation

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Himanshu-Ahirwar/SpringAuth.git
cd SpringAuth
