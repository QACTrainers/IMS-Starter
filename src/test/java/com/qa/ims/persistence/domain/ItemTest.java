package com.qa.ims.persistence.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void constructorTest() {
        Item item1 = new Item("MacBook Pro", 1500.99D);
        assertEquals("MacBook Pro", item1.getItemName());
        assertEquals(1500.99, item1.getItemPrice(), 0.1);
    }

    @Test
    public void constructorTestTwo() {
        Item item2 = new Item(1L, "MacBook Pro", 1500.99D);
        assertEquals(Long.valueOf(1), item2.getItemId());
        assertEquals("MacBook Pro", item2.getItemName());
        assertEquals(1500.99, item2.getItemPrice(), 0.1);

    }

    @Test
    public void setItemIdTest() {
        Item item3 = new Item();
        item3.setItemId(3L);
        assertEquals(Long.valueOf(3L), item3.getItemId());
    }

    @Test
    public void setItemNameTest() {
        Item item4 = new Item();
        item4.setItemName("MacBook Pro");
        assertEquals("MacBook Pro", item4.getItemName());
    }

    @Test
    public void setItemPriceTest() {
        Item item5 = new Item();
        item5.setItemPrice(1500.99);
        assertEquals(1500.99, item5.getItemPrice(), 0.1);
    }

    @Test
    public void toStringTest() {
        Item item6 = new Item(1L, "MacBook Pro", 1500.99D);
        String expected = "Item ID: 1, Item Name: MacBook Pro, Item Price: 1500.99";
        assertEquals(expected, item6.toString());
    }
}
