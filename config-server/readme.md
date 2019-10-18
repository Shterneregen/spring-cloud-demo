##### Create config repo

Windows:
```
cd %userprofile%
md config
cd config
echo server.port=8101>roomservices.properties
git init .
git add -A .
git commit -m "Add application.properties"
```