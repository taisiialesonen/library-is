# Build
FROM eclipse-temurin:25-jdk AS build
WORKDIR /workspace

COPY gradlew settings.gradle build.gradle ./
COPY gradle gradle
COPY src src

RUN chmod +x gradlew \
    && ./gradlew bootJar -x test --no-daemon \
    && JAR="$(find build/libs -name '*.jar' ! -name '*-plain.jar' | head -n 1)" \
    && cp "$JAR" /workspace/app.jar

# Runtime
FROM eclipse-temurin:25-jre
WORKDIR /app

COPY --from=build /workspace/app.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
