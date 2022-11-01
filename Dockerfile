FROM openjdk:17-jdk-slim

EXPOSE 8080

ADD build/libs/TIL-ULTIMATE-main-0.0.1-SNAPSHOT.jar TIL-ULTIMATE-main-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","TIL-ULTIMATE-main-0.0.1-SNAPSHOT.jar"]