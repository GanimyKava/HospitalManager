# Hospital Management System

A comprehensive Spring Boot-based application designed to streamline hospital operations, manage patient records, and coordinate medical staff efficiently.

## Features
- **Patient Management**: Register and manage patient profiles and medical history.
- **Doctor & Staff Tracking**: Manage medical personnel, departments, and specializations.
- **Appointment Scheduling**: Book, update, and track patient consultations.
- **Medical Records**: Secure storage and retrieval of diagnostic reports and prescriptions.
- **Billing & Invoicing**: Automated billing system for services and treatments.



## Build and Run
* Tip: To build and run the application, ensure you have Java 17+ and Maven installed.

Database Setup: Update the credentials in 
src/main/resources/application.properties
 to match your local MySQL configuration.
Build: Run mvn clean install in the project root.
Run: Use mvn spring-boot:run or run 
HospitalManagerApplication.java
 from your IDE.
The API will be available at http://localhost:8080/api/.