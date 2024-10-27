# Project name: Travel Gear Rental App
<br/>

### Project scope: using REST APIs to store customers and rented travel gear in a database
<br/>

### Technologies used:
   - Spring Boot - version: 3.3.4
   - Java 17
   - Maven
   - PostgreSQL version 16.4-1
   - H2 in-memory database
   - MockMVC (for integration tests) - *to be added*
   - JUnit (for unit tests)
   - Mockito (to mock dependencies for unit tests)
   - Hibernate as ORM (the default ORM provided by Spring)

### Dependencies required (pom.xml): 
*(dependencies were generated with Spring initializr)* 
- spring-boot-starter-data-jpa
- spring-boot-starter-validation
- spring-boot-starter-web
- spring-boot-starter-test
- H2 Database SQL
- PostgreSQL Driver
- Lombok

### Other requirements:
- pgAdmin4  version: 8.10
- PostMan   version 11.18.0

### Project setup:
1. Clone project repository on local machine 
2. Intall PostMan
3. Install PostgreSQL
4. Install pgAdmin4 
5. Check resources:
   --> application.properties should contain:
         
        |    spring.application.name=travelGearRentalApp
        |    
        |    # Database connection properties
        |    spring.datasource.url=jdbc:postgresql://localhost:5432/travel_Gear_Rental_App
        |    spring.datasource.username=developer
        |    spring.datasource.password=developer
        |   spring.datasource.driver-class-name=org.postgresql.Driver
        |    
        |    # JPA properties
        |    spring.jpa.show-sql=true
        |    spring.jpa.hibernate.ddl-auto=update
        |    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
        |    
        |    # Logging properties
        |    logging.level.org.hibernate.SQL=DEBUG
        |    logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
    
6. In pgAdmin -> PostgreSQL 16 -> create a new table with the following settings:

       General -> Database: travel_Gear_Rental_App
               -> Owner:    developer 

7. Run the travelGearRentalApp in intelliJ 
8. Use Postman to send REST API requests to endpoints
<br/>
<br/>
<br/>

### Examples of endpoins in Postman:
**Customers endpoints examples:**

            ------------------------------------------
            POST: http://localhost:8080/api/customers -> creates a new customer 
            body(raw JSON): 
            {
            "firstName": "customer",
            "lastName": "customer",
            "email": "customer@email.com",
            "customerGender": "customer"
            }
            ------------------------------------------
            PATCH:http://localhost:8080/api/customers/1 -> updates customer with id "1"
            body(raw JSON):
            {
            "firstName": "update",
            "lastName": "update",
            "email": "update@email.com",
            "customerGender": "update"
            }
            ------------------------------------------
            GET:http://localhost:8080/api/customers - > get all customers (without params) or by params
            Params:
            Key:                Value:
            firstName           customer
            lastName            customer
            email               customer@email.com
            customerGender      customer
            ------------------------------------------
            DEL: http://localhost:8080/api/customers/1 -> deletes customer with id "1"
            ------------------------------------------
            DEL: http://localhost:8080/api/customers   -> deletes all customers in database
            ------------------------------------------
    
 **Items endpoints examples:**

            ------------------------------------------
            POST: http://localhost:8080/api/items      -> create new item 
            body(raw JSON): 
            {
            "itemName": "item",
            }
            ------------------------------------------
            DEL: http://localhost:8080/api/items/1    -> deletes item with id "1"
            ------------------------------------------
            GET: http://localhost:8080/api/items      -> get all items (without params) or by params
            Params:
            Key:                Value:
            itemName           item
            isRented           no                     -> default for isRented is "no"
            ------------------------------------------