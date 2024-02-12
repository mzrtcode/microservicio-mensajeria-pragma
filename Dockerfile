# Usar una imagen base de OpenJDK con soporte para Alpine, que es más ligera
FROM openjdk:17-alpine

# Copiar nuestro build
COPY /build/libs/microservicio-mensajeria-0.0.1-SNAPSHOT.jar java-app.jar

# Comando que se ejecuta una vez que el contenedor este listo y ejecutara nuestra aplicacione
ENTRYPOINT ["java", "-jar", "java-app.jar"]