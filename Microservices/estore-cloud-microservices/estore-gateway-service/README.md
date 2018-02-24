## estore-gateway-service

This service serves as an API gateway server for all the api's exposed by various services thereby enforcing any AuthN and AuthZ activities at a single point. It uses Spring Cloud Zuul to enable a gateway server. The Spring Cloud Zuul like all other modules in the Spring Cloud framework are built with Discovery in context. 

The idea is that with simple config service redirection to the downstream services can be achieved. The only code it might require is for AuthN and AuthZ. 

This service is hosted on http://localhost:8080

It relies on the route config defined the estore-gateway-service - 

    zuul:
	  prefix: /api
	#  ignoredServices: '*'
	  routes:
	    users:
	      path: /user-service/**
	      serviceId: ESTORE-USER-SERVICES
	    catalog:
	      path: /catalog-service/**
	      serviceId: ESTORE-CATALOG-SERVICE
	    orders:
	      path: /order-service/**
	      serviceId: ESTORE-ORDER-SERVICE

	server:
	  port: 8080
	  compression:
	    enabled: true
	    mime-types: application/json,text/css,application/javascript
	    min-response-size: 2048

	eureka:
	  client:
	    serviceUrl:
	      defaultZone: http://localhost:8761/eureka/

	ribbon:
	  eureka:
	    enabled: true

In the above configuration file the zuul.routes property defines the various routes against the serviceId to url pattern. That would mean that any hit to the http://localhost:8080/estore-catalog-service/catalog would redirect the request to the estore-catalog-service and http://localhost:8080/estore-user-services/users would redirect the request to the estore-user-services. 

TODO - I'm still investigating into why the prefix of api is not working. I shall keep this page update and posted once I'm done with my findings. 

----------

> Please pay attention to how the routes are configured as it plays a very important role. I would recommend reading the following articles until you are clear with the idea of routing.

I would recommend the following readings - 

 - http://www.baeldung.com/spring-rest-with-zuul-proxy
 - https://howtodoinjava.com/spring/spring-cloud/spring-cloud-api-gateway-zuul/
 - https://exampledriven.wordpress.com/2016/07/06/spring-cloud-zuul-example/
 - https://piotrminkowski.wordpress.com/2017/02/05/part-1-creating-microservice-using-spring-cloud-eureka-and-zuul/
