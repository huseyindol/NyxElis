# Single-stage runtime image
FROM amazoncorretto:21-alpine-jdk

# Build edilmiş JAR'ı kopyala
COPY app.jar /app/app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "/app/app.jar"]