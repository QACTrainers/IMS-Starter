package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Items> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO ItemsDAO;
	private Utils utils;

	public ItemsController(ItemsDAO ItemsDAO, Utils utils) {
		super();
		this.ItemsDAO = ItemsDAO;
		this.utils = utils;

	}

	@Override
	public List<Items> readAll() {
		List<Items> items = ItemsDAO.readAll();
		for (Items item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	@Override
	public Items create() {
		Items items = null;
		while (items == null) {
			LOGGER.info("Please enter name (enter exit to cancel)");
			String name = utils.getString();
			if (name.equals("exit")) {
				LOGGER.info("Cancelling request");
				return null;
			}
			LOGGER.info("Please enter price (enter 0 to return)");
			Double price = utils.getDouble();
			if (price.equals(0d)) {
				LOGGER.info("Returning to start");
				continue;
			}
			items = ItemsDAO.create(new Items(name, price));
			LOGGER.info("Item created");
		}
		return items;
	}

	@Override
	public Items update() {
		Items items = null;
		while (items == null) {
			LOGGER.info("Please enter ID of item you would like to update (enter 0 to cancel)");
			Long IID = utils.getLong();
			if (IID.equals(0l)) {
				LOGGER.info("Cancelling request");
				return null;
			}
			LOGGER.info("Please enter name (enter exit to return)");
			String name = utils.getString();
			if (name.equals("exit")) {
				LOGGER.info("Returning to start");
				continue;
			}
			LOGGER.info("Please enter price (enter 0 to return)");
			Double price = utils.getDouble();
			if (price.equals(0d)) {
				LOGGER.info("Returning to start");
				continue;
			}
			items = ItemsDAO.update(new Items(IID, name, price));
			LOGGER.info("Item Updated");
		}
		return items;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter ID of Item you would like to delete (enter 0 to cancel)");
		Long IID = utils.getLong();
		if (IID.equals(0l)) {
			LOGGER.info("Cancelling request");
			return 0;
		}
		LOGGER.info("Item Deleted");
		return ItemsDAO.delete(IID);
	}

}