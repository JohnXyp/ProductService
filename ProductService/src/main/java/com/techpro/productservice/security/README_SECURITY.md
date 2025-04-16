# 🔐 Security Configuration - ProductService

This document explains in depth how the **Spring Security** system is implemented and configured for the `ProductService` REST API. The goal is to provide **stateless authentication** using **JWT (JSON Web Token)** and secure the API endpoints accordingly.

---

## 🔧 Overview

- **Authentication Method:** In-memory users with username & password.
- **Token-based Authentication:** JWT.
- **Frameworks:** Spring Security 6+, Jakarta Servlet, JSON Web Token (JJWT).
- **Main File:** `SecurityConfig.java` (under `com.techpro.productservice.security`).
- **JWT Utilities:** `JwtUtil.java`
- **JWT Filter:** `JwtFilter.java`

---

## 📁 File Breakdown

### 🔑 `SecurityConfig.java`
The main Spring Security configuration:
- Defines in-memory users.
- Creates a `SecurityFilterChain` bean.
- Disables session creation (stateless).
- Adds JWT filter before the standard `UsernamePasswordAuthenticationFilter`.

---

### 👤 `userDetailsService()`
In-memory user configuration:
- Provides a default admin user for authentication purposes.
- Uses `{noop}` to skip password encoding for demo purposes.

---

### 🛡️ `JwtFilter.java`
This class checks the `Authorization` header, validates the token, extracts the username and roles, and sets the security context.
- Skips filtering for `/auth/login` and Swagger paths.
- Extracts roles from token claims and assigns them as authorities.

---

### 🧠 `JwtUtil.java`
Handles JWT creation, validation, and parsing:
- Generates tokens with claims and expiration.
- Validates token signature and expiration.
- Extracts username and roles.

---

## 📜 Authentication Flow

1. **Login Request:**
   - Send a POST request to `/auth/login` with JSON body containing username and password.

2. **Token Response:**
   - On success, the response returns a JWT token prefixed with "Bearer".

3. **Authorize Protected Routes:**
   - Use the token in the `Authorization` header to access secured endpoints.

---

## 🔒 Protected Endpoints

All endpoints under `/api/products/**` require authentication.

---

## 🔍 Swagger and Public Endpoints

The following endpoints are public:
- `/auth/login`
- `/swagger-ui/**`
- `/v3/api-docs/**`

---

## 🐞 Troubleshooting

- **403 Forbidden:** Ensure you're passing a valid token in the Authorization header.
- **Login failure:** Verify the correct default credentials.
- **Swagger access:** Token should be pasted in Swagger's "Authorize" modal to test secured routes.

---