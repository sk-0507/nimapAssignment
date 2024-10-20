# Product-Category crud Application

This project is a simple e-commerce application built with Spring Boot, Hibernate, and JPA. It allows users to manage categories and products with support for pagination and lazy loading.

## Table of Contents
1. [Prerequisites](#prerequisites)
2. [Installation](#installation)
3. [Configuration](#configuration)
4. [Running the Application](#running-the-application)
5. [API Endpoints](#api-endpoints)
6. [Testing](#testing)
7. [License](#license)

## Prerequisites

Make sure you have the following installed on your machine:
- Java Development Kit (JDK) 11 or later
- Maven
- PostgreSQL (or any other database you prefer)

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/e-commerce-app.git
   cd e-commerce-app
## configuration

spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password

## running-the-application
mvn clean install

## api-endpoints
**API Endpoints**
1. **Categories**:
- Create Category: POST /api/categories
- Get All Categories: GET /api/categories
- Get Category by ID: GET /api/categories/{id}
- Update Category: PUT /api/categories/{id}
- Delete Category: DELETE /api/categories/{id}
2. **Products**:
- Create Product: POST /api/products
- Get Products by Category: GET /api/products/category/{categoryId}?page={pageNumber}&size={pageSize}
- Get Product by ID: GET /api/products/{id}
- Update Product: PUT /api/products/{id}
- Delete Product: DELETE /api/products/{id}

## testing
mvn test
## license

Feel free to replace placeholders like `your-username`, `your_database_name`, `your_username`, and `your_password` with actual values as needed!
