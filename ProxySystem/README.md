
# 🔁 ProxySystem - Java Servlet Redirector

This is a simple Java Servlet project named **ProxySystem** designed to simulate an entry point to a system. It listens on `/proxy-system`, displays a "System reached" message, and automatically redirects the user to a target Swagger UI (hosted on a Spring Boot app running at port `8081`).

## 🚀 Features

- ✅ Java Servlet mapped to `/proxy-system`
- ✅ Responds with a styled HTML message: _"System reached"_
- ✅ Automatically redirects (after 2 seconds) to `http://localhost:8081/swagger-ui/index.html`
- ✅ Deployed in a local **Tomcat** instance (no Docker)

---

## 📁 Project Structure

```
ProxySystem/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── techpro/
│                   └── proxy/
│                       └── ProxySystem.java
├── webapp/
│   └── WEB-INF/
│       └── web.xml
├── pom.xml
```

---

## ⚙️ How It Works

When you access:

```
http://localhost:8080/proxysystem/proxy-system
```

You’ll see:

> ✅ "System reached" message  
> 🔜 Auto-redirect to: `http://localhost:8081/swagger-ui/index.html`

---

## 🛠️ Setup & Deployment

### 1. Prerequisites

- Java 21+
- Apache Tomcat 9+
- Maven

### 2. Build the project

```bash
mvn clean package
```

### 3. Deploy to Tomcat

- Copy the generated `.war` file from `target/` to `TOMCAT_HOME/webapps`
- Restart Tomcat

> 📦 Make sure the `.war` is named like `proxysystem.war` so it's accessible via `/proxysystem/...`

---

## 🔗 Redirect Target

This servlet redirects to the Swagger UI of the companion app **ProductService**:

```
http://localhost:8081/swagger-ui/index.html
```

Ensure that the **ProductService** Docker container is running on port 8081.

---

## 🧪 Example Response

```html
<h2>System reached</h2>
<p>You will be redirected to the Swagger UI shortly...</p>
```

Auto-redirect with:

```html
<meta http-equiv='refresh' content='2;URL=http://localhost:8081/swagger-ui/index.html'/>
```

---

## 🧰 Technologies Used

- Java Servlet API
- Apache Tomcat
- Maven

---

## 👤 Author

**Ioannis Xypteras**  
GitHub: [@JohnXyp](https://github.com/JohnXyp)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
