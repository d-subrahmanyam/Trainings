This project depicts the way a monolithic application can be spliced into a more service based application.

This version uses a number of Spring Cloud modules like 
   - Spring Boot 
   - Spring Cloud Config (for managing the configuration of the entire application)
      - A small catch being that the config is hosted on github https://github.com/d-subrahmanyam/estore-cloud-microservices-config
   - Srping Cloud Discovery (for publishing and discovering services like UDDI)
   - Spring Zuul (for Gateway or Edge services)
   - Spring Eureka LB (for client-side(aka services) load balancing)
   - Spring Data Rest (for exposing JPA repos as a rest endpoints)
   - Spring Feign Client(for consuming REST endpoints) 

The services need be executed in an order

1. estore-config-service ([http://localhost:8888](http://localhost:8888))
2. estore-discovery-service ((http://localhost:8761)[http://localhost:8761))
3. estore-gateway-service ([http://localhost:8080](http://localhost:8080))
4. estore-catalog-service (This service would be hosted on a random port)
5. estore-user-services (This service would be hosted on a random port)
6. estore-order-service (This service would be hosted on a random port)

Navigate to each folder and hit **mvn clean spring-boot:run** 

Ideally all the services would interact with each other using the gateway service as a proxy over call one another directly, which would enable us to AuthN and AuthZ the requests.

I still have'nt built the UI, but I believe the UI that we have built in the other approach of estore-microservices could pretty much be used with a change in the Feign Clients to use the estore-gateway-service instead of the direct service url's. 

The Spring Feign client has been designed to interact with Spring Discovery service. 
