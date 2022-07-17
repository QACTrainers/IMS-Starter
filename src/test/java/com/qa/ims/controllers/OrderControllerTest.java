package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.qa.ims.controller.CustomerController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

    @Mock
    private Utils utils;

    @Mock
    private OrderDAO dao;

    @Mock
    private OrderItemsDAO OIdao;

    @InjectMocks
    private OrderController controller;


    @Test
    public void testCreate() throws ParseException {

        final Long FK_CUSTOMER_ID = 1L, TOTAL = 0L;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final Date PLACED = new java.sql.Date(dateFormat.parse("1/2/2003").getTime());

        final Order created = new Order(FK_CUSTOMER_ID, PLACED, TOTAL);

        Mockito.when(utils.getLong()).thenReturn(FK_CUSTOMER_ID);
        Mockito.when(utils.getDate()).thenReturn(PLACED);

        Mockito.when(dao.create(created)).thenReturn(created);

        assertEquals(created, controller.create());

        Mockito.verify(utils, Mockito.times(1)).getLong();
        Mockito.verify(utils, Mockito.times(1)).getDate();


        Mockito.verify(dao, Mockito.times(1)).create(created);
    }

    @Test
    public void testReadAll() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final Date PLACED = new java.sql.Date(dateFormat.parse("1/2/2003").getTime());

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1L, 1L, PLACED, 0L ));

        Mockito.when(dao.readAll()).thenReturn(orders);

        assertEquals(orders, controller.readAll());

        Mockito.verify(dao, Mockito.times(1)).readAll();
    }

    @Test
    public void testUpdate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final Date PLACED = new java.sql.Date(dateFormat.parse("4/7/2013").getTime());

        final Long ORDER_ID = 1L, FK_CUSTOMER_ID = 1L, TOTAL = 0L;

        Order updated = new Order(ORDER_ID, FK_CUSTOMER_ID, PLACED, TOTAL);


        Mockito.when(this.utils.getLong()).thenReturn(1L);
        Mockito.when(utils.getLong()).thenReturn(updated.getFkCustomerID());
        Mockito.when(utils.getDate()).thenReturn(updated.getPlaced());
        Mockito.when(this.dao.update(updated)).thenReturn(updated);

        assertEquals(updated, this.controller.update());

        Mockito.verify(this.utils, Mockito.times(2)).getLong();
        Mockito.verify(this.utils, Mockito.times(1)).getDate();
        Mockito.verify(this.dao, Mockito.times(1)).update(updated);
    }

    @Test
    public void testDelete() {
        final long ORDER_ID = 1L;

        Mockito.when(utils.getLong()).thenReturn(ORDER_ID);
        Mockito.when(dao.delete(ORDER_ID)).thenReturn(1);

        assertEquals(1L, this.controller.delete());

        Mockito.verify(utils, Mockito.times(1)).getLong();
        Mockito.verify(dao, Mockito.times(1)).delete(ORDER_ID);
    }

}
