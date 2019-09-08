# nginx-reverse-proxy-in-k8s-in-docker
Example of nginx reverse proxy in k8s in Docker for Mac (Windows)

## Table of content

* [local development](#local-development)
** [build locally](#build-locally)
** [run locally](#run-locally)
** [run tests](#run-tests)
* [docker development](#docker-development)
** [build docker image](#build-docker-image)
** [run in docker](#run-in-docker)
* [k8s](#k8s)

## local development

### build locally

```shell script
./mvnw
```

### run locally

```shell script
java -jar webapp/target/*.jar
```

### run tests

```shell script
http  get :8080
http post :8080/maksimko
```

## docker development

### build docker image

```shell script
docker build -t daggerok/webapp -f docker/Dockerfile webapp
```

### run in docker

```shell script
docker run -i --rm --name native-app -p 8080:8080 daggerok/webapp
```

### k8s

TODO: implement me please...

## resources

* [YouTube: Transform a Legacy Application with Kubernetes and Istio - David Gageot](https://www.youtube.com/watch?v=6jBetJgluEE&list=UUCBVCTuk6uJrN3iFV_3vurg&index=5)
