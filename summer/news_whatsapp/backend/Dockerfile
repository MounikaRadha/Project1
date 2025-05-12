FROM eclipse-temurin:21-jdk-alpine
RUN apk add --no-cache python3 py3-pip
RUN python3 -m venv /opt/venv
RUN /opt/venv/bin/pip install --no-cache-dir beautifulsoup4 urllib3
ENV PATH="/opt/venv/bin:$PATH"
LABEL maintainer="m0wn1ka.github.io"
COPY build/libs/backend-0.0.1-SNAPSHOT.jar /backend.jar
COPY scrape.py /scrape.py
RUN ls -al /
ENTRYPOINT ["java", "-Dserver.address=0.0.0.0", "-Dserver.port=8080", "-jar", "/backend.jar"]
