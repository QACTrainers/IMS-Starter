package com.qa.ims.persistence.domain;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

import static org.junit.Assert.assertNotNull;

public class CustomerTest {

	//@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
		//EqualsVerifier.forClass(Customer.class).verify();
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
}
