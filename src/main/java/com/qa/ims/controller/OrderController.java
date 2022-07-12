package com.qa.ims.controller;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Customer;

import java.util.List;

import com.qa.ims.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderController implements CrudController<Order> {

    public static final Logger LOGGER = LogManager.getLogger();

    private final OrderDAO orderDAO;
    private final Utils utils;

    public OrderController(OrderDAO orderDAO, Utils utils) {
        super();
        this.orderDAO = orderDAO;
        this.utils = utils;
    }

    @Override
    public Order create() {
        LOGGER.info("Please enter the Customer ID");
        Long fk_customers_id = utils.getLong();
        CustomerDAO customerDao = new CustomerDAO();
        Customer newCustomer = customerDao.read(fk_customers_id);
        Order order = orderDAO.create(new Order(newCustomer));
        LOGGER.info("New Order Successfully Created");
        return order;
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
    public Order update() {
        Order order = new Order();
        LOGGER.info("Please enter the Order ID you want to update");
        Long orders_id = utils.getLong();
        LOGGER.info("Do you want to Add or Remove an item?");
        String choice = utils.getString();
        LOGGER.info("Enter the Item ID you would like to update");
        Long items_id = utils.getLong();
        if (choice.equals("Add")) {
            order = orderDAO.updateAdd(orders_id, items_id);
            LOGGER.info("The item has been successfully added to the order");
        }
        if (choice.equals("Remove")) {
            order = orderDAO.updateRemove(orders_id, items_id);
            LOGGER.info("The item has been successfully removed from order");
        }
        LOGGER.info("Order Successfully Updated");
        return order;
    }

    @Override
    public int delete() {
        LOGGER.info("Please enter the ID of the Order you want to delete");
        Long id = utils.getLong();
        LOGGER.info("Order Successfully Deleted");
        return orderDAO.delete(id);
    }

}
