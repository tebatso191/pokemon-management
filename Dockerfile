FROM maven:3.6.1-jdk-8-slim AS build
EXPOSE 8181
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package -Dmaven.wagon.http.ssl.insecure=true

FROM openjdk:8-jdk-alpine
COPY --from=build /workspace/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]