FROM openjdk:8-jdk-alpine
MAINTAINER Marilia Nunes Alves <nunes.marilia@gmail.com>

RUN apk --no-cache add curl

ENV JAVA_OPTS=""

VOLUME /tmp
COPY ./target/newclient-0.0.1.jar app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
EXPOSE 8080 9001
