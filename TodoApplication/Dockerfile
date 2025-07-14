FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/todo-java-app-1.0.jar pranalitodo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "pranalitodo.jar"]  