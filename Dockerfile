FROM quay.io/wildfly/wildfly:27.0.1.Final-jdk17

USER root

RUN mkdir -p /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main

COPY postgresql-42.7.2.jar /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main/
COPY module.xml /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main/

COPY standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml

COPY build/libs/is_lab1-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/app.war

RUN chown -R jboss:root /opt/jboss/wildfly

USER jboss

EXPOSE 8080 9990

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]