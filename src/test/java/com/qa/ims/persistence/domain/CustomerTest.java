package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	@Test
	public void getIdTest() {
		 Customer customer = new Customer(1L, "kerry", "goodinson");
		 final long expected = 1L;
		 final long actual = customer.getId();
		 assertEquals(expected, actual);
	}
	@Test
	public void setIdTest() {
		Customer customer = new Customer(1L, "kerry", "goodinson");
		final long expected = 2L;
		customer.setId(2L);
		assertTrue(expected == customer.getId());
		
	}
	@Test
	public void getFirstNameTest() {
		Customer customer = new Customer(1L, "kerry", "goodinson");
		final String expected = "kerry";
		final String actual = customer.getFirstName();
		
		assertEquals(expected, actual);
	}
	@Test
	public void setFirstNameTest() {
		Customer customer = new Customer(1L, "kerry", "goodinson");
		final String expected = "kieran";
		customer.setFirstName("kieran");
		assertTrue(expected == customer.getFirstName());
	}
	@Test
	public void getSurnameTest() {
		Customer customer = new Customer(1L, "kerry", "goodinson");
		final String expected = "goodinson";
		final String actual = customer.getSurname();
		
		assertEquals(expected, actual);
	}
	@Test
	public void setSurnameTest() {
		Customer customer = new Customer(1L, "kerry", "goodinson");
		final String expected = "Anne";
		customer.setSurname("Anne");
		assertTrue(expected == customer.getSurname());
	}
	@Test
	public void toStringTest() {
		Customer customer = new Customer(1L, "kerry", "goodinson");
		final String expected = "id:1 first name:kerry surname:goodinson";
		final String actual = customer.toString();
		
		assertEquals(expected, actual);
	}
	
	

}
