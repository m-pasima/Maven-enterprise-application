# Maven Enterprise Application

This is a **Maven Enterprise Web Application** that leverages **Spring Boot**, **Maven**, and **Docker** for building and deploying a simple enterprise-level Java application. It includes RESTful services, database integration, and a full CI/CD pipeline with **Jenkins** and **Kubernetes** for deployment.

## Project Overview

The application demonstrates the following:
- A **Spring Boot** application with **REST API** endpoints.
- **H2 Database** integration for development and testing.
- **JUnit 5** testing for API endpoints.
- **Docker** to containerize the application.
- **Kubernetes** for orchestration and deployment.
- **Jenkins CI/CD** pipeline for automation.

### Technologies Used:
- **Spring Boot**: For building the Java web application.
- **Maven**: For project management and build automation.
- **JUnit 5**: For writing unit and integration tests.
- **Log4J**: For logging.
- **H2 Database**: An in-memory database used for development and testing.
- **Docker**: For creating a containerized application.
- **Kubernetes**: For deploying and managing the application in a containerized environment.
- **Jenkins**: For continuous integration and deployment automation.

## Features:
- **Spring Boot Starter Web**: To create a simple web application using Spring MVC.
- **Spring Boot Starter Data JPA**: For easy integration with databases (H2 in this case).
- **RESTful Endpoints**: Expose simple REST APIs like `/hello` to interact with the application.
- **JUnit 5 Tests**: Unit tests for verifying controller functionality.
- **Dockerized**: The application is containerized using Docker for easy deployment.
- **Kubernetes Deployment**: The Docker container can be deployed to a Kubernetes cluster.
- **Jenkins CI/CD Pipeline**: Automates the process of building, testing, and deploying the application.

## Setup and Installation

### Prerequisites:
1. **Java 8 or newer**.
2. **Maven** installed.
3. **Docker** installed.
4. **Kubernetes** cluster set up (for deployment).
5. **Jenkins** set up (for CI/CD pipeline).

### Steps:

1. **Clone the repository:**

    ```bash
    git clone https://github.com/m-pasima/maven-enterprise-application.git
    cd maven-enterprise-application
    ```

2. **Ensure Maven, Java, Docker, and Kubernetes are installed:**

    ```bash
    mvn -v
    java -version
    docker -v
    kubectl version --client
    ```

3. **Build the Maven project:**

    Run the following command to compile the code, run tests, and package the application:

    ```bash
    mvn clean install
    ```

4. **Run the application locally with Maven (Spring Boot):**

    ```bash
    mvn spring-boot:run
    ```

    The application will be available at `http://localhost:8080/`.

5. **Dockerize the application:**

    - **Build the Docker image:**

        ```bash
        docker build -t your-docker-username/maven-enterprise-application .
        ```

    - **Run the Docker container:**

        ```bash
        docker run -p 8080:8080 your-docker-username/maven-enterprise-application
        ```

        The application will be accessible at `http://localhost:8080/` inside the Docker container.

6. **Deploy the application to Kubernetes:**

    - **Create the Kubernetes deployment file** (`deployment.yaml`).

    - **Apply the deployment to the Kubernetes cluster:**

        ```bash
        kubectl apply -f deployment.yaml
        ```

    The application will be deployed to the Kubernetes cluster, and you can access it via the exposed service.

7. **Run the Jenkins pipeline:**

    - **Create the Jenkinsfile** for automation.
    - **Set up Docker and Kubernetes credentials** in Jenkins.
    - **Run the Jenkins pipeline** to automate the build, Docker image creation, and Kubernetes deployment.

    The Jenkins pipeline will:
    - Clone the repository.
    - Build the application with Maven.
    - Build the Docker image and push it to a container registry.
    - Deploy the image to the Kubernetes cluster.

## Directory Structure

```
maven-enterprise-application/
├── Dockerfile                    # Dockerfile to build the application container
├── Jenkinsfile                   # Jenkins pipeline configuration
├── README.md                     # Project documentation
├── pom.xml                       # Maven configuration
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── mt/
│   │   │           └── enterprise/
│   │   │               ├── controller/
│   │   │               │   └── HelloWorldController.java
│   │   │               ├── model/
│   │   │               │   └── User.java
│   │   │               └── service/
│   │   │                   └── HelloWorldService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
│   └── test/
│       └── java/
│           └── com/
│               └── mt/
│                   └── enterprise/
│                       └── HelloWorldControllerTest.java
└── target/                       # Generated files after building (e.g., JAR file)
```

## Running in a Servlet Container

To deploy this application in a servlet container like **Tomcat**, you can package it as a WAR file:

```bash
mvn clean package
```

This will generate a `maven-enterprise-application-0.0.1-SNAPSHOT.war` file in the `target/` directory. You can deploy this WAR file to your servlet container.

## Jenkins Pipeline for CI/CD

1. **Jenkins Setup**:
   - Ensure you have Docker and Kubernetes installed on the Jenkins agent.
   - Store Docker credentials (`DOCKER_USERNAME`, `DOCKER_PASSWORD`) and Kubernetes configurations securely in Jenkins.

2. **Jenkins Pipeline Steps**:
   - **Clone the Repository**.
   - **Build the application** using Maven.
   - **Build the Docker image** using the Dockerfile.
   - **Push the Docker image** to Docker Hub or another container registry.
   - **Deploy the image to Kubernetes** using `kubectl`.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Add feature'`).
4. Push to your fork (`git push origin feature-branch`).
5. Open a Pull Request.

## License

This project is open-source and available under the **MIT License**.

---

This `README.md` file covers the entire process from setup to deployment, and explains how to run the application locally, dockerize it, deploy it to Kubernetes, and automate the process using Jenkins.
