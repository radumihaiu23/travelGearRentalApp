#Travel Gear Rental java project with Spring

You will find below the technical requirements for individual projects:

1. The application should use the following tech stack:
   Spring Boot
   Java 17
   Maven
   PostgreSQL
   H2 in-memory database
   MockMVC (for integration tests)
   JUnit (for unit tests)
   Mockito (to mock dependencies for unit tests)
   Hibernate as ORM (the default one provided by Spring)

2. There should be at least four REST APIs: one for each CRUD operation.

3. At least one API should have a more complex query behind it, for example, 
   a GET API that retrieves data with more than one @RequestParam (as in the example below).

   @GetMapping
   public ResponseEntity<List<User>> getUsers(@RequestParam("name") String name,
   @RequestParam("city") String city,
   @RequestParam("gender") String gender) {
   // Logic to fetch users based on the provided criteria
   }

4. Create a readme file of the project - this should include a description of the tech stack used, 
   how the application can be started, and the core functionalities.

5. Create integration and unit tests.

6. Use try-catch blocks when needed and custom exceptions.

7. There is no authentication or authorization required.

8. If needed, you can use a SQL script to populate the database or you can create POST APIs for this.

9. Validate data before saving it to the database (DTO validation and/or service layer validation). 
   If the validation is not fulfilled, the API should return a proper message and HTTP status code to the user.

10. Ensure that your application is free of compile errors, all tests pass successfully, and it has been thoroughly
   tested with Postman. Don't forget to follow proper code formatting. We want to make sure everything works perfectly 
   for the final demo.
