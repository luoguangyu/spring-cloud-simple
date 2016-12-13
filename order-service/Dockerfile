FROM frolvlad/alpine-oraclejdk8:slim
#FROM daocloud.io/java:8
MAINTAINER Ivan.Luo
VOLUME /tmp
ADD order-service-1.0.0.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]