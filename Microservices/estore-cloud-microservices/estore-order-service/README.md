## estore-order-service

This service serves a [HATEOS](https://spring.io/understanding/HATEOAS) REST API for managing the orders placed against the items in the catalog by users of the store. It uses Spring Data Rest to expose the JPA repos as REST endpoints.

While it were part of the monolithic application context all the relations between various entities like Order-Item and Order-User were managed as referential relations (aka Foreign Keys and/or relation tables). Well again its recommended that each microservice have and store their data-set in their isolated database to the best, which isolate the failure to just that unit. 

Having made that statement the way every service propagates or chats with the other services is using the concept of a UUID. The idea is that every entity would have an UUID apart from a Primary Key and this UUID would be used to define relations between entities that need be shared across services. 

The estore-order-service is no different, it stores the user UUID onto userId attribute and similarly the item UUID onto the itemId attribute in the Order entity.

> LineItem.java

    @Entity
	public class LineItem implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    private String itemId; //stores the UUID of the Item entity from estore-catalog-service

    private int quantity;
    
    ... the constructor and getters/setters follow

> Order.java

    @Entity
	@Table(name = "orders")
	public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String userId; //stores the UUID of the User entity from estore-user-services

    private double tax;

    private double amount;

    private String guid;
    
    ... the constructor and getters/setters follow
