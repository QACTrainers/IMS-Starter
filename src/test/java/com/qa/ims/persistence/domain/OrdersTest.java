package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrdersTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Orders.class).verify();
	}

	@Test
	public void testOrderConstructor1() {
		Orders test = new Orders(1L, 1L, "2022-03-04", 1L);
		assertEquals(Long.valueOf(1), test.getOrderID());
		assertEquals(Long.valueOf(1), test.getCustomerID());
		assertEquals("2022-03-04", test.getDate());
		assertEquals(Long.valueOf(1), test.getFk_itemID());

	}

	@Test
	public void testCustomerConstructor2() {
		Orders test = new Orders(1L, 3L, 1L);
		assertEquals(Long.valueOf(1), test.getOrderID());
		assertEquals(Long.valueOf(3), test.getCustomerID());
		assertEquals(Long.valueOf(1), test.getFk_itemID());

	}

	@Test
	public void testCustomerConstructor3() {
		Orders test = new Orders(1L, "2022-03-04", 1L);
		assertEquals(Long.valueOf(1), test.getCustomerID());
		assertEquals("2022-03-04", test.getDate());
		assertEquals(Long.valueOf(1), test.getFk_itemID());

	}

	@Test
	public void testToString() {
		Orders test = new Orders(1L, 3L, "2022-04-04", 1L);
		String expected = "orderID=" + test.getOrderID() + ", customerID=" + test.getCustomerID() + ", date="
				+ test.getDate() + ", fk_itemID=" + test.getFk_itemID();
		assertEquals(expected, test.toString());

	}

	@Test
	public void testHashCode() {
		Orders test1 = new Orders(1L, 4L, "2022-12-10", 2L);
		Orders test2 = new Orders(1L, 4L, "2022-12-10", 2L);
		assertEquals(test1, test2);
		assertTrue(test1.hashCode() == test2.hashCode());

	}

}
