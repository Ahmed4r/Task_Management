# TaskFlow API

TaskFlow is a REST API for managing tasks, built with Java and Spring Boot.

This project is developed as part of a backend engineering learning project, focusing on REST APIs, layered architecture, database persistence, validation, and testing.

## Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Jakarta Bean Validation
- H2 Database
- Maven

## Project Structure

```text
src/main/java/com/devcore/taskflow/
├── controller/
├── service/
├── repository/
├── entity/
├── dto/
├── exception/
└── TaskflowApplication.java
```

## Getting Started

### Prerequisites

- Java 21
- Git

### Run Locally

Clone the repository:

```bash
git clone https://github.com/Ahmed4r/Task_Management.git
cd taskflow
```

Start the application using the Maven Wrapper.

**Windows:**

```powershell
.\mvnw.cmd spring-boot:run
```

**Linux/macOS:**

```bash
./mvnw spring-boot:run
```

The application runs at:

`http://localhost:8080`

## Database

TaskFlow uses an in-memory H2 database for local development.

Access the H2 Console at:

`http://localhost:8080/h2-console`

Connection settings:

- JDBC URL: `jdbc:h2:mem:taskflow`
- Username: `sa`
- Password: *(empty)*

The database is reset whenever the application restarts.

## Development Status

The project is currently under development.

Planned features include:

- Task creation, retrieval, updating, and deletion
- Task status management
- Request validation
- Global exception handling
- API testing

## License

No license has been specified yet.