FROM openjdk:8-jdk-alpine
COPY entrypoint.sh /entrypoint.sh
COPY backend/target/backend-0.0.1-SNAPSHOT.jar security-1.0.0.jar
RUN chmod +x /entrypoint.sh
CMD ["/entrypoint.sh"]
