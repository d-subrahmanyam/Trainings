package com.subbu.estore.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.id.GUIDGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by subbu on 19/02/18.
 */

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;

    private double tax;

    private double amount;

    private String guid;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LineItem> lineItems;

    public Order() {
        guid = UUID.randomUUID().toString();
    }

    public Order(User user, List<LineItem> lineItems, double amount) {
        this.user = user;
        this.lineItems = lineItems;
        this.amount = amount;
        this.tax = 2.5;
        guid = UUID.randomUUID().toString();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public void addLineItem(LineItem lineItem) {
        if(lineItems == null) {
            lineItems = new ArrayList<>();
        }
        if (!lineItems.contains(lineItem)) {
            lineItems.add(lineItem);
        }
    }

    public void calculateTotal() {
        this.tax = 5.0;
        this.amount = 0;
        lineItems.stream().forEach(lineItem -> amount+=(lineItem.getItem().getPrice() * lineItem.getQuantity()));
        amount += tax;
    }

    public String getGuid() {
        return this.guid;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this,false);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
