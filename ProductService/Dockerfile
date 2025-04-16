# Base Java image
FROM openjdk:21-jdk-slim

# Add curl + net-tools + procps for debugging
RUN apt-get update && apt-get install -y curl net-tools procps && rm -rf /var/lib/apt/lists/*

# Copy and run the application
VOLUME /tmp
COPY target/productservice-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]