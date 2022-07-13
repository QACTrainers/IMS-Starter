package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}

	@Test
	public void testCustomerConstructor1() {
		Customer test = new Customer("henry", "cavill");
		assertEquals("henry", test.getFirstName());
		assertEquals("cavill", test.getSurname());

	}

	@Test
	public void testCustomerConstructor2() {
		Customer test = new Customer(1L, "nancy", "wheeler");
		assertEquals(Long.valueOf(1), test.getId());
		assertEquals("nancy", test.getFirstName());
		assertEquals("wheeler", test.getSurname());

	}

	@Test
	public void testToString() {
		Customer test = new Customer(1L, "rachel", "evans");
		String expected = "id:" + test.getId() + " first name:" + test.getFirstName() + " surname:" + test.getSurname();
		assertEquals(expected, test.toString());

	}

	@Test
	public void testHashCode() {
		Customer test1 = new Customer(1L, "rachel", "evans");
		Customer test2 = new Customer(1L, "rachel", "evans");
		assertEquals(test1, test2);
		assertTrue(test1.hashCode() == test2.hashCode());

	}

}
