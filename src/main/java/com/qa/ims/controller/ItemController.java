package com.qa.ims.controller;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ItemController implements CrudController<Item>{

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
            LOGGER.info(item);
        }
        return items;
    }

    @Override
    public Item create() {
        LOGGER.info("Please enter a new item name");
        String itemName = utils.getString();
        LOGGER.info("Please enter a price");
        Double itemPrice = utils.getDouble();
        Item item = itemDAO.create(new Item(itemName, itemPrice));
        LOGGER.info("New Item Successfully Created");
        return item;
    }

    @Override
    public Item update() {
        LOGGER.info("Please enter the ID of the Item you would like to update");
        Long id = utils.getLong();
        LOGGER.info("Please enter a updated name");
        String itemName = utils.getString();
        LOGGER.info("Please enter an updated price");
        Double itemPrice = utils.getDouble();
        Item item = itemDAO.update(new Item(id, itemName, itemPrice));
        LOGGER.info("Item Successfully Updated");
        return item;
    }

    @Override
    public int delete() {
        LOGGER.info("Please enter the ID of the Item you would like to delete");
        Long id = utils.getLong();
        return itemDAO.delete(id);
    }
}
