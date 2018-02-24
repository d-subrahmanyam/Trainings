## estore-discovery-service

This service serves as a discovery server for services to self register and query for the services. As the trivia of building microservices is to scale the instances of each service at runtime, if the service are configured with a client side load balancer like eureka when a request for service by its serviceId is made a handle to one of the various instances is made by applying algorithms like round-robin or load based. 

The Spring framework provides a very useful module in Spring Cloud Discovery server which has been a very valued contribution from Netflix. 

The idea is that every service that needs to be discovered by other services would annotate their SpringBootApplication classes with an EnableDiscoveryClient annotation like - 

    @EnableDiscoveryClient
    @SpringBootApplication
	public class EstoreCatalogServiceApplication {
		public static void main(String[] args) {
			SpringApplication.run(EstoreCatalogServiceApplication.class, args);
		}
	}

The estore-discovery-service runs on the http://localhost:8761

I would recommend the following readings 

 - http://www.baeldung.com/spring-cloud-netflix-eureka
 - https://spring.io/blog/2015/01/20/microservice-registration-and-discovery-with-spring-cloud-and-netflix-s-eureka
 - https://memorynotfound.com/spring-cloud-eureka-service-discovery-client-server-example/
