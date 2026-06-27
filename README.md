# SecureCode AI

## Overview

SecureCode AI is an AI-powered Application Security (AppSec) platform designed to help developers identify security vulnerabilities in source code before deployment.

The platform allows users to:

* Register and authenticate securely using JWT authentication.
* Create and manage software projects.
* Upload complete source code projects as ZIP archives.
* Extract, process, and persist every source code file into PostgreSQL.
* Perform static code analysis using custom security rules.
* Detect common security vulnerabilities based on OWASP principles.
* Store scan findings for future analysis.
* Generate AI-assisted remediation suggestions (Upcoming).
* Produce security reports and interactive dashboards (Upcoming).

The current implementation now includes a fully functional source code ingestion engine and the foundation of a static application security testing (SAST) scanner.

---

# Current Features

## Authentication & Authorization

* User Registration
* User Login
* JWT Token Generation
* JWT Token Validation
* Stateless Authentication
* Protected API Endpoints using Spring Security

---

## Project Management

* Create Project
* View User Projects
* Associate Projects with Users
* Ownership-based data access

---

## Database Management

* PostgreSQL Integration
* Flyway Database Versioning
* Automatic Schema Migration
* Versioned Database Evolution

---

## Source Code Ingestion Engine

Implemented:

* Upload complete project as ZIP
* Validate uploaded archive
* Extract ZIP contents
* Filter supported source files
* Preserve project folder structure
* Store complete source code inside PostgreSQL

Supported file types:

* Java
* XML
* Properties
* YAML
* JSON
* SQL
* JavaScript
* TypeScript
* Markdown

Every supported source file is stored individually for future analysis.

---

## Scanner Engine (Foundation)

Implemented:

* ScanResult database
* ScannerService
* ScannerController
* Scan Summary Response
* Source Code Reader
* Project Scanner Endpoint

Current Scan Flow:

Project

↓

Load Uploaded Files

↓

Read Every Source File

↓

Analyze Source Code

↓

Return Scan Summary

---

## Security Rule Engine

Implemented

### Hardcoded Secret Detection (Initial Version)

Current scanner searches for:

* password
* secret
* token
* apiKey
* api_key

Current implementation:

* Reads every uploaded source file
* Performs line-by-line analysis
* Detects potential hardcoded secrets
* Counts detected vulnerabilities

Future versions will improve detection accuracy and reduce false positives.

---

## API Documentation

* Swagger/OpenAPI Integration
* Interactive API Testing

---

## CI/CD

* GitHub Actions Workflow
* Automated Maven Build Validation
* PostgreSQL-backed CI Environment

---

# Technology Stack

## Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* Flyway

## Database

* PostgreSQL

## Security

* JWT Authentication
* BCrypt Password Encryption

## Documentation

* Swagger / OpenAPI

## Build & CI

* Maven
* GitHub Actions

## Future AI Integration

* Gemini API
* OpenAI Compatible APIs

---

# System Architecture

Client

↓

Spring Security

↓

JWT Authentication

↓

Controllers

↓

Services

↓

Repositories

↓

PostgreSQL

↓

Scanner Engine

↓

Security Rules

↓

Scan Results

↓

Gemini AI (Upcoming)

---

# Database Schema

## users

Stores platform users.

---

## projects

Stores projects uploaded by authenticated users.

Relationship:

User (1)

↓

Project (N)

---

## uploaded_files

Stores every extracted source code file.

Fields:

* File Name
* File Path
* File Type
* File Content
* Upload Timestamp
* Project Reference

Relationship:

Project (1)

↓

UploadedFile (N)

---

## scan_results

Stores vulnerabilities detected during static analysis.

Fields:

* Rule Name
* Severity
* Line Number
* Description
* Recommendation
* Status
* Created Timestamp

Relationship:

UploadedFile (1)

↓

ScanResult (N)

---

# API Endpoints

## Authentication

POST /api/auth/register

POST /api/auth/login

---

## Projects

POST /api/projects

GET /api/projects

---

## File Upload

POST /api/files/upload-zip/{projectId}

Status:

✔ Implemented

✔ ZIP Extraction

✔ Source Code Persistence

---

## Scanner

POST /api/scans/start/{projectId}

Current Behaviour:

* Reads project source code
* Executes security rules
* Returns scan summary
* Foundation for vulnerability detection

---

# Flyway Migrations

Implemented:

* V1__create_users_table.sql
* V2__create_projects_table.sql
* V3__create_uploaded_files_table.sql
* V4__add_file_path_to_uploaded_files.sql
* V5__create_scan_results_table.sql

---

# Project Progress

## Completed

* Spring Boot Setup
* PostgreSQL Configuration
* Flyway Integration
* Swagger Integration
* JWT Authentication
* Project Management Module
* ZIP Upload
* ZIP Extraction
* Source Code Persistence
* Scanner Infrastructure
* Scan Results Module
* Initial Hardcoded Secret Detection
* GitHub Actions CI Pipeline

---

## In Progress

* Persisting detected vulnerabilities into scan_results
* Modular Rule Engine
* Security Rule Refinement

---

## Planned

* SQL Injection Detection
* XSS Detection
* Weak Cryptography Detection
* Command Injection Detection
* Path Traversal Detection
* AI-powered Vulnerability Explanation
* Security Report Generation
* Angular Dashboard
* GitHub Repository Scanning
* Docker Deployment
* AWS Deployment

---

# Future Roadmap

## Phase 1 – Foundation ✅

* Authentication
* Authorization
* Project Management
* Database Design

---

## Phase 2 – Code Ingestion ✅

* ZIP Upload
* ZIP Extraction
* Source Code Persistence

---

## Phase 3 – Static Security Scanning 🚧

* Scanner Engine
* Hardcoded Secret Detection
* SQL Injection Detection
* XSS Detection
* Weak Authentication Detection
* Rule Engine
* Findings Persistence

---

## Phase 4 – AI Security Analysis

* Gemini Integration
* AI-generated Remediation
* Risk Assessment
* Secure Code Suggestions

---

## Phase 5 – Dashboard & Reporting

* Angular Dashboard
* Security Reports
* Scan History
* Project Analytics
* PDF Export

---

# Author

**Bajrang Yadav**

Associate Programmer | Java Backend Developer

**Technologies**

Java • Spring Boot • PostgreSQL • Spring Security • JWT • Flyway • Hibernate • GitHub Actions • AI • Static Application Security Testing (SAST)
