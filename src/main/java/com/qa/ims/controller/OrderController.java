package com.qa.ims.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString()); 
		}
		return orders; 
	}

	
	@Override
	public Order create() {
		LOGGER.info("Please enter customer Id");
		int customer_id = utils.getInteger();
		LOGGER.info("Please enter an item Id");
		Long itemId= utils.getLong(); 
		LOGGER.info("Please enter item quantity");
		Integer quantity= utils.getInteger(); 
		HashMap<Long, Integer> items = new HashMap<Long, Integer>();
		items.put(itemId, quantity); 
		LOGGER.info("Would you like to add another item? Y/N");
		String input = utils.getString();
		Boolean choice = input.equalsIgnoreCase("Y");

		
		while(choice) {
			LOGGER.info("Please enter an item Id");
			itemId= utils.getLong(); 
			LOGGER.info("Please enter item quantity");
			quantity= utils.getInteger(); 
			items.put(itemId, quantity); 
			LOGGER.info("Would you like to add another item? Y/N");
			input = utils.getString();
			choice = input.equalsIgnoreCase("Y");
		}
		
		LOGGER.info("Please enter total order price");
		Double totalOrderPrice = utils.getDouble();
		
		Order order = orderDAO.create(new Order(customer_id, items, totalOrderPrice)); 
		
		LOGGER.info("Order created");
		return order;
	}

	
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the quantity");
		int orderQuantity = utils.getInteger();

		LOGGER.info("Please enter the total price");
		Double totalOrderPrice = utils.getDouble();
		
		Order order = orderDAO.update(new Order(orderId, orderQuantity, totalOrderPrice));
		LOGGER.info("Order Updated");
		return order;
	}
	
	

	
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to operate on");
		Long orderId = utils.getLong();
		LOGGER.info("Would you like to delete? ITEM or ORDER");
		String choice = utils.getString();

		if (choice.equalsIgnoreCase("ITEM")) {
			LOGGER.info("Please enter the id of the item you would like to delete");
			Long itemId = utils.getLong(); 
			orderDAO.deleteItemFromOrder(orderId, itemId); 
			LOGGER.info("item deleted from order");

		} else if (choice.equalsIgnoreCase("ORDER")) {
			
			orderDAO.delete(orderId); 
			LOGGER.info("order deleted");

		}
		
         return 0;
	}


	
	

}
