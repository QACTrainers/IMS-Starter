package com.qa.ims.controller;

import java.sql.Date;
import java.util.List;

import com.qa.ims.persistence.domain.Customer;
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
        super();
        this.orderDAO = orderDAO;
        this.utils = utils;
    }


    @Override
    public List<Order> readAll() {
        List<Order> orders = orderDAO.readAll();
        for (Order order : orders) {
            System.out.println(order.getPlaced());
            LOGGER.info(order);
        }
        return orders;
    }

    @Override
    public Order create() {
        LOGGER.info("Please enter the customer's ID");
        Long fkCustomerID = utils.getLong();
        LOGGER.info("Please enter the date the order was placed");
        Date placed = utils.getDate();
        //ENTER SOMETHING TO LINK THE ORDERS AND HE ORDERS_ITEMS TABLE TOGETHER
        Order order = orderDAO.create(new Order(fkCustomerID, placed, 3L));
        LOGGER.info("order created");
        return order;
    }

    @Override
    public Order update() {
        LOGGER.info("Please enter the id of the order you would like to update");
        Long orderID = utils.getLong();
        LOGGER.info("Please enter the customer's ID");
        Long fkCustomerID = utils.getLong();
        LOGGER.info("Please enter the date the order was placed");
        Date placed = utils.getDate();
        //ENTER SOMETHING TO LINK THE ORDERS AND HE ORDERS_ITEMS TABLE TOGETHER
        Order order = orderDAO.update(new Order(orderID, fkCustomerID, placed, 3L));
        LOGGER.info("order Updated");
        return order;
    }

    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the customer you would like to delete");
        Long orderId = utils.getLong();
        return orderDAO.delete(orderId);
    }
}
