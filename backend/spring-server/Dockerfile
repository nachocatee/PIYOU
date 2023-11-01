# 빌드 스테이지
FROM openjdk:11 AS build
WORKDIR /workspace/app
COPY . /workspace/app
RUN chmod 777 ./gradlew
RUN ./gradlew clean build -x test

# 실행 스테이지
FROM openjdk:11-jre-slim
COPY --from=build /workspace/app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
