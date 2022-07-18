package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderlineTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}

	@Test
	public void testCOrderlineConstructor1() {
		Orderline test = new Orderline(1L, 1L, 1L, 25L, 9.99);
		assertEquals(Long.valueOf(1), test.getOrderlineID());
		assertEquals(Long.valueOf(1), test.getFk_orderID());
		assertEquals(Long.valueOf(1), test.getFk_itemID());
		assertEquals(Long.valueOf(25), test.getQuantity());
		assertEquals(Double.valueOf(9.99), test.getPrice());

	}

	@Test
	public void testCOrderlineConstructor2() {
		Orderline test = new Orderline(1L, 1L, 25L, 9.99);
		assertEquals(Long.valueOf(1), test.getFk_orderID());
		assertEquals(Long.valueOf(1), test.getFk_itemID());
		assertEquals(Long.valueOf(25), test.getQuantity());
		assertEquals(Double.valueOf(9.99), test.getPrice());
	}

//	@Test
//	public void testCOrderlineConstructor3() {
//		Orderline test = new Orderline(1L, 1L, 1L, 25L, 9.99);
//		assertEquals(Long.valueOf(1), test.getOrderlineID());
//		assertEquals(Long.valueOf(1), test.getFk_orderID());
//		assertEquals(Long.valueOf(1), test.getFk_itemID());
//		assertEquals(Long.valueOf(25), test.getQuantity());
//		assertEquals(Double.valueOf(9.99), test.getPrice());
//
//
//	}

	@Test
	public void testToString() {
		Orderline test = new Orderline(1L, 1L, 1L, 25L, 9.99);
		String expected = "orderlineID=" + test.getOrderlineID() + ", fk_orderID=" + test.getFk_orderID()
				+ ", fk_itemID=" + test.getFk_itemID() + ", quantity=" + test.getQuantity() + ", price="
				+ test.getPrice();
		assertEquals(expected, test.toString());

	}

	@Test
	public void testHashCode() {
		Orderline test1 = new Orderline(2L, 2L, 2L, 15L, 5.99);
		Orderline test2 = new Orderline(2L, 2L, 2L, 15L, 5.99);
		assertEquals(test1, test2);
		assertTrue(test1.hashCode() == test2.hashCode());

	}

}