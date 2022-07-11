package com.qa.ims.controller;

import java.util.List;

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
        return null;
    }

    @Override
    public Item create() {
        return null;
    }

    @Override
    public Item update() {
        return null;
    }

    @Override
    public int delete() {
        return 0;
    }
}
