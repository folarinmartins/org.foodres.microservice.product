ARG JAVA_VERSION=19
FROM openjdk:${JAVA_VERSION}-alpine as openjdk
RUN addgroup -S spring && adduser -S spring -G spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/app.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","/app/app.jar" ]