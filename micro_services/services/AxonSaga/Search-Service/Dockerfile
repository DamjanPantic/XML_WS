FROM maven:3.6.3-ibmjava-8-alpine AS appServer
WORKDIR /usr/src/search
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
COPY entrypoint.sh /entrypoint.sh
COPY --from=appServer /usr/src/search/target/Search-Service-1.0.0.jar searchservice-1.0.0.jar
RUN chmod +x /entrypoint.sh
CMD ["/entrypoint.sh"]
