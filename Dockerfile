FROM amazoncorretto:17
COPY target/employee-training-0.0.1-SNAPSHOT.jar app/applications.jar
CMD ["java", "-jar", "app/applications.jar"]
