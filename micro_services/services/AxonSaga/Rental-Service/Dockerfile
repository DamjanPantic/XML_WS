FROM maven:3.6.3-ibmjava-8-alpine AS appServer
WORKDIR /usr/src/rental
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
COPY entrypoint.sh /entrypoint.sh
COPY --from=appServer /usr/src/rental/target/Rental-Service-1.0.0.jar rentalservice-1.0.0.jar
RUN chmod +x /entrypoint.sh
CMD ["/entrypoint.sh"]
