
FROM openjdk:17-slim



VOLUME /tmp

EXPOSE 8080

CMD ["java","-jar","target/autos-0.0.1-SNAPSHOT.jar"]