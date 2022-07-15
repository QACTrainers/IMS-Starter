package com.qa.ims.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.OrderItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

    public static final Logger LOGGER = LogManager.getLogger();

    private OrderDAO orderDAO;

    private Utils utils;

    private List<OrderItems> orderItems;

    private OrderItemsDAO orderItemsDAO;

    public OrderController(OrderDAO orderDAO, Utils utils, OrderItemsDAO orderItemsDAO) {
        super();
        this.orderDAO = orderDAO;
        this.utils = utils;
        this.orderItemsDAO = orderItemsDAO;
    }


    @Override
    public List<Order> readAll() {
        List<Order> orders = orderDAO.readAll();
        List<OrderItems> orderItemsRead = orderItemsDAO.readAll();
        for (Order order : orders) {
            LOGGER.info(order);
            for (int i = 0; i < orderItemsRead.size(); i++) {
                if(order.getOrderID().equals(orderItemsRead.get(i).getFkOrderID())){
                    LOGGER.info(orderItemsRead.get(i));
                }
            }
        }
        return orders;
    }

    @Override
    public Order create() {
        LOGGER.info("Please enter the customer's ID");
        Long fkCustomerID = utils.getLong();
        LOGGER.info("Please enter the date the order was placed");
        Date placed = utils.getDate();
        Order order = orderDAO.create(new Order(fkCustomerID, placed, 0L));

        LOGGER.info("order created, to add items to the order, update created order.");
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
        LOGGER.info("Please enter the number of items in your order");
        int quant = utils.getInteger();

        Long orderTotal = 0L;

        for (int i = 0; i < quant; i++) {
            LOGGER.info("Please enter the item ID for the " + (i+1) + "th item");
            Long fkItemID = utils.getLong();
            LOGGER.info("Please enter the quantity of the item ");
            Long quantity = utils.getLong();
            LOGGER.info("please enter the price of the item, if unsure check items table");
            Long total = utils.getLong()*quantity;
            orderTotal += total;
            orderItems.add(orderItemsDAO.create(new OrderItems(orderID, fkItemID, quantity, total)));
        }

        Order order = orderDAO.update(new Order(orderID, fkCustomerID, placed, orderTotal, orderItems));
        LOGGER.info("order Updated, items added.");
        return order;
    }

    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the customer you would like to delete");
        Long orderId = utils.getLong();
        return orderDAO.delete(orderId) + orderItemsDAO.delete(orderId);
    }
}
