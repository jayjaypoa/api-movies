FROM openjdk:11-jre-slim
EXPOSE 32000
WORKDIR ./
ADD /build/libs/api-movies-server-1.0-SNAPSHOT.jar /opt/api-movies-server.jar
CMD exec java -jar /opt/api-movies-server.jar