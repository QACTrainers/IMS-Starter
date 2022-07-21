package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final Long customer_ID = 1L, Item_ID = 1L, quantity = 1L;

		final Order created = new Order(1L, 1L, 1L);

		Mockito.when(utils.getLong()).thenReturn(customer_ID, Item_ID, quantity);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
	@Test
	public void testCreate2() {
		final Long customer_ID = 1L, Item_ID = 1L, quantity = 1L;
		final Order created = new Order(1L, 1L, 1L);
		Mockito.when(utils.getLong()).thenReturn(0L);
		assertEquals(null, controller.create());
		Mockito.verify(utils, Mockito.times(1)).getLong();
	}

	@Test
	public void testReadAll() {
		List<Order> order = new ArrayList<>();
		order.add(new Order(1L, 1L, 1L));

		Mockito.when(dao.readAll()).thenReturn(order);

		assertEquals(order, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Order updated = new Order(1L, 1L, 1L, 1L);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getLong()).thenReturn(updated.getCustID(), updated.getItem_ID(), updated.getQuantity());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(4)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
	
	@Test
	public void testUpdate2() {
		Mockito.when(utils.getLong()).thenReturn(0L);
		assertEquals(null, controller.update());
		Mockito.verify(utils, Mockito.times(1)).getLong();
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

	@Test
	public void testDelete2() {
		final long ID = 0L;

		Mockito.when(utils.getLong()).thenReturn(ID);

		assertEquals(0L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
	}



}