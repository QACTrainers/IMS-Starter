package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO;
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	@Override
	public Item create() {
		LOGGER.info("Please enter an Item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter the price of the Item");
		Double itemPrice = utils.getDouble();
		Item item = itemDAO.create(new Item(itemName, itemPrice));
		LOGGER.info("Item successfully created");
		return item;
	}

	@Override
	public Item update() {
		LOGGER.info("Please enter the ID of the item you would like to update");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter an Item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter a price");
		Double itemPrice = utils.getDouble();
		Item item = itemDAO.update(new Item(itemId, itemName, itemPrice));
		LOGGER.info("Item successfully updated");
		return item;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the ID of of the item you would like to delete");
		Long itemId = utils.getLong();
		return itemDAO.delete(itemId);
	}

}
