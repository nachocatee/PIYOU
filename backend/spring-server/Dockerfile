# 베이스 이미지를 선택합니다.
FROM openjdk:11

# 작업 디렉토리를 설정합니다.
WORKDIR /app

# 소스 코드와 빌드 파일을 복사합니다.
COPY . /app

# Gradle wrapper 권한 설정
RUN chmod +x ./gradlew

EXPOSE 9999

# 애플리케이션을 실행합니다.
CMD ["./gradlew", "bootRun"]
