# URL lookup service

Url lookup is a service which will help to block the malware urls

## Requirements
Java 1.8
Maven 3.8.3

## Build Spring Boot with Maven
mvn install / mvn clean install

## Run the project
mvn spring-boot:run

## DB
H2 - Relational in-memory database
To view data in console - 
http://localhost:8080/h2-console

## Unit Test
Junit

## Test Case
valid url example-
http://localhost:8080/urlinfo/www.somedb.com:8080/search?q=ancient
Expected response - It is valid url

malware url example -
http://localhost:8080/urlinfo/test:9999/history?q=spampath
Expected response - It is malware url


## Questions- 

• The size of the URL list could grow infinitely. How might you scale this beyond the memory capacity of the system?

• Assume that the number of requests will exceed the capacity of a single system, 
describe how might you solve this, and how might this change if you have to distribute 
this workload to an additional region, such as Europe.

• What are some strategies you might use to update the service with new URLs? 
Updates may be as much as 5 thousand URLs a day with updates arriving every 10 minutes.

• [On-Call] You’re woken up at 3am, what are some of the things you’ll look for? 
Does that change anything you’ve done in the app?

• What are some considerations for the lifecycle of the app?

• You need to deploy a new version of this application. What would you do?