## Let's Microservices

The idea of this session was to teach having the mindset of building applications using microservices rather building microservices using a certain framework. We started the session discussing over building a simple monolithic application and discussing the various limitations it would have as we intend to scale the application in the number of features, the number of end-user's it could support, scaling the computation infra when and where it were needed and maintainence over the run.

We even discussed a little over how the J2EE stack is designed, how the J2EE servers themselvesbehave as closely knit band of microservices and how difficult it were to scale the application with such infra. In fact, no denial that even these mammoth applications also have embraced the microservices mindset thanks to OSGi. 

We then moved on to discuss on the various startegies available to design applications in a microservices format. Some of the key strategies were like Virtualization (the concept of using virtualizing software and hardware resources), Containerization (the concept of using the Linux LxC like Docker, Rocket to name a few), using frameworks like Spring Boot and then with a full blown suite of Spring Cloud. There were a couple of other strategies like PaaS(Platform as a Service) like Pivotal Cloudfoundry, Redhat OpenShift and IaaS like AWS and Azure, that we could just do a little pep talk on. We did discuss a little over scaffolding services offered by JHipster and Spring Starters.

## Case Study
For our case study we have taken the concept and context of an estore which offers the following functionality - 

 - Display all the items in the catalog
 - User Login and New User Registration
 - Shopping Cart
 - Checkout
 - List all Orders

If you see there are 3 projects in this folder. 

 1. estore-monolithic - This is the monolithic version of the estore
 2. estore-microservices - This is the microservices version of the estore built using the tech stack like
	 - Spring Boot
	 - Spring-Data-Rest (for exposing JPA repos as a rest endpoints), 
	 - Spring Feign Client(for consuming REST endpoints) 
	 - JSP.
 3. estore-cloud-microservices - This is the microservices version of the estore build using the tech stack 
	 - Spring Boot 
	 - Spring Cloud Config (for managing the configuration of the entire application)
	 - Srping Cloud Discovery (for publishing and discovering services like UDDI)
	 - Spring Zuul (for Gateway or Edge services)
	 - Spring Eureka LB (for client-side(aka services) load balancing)
	 - Spring Data Rest (for exposing JPA repos as a rest endpoints)
	 - Spring Feign Client(for consuming REST endpoints) 

TODO - Yes I would love write and publish code on building microservices using docker with microservices written in multiple programming languages like Ruby (RoR), NodeJS and Python. I shall keep you updated. I shall try write a little on how to microservices using OSGi (still one of my favorite) :D.
