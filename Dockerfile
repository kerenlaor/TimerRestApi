# Use an official Gradle image with Java 17
FROM gradle:8.6.0-jdk17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy Gradle build files
COPY build.gradle .
COPY settings.gradle .
COPY gradle.properties .

# Copy the source code
COPY src src

# Build the application
RUN gradle clean --no-daemon
RUN gradle build

# Create a new image
FROM anegine/android-33-jdk-17:latest

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the Gradle build stage to the container
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]