# Java 21 base image
FROM amazoncorretto:21-alpine3.20-jdk

# Çalışma dizini
WORKDIR /app

# JAR dosyasını kopyala
COPY target/starter-0.0.1-SNAPSHOT.jar app.jar

# Port aç
EXPOSE 8080

# Uygulamayı başlat
ENTRYPOINT ["java", "-jar", "app.jar"]
