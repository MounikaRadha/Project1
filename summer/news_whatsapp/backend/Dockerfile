FROM eclipse-temurin:21-jdk-alpine
RUN apt-get update && apt-get install -y python3
MAINTAINER m0wn1ka.github.io
COPY build/libs/backend-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java", "-Dserver.address=0.0.0.0", "-Dserver.port=8080", "-jar", "/backend.jar"]


