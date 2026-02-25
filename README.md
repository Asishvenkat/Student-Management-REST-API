# RESTAPIs - Student Management Service

Small Spring Boot REST API for managing student records (CRUD + partial updates).

## Overview

This project demonstrates a clean, layered Spring Boot application exposing REST endpoints for student management. It uses DTOs to decouple API models from persistence entities and supports full (PUT) and partial (PATCH) updates.

## Key Features

- CRUD endpoints for students (GET, POST, PUT, PATCH, DELETE)
- Validation using `jakarta.validation` on request DTOs
- Entity ↔ DTO mapping (Mapper config present)
- Persistence with Spring Data JPA

## Tech Stack

- Java 17+ (or configured JDK)
- Spring Boot
- Spring Data JPA
- Maven (`pom.xml`)

## Quick Start

1. Build with Maven:

   mvn clean package

2. Run the application locally:

   mvn spring-boot:run

   or

   java -jar target/RESTAPIs-0.0.1-SNAPSHOT.jar

The server will start on the default Spring Boot port (8080) unless overridden in `application.properties`.

## API Endpoints (examples)

- GET `/students` — list all students
- GET `/students/{id}` — get student by id
- POST `/students` — create new student (validate request body)
- PUT `/students/{id}` — full update
- PATCH `/students/{id}` — partial update (JSON object of fields to change)
- DELETE `/students/{id}` — delete student

Example curl to create a student:

```
curl -X POST http://localhost:8080/students \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Jane","lastName":"Doe","email":"jane@example.com"}'
```

## Project Structure

- `src/main/java` — application sources (controller, service, repository, dto, entity)
- `src/main/resources/application.properties` — configuration
- `pom.xml` — Maven build file

## Tests

Run unit/integration tests with:

```
mvn test
```

## Next Steps / Notes

- Consider adding an OpenAPI/Swagger UI for interactive API docs.
- Add database configuration for production use and integration tests.

---

If you want, I can also commit this README and open a Git change for you.
