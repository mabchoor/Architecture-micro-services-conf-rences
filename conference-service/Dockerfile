# Conference service Dockerfile
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
# Copy the fat jar produced by `mvn package` from the target directory
COPY target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS:-} -jar /app/app.jar"]

