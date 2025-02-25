FROM nginx:latest

COPY ./myrefrig.site.conf /etc/nginx/conf.d/myrefrig.site.conf

COPY ./fullchain.pem /etc/letsencrypt/live/myrefrig.site/fullchain.pem
COPY ./privkey.pem /etc/letsencrypt/live/myrefrig.site/privkey.pem
COPY ./options-ssl-nginx.conf /etc/letsencrypt/options-ssl-nginx.conf
COPY ./ssl-dhparams.pem /etc/letsencrypt/ssl-dhparams.pem

EXPOSE 80 443