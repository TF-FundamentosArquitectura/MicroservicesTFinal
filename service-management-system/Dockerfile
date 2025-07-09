FROM adoptopenjdk/openjdk11
ADD target/*.jar app.jar
ENV JAVA_OPTS=''
ENTRYPOINT [ "java", "-jar", "app.jar" ]
