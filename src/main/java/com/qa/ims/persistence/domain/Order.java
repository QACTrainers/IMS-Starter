package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private Long orderId;
    private Customer customerId;
    private Double orderTotalPrice;
    private List<Item> ordersItems = new ArrayList<>();

    public Order() {
    }

    public Order(Long orderId) {
        this.orderId = orderId;
    }

    public Order(Customer customerId) {
        this.customerId = customerId;
    }

    public Order(Long orderId, Customer customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public Order(Long orderId, Customer customerId, Double orderTotalPrice) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderTotalPrice = orderTotalPrice;
    }

    public Order(Long orderId, Customer customerId, Double orderTotalPrice, List<Item> ordersItems) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderTotalPrice = orderTotalPrice;
        this.ordersItems = ordersItems;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(Double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public List<Item> getOrdersItems() {
        return ordersItems;
    }

    public void setOrdersItems(List<Item> ordersItems) {
        this.ordersItems = ordersItems;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer ID: " + customerId + ", Total Price: " + orderTotalPrice + ", Order Items: " + ordersItems + ".";
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, orderTotalPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Order other = (Order) o;
        return Objects.equals(customerId, other.customerId) && Objects.equals(orderId, other.orderId)
                && Objects.equals(ordersItems, other.ordersItems) && Objects.equals(orderTotalPrice, other.orderTotalPrice);
    }
}
