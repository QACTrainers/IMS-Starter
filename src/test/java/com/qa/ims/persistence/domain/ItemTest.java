package com.qa.ims.persistence.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ItemTest {

   // @Test
    public void testEquals() {
        EqualsVerifier.simple().forClass(Item.class).verify();
    }


    @Test
    public void objectIsNotNull() {

        Item item = new Item(1L, "butter knife", 2L, 25L, "silver");
        assertNotNull("Expected: Not Null Object",item.getItemID());
        assertNotNull("Expected: Not Null Object",item.getItemName());
        assertNotNull("Expected: Not Null Object",item.getItemValue());
        assertNotNull("Expected: Not Null Object",item.getQuantity());
        assertNotNull("Expected: Not Null Object",item.getColour());
        assertNotNull("Expected: Not Null Object",item.toString());
        assertNotNull("Expected: Not Null Object",item.hashCode());

    }

    @Test
    public void setterTets() {
        Item item = new Item(1L, "butter knife", 2L, 25L, "silver");
        item.setItemName("spoon");
        assertEquals("spoon", item.getItemName());
        item.setColour("black");
        assertEquals("black", item.getColour());
    }
}
