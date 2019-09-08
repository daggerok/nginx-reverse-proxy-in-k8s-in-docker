#!/usr/bin/env bash
DIR=$(cd `dirname $0` && pwd)
. $DIR/stop.sh

./mvnw >/dev/null

docker build -t daggerok/webapp -f docker/Dockerfile webapp
docker run -i --rm --name native-app -p 8080:8080 daggerok/webapp
