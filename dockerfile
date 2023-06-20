FROM openjdk:11

COPY build/libs/Customer-0.0.1-SNAPSHOT.war Customer-0.0.1-SNAPSHOT.war
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "Customer-0.0.1-SNAPSHOT.war"]