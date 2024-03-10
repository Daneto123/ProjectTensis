FROM gradle:jdk17 AS build

WORKDIR /app

COPY build.gradle settings.gradle /app/
COPY src /app/src

COPY gradlew /app/
COPY gradle /app/gradle

RUN gradle --no-daemon init

COPY . /app

RUN gradle --no-daemon build

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/build/libs/IotSensorArt.jar .

CMD ["java", "-jar", "IotSensorArt.jar"]

