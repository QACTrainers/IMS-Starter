package com.qa.ims.persistence.domain;

import org.junit.Test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertNotNull;

public class OrderTest {

    @Test
    public void objectIsNotNull() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final Date PLACED = new java.sql.Date(dateFormat.parse("1/2/2003").getTime());

        Order order = new Order(1L, 1L, PLACED,  5L);
        assertNotNull("Expected: Not Null Object",order.getOrderID());
        assertNotNull("Expected: Not Null Object",order.getFkCustomerID());
        assertNotNull("Expected: Not Null Object",order.getPlaced());
        assertNotNull("Expected: Not Null Object",order.getTotal());
        assertNotNull("Expected: Not Null Object",order.toString());
        assertNotNull("Expected: Not Null Object",order.hashCode());
    }
}
