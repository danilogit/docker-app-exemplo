#!/bin/bash
./mvnw clean package -Dmaven.test.skip
docker build --rm -t docker-app-exemplo .