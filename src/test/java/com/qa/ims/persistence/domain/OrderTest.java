package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Order.class).verify();
	}

	@Test
	public void testOrder() {
		Order order = new Order(10L, 10L, 10L);
		assertTrue(order instanceof Order);
	}

	@Test
	public void testOrder2() {
		Order order = new Order(10L, 10L, 10L, 10L);
		assertTrue(order instanceof Order);
	}

}