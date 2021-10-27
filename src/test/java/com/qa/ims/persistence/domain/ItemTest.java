package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ItemTest {

	@Test
	public void getIdTest() {
		 Item item = new Item(1L, "ps5", 500.25d);
		 final long expected = 1L;
		 final long actual = item.getId();
		 assertEquals(expected, actual);
	}
	@Test
	public void setIdTest() {
		Item item = new Item(1L, "ps5", 500.25d);
		final long expected = 2L;
		item.setId(2L);
		assertTrue(expected == item.getId());
		
	}
	@Test
	public void getItem_nameTest() {
		Item item = new Item(1L, "ps5", 500.25d);
		final String expected = "ps5";
		final String actual = item.getItem_name();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void setItem_nameTest() {
		Item item = new Item(1L, "ps5", 500.25d);
		final String expected = "Iphone";
		item.setItem_name("Iphone");
		assertTrue(expected == item.getItem_name());
	}
	@Test
	public void getValueTest() {
		 Item item = new Item(1L, "ps5", 500.25d);
		 final double expected = 500.25d;
		 final double actual = item.getValue();
		 assertTrue(expected == actual);
	}
	@Test
	public void setValueTest() {
		Item item = new Item(1L, "ps5", 500.25d);
		final double expected = 400.53d;
		item.setValue(400.53d);
		assertTrue(expected == item.getValue());
	}
	@Test
	public void toStringTest() {
		Item item = new Item(1L, "ps5", 500.25d);
		final String expected = "id:1, item_name:ps5, value:500.25";
		final String actual = item.toString();
		assertEquals(expected, actual);
	}
	
}
