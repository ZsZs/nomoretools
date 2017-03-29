FROM nginx:latest
MAINTAINER Zsolt Zsuffa "zsolt.zsuffa@gmail.com"

COPY ./default.conf /etc/nginx/conf.d/default.conf
COPY ./gitlab.conf /etc/nginx/conf.d/
COPY ./jenkins.conf /etc/nginx/conf.d/
COPY ./nexus.conf /etc/nginx/conf.d/
COPY ./sonar.conf /etc/nginx/conf.d/

COPY ./index.html /usr/share/nginx/html
COPY ./backend-not-found.html /usr/share/nginx/html

# expose both the HTTP (80) and HTTPS (443) ports
EXPOSE 80 443

CMD ["nginx", "-g", "daemon off;"]
