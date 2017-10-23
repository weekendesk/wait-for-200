FROM openjdk:8-jre

ARG LIB_DIRECTORY
ARG PACKAGED_ARTIFACT_FILENAME

ADD ${LIB_DIRECTORY} /app/lib
ADD ${PACKAGED_ARTIFACT_FILENAME} /app/app.jar

WORKDIR /app

ENTRYPOINT ["java", "-cp", "lib/*:app.jar", "com.weekendesk.waitfor200.WaitFor200"]



