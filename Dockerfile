FROM openjdk:17


ADD ./instzaa.jar instzaa.jar
ADD ./certs/homologacao-571485-InstzaaHMLv2.p12 /certs/homologacao-571485-InstzaaHMLv2.p12
ENTRYPOINT ["java", "-jar", "instzaa.jar"]
