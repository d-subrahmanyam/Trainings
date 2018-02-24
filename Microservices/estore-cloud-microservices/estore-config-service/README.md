## estore-config-service

This service serves as a remote distributed configuration management service. One of the key principles the [Twelve Factor App](https://12factor.net/config) dictates is about strictly separating the config from the code. This would help the service evolve independent of its configuration. All the elements we believe are configurable like the datasource names, the database to be used in Dev, QA, STG and PROD can be abstracted out to their own config using either a .properties or .yml format. 

The Spring framework provides a git backed configuration management system in spring config. 

The config for this service are hosted on https://github.com/d-subrahmanyam/estore-cloud-microservices-config. Each file represents to that of a service and are named by their serviceId.yml format. For example the estore-discovery-service.yml file stores all the config related to the estore-discovery-service service. The service name or id is/are defined in each service's bootstrap.yml `spring.application.name` property.

I would recommend the following readings on Spring Cloud

 - http://www.baeldung.com/spring-cloud-configuration
 - https://spring.io/guides/gs/centralized-configuration/
 - http://zoltanaltfatter.com/2016/06/30/centralized-configuration-with-spring-cloud-config/
 - https://piotrminkowski.wordpress.com/2017/07/17/microservices-configuration-with-spring-cloud-config/
