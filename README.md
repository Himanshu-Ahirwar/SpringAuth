Spring Boot JWT Authentication API
This project is a complete and ready-to-use REST API for user registration and login, built with Spring Boot. It uses JSON Web Tokens (JWT) for securing endpoints and follows modern best practices for API development.

Features
User Registration: Securely register new users with encrypted passwords.

User Login: Authenticate users and issue a stateless JWT for accessing protected routes.

JWT Security: Endpoints are protected using a JWT authentication filter.

Password Encryption: Passwords are hashed using BCrypt before being stored.

DTO Pattern: Uses Data Transfer Objects (DTOs) to separate API logic from the data model.

Global Exception Handling: Provides consistent and clean error responses for all API exceptions.

Validation: Implements request validation for incoming data.

Technologies Used
Java 21

Spring Boot 3.1.4

Spring Web

Spring Data JPA

Spring Security

MySQL: Relational database for storing user data.

Hibernate: JPA implementation for data persistence.

jjwt: Java library for creating and parsing JSON Web Tokens.

Lombok: Reduces boilerplate code for model classes.

ModelMapper: Simplifies object mapping between entities and DTOs.

Maven: Dependency Management

Prerequisites
Before you begin, ensure you have the following installed on your system:

JDK 21 or later

Maven 3.2+

MySQL Server

Setup and Installation
Clone the repository:

git clone https://github.com/Himanshu-Ahirwar/SpringAuth.git
cd SpringAuth

Create the MySQL Database:
Log in to your MySQL server and run the following command to create the required database:

CREATE DATABASE jwtdb;

Configure the Application:
Open the src/main/resources/application.properties file and update the database credentials and JWT secret.

# Database settings
spring.datasource.url=jdbc:mysql://localhost:3306/jwtdb
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

# JWT settings
jwt.secret=ReplaceThisWithAStrongSecretKeyOfAtLeast256Bits
jwt.expiration-ms=3600000

Run the application:
Use the Maven wrapper to build and run the project.

mvn spring-boot:run

The application will start on http://localhost:8080.

API Endpoints
Authentication
1. Register a New User
Method: POST

URL: /api/auth/register

Body (raw/json):

{
  "fullName": "Test User",
  "email": "test@example.com",
  "password": "password123"
}

Success Response (201 Created):

{
    "id": 1,
    "email": "test@example.com",
    "fullName": "Test User",
    "role": "ROLE_USER"
}

2. Log In
Method: POST

URL: /api/auth/login

Body (raw/json):

{
  "email": "test@example.com",
  "password": "password123"
}

Success Response (200 OK):

{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0Z..."
}

Accessing Protected Routes
To access any protected endpoint, include the JWT in the Authorization header.

Header: Authorization

Value: Bearer <your_jwt_token>
