##### Create config repo

Windows:
```
cd %userprofile%
md config
cd config
echo server.port=8101>roomservices.properties
echo management.security.enabled=false>>roomservices.properties
echo server.port=8500>reservationbusinessservices.properties
echo management.security.enabled=false>>reservationbusinessservices.properties
echo server.port=8102>guestservices.properties
echo management.security.enabled=false>>guestservices.properties
echo server.port=8600>reservationapp.properties
echo management.security.enabled=false>>reservationapp.properties
echo server.port=8103>reservationservices.properties
echo management.security.enabled=false>>reservationservices.properties
git init .
git add -A .
git commit -m "Add application.properties"
```