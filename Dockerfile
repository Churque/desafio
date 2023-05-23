FROM openjdk:17-slim

COPY target/autos-0.0.1-SNAPSHOT.jar autos.jar

VOLUME /tmp

EXPOSE 3001

CMD ["java","-jar","autos.jar"]