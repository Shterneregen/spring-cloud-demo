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
echo "Waiting for the room-services server to start on port $ROOMSERVICES_PORT"
echo "********************************************************"
while ! nc -z room-services "$ROOMSERVICES_PORT"; do sleep 3; done
echo "*******  Room-services Server has started"

echo "********************************************************"
echo "Waiting for the guest-services server to start on port $GUESTSERVICES_PORT"
echo "********************************************************"
while ! nc -z guest-services "$GUESTSERVICES_PORT"; do sleep 3; done
echo "*******  guest-services Server has started"

echo "********************************************************"
echo "Waiting for the reservation-services server to start on port $RESERVATIONSERVICES_PORT"
echo "********************************************************"
while ! nc -z reservation-services "$RESERVATIONSERVICES_PORT"; do sleep 3; done
echo "*******  Reservation-services Server has started"

echo "********************************************************"
echo "Starting reservation-business-services "
echo "********************************************************"
java -Dspring.cloud.config.uri="$CONFIGSERVER_URI" -jar /usr/local/apps/app.jar
