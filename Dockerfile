FROM openjdk:latest
COPY ./target/devOpsTeam4-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "devOpsTeam4-0.1.0.2-jar-with-dependencies.jar"]
