FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/maven-enterprise-application-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
