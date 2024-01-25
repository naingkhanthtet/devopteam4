FROM openjdk:latest
COPY ./target/devOpsTeam4-1.0-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "devOpsTeam4-1.0-jar-with-dependencies.jar"]
