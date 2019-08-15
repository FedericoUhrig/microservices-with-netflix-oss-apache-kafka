# Microservices with Netflix OSS, Apache Kafka and Spring Boot 

Simple system mixing the two main ways for communication between microservices: REST and messaging. 

## Components 

1. __Service registry (Eureka)__ — Where all services will register themselves
2. __Config server (Spring Cloud Config)__ — Where all services will take their configurations from. Config server will keep configuration files in git repository
3. __Gateway (Zuul)__ — that will redirect all the requests to the needed microservice
4. __User service__ — using this one the new users will register. On every new registration the User service will send a message “USER_REGISTERED” to the message broker (Kafka)
5. __Email service__ — using this one we will send emails. On “USER_REGISTERED”message received the Email service will send a confirmation email to the new user


## Requirements

The asynchronous communication is performed through [Apache Kafka](https://kafka.apache.org/), therefore first it must be started

Kafka uses ZooKeeper so you need to first start a ZooKeeper server if you don't already have one.

```bash
> bin/zookeeper-server-start.sh config/zookeeper.properties
```

Now start the Kafka server:

```bash
> bin/kafka-server-start.sh config/server.properties
```

## Example of usage

1. Start the Service registry (ms-discovery)
2. Start the Config server    (ms-config-server)
3. Start the Gateway          (ms-gateway)
4. Start the User service     (ms-user)
5. Start the Mail service     (ms-mail)
6. Register a new user

```bash
curl -X POST \
  http://localhost:8765/api/user \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
	"username": "foo@mail.com",
	"password": "mynewpass"
}'
```
7. Validate that the new user has been [registered on User service](http://localhost:8080/h2-console/)
8. Validate that a new mail has been received on foo@mail.com account


