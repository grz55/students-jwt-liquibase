# Students API + JWT Secured + liquibase used

# How to start: 

Pull into IDE, app runs on Tomcat server.
Postman the best for tests.
Use POST /login to login by credentials, then you have full access to API.
When compiling, liquibase xml files should populate H2 in-memory database.

# Test credentials: 
Login: user or admin
Password: user123 or admin123

# Description: 

This app provides students API. Open access to /students/all endpoint. Other endoints JWT secured

# Technologies: 

Java, Spring Boot, Spring Security, Spring Data, Hibernate, H2 database, liquibase

# App features:

- CRUD students table API
- JWT authentication

# For future:

- login page
- logout not done yet
