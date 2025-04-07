Survey Management System - README
Overview
The Survey Management System is a RESTful web application built with Dropwizard, designed to manage surveys. This application allows users to create and retrieve survey data using a simple API. The API is documented using Swagger, providing clear and easy-to-understand documentation for all available endpoints.

Features
Create Survey: Allows the creation of a new survey with various attributes such as age, gender, region, survey ID, and score.

Retrieve Surveys: Retrieves all surveys stored in memory (simulated, no database).

Swagger Documentation: Automatically generated API documentation accessible through Swagger UI.

Technologies Used
Dropwizard: A Java framework for developing RESTful web services.

Swagger: API documentation generated for the service.

Lombok: Simplifies the code by generating getters, setters, and other utility methods.

Maven: Dependency management and project build tool.

Docker: Containerization for running the application in isolated environments.

OpenJDK 17: Java runtime for running the application.

Setup Instructions
Prerequisites
Ensure the following tools are installed on your machine:

Java 17 or above

Maven (for building the project)

Docker (for containerizing the application)

Running the Application Locally
Step 1: Clone the repository
git clone <repository_url>
cd survey-management-system

Step 2: Run the Docker container
mvn clean package -DskipTests
docker compose build
docker compose up
