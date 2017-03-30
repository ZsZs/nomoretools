FROM nginx:latest
MAINTAINER Zsolt Zsuffa "zsolt.zsuffa@gmail.com"

COPY conf/ /etc/nginx/conf.d/
#COPY conf/default.conf /etc/nginx/conf.d/default.conf
RUN ls -la /etc/nginx/conf.d/*
COPY html/ /usr/share/nginx/html/
RUN ls -la /usr/share/nginx/html/*

# expose both the HTTP (80) and HTTPS (443) ports
EXPOSE 80 443

CMD ["nginx", "-g", "daemon off;"]
