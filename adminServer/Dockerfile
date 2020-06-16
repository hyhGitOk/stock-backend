FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app1.jar
EXPOSE 19002
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app1.jar"]
