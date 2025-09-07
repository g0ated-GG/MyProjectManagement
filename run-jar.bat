set DB_URL='jdbc:postgresql://localhost:5532/myprojectmanagement'
set DB_USER='root'
set DB_PASSWORD='root'
set APP_USER='admin'
set APP_PASSWORD='admin'
rem java -jar build/libs/jmixpm-0.0.1.jar
java -jar "-Dspring.profiles.active=dev" build/libs/jmixpm-0.0.1.jar
