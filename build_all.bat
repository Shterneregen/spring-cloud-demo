cd .\config-server
call gradle clean build

cd ..\eureka-server
call gradle clean build

cd ..\room-services
call gradle clean build

cd ..\guest-services
call gradle clean build

cd ..\reservation-services
call gradle clean build

cd ..\reservation-business-services
call gradle clean build

cd ..\reservation-webapp
call gradle clean build

pause