# Spring Boot Application

Welcome to the Spring Boot Application! This guide will help you get started with setting up and running the application using Docker.

## Prerequisites

Before you begin, ensure you have Docker installed on your machine.

## Getting Started

### Running the Application with Docker

1. **Build the Docker Image**:

   Open a terminal in the root directory of the project and build the Docker image by running:

   ```sh
   docker build -t spring-boot-app .
2. **Run the Docker Container**:

   Run the Docker container by executing the following command:

   ```sh
   docker run -p 8080:8080 spring-boot-app

3. **Access the Application**:

   Open a web browser and navigate to `http://localhost:8080` to access the application.
4. **Stopping the Application**:

   To stop the application, press `Ctrl+C` in the terminal where the container is running.
5. View swagger documentation by navigating to `http://localhost:8080/swagger-ui/index.html`