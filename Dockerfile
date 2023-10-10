
FROM amazoncorretto:17
EXPOSE 8080
ADD target/e-commerce-backend.jar e-commerce-backend-1.jar
ENTRYPOINT  ["java", "-jar", "./e-commerce-backend-1.jar"]