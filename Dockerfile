FROM maven:3.9.9-eclipse-temurin-21-alpine AS build

ENV PROJECT_HOME /usr/src/av3poo
ENV JAR_NAME av3poo3-0.0.1-SNAPSHOT.jar

RUN mkdir -p $PROJECT_HOME
WORKDIR $PROJECT_HOME

COPY . .

RUN mvn clean package -DskipTests
RUN mv target/$JAR_NAME $PROJECT_HOME/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "av3poo3-0.0.1-SNAPSHOT.jar"]