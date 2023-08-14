# MobilizProject

This is a micro service to store car logs and user authorizations.

# Features

  1. User registration with role assignment (ADMIN, STANDARD, COMPANY_ADMIN).
  2. User authentication using JWT (JSON Web Tokens).
  3. Role-based access control with permissions (Read, Create, Update, Delete).
  4. Token-based authentication and authorization.
  5. CRUD operations for user management (admin only).
  6. User details stored in the database.
  7. User password encryption using BCrypt.
  8. CRUD operations for vehicle group management (admin only).
  9. Group details stored in the database.
  10. Each group can have multiple vehicles associated with it.
  11. JPA repositories for accessing and managing data in the database.

# Prerequisites

Before running the server, make sure you have the following dependencies installed:

    Spring Boot Web Starter
        Group: org.springframework.boot
        Artifact: spring-boot-starter-web

    Spring Boot Data JPA Starter
        Group: org.springframework.boot
        Artifact: spring-boot-starter-data-jpa

    Spring Security Starter
        Group: org.springframework.boot
        Artifact: spring-boot-starter-security

    Spring Security JWT
        Group: io.jsonwebtoken
        Artifact: jjwt

    Springdoc OpenAPI UI
        Group: org.springdoc
        Artifact: springdoc-openapi-ui

    H2 Database (Optional for Development)
        Group: com.h2database
        Artifact: h2

    Spring Boot DevTools (Optional)
        Group: org.springframework.boot
        Artifact: spring-boot-devtools

    Lombok (Optional)
        Group: org.projectlombok
        Artifact: lombok

    Spring Boot Starter Test
        Group: org.springframework.boot
        Artifact: spring-boot-starter-test

# Getting Started

To run the server on your local machine, follow these steps:

   1. Clone the repository: 
      ```bash
      git clone https://github.com/YasinOkat/MobilizProject.git
      
   2. Install the required dependencies.

# API Endpoints

AuthorizationController

This controller is responsible for managing user authentication and login processes.
Endpoints

    POST /api/auth/login

    Request: Authenticate a user by sending user information in the request body.

    json

    {
      "username": "user123",
      "password": "secretpassword"
    }

    Response: A token or authentication result.

UserController

The UserController manages user-related operations.
Endpoints

    GET /api/users

    Response: Get a list of all users.

    GET /api/users/{userId}

    Response: Get user details by user ID.

    POST /api/users

    Request: Create a new user by providing user information in the request body.

    json

{
  "username": "newuser",
  "password": "newpassword"
}

Response: The created user's details.

PUT /api/users/{userId}

Request: Update user details by providing user information in the request body.

json

    {
      "username": "updateduser",
      "password": "updatedpassword"
    }

    Response: The updated user's details.

    DELETE /api/users/{userId}

    Response: Delete a user by user ID.

    GET /api/users/endpoint

    Request: Provide an X-User header containing user information.

    Response: Endpoint response based on the provided user information.

VehicleController

The VehicleController manages vehicle-related operations.
Endpoints

    GET /api/vehicles

    Response: Get a list of all vehicles.

    POST /api/vehicles

    Request: Create a new vehicle by providing vehicle information in the request body.

    json

{
  "name": "Car",
  "type": "Sedan"
}

Response: The created vehicle's details.

GET /api/vehicles/{vehicleId}

Response: Get vehicle details by vehicle ID.

PUT /api/vehicles/{vehicleId}

Request: Update vehicle details by providing updated information in the request body.

json

    {
      "name": "Updated Car",
      "type": "SUV"
    }

    Response: The updated vehicle's details.

    DELETE /api/vehicles/{vehicleId}

    Response: Delete a vehicle by vehicle ID.

VehicleGroupController

The VehicleGroupController manages vehicle group-related operations.
Endpoints

    GET /api/vehicle-groups

    Response: Get a list of all vehicle groups.

    POST /api/vehicle-groups

    Request: Create a new vehicle group by providing group information in the request body.

    json

{
  "name": "Family Cars"
}

Response: The created vehicle group's details.

GET /api/vehicle-groups/{id}

Response: Get vehicle group details by ID.

PUT /api/vehicle-groups/{id}

Request: Update vehicle group details by providing updated information in the request body.

json

{
  "name": "Updated Group"
}

Response: The updated vehicle group's details.

DELETE /api/vehicle-groups/{id}

Response: Delete a vehicle group by ID.

# License

This project is licensed under the GNU General Public License (GPL). See the [LICENSE](LICENSE) file for more information.
