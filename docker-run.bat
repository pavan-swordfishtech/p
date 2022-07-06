docker build -t product-services:v1.0 .
docker images
docker run -d -p 8080:8080 product-services:v1.0;
docker ps
