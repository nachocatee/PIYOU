# 빌드 스테이지
FROM gradle:3.8-jdk11 AS build
WORKDIR /workspace/app
COPY . /workspace/app
RUN gradle clean build -x test

# 실행 스테이지
FROM openjdk:11-jre-slim
COPY --from=build /workspace/app/build/libs/*.jar app.jar
EXPOSE 9999
ENTRYPOINT ["java","-jar","/app.jar"]
