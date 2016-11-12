# Pull base image.
FROM maven:latest

# Define working directory.
WORKDIR /fitnesse

MAINTAINER zsolt.zsuffa@gmail.com

EXPOSE 9123
ADD build/. /fitnesse
CMD mvn clean verify -P wiki
