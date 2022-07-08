package com.qa.ims.controller;

import java.util.List;

import com.qa.ims.persistence.domain.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Takes in item details for CRUD functionality
 *
 */
public class ItemController  implements CrudController<Item> {

    public static final Logger LOGGER = LogManager.getLogger();
}
