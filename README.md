# Maven Enterprise Application

This repository contains a **Spring Boot** based **Enterprise Application**. The application is built using **Maven** and can be packaged as a **Docker image** for local and cloud deployment. This guide will walk you through the steps to build, deploy, and run the application both locally and on an **EC2 Red Hat instance**.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Directory Structure](#directory-structure)
  - [Build and Run Locally](#build-and-run-locally)
  - [Build Docker Image Locally](#build-docker-image-locally)
  - [Run Docker Container Locally](#run-docker-container-locally)
- [Deploy on EC2 Red Hat Server](#deploy-on-ec2-red-hat-server)
  - [Install Docker on EC2](#install-docker-on-ec2)
  - [Copy Project to EC2](#copy-project-to-ec2)
  - [Build and Run Docker on EC2](#build-and-run-docker-on-ec2)
  - [Access Application on EC2](#access-application-on-ec2)
- [Optional: Using Docker Compose](#optional-using-docker-compose)
- [Additional Notes](#additional-notes)
- [Conclusion](#conclusion)


## Prerequisites

Before starting, make sure the following software is installed:

- **Java 1.8 or later**
- **Maven 3.6.x or later**
- **Docker** (for building and running the Docker container)
- **AWS EC2 instance (Red Hat)** with **Docker** installed

## Getting Started

### Directory Structure

Here is the directory structure of the project:

```
maven-enterprise-application/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── mt/
│   │   │           └── enterprise/
│   │   │               ├── controller/
│   │   │               ├── model/
│   │   │               └── service/
│   │   ├── resources/
│   └── test/
│       └── java/
│           └── com/
│               └── mt/
│                   └── enterprise/
│
├── target/                    # Compiled classes and packaged JARs
│
├── Dockerfile                 # Defines how the Docker image is built
└── pom.xml                    # Maven configuration
```

### Build and Run Locally

Follow these steps to build and run the application locally.

#### 1. Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/m-pasima/Maven-enterprise-application
cd maven-enterprise-application
```

#### 2. Build the Spring Boot Application

Run the following Maven command to build the application and package it as a JAR file:

```bash
mvn clean install
```

This will generate a `.jar` file in the `target/` directory.

#### 3. Build Docker Image Locally

To build the Docker image locally, use the following Maven command:

```bash
mvn docker:build
```

This will create a Docker image named `maven-enterprise-application`.

#### 4. Run Docker Container Locally

After building the Docker image, you can run the container locally by executing:

```bash
docker run -p 8080:8080 maven-enterprise-application
```

This will expose the application on port `8080` of your local machine.

#### 5. Access the Application Locally

Once the Docker container is running, you can access your application by opening a browser and navigating to:

```
http://localhost:8080
```

---

## Deploy on EC2 Red Hat Server

### 1. Create and Launch a Red Hat EC2 Instance

- Log in to your AWS console and create a **Red Hat EC2 instance**.
- Ensure the **Security Group** allows inbound traffic on port `8080` (or the port you choose to expose for your application).
- Connect to your EC2 instance using SSH.

### 2. Install Docker on EC2

Once connected to your EC2 instance, run the following commands to install Docker:

```bash
sudo yum update -y
sudo amazon-linux-extras install docker
sudo service docker start
sudo usermod -aG docker ec2-user
```

- **Start Docker**: `sudo service docker start`
- **Add your EC2 user to the Docker group** to avoid needing `sudo` for Docker commands: `sudo usermod -aG docker ec2-user`
- **Log out and log back in** to ensure the Docker group permissions take effect.

Check Docker installation:

```bash
docker --version
docker info
```

### 3. Copy Project to EC2

You can copy the project to your EC2 instance using `scp` or `rsync`. Here's how to use `scp`:

```bash
scp -i your-key.pem -r /path/to/your/project ec2-user@<EC2-PUBLIC-IP>:/home/ec2-user/
```

Alternatively, you can clone the Git repository directly on the EC2 instance:

```bash
git clone https://github.com/m-pasima/Maven-enterprise-application
cd Maven-enterprise-application
```

### 4. Build and Run Docker on EC2

Once the project is on your EC2 instance, you need to install Maven (if not already installed) and build the project.

#### Install Maven on EC2:

```bash
sudo yum install maven -y
```

#### Build the project and Docker image:

```bash
mvn clean install
mvn docker:build
```

### 5. Run Docker Container on EC2

After successfully building the Docker image on the EC2 instance, run the following command to start the Docker container:

```bash
docker run -p 8080:8080 maven-enterprise-application
```

This will start the container and expose the application on port `8080` of the EC2 instance.

### 6. Access the Application on EC2

To access the application, open your web browser and navigate to:

```
http://<EC2-PUBLIC-IP>:8080
```

Replace `<EC2-PUBLIC-IP>` with your EC2 instance’s public IP address.

---

## Optional: Using Docker Compose

If you plan to run multiple services or configurations, you can use **Docker Compose**. This tool allows you to define multi-container applications. Here's how you can use Docker Compose for your application:

1. **Create a `docker-compose.yml` file**:

```yaml
version: '3'
services:
  app:
    image: maven-enterprise-application
    ports:
      - "8080:8080"
    build:
      context: .
      dockerfile: Dockerfile
```

2. **Run Docker Compose**:

If you want to use Docker Compose for local testing or on your EC2 instance:

```bash
docker-compose up --build
```

This will build the image and start the container using Docker Compose.

---

## Additional Notes

- **Dockerfile**: Ensure that your `Dockerfile` is properly set up in the project directory. This file defines how the Docker image is built and run.
  
- **Ports**: Make sure the EC2 instance's security group is configured to allow inbound traffic on the ports you are using (e.g., port `8080`).

- **Production Deployment**: For production environments, consider using **AWS ECS** or **EKS** for managing containerized applications.

- **Local Development**: When working locally, you can run the application using Docker or use Maven to run the Spring Boot app directly (without Docker).

---

## Conclusion

This guide has shown how to build, deploy, and run your **Maven Enterprise Application** as a Docker container both locally and on an **EC2 Red Hat instance**. Docker provides a consistent environment for development and production, and using EC2 for deployment helps in scaling your application efficiently.
