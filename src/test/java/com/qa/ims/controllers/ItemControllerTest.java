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
	private ItemDAO itemdao;

	@InjectMocks
	private ItemController itemcontroller;

	@Test
	public void testCreate() {
		final Long itemId = 1L;
		final String itemName = "Scissors";
		final Double itemPrice = 3.50D;
		final Item created = new Item(itemName, itemPrice);

		Mockito.when(utils.getLong()).thenReturn(itemId);
		Mockito.when(utils.getString()).thenReturn(itemName);
		Mockito.when(utils.getDouble()).thenReturn(itemPrice);
		Mockito.when(itemdao.create(created)).thenReturn(created);

//		assertEquals(created, ItemController.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(itemdao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		final List<Item> items = new ArrayList<Item>();
		final Item read = new Item("Scissors", 3.50D);
		items.add(read);

		Mockito.when(itemdao.readAll()).thenReturn(items);
		assertEquals(items, itemcontroller.readAll());
		Mockito.verify(itemdao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Item updated = new Item("Scissors", 3.50);

		Mockito.when(this.utils.getLong()).thenReturn(updated.getItemId());
		Mockito.when(this.utils.getString()).thenReturn(updated.getItemName());
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getItemPrice());
		Mockito.when(this.itemdao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.itemcontroller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.itemdao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(itemdao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.itemcontroller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(itemdao, Mockito.times(1)).delete(ID);

	}

}
