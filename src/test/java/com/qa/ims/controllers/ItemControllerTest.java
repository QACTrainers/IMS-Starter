package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	//big decimal price 
Double item_price = 80.00;

	
	
	// GET NUMBER IS MEANT TO RETURN BIG DECIMAL 
	/**
	 *  The thing I want to fake functionlity for
	 */
	@Mock
	private ItemServices ItemServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the Item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the Item controller
	 */
	@Spy
	@InjectMocks
	private ItemControllerTest ItemController;

	@Test
	public void readAllTest() {
		ItemControllerTest ItemController = new ItemController(ItemServices);
		List<Item> Items = new ArrayList<>();
		Items.add(new Item("Chris", item_price));
		Items.add(new Item("Rhys", item_price));
		Items.add(new Item("Nic", item_price));
		Mockito.when(ItemServices.readAll()).thenReturn(Items);
		assertEquals(Items, ItemController.readAll());
	}

	@Test
	public void createTest() {
		String item_id = "1";
		String itemName = "Chris";
		String item_price = "80.00";
		Mockito.doReturn(item_id, itemName, item_price).when(ItemController).getInput();
		Item Item = new Item(itemName, 88.00);
		Item savedItem = new Item(1L, "Chris", 88.00);
		Mockito.when(ItemServices.create(Item)).thenReturn(savedItem);
		assertEquals(savedItem, ItemController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		String item_id = "1";
		String itemName = "Rhys";
		String item_price = "80.00";
		Mockito.doReturn(item_id, itemName, item_price).when(ItemController).getInput();
		Item Item = new Item(1L, itemName, Double.parseDouble(item_price));
		Mockito.when(ItemServices.update(Item)).thenReturn(Item);
		assertEquals(Item, ItemController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String item_id = "1";
		Mockito.doReturn(item_id).when(ItemController).getInput();
		ItemController.delete();
		Mockito.verify(ItemServices, Mockito.times(1)).delete(1L);
	}
	
}