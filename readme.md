## How to build it?
``` bash
mvn package
```

## How to run it?
``` bash
cd ./target
java -jar smekalka-server.jar
```

## UI
http://127.0.0.1:8080

## End point
http://127.0.0.1:8080/api/1/tracks

## Database
``` bash
docker run -e POSTGRES_PASSWORD=pass -e POSTGRES_USER=user -e POSTGRES_DB=tracks -p5432:5432 postgres
```