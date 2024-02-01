FROM maven:3.8.1-openjdk-17-slim AS MAVEN_BUILD

RUN mkdir /sources
COPY ./ /sources

RUN echo "Building app..." && cd /sources && mvn clean package -DskipTests

FROM amazoncorretto:21-alpine-jdk

WORKDIR /app
COPY --from=MAVEN_BUILD /sources/target/amaris-consulting-test-*.war /app/amaris-consulting-test.war
EXPOSE 8080

CMD ["java", "-jar", "amaris-consulting-test.war"]
