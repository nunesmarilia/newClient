FROM nginx:latest
MAINTAINER Marilia Nunes Alves
#COPY /public /var/www/public
RUN mkdir -p /var/www/public
COPY docker/nginx.conf /etc/nginx/nginx.conf
RUN chmod 755 -R /var/www/public
EXPOSE 80
ENTRYPOINT ["nginx"]
# Parametros extras para o entrypoint
CMD ["-g", "daemon off;"]
