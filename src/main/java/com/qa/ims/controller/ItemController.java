package com.qa.ims.controller;

import java.util.List;

import com.qa.ims.persistence.domain.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

/**
 * Takes in item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item>{

    public static final Logger LOGGER = LogManager.getLogger();

    private ItemDAO itemDOA;

    private Utils utils;

    public ItemController(ItemDAO itemDOA, Utils utils) {
        super();
        this.itemDOA = itemDOA;
        this.utils = utils;
    }
    @Override
    public List<Item> readAll() {
        List<Item> items = itemDOA.readAll();
        for (Item item : items) {
            LOGGER.info(item);
        }
        return items;
    }

    @Override
    public Item create() {

        LOGGER.info("please enter the item name");
        String itemName = utils.getString();
        LOGGER.info("please enter the value of the item");
        Long itemValue = utils.getLong();
        LOGGER.info("please enter the quantity of the item");
        Long quantity = utils.getLong();
        LOGGER.info("Please enter the colour of the item");
        String colour = utils.getString();
        Item item = itemDOA.create(new Item(itemName, itemValue, quantity, colour));
        LOGGER.info("Item created");
        return item;
    }

    @Override
    public Item update() {

        LOGGER.info("Please enter the id of the item you would like to update");
        Long id = utils.getLong();
        LOGGER.info("Please enter an item name");
        String itemName = utils.getString();
        LOGGER.info("please enter the value of the item");
        Long itemValue = utils.getLong();
        LOGGER.info("please enter the quantity of the item");
        Long quantity = utils.getLong();
        LOGGER.info("Please enter the colour of the item");
        String colour = utils.getString();
        Item item = itemDOA.update(new Item(id, itemName, itemValue, quantity, colour));
        LOGGER.info("item Updated");
        return item;
    }

    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the item you would like to delete");
        Long id = utils.getLong();
        return itemDOA.delete(id);
    }
}
