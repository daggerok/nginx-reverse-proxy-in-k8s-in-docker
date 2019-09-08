# nginx-reverse-proxy-in-k8s-in-docker [![Build Status](https://travis-ci.org/daggerok/nginx-reverse-proxy-in-k8s-in-docker.svg?branch=master)](https://travis-ci.org/daggerok/nginx-reverse-proxy-in-k8s-in-docker)
Example of nginx reverse proxy in k8s in Docker for Mac / Windows or by using kind (Kubernetes in Docker) tool on Linux

## Table of content

* [Local development](#local-development)
  - [Build locally](#build-locally)
  - [Run locally](#run-locally)
  - [Run tests](#run-tests)
* [Docker development](#docker-development)
  - [Build docker image](#build-docker-image)
  - [Run in docker](#run-in-docker)
* [k8s](#k8s)
  - [create k8s deployment](#create-k8s-deployment)
  - [delete k8s deployment](#delete-k8s-deployment)

## Local development

### Build locally

```shell script
./mvnw
```

### Run locally

```shell script
java -jar webapp/target/*.jar
```

### Run tests

```shell script
http  get :8080
http post :8080/maksimko
```

## Docker development

### Build docker image

```shell script
docker build -t daggerok/webapp -f docker/Dockerfile webapp
```

### Run in docker

```shell script
docker run -i --rm --name native-app -p 8080:8080 daggerok/webapp
```

## k8s

after docker image was built

### create k8s deployment

```shell script
kubectl apply -f k8s/
```

### delete k8s deployment

```shell script
kubectl delete -f k8s/
```

## Resources

* [YouTube: Transform a Legacy Application with Kubernetes and Istio - David Gageot](https://www.youtube.com/watch?v=6jBetJgluEE&list=UUCBVCTuk6uJrN3iFV_3vurg&index=5)
