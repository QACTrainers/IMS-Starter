package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderlineDAO;
import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.utils.Utils;

public class OrderlineController {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderlineDAO orderlineDAO;
	private Utils utils;

	public OrderlineController(OrderlineDAO orderlineDAO, Utils utils) {
		super();
		this.orderlineDAO = orderlineDAO;
		this.utils = utils;
	}

	public Orderline create() {
		LOGGER.info("Please enter the order ID");
		Long fk_orderID = utils.getLong();
		LOGGER.info("Please enter the item ID");
		Long fk_itemID = utils.getLong();
		LOGGER.info("Please enter the number of units");
		Long quantity = utils.getLong();
		LOGGER.info("Please enter the price per unit");
		Double price = utils.getDouble();
		Orderline orderline = orderlineDAO.create(new Orderline(fk_orderID, fk_itemID, quantity, price));
		LOGGER.info("Item added to orderline");
		return orderline;
	}

	public int delete() {
		LOGGER.info("Please enter the id of the orderline you would like to delete");
		Long orderlineID = utils.getLong();
		return orderlineDAO.delete(orderlineID);
	}
}
