FROM openjdk:17

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} /app.jar

ENV SPRING_PROFILE="DEV"

ENTRYPOINT ["java", "-jar", "/app.jar"]