FROM alpine/ubuntu-java
MAINTAINER nghiatn
COPY spring-boot-skeleton-0.0.1-SNAPSHOT.jar /opt/mercury/lib/
ENV SPRING_APPLICATION_JSON="SB"
ENTRYPOINT ["/bin/bash"]
VOLUME /var/lib/mercury/data
EXPOSE 8082



FROM openjdk:12
ADD target/user-mysql.jar user-mysql.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "user-mysql.jar"]