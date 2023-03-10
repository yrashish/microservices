# Rookie way of writing Dockerfile
FROM openjdk:17
RUN mkdir /app
COPY target/*SNAPSHOT-exe.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","/app/app.jar"]