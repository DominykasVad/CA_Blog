FROM adoptopenjdk/openjdk11:jdk-11.0.9_11.1-alpine

ENV SPRING_PROFILES_ACTIVE=prod

RUN apk update
RUN apk upgrade

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080/tcp