# CGM Test

##  Module "part 2..."
Modules specific to the part 2 (multiple answers and improve code test)

##  Module "part 3"
This module is an frontend application (Angular 4, with springboot backend) that manage dentists.

## requirement
- Docker 17.06 (Please disable the using of TLS in docker config)
- NPM 8.5.0
- Maven 3.3.9

# How to run it ?
Go to the root folder of the code test : **cd part3**
Launch following command: **mvn clean install -Pfront,docker,docker-run** it will deploy the database, the backend, 
and frontend.
Please wait all containers are 'healthy'. You can check it by executing the following command : 
```
docker ps -a | grep "cgm" 
```

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
- Nginx
- Angular 4
- Angular Cli 
- Karma/Jasmin launched at build on port 9876
```

- part3/docker : Build docker images, launch docker platform from maven 
```
- Docker
- Docker Compose 
```
the images built are :  
```
- cgm-backend for the backend providing REST API based on springboot
- cgm-database based on mariadb
- cgm-frontend nginx frontend 
```




