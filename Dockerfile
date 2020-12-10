FROM adoptopenjdk/openjdk11:alpine
EXPOSE 8080
ADD ./target/PTBCP-0.0.1-SNAPSHOT.jar /app/api.jar
ENTRYPOINT ["java","-jar","/app/api.jar"]