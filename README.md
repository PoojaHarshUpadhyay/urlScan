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

## Test Case to run on POSTMAN
1- Valid url example-
[GET] - 
http://localhost:8080/urlinfo/www.somedb.com:8080/search?q=ancient
http://localhost:8080/urlinfo/www.somedb.com:8080/search
Expected response - "It is valid url"

2- Malware url example -
[GET] -
http://localhost:8080/urlinfo/test:9999/history?q=spampath
http://localhost:8080/urlinfo/test:9999/history
Expected response - "It is malware url"


## Questions- 

• The size of the URL list could grow infinitely. How might you scale this beyond the memory capacity of the system?

-> I am using H2 in memory database which has some limitations on data storage but I can start 
with increasing the capacity of my storage and even if that is beyond the memory capacity of the system 
then I can do horizontal scaling and implement database sharding.

• Assume that the number of requests will exceed the capacity of a single system, 
describe how might you solve this, and how might this change if you have to distribute 
this workload to an additional region, such as Europe.

-> AWS provides regional support for APIs so, I can create API based on region and deploy accordingly like 
US users from will be redirected to us-east-1 and EU users will be redirected to eu-west-1 region and this will help in 
better performance of APIs

• What are some strategies you might use to update the service with new URLs? 
Updates may be as much as 5 thousand URLs a day with updates arriving every 10 minutes.

-> I can have a PUT REST API which is idempotent so, it will update the url if already present also I can have some sort 
of cron job that will collect/cache all the incoming request every 10 minutes and then do the update on database at once.

• [On-Call] You’re woken up at 3am, what are some of the things you’ll look for? 
Does that change anything you’ve done in the app?

-> I think I will first debug the root cause of the issue happened on [On-Call] and resolve accordingly but, as far as 
improvement goes for my project - I will do some improvements in database end like implement indexing, implement logging.

• What are some considerations for the lifecycle of the app?

-> I am using Springboot to create REST APIs and the beans are deleted as the app is closed and 
java manages garbage collection internally and realeases the memory.

• You need to deploy a new version of this application. What would you do?

-> I can implement versioning in my API, springboot provides support for API versioning.