
# Start with a base image containing Java runtime
FROM java

# Add Maintainer Info
LABEL maintainer="hassano.ben25@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=springbootdocker.jar

# Add the application's jar to the container
ADD ${JAR_FILE} springbootdocker.jar



# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springbootdocker.jar"]