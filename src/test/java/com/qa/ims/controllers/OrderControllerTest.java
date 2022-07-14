package com.qa.ims.controllers;

import com.qa.ims.utils.Utils;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
    @Mock
    private Utils utils;

    @Mock
    private OrderDAO orderDAO;

    @InjectMocks
    private OrderController orderController;

    @Test
    public void testReadAll() {
        final List<Order> orders = new ArrayList<>();
        final Customer CUSTOMER = new Customer(1L, "Ian", "Petts");
        final List<Item> items = new ArrayList<>();
        final Item item = new Item(1L, "MacBook Pro", 1599.99);
        items.add(item);
        orders.add(new Order(1L, CUSTOMER, 1599.99));

        Mockito.when(orderDAO.readAll()).thenReturn(orders);

        assertEquals(orders, orderController.readAll());

        Mockito.verify(orderDAO, Mockito.times(1)).readAll();
    }

    @Test
    public void testDelete() {
        final long ID = 1L;

        Mockito.when(utils.getLong()).thenReturn(ID);
        Mockito.when(orderDAO.delete(ID)).thenReturn(1);

        assertEquals(1L, this.orderController.delete());

        Mockito.verify(utils, Mockito.times(1)).getLong();
        Mockito.verify(orderDAO, Mockito.times(1)).delete(ID);
    }
}
