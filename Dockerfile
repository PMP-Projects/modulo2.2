FROM maven:3.9.8-amazoncorretto-17 AS builder

WORKDIR /app

COPY pom.xml .
COPY domain ./domain
COPY springframework ./springframework

# Compila somente o módulo Spring Boot
RUN mvn -pl springframework -am clean package -DskipTests

FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=builder /app/springframework/target/springframework-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
