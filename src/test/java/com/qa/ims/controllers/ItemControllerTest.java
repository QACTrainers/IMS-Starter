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

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)

public class ItemControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private ItemDAO DAO;

	@InjectMocks
	private ItemController ItemController;

	@Test
	public void TestCreate() {
		final String title = "Radio";
		final Double price = 29D;
		final Item created = new Item(title, price);

		Mockito.when(utils.getString()).thenReturn(title);
		Mockito.when(utils.getDouble()).thenReturn(price);
		Mockito.when(DAO.create(created)).thenReturn(created);

		assertEquals(created, ItemController.create());

	}

	@Test
	public void TestUpdate() {
		final Long id = 1L;
		final String title = "beans";
		final Double price = 34.55D;
		final Item updated = new Item(id, title, price);

		Mockito.when(utils.getLong()).thenReturn(id);
		Mockito.when(utils.getString()).thenReturn(title);
		Mockito.when(utils.getDouble()).thenReturn(price);
		Mockito.when(DAO.update(updated)).thenReturn(updated);
		Mockito.when(utils.getString()).thenReturn("ADD", "REMOVE", "CUSTOMER", "fgsdfg", "RETURN");

		assertEquals(null, ItemController.update());

	}

	@Test
	public void TestDelete() {
		final Long id = 1L;

		Mockito.when(utils.getLong()).thenReturn(id);
		Mockito.when(DAO.delete(id)).thenReturn(0);

		assertEquals(0, ItemController.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(DAO, Mockito.times(1)).delete(id);
	}

	@Test
	public void TestReadAll() {
		final List<Item> items = new ArrayList<Item>();
		final Item read = new Item(1l, "porridegeg", 23.965D);
		items.add(read);

		Mockito.when(DAO.readAll()).thenReturn(items);

		assertEquals(items, ItemController.readAll());

		Mockito.verify(DAO, Mockito.times(1)).readAll();
	}
}