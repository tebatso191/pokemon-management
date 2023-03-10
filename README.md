# Pokemon Management
This is a Spring Boot (Java) based application that consumes Pokémon API and expose the REST endpoints that can be consumed by frontend or Swagger UI. It supports Get HTTP REST method.
## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

## Prerequisites

In order to run this application you need to install two tools: **Docker** & **Docker Compose**.

Instructions how to install **Docker** on [Ubuntu](https://docs.docker.com/install/linux/docker-ce/ubuntu/), [Windows](https://docs.docker.com/docker-for-windows/install/), [Mac](https://docs.docker.com/docker-for-mac/install/).

**Docker Compose** is already included in installation packs for *Windows* and *Mac*, so only Ubuntu users needs to follow [this instructions](https://docs.docker.com/compose/install/).

## Installation
```cmd
mvn clean istall
```

## How to run Unit Tests
```bash
mvn clean test
```

## How to run the application
You can run the process application with Spring boot.
```bash
mvn spring-boot:run
```

## How to run the application in your Java IDE
Run the project as a Java application in your IDE using Application as the main class.

#### Pokemon (REST API)
Full list of available REST endpoints could be found in Swagger UI, could be called using link: **http://localhost:5000/microservice-ui**

## CI/CD

CodePipeline: This service will create a pipeline by combining all the above services and managing the CI/CD process.

CodeBuild: AWS CodeBuild is used to build the code. To build the code, AWS search for a buildspec yml file.

ECR (Elastic Container Registry): Amazon Elastic Container Registry (ECR) is a fully managed container registry that makes it easy to store, manage, share, and deploy your container images and artifacts anywhere.

ECS (Elastic Container Service): This service pulls the docker image from ECR and deploys the docker image in EC2 or as serverless (Fargate). Here, in this tutorial, we will use the Fargate type launch.

## How Our Pokemon-Management CI/CD Works?
1. Manage your source code.
2. Manage your docker image by ECR.
3. Build a docker image.
4. Docker image deployment to ECS.
5. CodePipeline to automate a process.

## Architecture Diagram
<img width="576" alt="11" src="https://user-images.githubusercontent.com/30393007/218535160-4e6fc52b-cb89-4324-81d9-2ada3576409a.JPG">

## Useful Commands
Build Docker Image
```bash
docker build -f Dockerfile -t pokemon-management .
```

Run Docker Image
```bash
docker run -p 5000:5000 pokemon-management
```

Publish Or Push The Docker Image To Docker Hub
```bash
docker push tebatso191/pokemon-management:latest
```
Tag Docker Image
```bash
docker tag pokemon-management tebatso191/pokemon-management
```
Validate Your build-spec
```bash
aws codebuild validate-build-spec --build-spec=buildspec.yml

```
### Deploying Docker Image TO AWS ECR From Local Machine

Retrieve an authentication token and authenticate your Docker client to your registry. Use the AWS CLI:
```bash
aws ecr get-login-password --region eu-west-1 | docker login --username AWS --password-stdin 029460343170.dkr.ecr.eu-west-1.amazonaws.com
```

Build your Docker image using the following command. For information on building a Docker file from scratch see the instructions here . You can skip this step if your image is already built:
```bash
docker build -t pokemon-management-registry .
```

After the build completes, tag your image so you can push the image to this repository:
```bash
docker tag pokemon-management-registry:latest 029460343170.dkr.ecr.eu-west-1.amazonaws.com/pokemon-management-registry:latest
```

Run the following command to push this image to your newly created AWS repository:
```bash
docker push 029460343170.dkr.ecr.eu-west-1.amazonaws.com/pokemon-management-registry:latest
```

## Useful Links

* [Local Swagger Docs](http://localhost:5000/microservice-docs)
* [Local Swagger UI](http://localhost:5000/swagger-ui/)
* [Get Pokémon List From PokeAPI](https://pokeapi.co/api/v2/pokemon-species/)
* [Get Pokémon Detail By ID From PokeAPI](https://pokeapi.co/api/v2/pokemon-species/1)
* [Get Pokémon Detail By Name From PokeAPI](https://pokeapi.co/api/v2/pokemon-species/bulbasaur)
* [GIT Hub Project Repository](https://github.com/tebatso191/pokemon-management)
* [JWT IO](https://jwt.io/)
* [AWS Console](https://eu-west-1.console.aws.amazon.com/console/home?region=eu-west-1#)
* [AWS Pokemon Build Pipeline](https://eu-west-1.console.aws.amazon.com/codesuite/codepipeline/pipelines/pokemon-management-pipeline/view?region=eu-west-1)
* [AWS ECR](https://eu-west-1.console.aws.amazon.com/ecr/repositories/private/029460343170/pokemon-management-registry?region=eu-west-1)

## License
[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

## Authors
Tebatso Mokgokolo 

## Acknowledgments

* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [AWS CI/CD](https://medium.com/thelorry-product-tech-data/end-to-end-cd-pipeline-amazon-ecs-deployment-using-aws-codepipeline-332b19ca2a9)
* [AWS CI/CD](https://priyank-agarwal.medium.com/deploy-spring-boot-docker-app-through-aws-complete-ci-cd-process-codepipeline-codebuild-ecr-4fe489eab74d)
