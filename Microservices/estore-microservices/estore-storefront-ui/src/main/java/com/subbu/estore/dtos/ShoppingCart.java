package com.subbu.estore.dtos;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subbu on 19/02/18.
 */
@Component
@SessionScope
public class ShoppingCart {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingCart.class);

    private User user;
    private List<LineItem> items;
    private double total;
    private boolean previousOrder;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        total = 0;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }

    public boolean isPreviousOrder() {
        return previousOrder;
    }

    public void setPreviousOrder(boolean previousOrder) {
        this.previousOrder = previousOrder;
    }

    public double getTotal() {
        total = 0;
        //items.stream().forEach(item -> total += item.getItem().getPrice());
        //TODO - Design the logic to calculate the total
        return total;
    }

    public void addItem(String itemId, int quantity) {
        LineItem lineItem = new LineItem(itemId, quantity);
        if(items.contains(lineItem)) {
            logger.info("This item already exists in the cart");
            int index = items.indexOf(lineItem);
            LineItem _lineItem = items.get(index);
            int _quantity = _lineItem.getQuantity() + quantity;
            _lineItem.setQuantity(_quantity);
            items.set(index, _lineItem);
        } else {
            items.add(lineItem);
        }
    }

    public void reset() {
        this.items = new ArrayList<>();
        this.user = null;
        this.previousOrder = false;
    }

    public void clear() {
        this.items = new ArrayList<>();
        this.previousOrder = false;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
