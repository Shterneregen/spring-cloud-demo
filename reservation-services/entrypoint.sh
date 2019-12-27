#!/bin/sh

echo "********************************************************"
echo "Waiting for the configuration server to start on port $CONFIGSERVER_PORT"
echo "********************************************************"
while ! nc -z config-server "$CONFIGSERVER_PORT"; do sleep 3; done
echo "*******  Configuration Server has started"

echo "********************************************************"
echo "Waiting for the eureka server to start on port $EUREKASERVER_PORT"
echo "********************************************************"
while ! nc -z eureka-server "$EUREKASERVER_PORT"; do sleep 3; done
echo "*******  Eureka Server has started"

echo "********************************************************"
echo "Starting reservation-services "
echo "********************************************************"
java -Dspring.cloud.config.uri="$CONFIGSERVER_URI" -jar /usr/local/apps/app.jar
