FROM maven:3.3.9-jdk-8
EXPOSE 5000
ADD target/*.jar pokemon-management.jar
ENTRYPOINT ["java","-jar","/pokemon-management.jar"]