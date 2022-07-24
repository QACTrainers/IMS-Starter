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
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO orderdao;

	@InjectMocks
	private OrderController ordercontroller;

	private Long id;

	private Long itemId;

	@Test
	public void testCreate() {
		final Long id = 1L;
		final Long itemId = 1L;
		final Order created = new Order(id, itemId);
		Mockito.when(utils.getLong()).thenReturn(id, itemId);
		Mockito.when(orderdao.create(created)).thenReturn(created);

		assertEquals(created, ordercontroller.create());

	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order(1L, 1L));

		Mockito.when(orderdao.readAll()).thenReturn(orders);

		assertEquals(orders, ordercontroller.readAll());

		Mockito.verify(orderdao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Order updated = new Order(id, itemId);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.orderdao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.ordercontroller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.orderdao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(orderdao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.ordercontroller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(orderdao, Mockito.times(1)).delete(ID);
	}

}
