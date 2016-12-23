# Sample Application Using Spring Boot , Jersey and MongoDb

This sample application aims to demonstrate the intergration between spring boot, mongodb and Jersey.

Concepts Involved :

1. NoSQL Database (MongoDB)
2. Spring Data 
3. Spring Boot
4. Jersey based REST services.
5. Maven 


##Pre-Requisite:

1. JDK 1.8
2. Maven 3.3+


## Running the application

1. Use the maven command  "mvn clean package" to build the application.
2. You can run the application in two way
    a) Using IDE 

         i)  Import the project into an IDE (like eclipse, Spring Tool Suite). 

         ii) Right click on the "SpringBootInitializer" class and 'Run as Java Application' 

    b) Using Maven

         i)  Use the "mvn spring-boot:run" command to start the application from the terminal


## Testing the Service

1. Send Message API

URL: http://localhost:7001/chat-service/chat/v1/messages

Method Type : HTTP POST

Headers :
      content-type=application/json
      
 Payload Body:
 
 ```javascript
            {
              "senderUserId": "123",
              "receiverUserId": "234",
              "message": "heelow"
            }  
```

2. Get Messages API

URL : http://localhost:7001/chat-service/chat/v1/users/{userId}/messages?filterBy={filter}

Method : HTTP GET

 ```javascript
Example:
      http://localhost:7002/chat-service/chat/v1/users/123/messages?filterBy=sent
```

  








