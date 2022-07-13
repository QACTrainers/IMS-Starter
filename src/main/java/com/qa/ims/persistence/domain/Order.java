package com.qa.ims.persistence.domain;

//import java.util.Date;
import java.sql.Date;
import java.util.Objects;

public class Order {

    private Long orderID;

    private Long fkCustomerID;

    private Date placed;

    private Long total;

    public Order(Long orderID, Long fkCustomerID, Date placed, Long total) {
        this.orderID = orderID;
        this.fkCustomerID =fkCustomerID;
        this.placed = placed;
        this.total = total;
    }

    public Order(Long fkCustomerID, Date placed, Long total) {
        this.fkCustomerID =fkCustomerID;
        this.placed = placed;
        this.total = total;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getFkCustomerID() {
        return fkCustomerID;
    }

    public void setFkCustomerID(Long fkCustomerID) {
        this.fkCustomerID = fkCustomerID;
    }

    public Date getPlaced() {
        return placed;
    }

    public void setPlaced(Date placed) {
        this.placed = placed;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "orderID=" + orderID + ", fkCustomerID=" + fkCustomerID + ", placed=" + placed + ", total=" + total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderID, order.orderID) && Objects.equals(fkCustomerID, order.fkCustomerID) && Objects.equals(placed, order.placed) && Objects.equals(total, order.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, fkCustomerID, placed, total);
    }
}
