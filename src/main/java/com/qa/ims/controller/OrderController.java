package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrdersDAO ordersDAO;
	private Utils utils;

	public OrderController(OrdersDAO orderDAO, Utils utils) {
		super();
		this.ordersDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Orders> readAll() { // view all orders in the system
		List<Orders> orders = ordersDAO.readAll();
		for (Orders order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Orders create() { // create an order in the system
		LOGGER.info("Please a customer ID");
		Long customerID = utils.getLong();
		LOGGER.info("Please enter the date in the format 'YYYY-MM-DD' ");
		String date = utils.getString();
		LOGGER.info("Please enter an item ID to add to the order");
		Long fk_itemID = utils.getLong();
		Orders order = ordersDAO.create(new Orders(customerID, date, fk_itemID));
		LOGGER.info("Order created");
		return order;
//
	}

	@Override
	public Orders update() { // change the item ID from an order (how to reflect this is orderline???)
		LOGGER.info("Please enter the id of the order you would like to update");
		Long orderID = utils.getLong();
		LOGGER.info("Please enter the customer ID");
		Long customerID = utils.getLong();
		LOGGER.info("Please enter item id of the product being ordered");
		Long fk_itemID = utils.getLong();
		Orders order = ordersDAO.update(new Orders(orderID, customerID, fk_itemID));
		LOGGER.info("Order Updated");
		return order;
	}

//	public Orders update2() { // delete an item to an order using the orderline table
//		LOGGER.info("Please enter the id of the order you would like to update");
//		Long orderID = utils.getLong();
//		LOGGER.info("Please enter the customer ID");
//		Long customerID = utils.getLong();
//		LOGGER.info("Please enter the date of the order in the format YYYY-MM-DD");
//		String date = utils.getString();
//		Orders order = OrderlineDAO);
//		LOGGER.info("Order Updated");
//		return order;
//	}

	@Override
	public int delete() { // delete an order in the system
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long orderID = utils.getLong();
		return ordersDAO.delete(orderID);
	}

//	public Orders totalCost() {
//		LOGGER.info("Please enter the ID of an order to see the total cost");
//		Long orderID = utils.getLong();
//
//		return Orders;
//
//	}

}
