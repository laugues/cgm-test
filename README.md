# CGM Test

##  Module "part 2..."
Modules specific to the part 2 (multiple answers and improve code test)

##  Module "part 3"
This module is an frontend application (Angular 4, with springboot backend) that manage dentists.

## requirement
- Docker 17.06
```UPDATE
Please disable the using TLS in docker
```
- NPM 8.5.0
- Maven 3.3.9

# How to run it ?
Go to the root folder of the code test : **cd part3**
Launch following command: **mvn clean install -Pfront,docker,docker-run** it will deploy the database, the backend, 
and frontend.

# Enjoy it!
Please go to [http://localhost](http://localhost)

# Project : 
- part3/backend : Endpoint rest and database access 
```
- Java 8
- Springboot 1.5.7, with spring securtity
- Database entity , using JPA 2.0 and Hibernate 5.2.10.Final for communicate to the database.
- Jersey 
```

- part3/frontend : Endpoint rest and database access 
```
- Angular 4
- Angular Cli 
```

- part3/docker : Build docker images, launch docker platform from maven 
```
- Docker
- Docker Compose 
```




