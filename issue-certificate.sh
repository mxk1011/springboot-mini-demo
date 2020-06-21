apt install certbot
export DOMAIN="example.com"
certbot certonly --standalone --preferred-challenges http -d $DOMAIN

cd /etc/letsencrypt/live/$DOMAIN/
ufw allow 80
openssl pkcs12 -export -in fullchain.pem \
                 -inkey privkey.pem \
                 -out keystore.p12 \
                 -name streamy \
                 -CAfile chain.pem \
                 -caname root
ufw deny 80