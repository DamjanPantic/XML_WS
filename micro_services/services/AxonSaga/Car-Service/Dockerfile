FROM maven:3.6.3-ibmjava-8-alpine AS appServer
WORKDIR /usr/src/car
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
COPY entrypoint.sh /entrypoint.sh
COPY --from=appServer /usr/src/car/target/Car-Service-1.0.0.jar carservice-1.0.0.jar
RUN chmod +x /entrypoint.sh
CMD ["/entrypoint.sh"]
