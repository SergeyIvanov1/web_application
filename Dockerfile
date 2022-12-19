FROM tomcat:9.0

COPY ./target/ROOT.war /usr/local/tomcat/webapps/
