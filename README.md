# URL lookup service

Url lookup is a service which will help to block the malware urls

##Requirements

Java 1.8
Maven 3.8.3

##Build Spring Boot with Maven

mvn install / mvn clean install

##Run the project

mvn spring-boot:run

##DB

H2 - Relational in-memory database
To view data in console - 
http://localhost:8080/h2-console

##Unit Test

Junit

##Test Case

valid url example-
http://localhost:8080/urlinfo/www.somedb.com:8080/search?q=ancient
Expected response - It is valid url

malware url example -
http://localhost:8080/urlinfo/test:9999/history?q=spampath
Expected response - It is malware url
