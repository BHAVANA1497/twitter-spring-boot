## About The Project
This project is to store the tweets in database and find the top 10 hashtags in twitter

## Technology used 
Spring boot : Web application Maven : Building project Java 8 : programming language Swagger : RESTful Documentation

## Web Application configuration 
Web Application is running on port 8080 You can change the configuration in application.properties

## Steps to run the project
1)Download the zip file or clone the project
2)Inside IntelliJ IDEA File --> open --> select the project --> ok
3)Build the project
```sh
 mvn clean install
```
4)open TwitterHashTagApplication --> right click --> run application
5)Swagger is already integrated and can be used for using API. 
    visit http://localhost:8080/swagger-ui.html in your browser

6) In memory Database is used in this project
   visit http://localhost:8080/h2-console in your browser
   Give this "jdbc:h2:mem:bhavana" at JDBC url and click on connect

## Run Test cases with coverage
1) Right click on the project and run all tet cases with coverage