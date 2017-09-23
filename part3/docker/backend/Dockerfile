FROM frolvlad/alpine-oraclejdk8:slim

LABEL Description="CGM backend"
LABEL version="${project.version}"

RUN echo 'version=${project.version}' > /version.txt
RUN echo 'build=${docker.image.tag}' >> /version.txt

VOLUME /tmp

#Install curl
RUN apk --update add curl
#Copy cgm backend
COPY packages/cgm-springboot-${project.version}.jar cgm-backend.jar

ENTRYPOINT ["java","-Xms512m","-Xss512k","-XX:MaxMetaspaceSize=512m","-Djava.security.egd=file:/dev/./urandom","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000","-jar","/cgm-backend.jar"]
EXPOSE 8080 8000
