# TaskFlow API

TaskFlow is a Java Spring Boot backend project for task management. It is being built incrementally to practice REST API design, layered architecture, database persistence, validation, exception handling, and testing.

> **Status:** In development. The application skeleton is set up; task CRUD endpoints are planned but not implemented yet.

## Tech Stack

- Java 21 (LTS)
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- Jakarta Bean Validation
- H2 in-memory database
- Maven Wrapper

## Prerequisites

- JDK 21
- Git

No separate Maven installation is required; the repository includes the Maven Wrapper.

## Run Locally

```bash
git clone https://github.com/Ahmed4r/Task_Management.git
cd Task_Management
```

On Windows (PowerShell):

```powershell
.\mvnw.cmd clean test
.\mvnw.cmd spring-boot:run
```

On Linux or macOS:

```bash
./mvnw clean test
./mvnw spring-boot:run
```

The application starts on `http://localhost:8080` by default. The root URL is not an API endpoint and may return 404 until routes are implemented.

## Local Database (H2)

The application uses an in-memory H2 database for local development. Data is lost when the application stops.

The intended configuration in `src/main/resources/application.properties` is:

```properties
spring.application.name=TaskFlow
spring.datasource.url=jdbc:h2:mem:taskflow
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

Once these settings are applied and the application is running, open `http://localhost:8080/h2-console` and connect with:

| Setting | Value |
| --- | --- |
| JDBC URL | `jdbc:h2:mem:taskflow` |
| Username | `sa` |
| Password | Leave blank |

> The database configuration above is the **target local setup**. Ensure your local `application.properties` matches it; the existing configuration may still use `testdb` and a password.

## Architecture (Planned)

The application will follow a layered structure:

- `controller` — HTTP endpoints
- `service` — business logic
- `repository` — database access
- `entity` — JPA entities
- `dto` — API request and response objects
- `exception` — error handling

The current application entry point is `src/main/java/com/projects/Task_Management/TaskManagementApplication.java`. The package structure above is planned and may change as implementation progresses.

## Planned Features

- Create, list, retrieve, update, and delete tasks
- Manage task status (`TODO`, `IN_PROGRESS`, `DONE`)
- Validate incoming requests
- Return consistent API errors
- Add automated tests

## Project Workflow

Development tasks are tracked in [DevCore Engineering (Jira)](https://ahmedrady03.atlassian.net/browse/DCE-1).

## License

No license has been specified yet.
