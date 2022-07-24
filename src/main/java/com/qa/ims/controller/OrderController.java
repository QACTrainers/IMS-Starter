package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
//		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter the Customer ID");
		Long id = utils.getLong();
		LOGGER.info("Please enter the Item ID");
		Long itemId = utils.getLong();
		Order order = orderDAO.create(new Order(id, itemId));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the Order ID of the order you would like to update");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the Customer ID");
		Long id = utils.getLong();
		LOGGER.info("Please enter the Item ID");
		Double quantity = utils.getDouble();
		LOGGER.info("Please enter the Item quantity");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter the new Total Price of the order");
		Double totalPrice = utils.getDouble();
		Order order = orderDAO.update(new Order(orderId, id, itemId, quantity, totalPrice));
		LOGGER.info("Order Updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the Order ID of the order you would like to delete");
		Long orderId = utils.getLong();
		return orderDAO.delete(orderId);
	}

}
