dropwizard-guice-jpa-eclipselink
=========================

Sample REST application written with:

- Dropwizard
- Google Guice DI
- Google Guice-Persist extension
- EclipseLink ORM as implementation of JPA 2.1
- PostgreSql as database
- JDK 1.8

###### QuickStart
```
mvn clean package
java -jar target/dropwizard-guice-jpa-eclipselink-1.0-SNAPSHOT.jar server conf.yml
```

###### API - examples
- POST /player - new player
```
curl -H "Content-type: application/json" -X POST -d '{"login": "test-player-01", "name": "test"}' http://localhost:18080/player/
```
- GET /player/{id} - get player
```
curl -H "Content-type: application/json" -X GET http://localhost:18080/player/1
```
- DELETE /player/{id} - delete player
```
curl -H "Content-type: application/json" -X DELETE http://localhost:18080/player/51
```
- GET /player - get all players
```
curl -H "Content-type: application/json" -X GET http://localhost:18080/player/
```
- GET /player/find?name=test - find player by name
```
curl -H "Content-type: application/json" -X GET http://localhost:18080/player/find?name=test
```