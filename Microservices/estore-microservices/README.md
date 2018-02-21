This project depicts the way a monolithic application can be spliced into a more service based application.

This version still doesnt use the spring-cloud modules with an exception of the feign client.

The services need be executed in an order

1. estore-catalog-services ([http://localhost:8082](http://localhost:8082))
2. estore-user-services ([http://localhost:8081](http://localhost:8081))
3. estore-order-services ([http://localhost:8083](http://localhost:8083))
4. estore-storefront-ui ([http://localhost:8080](http://localhost:8080))

Navigate to each folder and hit **mvn clean spring-boot:run** 
