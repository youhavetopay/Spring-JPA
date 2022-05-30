FROM adoptopenjdk/openjdk11
ARG JAR_FILE=build/ibs/SpringJPA-Project-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
VOLUME /tmp
ENTRYPOINT ["java", "-jar", "/app.jar"]