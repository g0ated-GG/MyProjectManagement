#!/bin/bash
export DB_URL=jdbc:postgresql://localhost:5532/myprojectmanagement
export DB_USER=root
export DB_PASSWORD=root
export APP_USER=admin
export APP_PASSWORD=admin
#java -jar ./build/libs/jmixpm-0.0.1.jar
java -jar -Dspring.profiles.active=dev ./build/libs/jmixpm-0.0.1.jar
