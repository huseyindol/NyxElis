FROM amazoncorretto:21-alpine-jdk

WORKDIR /app

COPY target/starter-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]