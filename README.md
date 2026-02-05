# Hospital Management System

A comprehensive Spring Boot-based application designed to streamline hospital operations, manage patient records, and coordinate medical staff efficiently.

## Features
- **Patient Management**: Register and manage patient profiles and medical history.
- **Doctor & Staff Tracking**: Manage medical personnel, departments, and specializations.
- **Appointment Scheduling**: Book, update, and track patient consultations.
- **Medical Records**: Secure storage and retrieval of diagnostic reports and prescriptions.
- **Billing & Invoicing**: Automated billing system for services and treatments.



## Tech Stack & Tools
- **Java 17**
- **Spring Boot 3.2.2**
- **MySQL 8.0**
- **Docker & Docker Compose**
- **Maven** (for local development)

## Build and Run with Docker Compose
This project is containerized for easy deployment. You do not need to install Java or Maven on your machine to run the application if you use Docker.

### Prerequisites
- [Docker](https://www.docker.com/get-started) installed and running.
- [Docker Compose](https://docs.docker.com/compose/install/) installed.

### Steps
1.  **Clone the repository**:
    ```bash
    git clone <repository_url>
    cd HospitalManager
    ```

2.  **Build and Run**:
    Run the following command in the project root to build the application image and start the database and application containers:
    ```bash
    docker compose up --build
    OR
    docker-compose up --build
    ```

3.  **Access the Application**:
    - The API will be available at: `http://localhost:8080/api/`
    - The database is accessible at `localhost:3307` (mapped from container port 3306).

4.  **Stop the Application**:
    To stop the containers, press `Ctrl+C` or run:
    ```bash
    docker compose down 
    OR
    docker-compose down
    ```