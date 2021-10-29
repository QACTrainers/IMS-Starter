package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

import Services.CrudServices;

public class ItemController implements CrudController<Item>{

		public static final Logger LOGGER = LogManager.getLogger(ItemController.class);
		
		private CrudServices<Item> itemService;
		
		public ItemController(CrudServices<Item> ItemService) {
			this.itemService = ItemService;
		}
		

		String getInput() {
			return Utils.getInput();
		}
		Double getNumber() {
			return Utils.getNumber();
		}
		
		/**
		 * Reads all Items to the logger
		 */
		@Override
		public List<Item> readAll() {
			List<Item> items = itemService.readAll();
			for(Item item: items) {
				LOGGER.info(item.toString());
			}
			return items;
		}

		/**
		 * Creates a Item by taking in user input
		 */
		@Override
		public Item create() {
			LOGGER.info("Please enter the Item name");
			String item_name = getInput();
			LOGGER.info("Please enter item price");
			Double item_price = getNumber();
			Item Item = itemService.create(new Item(item_name, item_price));
			LOGGER.info("Item Created, here is your Item_ID" + " " + Item.getItem_id());
			return Item;
		}

		/**
		 * Updates an existing Item by taking in user input
		 */
		@Override
		public Item update() {
			LOGGER.info("Please enter the id of the Item you would like to update");
			Long item_id = Long.valueOf(getInput());
			LOGGER.info("Please enter the Item name");
			String item_name = getInput();
			LOGGER.info("Please enter item price");
			Double item_price = getNumber();
			Item Item = itemService.update(new Item(item_id, item_name, item_price));
			LOGGER.info("Item Updated");
			return Item;
		}
		

		/**
		 * Deletes an existing Item by the id of the Item
		 */
		@Override
		public void delete() {
			LOGGER.info("Please enter the id of the Item you would like to delete");
			Long item_id = Long.valueOf(getInput());
			LOGGER.info("Item Deleted"); 
			itemService.delete(item_id);
		}
		
	}


