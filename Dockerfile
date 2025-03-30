# 1. 빌드 스테이지 (의존성 다운로드 및 JAR 파일 생성)
FROM openjdk:17-jdk-slim AS build
WORKDIR /app

# Gradle 실행 전 필요한 패키지 설치
RUN apt-get update && apt-get install -y dos2unix

# Gradle 관련 파일 복사
COPY build.gradle gradlew settings.gradle ./
COPY gradle ./gradle

# Gradle 실행 권한 부여 및 형식 변환
RUN dos2unix ./gradlew && chmod +x ./gradlew

# 의존성 다운로드 (캐싱 활용)
RUN ./gradlew dependencies

# 소스 코드 복사 및 빌드
COPY src ./src
RUN ./gradlew build -x test

# 2. 실행 스테이지 (최종 이미지 생성)
FROM openjdk:17-jdk-slim
WORKDIR /app

# 빌드 스테이지에서 생성된 JAR 파일 복사
COPY --from=build /app/build/libs/*.jar app.jar

# 포트 노출 (Spring Boot 기본 포트: 8080)
EXPOSE 8080

# 컨테이너 실행 시 JAR 파일 실행
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
