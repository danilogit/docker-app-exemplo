FROM openjdk:11-jre-slim

WORKDIR  /app

COPY ./target/app-exemplo-0.0.1-SNAPSHOT.jar /app/
COPY ./data /app/data/

EXPOSE 8080

ENTRYPOINT  ["java", "-jar"]

CMD ["app-exemplo-0.0.1-SNAPSHOT.jar"]

#CMD ["java", "-jar", "/app/src/target/app-exemplo-0.0.1-SNAPSHOT.jar"]