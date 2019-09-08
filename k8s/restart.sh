#!/usr/bin/env bash
DIR=$(cd `dirname $0` && pwd)
. $DIR/stop.sh

./mvnw >/dev/null
docker build -t daggerok/webapp:v1 -f docker/Dockerfile webapp

kubectl delete -f k8s/
kubectl apply -f k8s/
kubectl get all
