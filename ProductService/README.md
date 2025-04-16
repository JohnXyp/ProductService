# 📦 ProductService – Spring Boot REST API with PostgreSQL, JWT Security & Docker

This is a secure, Dockerized RESTful API for managing products. It uses Spring Boot, PostgreSQL, JWT-based authentication, and includes Swagger UI and PgAdmin for database management.

## 🚀 Features

- 🔐 JWT Authentication
- 📦 Full CRUD for Product Entity
- 🧾 PostgreSQL integration
- 🐳 Fully Dockerized (Spring App + DB + Admin)
- 📘 Swagger UI docs
- 🔑 Basic Spring Security (in-memory user)

## 🧰 Tech Stack

- Java 21
- Spring Boot 3.4.4
- Spring Security
- JWT (io.jsonwebtoken)
- PostgreSQL 17
- Docker + Docker Compose
- Swagger UI (springdoc-openapi)
- PgAdmin 4

## 📁 Project Structure

```
ProductService/
├── src/
│   └── main/
│       ├── java/com/techpro/productservice/
|       |---|-- config
│       │   ├── controller/
│       │   ├── dto/
│       │   ├── model/
│       │   ├── repository/
│       │   ├── security/
│       │   └── service/
│       └── resources/
│           ├── application.properties
│           ├── init-scripts/     ← Contains schema.sql & data.sql for PostgreSQL initialization
|
├── Dockerfile
├── docker-compose.yml
└── README.md
```
---

## 🏗️ Getting Started

### 1️⃣ Clone the repository

```bash
git clone https://github.com/JohnXyp/ProductService
cd ProductService
```

### 2️⃣ Start with Docker

```bash
docker compose up --build
```

This starts:
- PostgreSQL (5432)
- PgAdmin (5050)
- Spring Boot App (8081)

---

## ⚙️ Configuration

`src/main/resources/application.properties`:

```properties
# PostgreSQL
spring.datasource.url=jdbc:postgresql://postgres:5432/productdb
spring.datasource.username=techpro
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=validate
spring.sql.init.mode=never

# Server
server.port=8081
```

---

## 🔐 Authentication

### 🔑 Login Endpoint

```
POST /auth/login
```

```json
{
  "username": "ioannis",
  "password": "xypteras"
}
```

Returns a Bearer token.

---

## 📦 API Endpoints

All endpoints require Bearer token (JWT):

| Method | Endpoint              | Description              |
|--------|-----------------------|--------------------------|
| GET    | /api/products         | Get all products         |
| GET    | /api/products/{id}    | Get product by ID        |
| POST   | /api/products         | Create new product       |
| PUT    | /api/products/{id}    | Update product           |
| DELETE | /api/products/{id}    | Delete product           |

---

## 📚 Swagger UI

Access API documentation here:

```
http://localhost:8081/swagger-ui/index.html
```

**Login first** via `/auth/login`, then paste the JWT as:

```
Bearer <your-token>
```

Authorize from the top-right 🔓 icon.

---

## 🧑‍💻 PgAdmin Access

```
URL: http://localhost:5050
Email: admin@techpro.com
Password: admin123
```

Connect to server with:

- Host: `postgres`
- User: `techpro`
- Password: `password`
- DB: `productdb`

---

## 🧪 Testing (Postman or Swagger)

1. Login via `/auth/login`
2. Copy token from response
3. Click 🔓 Authorize in Swagger UI
4. Use `Bearer <token>` format

---

## 🗃️ Database Initialization

Your schema and seed data are stored in `/init-scripts`:

- `schema.sql` creates the `products` table.
- `data.sql` inserts initial data.

This only runs the first time the PostgreSQL volume is created.

```yaml
volumes:
  - ./init-scripts:/docker-entrypoint-initdb.d
```

---

## ✅ Testing With curl

```bash
# Login to get JWT
curl -X POST http://localhost:8081/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"password"}'

# Get products with JWT
curl -X GET http://localhost:8081/api/products \
  -H "Authorization: Bearer <your_token>"
```

---

## 🧼 Cleanup

To shut down:

```bash
docker compose down
```

To remove volumes:

```bash
docker compose down -v
```

---

## 📬 Sample API Requests & Responses

### 🔐 1. Authenticate to receive a JWT token

**Request:**
```bash
curl -X POST http://localhost:8081/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"ioannis","password":"xypteras"}'
```

**Response:**
```json
"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJpb2FubmlzIiwiaWF0IjoxNjg3NjU2MDY2LCJleHAiOjE2ODc2NTk2NjZ9.JoLepFv-0bbt3XQFaF3MgcbXzNm2rknDOYJbAKvjUXg"
```

---

### 📦 2. Get all products

**Request:**
```bash
curl -X GET http://localhost:8081/api/products \
  -H "Authorization: Bearer <your_token_here>"
```

**Response:**
```json
[
  {
    "id": 1,
    "name": "Laptop",
    "price": 1200.00
  },
  {
    "id": 2,
    "name": "Smartphone",
    "price": 799.99
  }
]
```

---

### 🔍 3. Get a product by ID

**Request:**
```bash
curl -X GET http://localhost:8081/api/products/1 \
  -H "Authorization: Bearer <your_token_here>"
```

**Response:**
```json
{
  "id": 1,
  "name": "Laptop",
  "price": 1200.00
}
```

---

### 🆕 4. Add a new product

**Request:**
```bash
curl -X POST http://localhost:8081/api/products \
  -H "Authorization: Bearer <your_token_here>" \
  -H "Content-Type: application/json" \
  -d '{"name":"Tablet","price":450.00}'
```

**Response:**
```json
{
  "id": 6,
  "name": "Tablet",
  "price": 450.00
}
```

---

### 🔄 5. Update a product

**Request:**
```bash
curl -X PUT http://localhost:8081/api/products/6 \
  -H "Authorization: Bearer <your_token_here>" \
  -H "Content-Type: application/json" \
  -d '{"name":"Tablet Pro","price":499.99}'
```

**Response:**
```json
{
  "id": 6,
  "name": "Tablet Pro",
  "price": 499.99
}
```

---

### ❌ 6. Delete a product

**Request:**
```bash
curl -X DELETE http://localhost:8081/api/products/6 \
  -H "Authorization: Bearer <your_token_here>"
```

**Response:**
```http
HTTP/1.1 200 OK
```

## 📝 License

This project is for educational/demo purposes as part of the **TechPro Academy** backend developer training.

## 📧 Contact

Created by **Ioannis Xypteras**  
For any issues, please contact: `giannis.xypteras@gmail.com`
---

