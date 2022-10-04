package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItems {

    private Long orderItemID;

    private Long fkOrderID;

    private Long fkItemID;

    private Long quantity;

    private Long total;


    public OrderItems(Long orderItemID, Long fkOrderID, Long fkItemID, Long quantity, Long total) {
        this.orderItemID = orderItemID;
        this.fkOrderID = fkOrderID;
        this.fkItemID = fkItemID;
        this.quantity = quantity;
        this.total = total;
    }

    public OrderItems(Long fkOrderID, Long fkItemID, Long quantity, Long total) {
        this.fkOrderID = fkOrderID;
        this.fkItemID = fkItemID;
        this.quantity = quantity;
        this.total = total;
    }

    public OrderItems(Long fkItemID, Long quantity, Long total) {
        this.fkOrderID = fkOrderID;
        this.fkItemID = fkItemID;
        this.quantity = quantity;
        this.total = total;
    }

    public Long getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(Long orderItemID) {
        this.orderItemID = orderItemID;
    }

    public Long getFkOrderID() {
        return fkOrderID;
    }

    public void setFkOrderID(Long fkOrderID) {
        this.fkOrderID = fkOrderID;
    }

    public Long getFkItemID() {
        return fkItemID;
    }

    public void setFkItemID(Long fkItemID) {
        this.fkItemID = fkItemID;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return "OrderItems{" +
                "orderItemID=" + orderItemID +
                ", fkOrderID=" + fkOrderID +
                ", fkItemID=" + fkItemID +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItems that = (OrderItems) o;
        return Objects.equals(orderItemID, that.orderItemID) && Objects.equals(fkOrderID, that.fkOrderID) && Objects.equals(fkItemID, that.fkItemID) && Objects.equals(quantity, that.quantity) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemID, fkOrderID, fkItemID, quantity, total);
    }
}
