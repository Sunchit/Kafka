# Changelog

## Date: [November 02, 2025]

### Added

- Dockerized the `kafka-publisher` and `kafka-consumer` applications using multi-stage Docker builds.
- Upgraded kafka broker to work with Kraft rather than Zookeeper [Apache Docs Link for Kraft]('https://kafka.apache.org/documentation/#zk2kraft-summary')
- Created a `docker-compose.yml` file to manage and run the entire application stack, including the Kafka broker.
- Implemented health checks and restart policies in `docker-compose.yml` to ensure a resilient and orderly startup of services.
- Added Makefile for simple command to rebuild, restart & stop containers.
