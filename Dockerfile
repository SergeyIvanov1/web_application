FROM tomcat:9.0

#RUN --name mysql -d \
#    -p 3306:3306 \
#    -e MYSQL_ROOT_PASSWORD=bestuser \
#    -e MYSQL_USER=bestuser \
#    -e MYSQL_PASSWORD=bestuser \
#    -v mysql:/var/lib/mysql \
#    mysql:8
##    --restart unless-stopped \

COPY ./target/ROOT.war /usr/local/tomcat/webapps/

#ARG JAR_FILE=target/web-application.jar
#WORKDIR /opt/app
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","app.jar"]