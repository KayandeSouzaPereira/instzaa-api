FROM openjdk:17
ADD ./instzaa.jar instzaa.jar
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]
