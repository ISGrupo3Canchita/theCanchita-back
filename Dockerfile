FROM maven:3.9.9-ibm-semeru-23-jammy

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java","-jar","target/grupo3-0.0.1-SNAPSHOT.jar"]

