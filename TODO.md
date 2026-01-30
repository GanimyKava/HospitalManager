# Project Roadmap & TODOs

This document outlines planned improvements, technical debt, and feature enhancements for the HospitalManager application.

## 🏗️ Architecture & Best Practices
- [ ] **DTO Pattern Implementation**: Currently, JPA Entities are returned directly by the API. Introduced `RequestDTO` and `ResponseDTO` classes to decouple the API from the database schema.
- [ ] **JPA Relationships**: Refactor entities to use proper Hibernate relationships (`@ManyToOne`, `@OneToMany`) instead of raw ID fields (`Long patientId` -> `Patient patient`).
- [ ] **Pagination & Sorting**: Update `getAll` endpoints to support `Pageable` to handle large datasets efficiently.

## 🔒 Security
- [ ] **Spring Security Integration**: Add `spring-boot-starter-security`.
- [ ] **Authentication**: Implement JWT (JSON Web Token) or OAuth2 for secure API access.
- [ ] **Role-Based Access Control (RBAC)**: secure endpoints (e.g., only Admin can delete doctors).
- [ ] **CORS Configuration**: Configure Cross-Origin Resource Sharing if a separate frontend is developed.

## 🛡️ Validation & Error Handling
- [ ] **Input Validation**: Add `@NotNull`, `@Size`, `@Email` annotations to DTOs and enable `@Valid` in controllers.
- [ ] **Custom Exceptions**: Create specific exceptions (e.g., `PatientNotFoundException`) instead of generic `RuntimeException`.
- [ ] **Structured Error Responses**: Standardize error JSON structure (timestamp, status, error code, message).

## ⚙️ DevOps & Database
- [ ] **Database Migration**: Integrate **Flyway** or **Liquibase** for version-controlled database schema changes (replace `ddl-auto=update`).
- [ ] **Dockerization**: Create a `Dockerfile` and `docker-compose.yml` for easy deployment.
- [ ] **CI/CD**: Set up GitHub Actions for automated building and testing.
- [ ] **Profiles**: Configure `dev`, `test`, and `prod` profiles (e.g., H2 for test, MySQL for prod).

## 🧪 Testing
- [ ] **Integration Tests**: Add `@SpringBootTest` to test full API flows (Controller -> DB).
- [ ] **Unit Tests**: Increase code coverage for all services and controllers.
- [ ] **TestContainers**: Use TestContainers for running integration tests against a real database instance.

## 📊 Observability & Monitoring
- [ ] **Actuator**: Add `spring-boot-starter-actuator` to expose health, metrics, and info endpoints.
- [ ] **Logging**: Improve logging configuration (Logback/SLF4J) with correlation IDs for request tracing.
- [ ] **Metrics**: Integrate with Prometheus/Grafana for real-time application monitoring.

## 🚀 Performance
- [ ] **Caching**: Implement Spring Cache (e.g., with Redis or Caffeine) for frequently accessed data like `Doctors` or `Departments`.
- [ ] **Async Processing**: Use `@Async` for long-running tasks (e.g., sending email notifications).

## 💻 Frontend (Future)
- [ ] **UI Framework**: Plan for a React, Angular, or Vue.js frontend to consume the REST API.
- [ ] **Thymeleaf**: Alternatively, use server-side rendering with Thymeleaf for a simpler monolithic approach.

## 🧹 Code Quality
- [ ] **Static Analysis**: Integrate SonarQube or Checkstyle to enforce coding standards.
- [ ] **Formatting**: Apply Spotless or Google Java Format for consistent code style.
