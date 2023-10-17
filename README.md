# Basic Ktor project

## Getting started

All the commands you'll need for the moment.

```bash
psql postgres < databases/create_databases.sql
flyway -user=initialdev -password=initialdev -url="jdbc:postgresql://localhost:5432/example_development" -locations=filesystem:databases/example migrate 
flyway -user=initialdev -password=initialdev -url="jdbc:postgresql://localhost:5432/example_test" -locations=filesystem:databases/example migrate 
./gradlew clean build
java -jar applications/webapp/build/libs/webapp-all.jar
docker build -t webapp . --platform linux/amd64
docker run -p 8080:8080 --env-file .env.docker webapp
```

Thanks
