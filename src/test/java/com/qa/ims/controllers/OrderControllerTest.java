package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderLinesDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderLines;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@Mock
	private OrderLinesDAO daoLines;
	
	@Mock
	private ItemDAO iDao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final long customerId = 1L;
		final Order created = new Order(customerId);

		Mockito.when(utils.getLong()).thenReturn(customerId);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Order updated = new Order(1L, 2L);

		Mockito.when(this.utils.getLong()).thenReturn(1L, updated.getCustomer_id());

		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(2)).getLong();

		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
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
	public void addItemTest() {
		final long orderId = 1L, itemId = 1L, quant = 1L;
		final OrderLines created = new OrderLines(orderId, itemId, quant);
		
		Mockito.when(utils.getLong()).thenReturn(orderId, itemId, quant);
		Mockito.when(daoLines.create(created)).thenReturn(created);
		
		assertEquals(created, controller.addItem());

		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(daoLines, Mockito.times(1)).create(created);
	}
	@Test
	public void removeItemTest() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(daoLines.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.removeItem());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(daoLines, Mockito.times(1)).delete(ID);
	}
	@Test
	public void totalTest() {
		final long orderId = 1L;
		List<OrderLines> x = new ArrayList<>();
		x.add(new OrderLines(1L, 1L, 8L));
		final Item y = new Item("test item", 500.25d);
		
		Mockito.when(iDao.read(orderId)).thenReturn(y);
		Mockito.when(utils.getLong()).thenReturn(orderId);
		Mockito.when(daoLines.readOrderId(orderId)).thenReturn(x);
		double expected = 8*500.25d, actual = this.controller.total();
		
		assertTrue(expected == actual);
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(daoLines, Mockito.times(1)).readOrderId(orderId);
	}


}
