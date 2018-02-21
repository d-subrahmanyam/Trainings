This project depicts the way a monolithic application can be spliced into a more service based application.

This version still doesnt use the spring-cloud modules with an exception of the feign client.

The services need be executed in an order

1. estore-catalog-services
2. estore-user-services
3. estore-order-services
4. estore-storefront-ui

Navigate to each folder and hit **mvn clean spring-boot:run**