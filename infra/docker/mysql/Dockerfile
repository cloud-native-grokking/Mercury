# Please name the image "mysql-mercury" by using:
# docker build -t mysql-mercury .


FROM mysql:8.0
MAINTAINER nghiatn_pearly
ENV SPRING_APPLICATION_JSON="SB"
COPY ./scripts/ /docker-entrypoint-initdb.d/