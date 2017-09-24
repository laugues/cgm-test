FROM mariadb:10.3.1


LABEL Description="CGM database"
LABEL version="${project.version}"
RUN echo 'version=${project.version}' > /version.txt

COPY init/healthcheck.sh /opt/healthcheck.sh

# convert to unix just in case !!
RUN chmod +x /opt/healthcheck.sh && sed -i -e 's/\r$//' /opt/healthcheck.sh

RUN mkdir /sql && \
     mkdir /sql/temp

COPY init/sql/*.sql /sql/temp/

RUN cat /sql/temp/*.sql > /docker-entrypoint-initdb.d/cgm.sql

# convert to unix just in case !!
RUN chmod +x /docker-entrypoint-initdb.d/cgm.sql && sed -i -e 's/\r$//' /docker-entrypoint-initdb.d/cgm.sql

ENTRYPOINT ["/docker-entrypoint.sh"]

EXPOSE 3306
CMD ["mysqld"]
