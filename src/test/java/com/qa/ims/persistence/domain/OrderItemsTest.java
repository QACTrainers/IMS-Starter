package com.qa.ims.persistence.domain;

import org.junit.Test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderItemsTest {

    @Test
    public void objectIsNotNull() throws ParseException {

        OrderItems orderItems = new OrderItems(1L, 1L,1L,3L,6L);
        assertNotNull("Expected: Not Null Object",orderItems.getOrderItemID());
        assertNotNull("Expected: Not Null Object",orderItems.getFkOrderID());
        assertNotNull("Expected: Not Null Object",orderItems.getFkItemID());
        assertNotNull("Expected: Not Null Object",orderItems.getQuantity());
        assertNotNull("Expected: Not Null Object",orderItems.getTotal());
        assertNotNull("Expected: Not Null Object",orderItems.getTotal());
        assertNotNull("Expected: Not Null Object",orderItems.hashCode());
    }
}
