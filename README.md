basic build

mvn clean install
java -jar target/*.jar

if docker available then "mvn clean package docker:build"

docker run -p 8080:8080 -t springio/java-test

from docker hub: docker run -it -p 8080:8080 -t bprakg/alpine-springboot-javatest

URI's
--------------
http://localhost:8080/sales/products/ - GET- get prod list
http://localhost:8080/sales/products/1 - GET - get prod by id
http://localhost:8080/sales/products - POST - create product

http://localhost:8080/sales/orders/ POST - place order
http://localhost:8080/sales/orders/ GET - list all orders
http://localhost:8080/sales/orders/1 GET - read order by id
http://localhost:8080/sales/orders/1 PUT - modify order