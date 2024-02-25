FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=Alexey_Kalitin_javarush_bot
ENV BOT_TOKEN=6558913209:AAGa-FbVZ9DchtuPhxE5qS8KTQpTZEuFbC8
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]