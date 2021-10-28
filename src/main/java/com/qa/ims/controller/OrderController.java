package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.exceptions.OrderNotFoundException;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderLinesDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderLines;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	private ItemDAO itemDAO;
	private OrderDAO orderDAO;
	private Utils utils;
	private OrderLinesDAO olDAO;

	
	public OrderController(ItemDAO itemDAO, OrderDAO orderDAO, Utils utils, OrderLinesDAO olDAO) {
		super();
		this.itemDAO = itemDAO;
		this.orderDAO = orderDAO;
		this.utils = utils;
		this.olDAO = olDAO;
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
		LOGGER.info("Please enter a Customer ID");
		Long customerId = utils.getLong();

		Order order = orderDAO.create(new Order(customerId));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please Customer ID");
		Long customerId = utils.getLong();

		Order order = orderDAO.update(new Order(id, customerId));
		LOGGER.info("Order Updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		LOGGER.info("You will need to manually delete all items associated with this order");
		return orderDAO.delete(id);
	}

	public OrderLines addItem(){
		
			LOGGER.info("Please enter the order ID");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the Item ID");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter a Quantity");
		Long quant = utils.getLong();
		OrderLines orderL = olDAO.create(new OrderLines(orderId, itemId, quant));
		LOGGER.info("Item has been added");
		return orderL;
		
		
		

	}

	public int removeItem() {
		LOGGER.info("Please enter the order id of the items you would like to remove");
		LOGGER.info("WARNING: this will remove all items associated with the order");
		Long id = utils.getLong();
		return olDAO.delete(id);

	}

	public Double total() {
		LOGGER.info("Please enter the Order_id");
		Long orderId = utils.getLong();
		Double total = 0d;
		List<OrderLines> orderIds = olDAO.readOrderId(orderId);
		
		for (int i=0; i < orderIds.size(); i++) {
			Item item = itemDAO.read(orderIds.get(i).getItemId());
			total += item.getValue() * orderIds.get(i).getQuantity();
		}
		LOGGER.info(total);
		return total;
		
		
		

	}

}
