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

# API

# AuthorizationController

This controller is responsible for managing user authentication and login processes.
Endpoints

    POST /api/auth/login

Request: Authenticate a user by sending user information in the request body.

    {
      "username": "user123",
      "password": "secretpassword"
    }

Response: A token or authentication result.

# UserController

The UserController manages user-related operations.
Endpoints

    GET /api/users

Response: Get a list of all users.

    GET /api/users/{userId}

    Response: Get user details by user ID.

    POST /api/users

Request: Create a new user by providing user information in the request body.


{
  "username": "newuser",
  "password": "newpassword"
}

Response: The created user's details.

PUT /api/users/{userId}

Request: Update user details by providing user information in the request body.


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

# VehicleController

The VehicleController manages vehicle-related operations.
Endpoints

    GET /api/vehicles

Response: Get a list of all vehicles.

    POST /api/vehicles

Request: Create a new vehicle by providing vehicle information in the request body.


{
  "name": "Car",
  "type": "Sedan"
}

Response: The created vehicle's details.

GET /api/vehicles/{vehicleId}

Response: Get vehicle details by vehicle ID.

PUT /api/vehicles/{vehicleId}

Request: Update vehicle details by providing updated information in the request body.


    {
      "name": "Updated Car",
      "type": "SUV"
    }

Response: The updated vehicle's details.

    DELETE /api/vehicles/{vehicleId}

Response: Delete a vehicle by vehicle ID.

# VehicleGroupController

The VehicleGroupController manages vehicle group-related operations.
Endpoints

    GET /api/vehicle-groups

Response: Get a list of all vehicle groups.

    POST /api/vehicle-groups

Request: Create a new vehicle group by providing group information in the request body.


{
  "name": "Family Cars"
}

Response: The created vehicle group's details.

    GET /api/vehicle-groups/{id}

Response: Get vehicle group details by ID.

    PUT /api/vehicle-groups/{id}

Request: Update vehicle group details by providing updated information in the request body.


    {
      "name": "Updated Group"
    }

Response: The updated vehicle group's details.

    DELETE /api/vehicle-groups/{id}

Response: Delete a vehicle group by ID.

# AuthenticationController

This controller manages user authentication and token handling.
Endpoints

    POST /api/v1/auth/register

Request: Register a new user by providing registration details in the request body.


    {
      "firstname": "John",
      "lastname": "Doe",
      "email": "john@example.com",
      "password": "secretpassword",
      "role": "USER"
    }

Response: An authentication response containing access and refresh tokens.

    POST /api/v1/auth/authenticate

Request: Authenticate a user by sending email and password in the request body.


    {
      "email": "john@example.com",
      "password": "secretpassword"
    }

Response: An authentication response containing access and refresh tokens.

    POST /api/v1/auth/refresh-token

Request: Refresh the access token using the refresh token.

Response: An updated authentication response with a new access token.

# AuthenticationRequest

A model representing the request to authenticate a user.
AuthenticationResponse

A model representing the response containing access and refresh tokens.
AuthenticationService

This service class handles user registration, authentication, token generation, and management.
Methods

    register: Register a new user and provide an authentication response with tokens.
    authenticate: Authenticate a user and provide an authentication response with tokens.
    refreshToken: Refresh the access token using the refresh token.

# RegisterRequest

A model representing the request to register a new user.

# ApplicationConfig

This configuration class provides beans and settings related to the application's behavior and security.

Beans

    userDetailsService(): Provides a UserDetailsService implementation for user authentication.
    authenticationProvider(): Creates an AuthenticationProvider for user authentication.
    authenticationManager(AuthenticationConfiguration config): Creates an AuthenticationManager for authentication.
    passwordEncoder(): Provides a PasswordEncoder for password hashing.

# JwtAuthenticationFilter

This component implements a JWT-based authentication filter for securing API endpoints.
Functionality

This filter:

    Authenticates users using JWT tokens.
    Manages user authentication and access to protected resources.

# JwtService

This service class handles the creation, validation, and management of JWT tokens.
Methods

    extractUsername(token): Extracts the username from a JWT token.
    generateToken(userDetails): Generates an access token for a user.
    generateRefreshToken(userDetails): Generates a refresh token for a user.
    isTokenValid(token, userDetails): Checks if a token is valid for a user.
    Other utility methods for handling JWT tokens.

# LogoutService

This service class handles user logout by revoking tokens.
Functionality

    Revokes and expires tokens during user logout.

# OpenApiConfig

This configuration class provides OpenAPI documentation settings.
Features

    Defines API documentation settings such as contact information, description, servers, security, etc.

# SecurityConfiguration

This configuration class handles the overall security configuration for the application.
Features

    Defines security settings and authorization rules for different endpoints.
    Configures JWT authentication filter and authentication provider.
    Configures session management, authentication providers, and logout handling.

# UserRepository

This repository interface handles data access operations for the User entity.
Methods

    findByEmail(email): Retrieves a user by their email address.

# VehicleAuthorizationRepository

This repository interface manages data access operations for the VehicleAuthorization entity.
Methods

    deleteByUserIdAndVehicleId(userId, vehicleId): Deletes a vehicle authorization by user ID and vehicle ID.

# VehicleGroupMembershipRepository

This repository interface manages data access operations for the VehicleGroupMembership entity.
Methods

    deleteByUserIdAndGroupId(userId, groupId): Deletes a vehicle group membership by user ID and group ID.

# VehicleGroupRepository

This repository interface manages data access operations for the VehicleGroup entity.
# VehicleRepository

This repository interface manages data access operations for the Vehicle entity.

# ManagementController

This controller manages management-related operations with role-based access control.
Endpoints

    GET /api/v1/management

Description: Get endpoint for manager.

Summary: This is a summary for the management get endpoint.

Response: Returns a message related to the management controller.

    POST /api/v1/management

Response: Returns a message related to the management controller.

    PUT /api/v1/management

Response: Returns a message related to the management controller.

    DELETE /api/v1/management

Response: Returns a message related to the management controller.

# Permission Enum

This enum defines different permissions that users can have.
Permissions

    ADMIN_READ: Permission to read admin-related resources.
    ADMIN_UPDATE: Permission to update admin-related resources.
    ADMIN_CREATE: Permission to create admin-related resources.
    ADMIN_DELETE: Permission to delete admin-related resources.
    STANDARD_READ: Permission to read standard resources.
    STANDARD_UPDATE: Permission to update standard resources.
    STANDARD_CREATE: Permission to create standard resources.
    STANDARD_DELETE: Permission to delete standard resources.
    COMPANY_ADMIN_READ: Permission to read company admin-related resources.
    COMPANY_ADMIN_UPDATE: Permission to update company admin-related resources.
    COMPANY_ADMIN_CREATE: Permission to create company admin-related resources.
    COMPANY_ADMIN_DELETE: Permission to delete company admin-related resources.

# Role Enum

This enum defines different roles that users can have.
# Roles

    ADMIN: Role for administrators with various admin-related permissions.
    STANDARD: Role for standard users with standard-related permissions.
    COMPANY_ADMIN: Role for company administrators with both standard and company admin-related permissions.

# Methods

    getAuthorities(): Returns a list of granted authorities based on the role's permissions.

# User Class

This class represents a user in the application.
Properties

    id: The unique identifier of the user.
    firstname: The first name of the user.
    lastname: The last name of the user.
    email: The email address of the user.
    password: The password of the user.
    role: The role assigned to the user.
    companyId: The ID of the company associated with the user.
    companyName: The name of the company associated with the user.
    tokens: A list of tokens associated with the user.

# Methods

    getAuthorities(): Returns the granted authorities based on the user's role.

# Vehicle Class

This class represents a vehicle in the application.
Properties

    id: The unique identifier of the vehicle.
    plate: The license plate of the vehicle.
    chassisNumber: The chassis number of the vehicle.
    tag: The tag of the vehicle.
    brand: The brand of the vehicle.
    model: The model of the vehicle.
    modelYear: The model year of the vehicle.

# VehicleAuthorization Class

This class represents a vehicle authorization in the application.
Properties

    id: The unique identifier of the vehicle authorization.
    userId: The ID of the user associated with the authorization.
    vehicleId: The ID of the vehicle associated with the authorization.

# VehicleGroup Class

This class represents a vehicle group in the application.
Properties

    id: The unique identifier of the vehicle group.
    groupName: The name of the vehicle group.

# VehicleGroupMembership Class

This class represents a membership of a user in a vehicle group.
Properties

    id: The unique identifier of the membership.
    userId: The ID of the user associated with the membership.
    groupId: The ID of the vehicle group associated with the membership.

# AuthorizationService Class

This class provides methods to manage user authorizations for vehicles and groups.
Methods

    authorizeUserToVehicle(userId, vehicleId): Authorizes a user to a specific vehicle.
    unauthorizeUserFromVehicle(userId, vehicleId): Revokes a user's authorization from a specific vehicle.
    authorizeUserToGroup(userId, groupId): Authorizes a user to a specific group.
    unauthorizeUserFromGroup(userId, groupId): Revokes a user's authorization from a specific group.
    login(user): Simulates user login and returns a success message.

# AuthorizationServiceImpl Class

This class extends AuthorizationService and provides implementations for authorization methods.
Methods

    login(user): Overrides the login method to return a JWT token as a success response.

# UserService Interface

This interface defines methods for user-related operations.
Methods

    getAllUsers(): Retrieves a list of all users.
    getUserById(userId): Retrieves a user by their ID.
    createUser(user): Creates a new user.
    updateUser(userId, user): Updates an existing user.
    deleteUser(userId): Deletes a user.

# UserDetailsServiceImpl Class

This class implements UserDetailsService to load user details from the repository.
Methods

    loadUserByUsername(name): Loads user details by username.

# UserServiceImpl Class

This class implements the UserService interface to provide user-related operations.
Methods

    Implements methods defined in the UserService interface.

# VehicleGroupService Interface

This interface defines methods for vehicle group-related operations.
Methods

    getAllVehicleGroups(): Retrieves a list of all vehicle groups.
    getVehicleGroupById(groupId): Retrieves a vehicle group by its ID.
    createVehicleGroup(vehicleGroup): Creates a new vehicle group.
    updateVehicleGroup(groupId, vehicleGroup): Updates an existing vehicle group.
    deleteVehicleGroup(groupId): Deletes a vehicle group.

# VehicleGroupServiceImpl Class

This class implements the VehicleGroupService interface to provide vehicle group-related operations.
Methods

    Implements methods defined in the VehicleGroupService interface.

# VehicleService Interface

This interface defines methods for vehicle-related operations.
Methods

    getAllVehicles(): Retrieves a list of all vehicles.
    getVehicleById(vehicleId): Retrieves a vehicle by its ID.
    createVehicle(vehicle): Creates a new vehicle.
    updateVehicle(vehicleId, vehicle): Updates an existing vehicle.
    deleteVehicle(vehicleId): Deletes a vehicle.

# VehicleServiceImpl Class

This class implements the VehicleService interface to provide vehicle-related operations.
Methods

    Implements methods defined in the VehicleService interface.

# Token Class

This class represents a user's authentication token.
Properties

    id: The unique identifier of the token.
    token: The token string.
    tokenType: The type of the token (e.g., "BEARER").
    revoked: Indicates if the token is revoked.
    expired: Indicates if the token is expired.
    user: The user associated with the token.

# TokenRepository Interface

This interface defines methods for querying tokens in the repository.
Methods

    findAllValidTokenByUser(id): Retrieves a list of valid tokens associated with a user.
    findByToken(token): Retrieves a token by its value.

# TokenType Enum

This enum defines different token types.
Token Types

    BEARER: Bearer token type.

# License

This project is licensed under the GNU General Public License (GPL). See the [LICENSE](LICENSE) file for more information.
