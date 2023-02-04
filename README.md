# Explorer-UserApi

## Set up database and local env
in the folder `src/main/resource/` create a file `application.properties`. In the file paste those set up 
```
spring.data.mongodb.database=explorer
spring.data.mongodb.uri=<get it from mongodb connect in the cluster>
spring.data.mongodb.auto-index-creation=true

server.port=8080
```
