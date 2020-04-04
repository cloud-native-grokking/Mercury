# Please name the image "mercury-service" by using:
# docker build -t mercury-service .

FROM openjdk:8
MAINTAINER nghiatn_pearly
ENV SPRING_APPLICATION_JSON="SB"
ADD ./target/mercury-service-spring-boot.jar app/mercury-service-spring-boot.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app/mercury-service-spring-boot.jar", "--spring.profiles.active=docker"]