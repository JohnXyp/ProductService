
# 🚀 TechPro Product Management System

This is a full-stack **Product Management REST API** developed for educational and practical purposes using **Java Spring Boot**, secured with **JWT Authentication**, fully **Dockerized** with PostgreSQL and PgAdmin, and includes a **ProxyServlet** that redirects to Swagger UI.

---

## 📁 Project Structure

```
techpro-product-system/
├── ProductService/            # Main Spring Boot REST API application
│   ├── src/
│   ├── Dockerfile
│   ├── docker-compose.yml
│   └── init-scripts/          # Contains schema.sql and data.sql
├── ProxySystem/               # Java Servlet that redirects to Swagger UI
│   ├── src/
│   └── web.xml (if needed)
└── README.md
```

---

## 🔐 Features

- ✅ Full CRUD API for managing products
- ✅ JWT Authentication system (`/auth/login`)
- ✅ Secured API endpoints
- ✅ Swagger UI for testing endpoints
- ✅ Docker Compose (Spring Boot + PostgreSQL + PgAdmin)
- ✅ ProxyServlet for redirecting users to Swagger UI
- ✅ In-memory user for login: `ioannis:xypteras`

---

## 🐳 Docker Setup

From the `ProductService` directory:

```bash
docker-compose up --build
```

Then access:
- API base: [http://localhost:8081](http://localhost:8081)
- Swagger UI: [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)
- PgAdmin: [http://localhost:5050](http://localhost:5050) → `admin@techpro.com` / `admin123`

---

## ✅ Authentication

- Use this endpoint to get a JWT token:

```http
POST /auth/login
Content-Type: application/json

{
  "username": "ioannis",
  "password": "xypteras"
}
```

Successful response:

```json
{
  "token": "Bearer eyJhbGciOiJIUzI1NiIsIn..."
}
```

Use the token in the `Authorization` header for all subsequent requests:

```
Authorization: Bearer eyJhbGciOi...
```

---

## 🧪 Sample API Usage

### 🔍 Get All Products

```http
GET /api/products
```

**Response:**
```json
[
  {
    "id": 1,
    "name": "Laptop",
    "price": 1200.00
  },
  ...
]
```

---

### 📦 Create a Product

```http
POST /api/products
Content-Type: application/json

{
  "name": "New Monitor",
  "price": 159.99
}
```

**Response:**
```json
{
  "id": 6,
  "name": "New Monitor",
  "price": 159.99
}
```

---

### 🔄 Update a Product

```http
PUT /api/products/6
Content-Type: application/json

{
  "name": "Updated Monitor",
  "price": 179.99
}
```

**Response:**
```json
{
  "id": 6,
  "name": "Updated Monitor",
  "price": 179.99
}
```

---

### ❌ Delete a Product

```http
DELETE /api/products/6
```

---

## 🌐 Proxy Servlet (Bonus)

### URL:
[http://localhost:8080/proxysystem/proxy-system](http://localhost:8080/proxysystem/proxy-system)

This is a basic Java EE Servlet that:
- Prints: “System reached”
- Redirects to: `http://localhost:8081/swagger-ui/index.html`

---

## 📦 Technologies Used

- Java 21
- Spring Boot 3.4
- Spring Security (JWT)
- PostgreSQL 17
- PgAdmin4
- Docker + Docker Compose
- Swagger / OpenAPI (springdoc-openapi)
- Tomcat (for ProxyServlet)
- Maven

---

## 📂 GitHub Structure

If pushing to GitHub, structure like this:

```
TechPro/
├── ProductService/
├── ProxySystem/
└── README.md
```

---

## 💡 Author

Developed by **John Xypteras**  
Student project for full-stack backend development

---
