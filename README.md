# Microservices Demo with RabbitMQ, Zipkin, and OpenFeign

This repository demonstrates a basic microservices architecture using Spring Boot, with communication facilitated through RabbitMQ (message broker) and Zipkin (distributed tracing). The project consists of two services: `Order Service` and `Inventory Service`. These services interact with each other using OpenFeign for synchronous communication and RabbitMQ for asynchronous messaging.

## Features

- **Inter-service Communication**: Uses OpenFeign for REST client communication between microservices.
- **Asynchronous Messaging**: RabbitMQ serves as the message broker for decoupled, event-driven communication.
- **Distributed Tracing**: Zipkin provides tracing and helps visualize the call flows between services.
- **Docker Compose**: Spins up RabbitMQ and Zipkin instances alongside the services.

## Tools

- **Spring Boot**: Java framework for microservices.
- **RabbitMQ**: Message broker for event-driven architecture.
- **Zipkin**: Distributed tracing system.
- **OpenFeign**: REST client for easy microservice-to-microservice communication.
- **Docker Compose**: Orchestrates containers for RabbitMQ, Zipkin, and the services.

## Architecture Overview

- **Order Service**: Handles order placements. It checks inventory availability using OpenFeign and sends messages to RabbitMQ.
- **Inventory Service**: Manages inventory. It listens to order-related messages from RabbitMQ and updates stock levels accordingly.

## Getting Started

### Prerequisites

- **Docker**: Ensure Docker and Docker Compose are installed.
- **Java**: Java 17 or higher for Spring Boot services.

### Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/stahiomar/Microservice-Demo-RabbitMQ-Zipkin-Feign.git
   cd Microservice-Demo-RabbitMQ-Zipkin-Feign
   ```
2. **Start Services with Docker Compose**:
Docker Compose is used to spin up RabbitMQ, Zipkin, and the microservices.
   ```bash
   docker-compose up --build
   ```
3. **Access RabbitMQ and Zipkin Dashboards**:
- **RabbitMQ Management Console**: [http://localhost:15672](http://localhost:15672)
  - **Username**: guest
  - **Password**: guest
- **Zipkin Tracing Dashboard**: [http://localhost:9411](http://localhost:9411)

## Project Structure

- **order/**: Spring Boot application for managing orders.
- **inventory/**: Spring Boot application for managing inventory.
- **docker-compose.yml**: Defines services for RabbitMQ, Zipkin, Order, and Inventory services.

## Configuration

### RabbitMQ and Zipkin

The `docker-compose.yml` file includes services for RabbitMQ and Zipkin. The services are configured to connect to these instances automatically.

### OpenFeign Configuration

OpenFeign enables synchronous communication between the `Order Service` and `Inventory Service`. The configuration for OpenFeign is set up in `application.yml` or as Feign client annotations within the services.

## Example Workflow

1. **Place an Order**: When an order is placed in `Order Service`, it checks for item availability in `Inventory Service` using OpenFeign.
2. **Inventory Check and Message Publish**: If the item is available, a message is published to RabbitMQ, notifying the `Inventory Service` to reserve the stock.
3. **Distributed Tracing**: Zipkin records and displays the traces, allowing you to visualize the interaction between the services.

## How to do the demo
-you need just to run the two microservices then open postman and do this post request here http://localhost:9000/api/order
-open zipkin and click on run query
-open rabbitmq and the username and the password are guest
-then explore the things and the tools yourself

#### Good coding journey 😊
