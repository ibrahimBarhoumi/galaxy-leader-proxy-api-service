FROM openjdk:11-slim
WORKDIR /app
ADD /target/galaxy-leader-proxy-api-service-*.jar /app/galaxy-leader-proxy-api-service.jar
CMD ["java", "-Dspring.profiles.active = $SPRING_ACTIVE_PROFILE", "-jar", "galaxy-leader-proxy-api-service.jar"]
