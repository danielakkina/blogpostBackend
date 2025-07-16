# Use a lightweight Java image
FROM eclipse-temurin:17-jdk-jammy as build

# Set working directory
WORKDIR /app

# Copy Maven wrapper files
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

# Copy source and build
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Use runtime image
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy built JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
