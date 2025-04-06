# Stage 1: Build the JAR using Maven with JDK 17
FROM maven:3.8.1-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the entire project into the container
COPY . .

# Build the project, skipping tests (you can remove -DskipTests if you want to run tests)
RUN mvn clean package -DskipTests

# Debug step: Check if JAR file is created correctly
RUN ls -l /app/target

# Stage 2: Use OpenJDK 17 image to run the app
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the 'build' stage
COPY --from=build /app/target/survey-management-system-1.0-SNAPSHOT.jar /app/survey-management-system.jar

# Copy the application configuration file (e.g., application.yaml)
COPY --from=build /app/src/main/resources/application.yaml /app/application.yaml

# Debug step: Check if the application.yaml exists
RUN ls -l /app/

# Set correct file permissions for the YAML file
RUN chmod 644 /app/application.yaml

# Expose the port the app will run on
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/survey-management-system.jar", "server"]
CMD ["/app/application.yaml"]

