# 1. 빌드 스테이지 (의존성 다운로드 및 JAR 파일 생성)
FROM openjdk:17-jdk-slim AS build
WORKDIR /app

# 2. Gradle/Maven 빌드 파일 복사
COPY build.gradle gradlew settings.gradle ./
COPY gradle ./gradle

# 3. 의존성 다운로드 (캐싱 활용)
RUN chmod +x gradlew
RUN ./gradlew dependencies

# 4. 소스 코드 복사 및 빌드
COPY src ./src
RUN ./gradlew build -x test

# 5. 실행 스테이지 (최종 이미지 생성)
FROM openjdk:17-jdk-slim
WORKDIR /app

# 6. 빌드 스테이지에서 생성된 JAR 파일 복사
COPY --from=build /app/build/libs/*.jar app.jar

# 7. 컨테이너 실행 시 JAR 파일 실행
ENTRYPOINT ["java", "-jar", "app.jar"]

# 8. 포트 노출 (Spring Boot 기본 포트: 8080)
EXPOSE 8080
