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
import com.qa.ims.persistence.dao.Order_ItemDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	@Mock
	private Utils utils;

	@Mock
	private OrderDAO orderDAO;

	@Mock
	private Order_ItemDAO order_itemDAO;

	@InjectMocks
	private OrderController OrderController;

	@Test
	public void TestReadAll() {
		final List<Order> orders = new ArrayList<Order>();
		final Order read = new Order(1l, 1l);
		orders.add(read);

		Mockito.when(orderDAO.readAll()).thenReturn(orders);

		assertEquals(orders, OrderController.readAll());
	}

	@Test
	public void TestDelete() {
		final Long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);

		assertEquals(0, OrderController.delete());

		Mockito.verify(orderDAO, Mockito.times(1)).delete(ID);
	}

	@Test
	public void TestCreate() {
		final Long id = 2L;
		final Long item_id = 1L;
		final Order created = new Order(id, item_id);

		Mockito.when(utils.getLong()).thenReturn(id, item_id);
		Mockito.when(orderDAO.create(created)).thenReturn(created);
		// Mockito.when(orderDAO.readLatest()).thenReturn(created);

		assertEquals(created, OrderController.create());
	}

	@Test
	public void TestUpdate() {
		final Long order_id = 1L;
		final Long item_id = 1L;
		final Long customer_id = 1L;
		// final Order order = new Order(order_id, item_id);

		Mockito.when(utils.getLong()).thenReturn(order_id, item_id, item_id, customer_id);
		// Mockito.when(orderDAO.read(order_id)).thenReturn(order);
		// Mockito.when(utils.getString()).thenReturn("ADD", "REMOVE", "CUSTOMER",
		// "sdfg", "RETURN");

		assertEquals(null, OrderController.update());
	}

}