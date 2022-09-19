# spring-boot-reverse

Reverse service. Service has API method which takes any string as input, and returns a reversed string

## Requirements

For building and running the application you need:

- java 11
- docker

## Running the application locally

Build project
```shell
./gradlew clean build -i
```

Run project
```shell
docker run --publish 8080:8080 kozak/reverse-project
```

## Test the endpoint

Run integration tests(automatically would run after `bootBuildImage` step) 
or you can test it manually.

Example:
```shell
curl http://localhost:8080/api/reverse?text=asd
```
