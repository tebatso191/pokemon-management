FROM openjdk:8
EXPOSE 8080
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","/pokemon-management.jar"]