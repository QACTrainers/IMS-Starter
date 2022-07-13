package com.qa.ims.persistence.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void constructorTest() {
        Customer customer1 = new Customer("Jane", "Doe");
        assertEquals("Jane", customer1.getFirstName());
        assertEquals("Doe", customer1.getSurname());
    }

    @Test
    public void overloadedConstructorTest() {
        Customer customer2 = new Customer(2L, "Jane", "Doe");
        assertEquals(Long.valueOf(2), customer2.getId());
        assertEquals("Jane", customer2.getFirstName());
        assertEquals("Doe", customer2.getSurname());
    }

    @Test
    public void toStringTest() {
        Customer customer2 = new Customer(3L, "Jane", "Doe");
        String expected = "id:3 first name:Jane surname:Doe";
        assertEquals(expected, customer2.toString());
    }

}
