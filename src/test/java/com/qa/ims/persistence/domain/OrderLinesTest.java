package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrderLinesTest {

	@Test
	public void getIdTest() {
		 OrderLines orderL = new OrderLines(1L, 1L, 1L, 8L);
		 final long expected = 1L;
		 final long actual = orderL.getId();
		 assertEquals(expected, actual);
	}
	@Test
	public void setIdTest() {
		OrderLines orderL = new OrderLines(1L, 1L, 1L, 8L);
		final long expected = 2L;
		orderL.setId(2L);
		assertTrue(expected == orderL.getId());
		
	}
	@Test
	public void getOrderIdTest() {
		 OrderLines orderL = new OrderLines(1L, 1L, 1L, 8L);
		 final long expected = 1L;
		 final long actual = orderL.getOrderId();
		 assertEquals(expected, actual);
	}
	@Test
	public void setOrderIdTest() {
		OrderLines orderL = new OrderLines(1L, 1L, 1L, 8L);
		final long expected = 2L;
		orderL.setOrderId(2L);
		assertTrue(expected == orderL.getOrderId());
		
	}
	@Test
	public void getItemIdTest() {
		 OrderLines orderL = new OrderLines(1L, 1L, 1L, 8L);
		 final long expected = 1L;
		 final long actual = orderL.getItemId();
		 assertEquals(expected, actual);
	}
	@Test
	public void setItemIdTest() {
		OrderLines orderL = new OrderLines(1L, 1L, 1L, 8L);
		final long expected = 2L;
		orderL.setItemId(2L);
		assertTrue(expected == orderL.getItemId());
		
	}
	@Test
	public void getQuantityTest() {
		 OrderLines orderL = new OrderLines(1L, 1L, 1L, 8L);
		 final long expected = 8L;
		 final long actual = orderL.getQuantity();
		 assertEquals(expected, actual);
	}
	@Test
	public void setQuantityTest() {
		OrderLines orderL = new OrderLines(1L, 1L, 1L, 8L);
		final long expected = 2L;
		orderL.setQuantity(2L);
		assertTrue(expected == orderL.getQuantity());
		
	}
	@Test
	public void toStringTest() {
		OrderLines orderL = new OrderLines(1L, 1L, 1L, 8L);
		final String expected = "id:1, orderId:1, itemId:1, quantity:8";
		final String actual = orderL.toString();
		assertEquals(expected, actual);
	}
	
	
	

}
