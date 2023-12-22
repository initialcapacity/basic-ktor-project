# Basic Ktor project

## Getting started

Install dependencies.

- [Java](https://adoptium.net/temurin/releases/?version=21)
- [Flyway](https://documentation.red-gate.com/fd)
- [Docker Desktop](https://www.docker.com/products/docker-desktop)
- [Postgres](https://www.postgresql.org/)
- [Stripe mock](https://github.com/stripe/stripe-mock)

1. Set up the database.

   ```bash
   psql postgres < databases/create_databases.sql
   flyway -user=initialdev -password=initialdev -url="jdbc:postgresql://localhost:5432/example_development" -locations=filesystem:databases/example migrate
   flyway -user=initialdev -password=initialdev -url="jdbc:postgresql://localhost:5432/example_test" -locations=filesystem:databases/example migrate
   ```

1. Build the application.

   ```bash
   ./gradlew clean build
   ```

1. Run the application locally.

   ```bash
   java -jar applications/webapp/build/libs/webapp.jar
   ```

## Run with Docker

1. Build with Docker.
   ```bash
    docker build -t webapp . --platform linux/amd64
    ```

1. Run with Docker.
   ```bash
   docker run -p 8080:8080 --env-file .env.docker webapp
   ```
