FROM gradle:8.3-jdk11 AS builder

WORKDIR /app

COPY build.gradle settings.gradle ./
COPY src ./src/

RUN gradle clean
RUN gradle build

FROM adoptopenjdk/openjdk11

WORKDIR /app


COPY --from=builder /app/build/libs/spring-server-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9999

CMD [ "java", "-jar", "app.jar"]
