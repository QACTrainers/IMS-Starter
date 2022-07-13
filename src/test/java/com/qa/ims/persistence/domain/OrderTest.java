package com.qa.ims.persistence.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderTest {
    @Test
    public void constructorTest() {
        Order order1 = new Order(1L);
        assertEquals(Long.valueOf(1), order1.getOrderId());
    }

    @Test
    public void constructorTestTwo() {
        Customer customer1 = new Customer("Ian", "Petts");
        assertEquals("Ian", customer1.getFirstName());
        assertEquals("Petts", customer1.getSurname());
    }

    @Test
    public void constructorTestThree() {
        Customer customer2 = new Customer("Ian", "Petts");
        Order order2 = new Order(2L, customer2);
        assertEquals(Long.valueOf(2), order2.getOrderId());
        assertEquals(customer2, order2.getCustomerId());
    }

    @Test
    public void constructorTestFour() {
        Customer customer3 = new Customer("Ian", "Petts");
        Order order3 = new Order(3L, customer3, 1500.99);
        assertEquals(Long.valueOf(3), order3.getOrderId());
        assertEquals(customer3, order3.getCustomerId());
        assertEquals(1500.99, order3.getOrderTotalPrice(), 0.1);
    }

    @Test
    public void constructorTestFive() {
        Customer customer4 = new Customer("Ian", "Petts");
        Order order4 = new Order(4L, customer4, 1500.99);
        List<Item> list = new ArrayList<>();
        assertEquals(Long.valueOf(4), order4.getOrderId());
        assertEquals(customer4, order4.getCustomerId());
        assertEquals(1500.99, order4.getOrderTotalPrice(), 0.1);
        assertEquals(list, order4.getOrdersItems());
    }

    @Test
    public void setOrderIdTest() {
        Order order5 = new Order();
        order5.setOrderId(5L);
        assertEquals(Long.valueOf(5L), order5.getOrderId());
    }

    @Test
    public void setOrderTotalPriceTest() {
        Order order6 = new Order();
        order6.setOrderTotalPrice(1500.99);
        assertEquals(1500.99, order6.getOrderTotalPrice(), 0.1);
    }

    @Test
    public void setOrdersItemsTest() {
        Order order7 = new Order();
        List<Item> list1 = new ArrayList<>();
        assertEquals(list1, order7.getOrdersItems());
    }

    @Test
    public void toStringTest() {
        Customer customer5 = new Customer("Ian", "Petts");
        Order order5 = new Order(5L, customer5, 1500.99);
        List<Item> list = new ArrayList<>();
        assertEquals(Long.valueOf(5), order5.getOrderId());
        assertEquals(customer5, order5.getCustomerId());
        assertEquals(1500.99, order5.getOrderTotalPrice(), 0.1);
        assertEquals(list, order5.getOrdersItems());
        String expected = "Order ID: 5, Customer ID: null, Total Price: 1500.99, Order Items: []";
        assertEquals(expected, order5.toString());
    }
}
