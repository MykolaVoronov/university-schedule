FROM openjdk:11
ADD target/lectures-schedule-api.jar lectures-schedule-api.jar
ENTRYPOINT ["java", "-jar","lectures-schedule-api.jar"]
EXPOSE 8080