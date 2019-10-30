call start .\config-server\gradlew bootRun
TIMEOUT 7
call start .\eureka-server\gradlew bootRun
TIMEOUT 7
call start .\room-services\gradlew bootRun
TIMEOUT 7
call start .\guest-services\gradlew bootRun
TIMEOUT 7
call start .\reservation-services\gradlew bootRun
TIMEOUT 7
call start .\reservation-business-services\gradlew bootRun
TIMEOUT 7
call start .\reservation-webapp\gradlew bootRun

pause