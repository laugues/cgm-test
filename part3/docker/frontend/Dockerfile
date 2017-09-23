FROM nginx:latest

LABEL Description="CGM frontend"
LABEL version="${project.version}"

RUN apt-get -qq update
RUN apt-get -qq -y install curl socat vim

RUN echo 'version=${project.version}' > /version.txt
RUN echo 'build=${docker.image.tag}' >> /version.txt

#Copy cgm backend
COPY packages/cgm-springboot-${project.version}.jar /etc/nginx/conf.d/cgm-backend.jar
#COPY packages/cgm-frontend/* /usr/share/nginx/html/

ADD init/conf/ /etc/nginx/conf.d/

COPY init/entry-point.sh /opt/entry-point.sh
RUN chmod +x /opt/entry-point.sh && sed -i -e 's/\r$//' /opt/entry-point.sh
ENTRYPOINT  ["/opt/entry-point.sh"]