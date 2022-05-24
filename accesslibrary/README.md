# accesslibrary
Library Management System(LMS)

Let's create awesome LMS Microservices and RESTful web services with Spring and Spring Boot.

1. Overview
2. Installing Tools
3. Running Examples
4. Diagrams
5. Trobleshooting


Overview :
  Functional Requirements : 
  - Build a library that has 100 books from different categories.
	- People can check in and check out the books based on the availability.
	- Only 5 people can sit in the library.
	- Apart from books, library offers 2 computers, paper & magazines.
	- People can purchase books.
	
   Tools Needed/Installed :
	- Java : JDK 11.0.14
	- Eclipse : jee-2022-03
	- Python : 3.10.4
	- Docker Desktop : 4.8.2

Running Examples :
  - Download the zip or clone the Git repository.
  - Unzip the zip file (if you downloaded one)
  - Open Command Prompt and Change directory (cd) to folder containing pom.xml
  - Open Eclipse
    File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
  - Select the right project
  - Choose the Spring Boot Application file (search for @SpringBootApplication)
  - Right Click on the file and Run as Java Application
  - You are all Set

Requirements : 
1. Implement LMS-Access Library webservice and Set upLMS-Access Library Mysql Database.
2. Test the application using JUNIT and Mochito.
3. Set up Jenkin and build CI/CD pipeline.
4. Set up Sonarlint for Code QUality and JACOCO for code coverage in Jenkin.
6. Setup Docker Hub and deploy application in K8S pod.
7. Setup Mysql DB in cloud.Connect application to the Mysql DB.
8. Set up Jenkin and build CI/CD pipeline for the application deployed in Cloud.
9. Create Dev branch for local development and Use Master branch for cloud development(PROD).
10. Use GITGub as source code repo, DockerHUB as Image Registry and Kuberenets for automate deployment.

Learn Commands : 
1. Docker & Kubernetes
2. Mysql
3. Jenkin
4. Spring Boot

Docker & Kuberenetes :

Basic Docker Commands:
- Pull an image from repository -> docker pull
 - Run a container based on image -> docker run
 - List a container -> docker ps
 - Stop a container -> docker stop
 - Start a container -> docker start
 - Remove a container -> docker rm
 - Remove an image -> docker rmi
 - Kill a container -> docker kill
 - List last 100 lines of container logs -> docker logs --tail 100
 - Build an image from Docker file -> docker build
 - Push an image to repository -> docker push
