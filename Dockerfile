# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Arguments for JAR file name and path
ARG JAR_FILE_PATH
ARG SERVICE_PORT

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file from the build context to the container
COPY ${JAR_FILE_PATH} /app/application.jar

# Make port available to the world outside this container
EXPOSE ${SERVICE_PORT}

# Run the JAR file
ENTRYPOINT ["java","-jar","/app/application.jar"]
