# ----------------------------------------------------------------------
# Stage 1: BUILDER
FROM amazoncorretto:21-alpine-jdk AS builder
# Uygulama kaynak kodunu builder container içine kopyala
COPY . /app
WORKDIR /app

# Uygulamayı derle, JAR dosyasını oluştur.
RUN /app/mvnw clean package -DskipTests


# ----------------------------------------------------------------------
# Stage 2: RUNTIME
FROM amazoncorretto:21-alpine-jdk AS runner

# Build aşamasında oluşturulan JAR'ı kopyala
# JAR dosyasının adı 'starter-0.0.1-SNAPSHOT.jar' olarak varsayılmıştır.
COPY --from=builder /app/target/starter-0.0.1-SNAPSHOT.jar /app/app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "/app/app.jar"]