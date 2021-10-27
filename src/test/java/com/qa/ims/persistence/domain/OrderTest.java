package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrderTest {

	@Test
	public void getIdTest() {
		 Order order = new Order(1L, 1L);
		 final long expected = 1L;
		 final long actual = order.getId();
		 assertEquals(expected, actual);
	}
	@Test
	public void setIdTest() {
		Order order = new Order(1L, 1L);
		final long expected = 2L;
		order.setId(2L);
		assertTrue(expected == order.getId());
		
	}
	@Test
	public void getCustomer_idTest() {
		 Order order = new Order(1L, 1L);
		 final long expected = 1L;
		 final long actual = order.getCustomer_id();
		 assertEquals(expected, actual);
	}
	
	@Test
	public void setCutomer_idTest() {
		Order order = new Order(1L, 1L);
		final long expected = 2L;
		order.setId(2L);
		assertTrue(expected == order.getId());
	}
	@Test
	public void toStringTest() {
		Order order = new Order(1L, 1L);
		final String expected = "id:1, customer_id:1";
		final String actual = order.toString();
		assertEquals(expected, actual);
	}

}
