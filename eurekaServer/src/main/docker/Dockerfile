FROM openjdk:8-jdk-alpine
EXPOSE 10080
VOLUME /tmp
COPY eureka-server-1.0.0.BUILD-SNAPSHOT.jar app.jar
#RUN sh -c 'touch /eureka-server.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
