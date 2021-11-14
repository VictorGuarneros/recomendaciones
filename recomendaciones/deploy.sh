#!/bin/bash
clear && \
	mvn clean package -DskipTests && \
		heroku deploy:jar target/recomendaciones-0.0.1-SNAPSHOT.jar --app kafka-recomendaciones
