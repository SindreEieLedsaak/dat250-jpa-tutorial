# PostgreSQL Docker Container

## PostgreSQL Container Running

After creating the PostgreSQL container, we can verify that it is running by using the `docker ps` command. Below is the output:

```bash
sindreeieledsaak@Sindre-sin-Brbar-datamaskin ~ % docker ps
CONTAINER ID   IMAGE                             COMMAND                  CREATED        STATUS        PORTS                    NAMES
4e5b813de882   postgres                          "docker-entrypoint.s…"   46 hours ago   Up 46 hours   0.0.0.0:5432->5432/tcp   my-postgres
a8222996c967   docker/welcome-to-docker:latest   "/docker-entrypoint.…"   46 hours ago   Up 46 hours   0.0.0.0:8088->80/tcp     welcome-to-docker
sindreeieledsaak@Sindre-sin-Brbar-datamaskin ~ %
```
## Test passing using psql

INFO: HHH10001005: Database info:
Database JDBC URL [jdbc:postgresql://127.0.0.1:5432/postgres]
Database driver: org.postgresql.Driver
Database version: 17.0
Autocommit mode: false
Isolation level: undefined/unknown
Minimum pool size: 1
Maximum pool size: 20
okt. 09, 2024 10:02:13 A.M. org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
Max Mustermann lives at Inndalsveien 28
BUILD SUCCESSFUL in 1s
4 actionable tasks: 1 executed, 3 up-to-date
10:02:13: Execution finished ':test --tests "no.hvl.dat250.jpa.tutorial.creditcards.driver.CreditCardsMainTest"'.


# SPA Docker Container

## SPA Container Running

After creating the SPA container, we can verify that it is running by using the `docker images` command.
Below is the output, showing the newly created `myapp` image:

```bash
REPOSITORY                 TAG       IMAGE ID       CREATED          SIZE
myapp                      latest    f8bc7341ea1d   10 minutes ago   482MB
postgres                   latest    8ae3e9e1bbb0   12 days ago      456MB
docker/welcome-to-docker   latest    648f93a1ba7d   11 months ago    19MB
sindreeieledsaak@Sindre-sin-Brbar-datamaskin Project % 
```

````Dockerfile

FROM gradle:7.6.0-jdk17 AS build

WORKDIR /app


COPY build.gradle.kts /app/
COPY src /app/src

RUN gradle bootJar


FROM openjdk:21-jdk-slim


WORKDIR /app


COPY --from=build /app/build/libs/*.jar /app/myapp.jar


EXPOSE 8080

CMD ["java", "-jar", "/app/myapp.jar"]
````

## Running the SPA Container

To build the SPA container, we cna use the `docker build -t myapp .` command to build the image and then use the `docker run -p 8080:8080 myapp` command to run the container.

Below is the output from build command for the SPA container:

```bash
 Project % docker build -t myapp .

[+] Building 38.3s (16/16) FINISHED                                                                                                                             docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                                                                                            0.0s
 => => transferring dockerfile: 791B                                                                                                                                            0.0s
 => [internal] load metadata for docker.io/library/gradle:7.6.0-jdk17                                                                                                           1.0s
 => [internal] load metadata for docker.io/library/openjdk:21-jdk-slim                                                                                                          1.0s
 => [auth] library/openjdk:pull token for registry-1.docker.io                                                                                                                  0.0s
 => [auth] library/gradle:pull token for registry-1.docker.io                                                                                                                   0.0s
 => [internal] load .dockerignore                                                                                                                                               0.0s
 => => transferring context: 2B                                                                                                                                                 0.0s
 => [build 1/5] FROM docker.io/library/gradle:7.6.0-jdk17@sha256:bd8852274c9e10ecd00549e5d3a73edf2549c1c6442d808ce27d1e4a04251ebd                                               0.0s
 => [internal] load build context                                                                                                                                               0.0s
 => => transferring context: 4.24kB                                                                                                                                             0.0s
 => [stage-1 1/3] FROM docker.io/library/openjdk:21-jdk-slim@sha256:7072053847a8a05d7f3a14ebc778a90b38c50ce7e8f199382128a53385160688                                            0.0s
 => CACHED [stage-1 2/3] WORKDIR /app                                                                                                                                           0.0s
 => CACHED [build 2/5] WORKDIR /app                                                                                                                                             0.0s
 => [build 3/5] COPY build.gradle.kts /app/                                                                                                                                     0.0s
 => [build 4/5] COPY src /app/src                                                                                                                                               0.0s
 => [build 5/5] RUN gradle bootJar                                                                                                                                             37.0s
 => [stage-1 3/3] COPY --from=build /app/build/libs/*.jar /app/myapp.jar                                                                                                        0.0s 
 => exporting to image                                                                                                                                                          0.0s 
 => => exporting layers                                                                                                                                                         0.0s 
 => => writing image sha256:f8bc7341ea1daf7d9fc8e9a4be7e81a26a89924fb5f3021873f225cf8964a060                                                                                    0.0s
 => => naming to docker.io/library/myapp           
```

Next, we can run the container using the `docker run -p 8080:8080 myapp` command. Now the SPA container is running and accessible at `http://localhost:8080`.


