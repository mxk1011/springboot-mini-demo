FROM ubuntu:18.04

EXPOSE 443

RUN apt-get update
RUN apt-get install curl -y
RUN apt install apt-utils maven -y
RUN apt install openjdk-11-jdk openjdk-11-jre -y
RUN apt-get install software-properties-common -y

RUN mkdir /var/www
WORKDIR /var/www
RUN cd /var/www

COPY . .

ENTRYPOINT mvn -U clean spring-boot:run