#!/bin/sh

echo "********************************************************"
echo "Waiting for the configuration server to start on port $CONFIGSERVER_PORT"
echo "********************************************************"
while ! nc -z config-server "$CONFIGSERVER_PORT"; do sleep 3; done
echo "*******  Configuration Server has started"

echo "********************************************************"
echo "Waiting for the reservation-business-services server to start on port $RESERVATIONBUSINESSSERVICES_PORT"
echo "********************************************************"
while ! nc -z reservation-business-services "$RESERVATIONBUSINESSSERVICES_PORT"; do sleep 3; done
echo "*******  Reservation-business-services Server has started"

echo "********************************************************"
echo "Starting reservation-webapp"
echo "********************************************************"
java -Dspring.cloud.config.uri="$CONFIGSERVER_URI" -jar /usr/local/apps/app.jar
