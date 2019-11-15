##### Config types

1. External git repo  
    Run [createConfigRepo.bat](createConfigRepo.bat)  
    Set <b>spring.cloud.config.server.git.uri=file:///${user.home}/config</b>  
2. Config files from the local classpath or file system  
    Set <b>spring.profiles.active=native</b>  
    Set <b>spring.cloud.config.server.native.searchLocations=classpath:/config</b> (optional)  
