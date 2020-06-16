FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app2.jar
EXPOSE 19003
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app2.jar"]
