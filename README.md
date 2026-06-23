# SecureCode AI

## Overview

SecureCode AI is an AI-powered Application Security (AppSec) platform designed to help developers identify security vulnerabilities in source code before deployment.

The platform allows users to:

* Register and authenticate securely using JWT authentication.
* Create and manage software projects.
* Upload complete source code projects as ZIP archives.
* Extract and store source code files for analysis.
* Scan code for common security vulnerabilities based on OWASP guidelines.
* Generate AI-assisted remediation suggestions.
* Produce security reports and findings dashboards.

The current implementation focuses on the foundational platform architecture, including authentication, project management, database migrations, and file ingestion infrastructure.

---

## Current Features

### Authentication & Authorization

* User Registration
* User Login
* JWT Token Generation
* JWT Token Validation
* Stateless Authentication
* Protected API Endpoints using Spring Security

### Project Management

* Create Project
* View User Projects
* Associate Projects with Users
* Ownership-based data access

### Database Management

* PostgreSQL Integration
* Flyway Database Versioning
* Automatic Schema Migration

### File Ingestion Foundation

* Uploaded Files Database Schema
* ZIP Upload API Endpoint
* File Metadata Storage Design
* Source Code Storage Architecture

### API Documentation

* Swagger/OpenAPI Integration
* Interactive API Testing

### CI/CD

* GitHub Actions Workflow
* Automated Maven Build Validation
* PostgreSQL-backed CI Environment

---

## Technology Stack

### Backend

* Java 21
* Spring Boot 3
* Spring Security
* Spring Data JPA
* Hibernate
* Flyway

### Database

* PostgreSQL

### Security

* JWT Authentication
* BCrypt Password Encryption

### Documentation

* Swagger / OpenAPI

### Build & CI

* Maven
* GitHub Actions

### Future AI Integration

* Gemini API
* OpenAI Compatible APIs

---

## System Architecture

```text
                        +----------------+
                        |     Client     |
                        +-------+--------+
                                |
                                |
                                v
                    +----------------------+
                    |   Spring Security    |
                    +----------------------+
                                |
                                |
                                v
                    +----------------------+
                    | JWT Authentication   |
                    +----------------------+
                                |
                                |
                                v
                    +----------------------+
                    |     Controllers      |
                    +----------------------+
                                |
                                |
                                v
                    +----------------------+
                    |      Services        |
                    +----------------------+
                                |
                                |
                                v
                    +----------------------+
                    |    Repositories      |
                    +----------------------+
                                |
                                |
                                v
                    +----------------------+
                    |     PostgreSQL       |
                    +----------------------+
```

---

## Database Schema

### Users

Stores platform users.

| Column     | Type      |
| ---------- | --------- |
| id         | BIGSERIAL |
| name       | VARCHAR   |
| email      | VARCHAR   |
| password   | VARCHAR   |
| role       | VARCHAR   |
| created_at | TIMESTAMP |
| updated_at | TIMESTAMP |

---

### Projects

Stores projects owned by users.

| Column      | Type      |
| ----------- | --------- |
| id          | BIGSERIAL |
| name        | VARCHAR   |
| description | TEXT      |
| owner_id    | BIGINT    |
| created_at  | TIMESTAMP |
| updated_at  | TIMESTAMP |

Relationship:

```text
User (1)
   |
   |----< Project (N)
```

---

### Uploaded Files

Stores source code files belonging to projects.

| Column       | Type      |
| ------------ | --------- |
| id           | BIGSERIAL |
| project_id   | BIGINT    |
| file_name    | VARCHAR   |
| file_path    | VARCHAR   |
| file_type    | VARCHAR   |
| file_content | TEXT      |
| uploaded_at  | TIMESTAMP |

Relationship:

```text
Project (1)
   |
   |----< UploadedFile (N)
```

---

## API Endpoints

### Authentication

#### Register User

```http
POST /api/auth/register
```

Request:

```json
{
  "name": "Bajrang",
  "email": "bajrang@gmail.com",
  "password": "password123"
}
```

---

#### Login

```http
POST /api/auth/login
```

Request:

```json
{
  "email": "bajrang@gmail.com",
  "password": "password123"
}
```

Response:

```json
{
  "token": "jwt-token"
}
```

---

### Projects

#### Create Project

```http
POST /api/projects
```

#### Get My Projects

```http
GET /api/projects
```

---

### File Upload

#### Upload ZIP Archive

```http
POST /api/files/upload-zip/{projectId}
```

Current Status:

* Endpoint implemented
* ZIP processing pending

---

## Flyway Migrations

Implemented migrations:

```text
V1__create_users_table.sql

V2__create_projects_table.sql

V3__create_uploaded_files_table.sql

V4__add_file_path_to_uploaded_files.sql
```

---

## Project Progress

### Completed

* Spring Boot Setup
* PostgreSQL Configuration
* Flyway Integration
* Swagger Integration
* User Authentication
* JWT Authorization
* Project Management Module
* Uploaded Files Schema
* ZIP Upload API Foundation
* GitHub Actions CI Pipeline

### In Progress

* ZIP Extraction Engine
* Source Code Persistence

### Planned

* ZIP Extraction
* File Storage
* Security Rule Engine
* OWASP Vulnerability Detection
* Findings Management
* AI Security Analysis
* Vulnerability Remediation Suggestions
* Security Reports
* Angular Dashboard
* Scan History
* Project Analytics

---

## Future Roadmap

### Phase 1 – Foundation (Completed)

* Authentication
* Authorization
* Project Management
* Database Design

### Phase 2 – Code Ingestion (In Progress)

* ZIP Upload
* Source Code Extraction
* File Persistence

### Phase 3 – Security Scanning

* SQL Injection Detection
* XSS Detection
* Hardcoded Secret Detection
* Weak Authentication Detection

### Phase 4 – AI Analysis

* Gemini Integration
* AI-generated Remediation
* Risk Assessment

### Phase 5 – Reporting & Dashboard

* Security Reports
* Findings Dashboard
* Scan History
* Project Insights

---

## Author

Bajrang Yadav

Associate Programmer | Java Backend Developer

Technologies:
Java • Spring Boot • PostgreSQL • Angular • JWT • Flyway • GitHub Actions
