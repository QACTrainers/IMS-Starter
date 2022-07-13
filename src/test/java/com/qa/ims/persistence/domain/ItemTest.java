package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {

	public void testEquals() {
		EqualsVerifier.simple().forClass(Item.class).verify();

	}

	@Test
	public void testItemConstructor1() {
		Item test = new Item("mirror", 15.99);
		assertEquals("mirror", test.getItemName());
		assertEquals(Double.valueOf(15.99), test.getPrice());

	}

	@Test
	public void testItemConstructor2() {
		Item test = new Item(1L, "tulips", 5.99D);
		assertEquals(Long.valueOf(1), test.getItemID());
		assertEquals("tulips", test.getItemName());
		assertEquals(Double.valueOf(5.99), test.getPrice());

	}

	@Test
	public void testItemConstructor3() {
		Item test = new Item(1L, 100D);
		assertEquals(Long.valueOf(1), test.getItemID());
		assertEquals(Double.valueOf(100), test.getPrice());
	}

	@Test
	public void testToString() {
		Item test = new Item(1L, "TV", 499.99D);
		String expected = "itemID = " + test.getItemID() + " itemName = " + test.getItemName() + " price = "
				+ test.getPrice();
		assertEquals(expected, test.toString());

	}

	@Test
	public void testHashCode() {
		Item test1 = new Item(1L, "throw", 85.99D);
		Item test2 = new Item(1L, "throw", 85.99D);
		assertEquals(test1, test2);
		assertTrue(test1.hashCode() == test2.hashCode());

	}

}
