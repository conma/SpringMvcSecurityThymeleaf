Spring Mvc + Spring Security + Thymeleaf Annotation
- Spring Mvc 5
- Thymeleaf 3
- Spring Security 5
- Annotation Config
- Gradle build

import:

    gradle eclipse

  
Eclipse: File --> Import --> Gradle Project


Build For tomcat:

    1. gradle clean build
    2. cp build/libs/SpringMvcSecurityThymeleafGeneral.war /path/to/tomcat/webapps
    3. /path/to/tomcat/bin/start.sh (Linux) or /path/to/tomcat/bin/start.bat (Windows)
    4. access URL: localhost:8080/SpringMvcSecurityThymeleafGeneral (8080 is default port of Tomcat)
    
    
Join!


-----------
- Default page: / or /login
- User/Password: admin/123456 & user/123456
- /, /login: user & admin --> access
- /home: user & admin --> access
- /admin: admin only
- /user: user & admin --> access
- /logout: user & admin --> access
- /forgot: user & admin --> access
