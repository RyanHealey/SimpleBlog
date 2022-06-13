FROM openjdk:11-jre

WORKDIR /
COPY ./build/libs/simple-blog-backend-*.jar simple-blog-backend.jar
CMD java -Dspring.profiles.active=docker -jar simple-blog-backend.jar
EXPOSE 8080