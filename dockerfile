FROM openjdk:11-jre-slim

WORKDIR /root

COPY ./*.jar .

CMD java -jar demo-0.0.1-SNAPSHOT.jar