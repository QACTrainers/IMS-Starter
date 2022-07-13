package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

	public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO;
	private Utils utils;

	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	@Override
	public Item create() {
		LOGGER.info("Please enter the name of the item");
		String itemName = utils.getString();
		LOGGER.info("Please enter the price");
		Double price = utils.getDouble();
		Item item = itemDAO.create(new Item(itemName, price));
		LOGGER.info("Item added");
		return item;
	}

	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long itemID = utils.getLong();
		LOGGER.info("Please enter the name of the item");
		String itemName = utils.getString();
		LOGGER.info("Please enter a price");
		Double price = utils.getDouble();
		Item item = itemDAO.update(new Item(itemID, itemName, price));
		LOGGER.info("Item Updated");
		return item;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long itemID = utils.getLong();
		return itemDAO.delete(itemID);
	}
}
