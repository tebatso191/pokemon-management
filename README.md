# Pokemon Management
Run your Docker image on AWS ECS (Elastic Container Service)

This Project is using Java to consume Pokemon API


## Installation
AWSCodePipelineServiceRole-eu-west-1-pokemon-management-pipelin
## Useful Commands
# springboot-docker-ecs


- Build Docker Image.
  - docker build -f Dockerfile -t pokemon-management .
  - mvn spring-boot:build-image
- docker run -p 8080:8080 pokemon-management


Run below commands for docker hub
docker tag pokemon-management:latest 029460343170.dkr.ecr.eu-west-1.amazonaws.com/pokemon-management-registry
docker push 029460343170.dkr.ecr.eu-west-1.amazonaws.com/pokemon-management-registry
docker push tebatso191/pokemon-management:latest

- Run Docker Image.

      docker run --tty --publish 8080:8080 pokemon-management

- Tag Docker Image

      docker tag pokemon-management tebatso191/pokemon-management

- Push Docker Image to Docker Hub

      docker push tebatso191/pokemon-management
- docker push tebatso191/pokemon-management 

- Application Flow

<img width="576" alt="11" src="https://user-images.githubusercontent.com/25712816/91267149-570d0780-e790-11ea-8497-806b30cbcfc2.PNG">


## Useful Links

- [Swagger Docs](http://localhost:8181/microservice-docs)
- [Swagger UI](http://localhost:8181/swagger-ui/)
- [AWS Console](https://eu-west-1.console.aws.amazon.com/console/home?region=eu-west-1#)
- [GIT Hub](https://github.com/tebatso191/pokemon-management)
- [AWS Build Pipeline](https://eu-west-1.console.aws.amazon.com/codesuite/codepipeline/pipelines/pokemon-management-pipeline/view?region=eu-west-1)
- [AWS Build Pipeline](http://pokemonmanagement-env.eba-ypgcpqdm.eu-west-1.elasticbeanstalk.com/)
- [AWS ECR](https://eu-west-1.console.aws.amazon.com/ecr/repositories/private/029460343170/pokemon-management-registry?region=eu-west-1)
- 
## Architecture Diagram
## Resource To Be Deleted
- Elastic
- S3 
