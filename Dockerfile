
FROM amazoncorretto:17
EXPOSE 8081
ADD target/e-commerce-backend.jar e-commerce-backend.jar
ENTRYPOINT  ["java", "-jar", "./e-commerce-backend.jar"]