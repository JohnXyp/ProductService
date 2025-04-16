# ProxySystem Servlet Application

This is a simple Java Servlet project named **ProxySystem** developed as part of a Java backend assessment. The servlet:

    - Listens on the `/proxy-system` endpoint
    - Responds with the message `"System reached"`
    - Redirects the client to the Swagger UI of a Dockerized Spring Boot application (expected to run at `http://localhost:8081/swagger-ui/index.html`)

## 📦 Technologies Used

    - Java 21
    - Maven
    - Java Servlet API (javax.servlet)
    - Apache Tomcat 9+
    - HTML + Meta Redirect

## 📁 Project Structure

ProxySystem/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── techpro/
│                   └── proxy/
│                       └── ProxySystem.java
├── pom.xml
└── README.md

## ⚙️ How to Build

Make sure you have **JDK 21+** and **Maven** installed.

In the project root (`ProxySystem/`), run:

```bash
mvn clean package

This will generate a WAR file located at: target/proxysystem.war

🚀 How to Deploy
	1.	Install Apache Tomcat 9+.
	2.	Copy the generated WAR file into Tomcat’s webapps/ directory: cp target/proxysystem.war /path/to/tomcat/webapps/
    3.	Start Tomcat

🌐 How to Test

    Visit the servlet in your browser: http://localhost:8080/proxysystem/proxy-system
    You should see:
	•	A message: "System reached"
	•	After 2 seconds, your browser will automatically redirect to the Swagger UI of your Spring Boot application:
        http://localhost:8081/swagger-ui/index.html

    ⚠️ Note: Make sure your Spring Boot application is running in Docker on port 8081 with Swagger UI enabled.

	🔐 Notes
	•	The servlet uses the @WebServlet("/proxy-system") annotation for configuration.
	•	Response is written in HTML with a <meta> tag to perform a client-side redirect.

📄 License

This project is intended for educational and assessment purposes only.