# Use an official Java 8 runtime as the base image
FROM openjdk:8-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file to the container
COPY target/your-application.jar app.jar

# Set the environment variables for MySQL database connection
ENV DB_HOST=db-mysql-nyc1-85609-do-user-4849540-0.b.db.ondigitalocean.com
ENV DB_PORT=25060
ENV DB_NAME=defaultdb
ENV DB_USER=test
ENV DB_PASSWORD=AVNS_2PefuyUWwjAMTTSHyAB

# Expose the port on which your application runs (if necessary)
EXPOSE 8080

# Run the application when the container starts
CMD ["java", "-jar", "app.jar"]
