# Use an official OpenJDK image to run the Spring Boot application
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the target folder into the container
COPY target/maven-enterprise-application-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the app will run on (default is 8080)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
