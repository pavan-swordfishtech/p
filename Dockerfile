FROM openjdk:17
EXPOSE 8080
COPY target/appserver-0.0.1-SNAPSHOT.jar appserver-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/appserver-0.0.1-SNAPSHOT.jar"]
