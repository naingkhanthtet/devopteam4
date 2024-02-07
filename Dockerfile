FROM openjdk:latest
COPY ./target/devOpsTeam4.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "devOpsTeam4.jar", "db:3306", "30000"]