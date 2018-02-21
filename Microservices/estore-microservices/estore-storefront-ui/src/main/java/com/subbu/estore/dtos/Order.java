package com.subbu.estore.dtos;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by subbu on 22/02/18.
 */
public class Order {

    private String userId;

    private double tax;

    private double amount;

    private String guid;

    private List<LineItem> lineItems;

    public Order() {
        guid = UUID.randomUUID().toString();
    }

    public Order(String userId, List<LineItem> lineItems, double amount) {
        this.userId = userId;
        this.lineItems = lineItems;
        this.amount = amount;
        guid = UUID.randomUUID().toString();
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        // The logic for calculating the total amount of the order will have to moved to a client
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
