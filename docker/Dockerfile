FROM openjdk:14-ea-12-jdk-alpine3.10
LABEL MAINTAINER='Maksim Kostromin https://github.com/daggerok/nginx-reverse-proxy-in-k8s-in-docker'
RUN apk --no-cache --update add busybox-suid curl unzip sudo openssh-client shadow wget \
 && adduser -h /home/app.user -s /bin/bash -D -u 1025 app.user wheel \
 && echo "app.user ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers \
 && sed -i "s/.*requiretty$/Defaults !requiretty/" /etc/sudoers \
 && apk del busybox-suid unzip sudo openssh-client shadow wget \
 && rm -rf /var/cache/apk/* /tmp/*
USER app.user
WORKDIR /home/app.user
VOLUME /home/app.user
EXPOSE 8080
ENTRYPOINT java -Djava.net.preferIPv4Stack=true \
                -XX:+UnlockExperimentalVMOptions \
                -XshowSettings:vm \
                -jar ./app.jar
CMD /bin/ash
EXPOSE 8080
HEALTHCHECK --timeout=1s \
            --retries=35 \
            CMD curl -f http://127.0.0.1:8080/actuator/health || exit 1
COPY --chown=app.user target/*.jar ./app.jar
