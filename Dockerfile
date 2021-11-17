FROM openjdk:11

WORKDIR  /app/src

ADD . /app/src

RUN ./mvnw clean install

EXPOSE 8080

CMD ["java", "-jar", "/app/src/target/app-exemplo-0.0.1-SNAPSHOT.jar"]