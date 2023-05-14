FROM openjdk:11-jre-slim-buster
WORKDIR /app
COPY . /app
COPY target/DeutscheBankExercise-1.0-SNAPSHOT.jar DeutscheBankExercise.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "DeutscheBankExercise.jar"]
