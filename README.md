# Skill-3 - Spring Boot Product Management Application

A Spring Boot application built with Spring Data JPA and MySQL for product management. This project demonstrates the implementation of a RESTful service architecture with persistent data storage.

> **Note:** The internal project name is `skill2` as defined in the Maven configuration, while the repository is named `skill-3`.

## 📋 Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Contributing](#contributing)
- [License](#license)

## ✨ Features

- Product entity management
- Spring Data JPA for database operations
- MySQL database integration
- Service layer architecture
- Repository pattern implementation
- Spring Boot 4.0.1

## 🛠️ Technology Stack

- **Java**: 17
- **Spring Boot**: 4.0.1
- **Spring Data JPA**: For database operations
- **MySQL**: Database
- **Maven**: Build and dependency management

## 📦 Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 17 or higher
- Maven 3.6+
- MySQL Server 8.0+
- Git

## 🚀 Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/omprakash970/skill-3.git
   cd skill-3
   ```

2. **Set up MySQL Database**
   ```sql
   CREATE DATABASE skill2_db;
   ```

3. **Build the project**
   ```bash
   ./mvnw clean install
   ```
   
   Or on Windows:
   ```cmd
   mvnw.cmd clean install
   ```

## ⚙️ Configuration

Update the `src/main/resources/application.properties` file with your database credentials:

```properties
spring.application.name=skill2

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/skill2_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

## 🏃 Running the Application

### Using Maven Wrapper

```bash
./mvnw spring-boot:run
```

Or on Windows:
```cmd
mvnw.cmd spring-boot:run
```

### Using Java

```bash
./mvnw package
java -jar target/skill2-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080` by default.

## 📁 Project Structure

```
skill-3/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── klu/
│   │   │           └── skill2/
│   │   │               ├── Entity/
│   │   │               │   └── Product.java
│   │   │               ├── Repository/
│   │   │               │   └── ProductRepository.java
│   │   │               ├── Service/
│   │   │               │   └── ProductService.java
│   │   │               └── Skill2Application.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── klu/
│                   └── skill2/
│                       └── Skill2ApplicationTests.java
├── .gitignore
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## 🔌 API Endpoints

The application is designed to support the following RESTful API endpoints (to be implemented):

- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `POST /api/products` - Create a new product
- `PUT /api/products/{id}` - Update a product
- `DELETE /api/products/{id}` - Delete a product

## 🗄️ Database Schema

### Product Entity

The Product entity will contain the following fields:

- `id`: Primary key (Long)
- `name`: Product name (String)
- `description`: Product description (String)
- `price`: Product price (Double)
- `quantity`: Available quantity (Integer)

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👤 Author

**Omprakash**

- GitHub: [@omprakash970](https://github.com/omprakash970)

## 📧 Support

For support, please open an issue in the GitHub repository.

---

⭐️ If you find this project helpful, please consider giving it a star!
