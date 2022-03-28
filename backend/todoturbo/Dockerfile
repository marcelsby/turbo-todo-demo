FROM amazoncorretto:11

WORKDIR app

COPY target/*.jar todoTurboBackend.jar

ENTRYPOINT ["java", "-jar", "todoTurboBackend.jar"]