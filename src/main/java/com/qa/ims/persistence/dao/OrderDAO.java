package com.qa.ims.persistence.dao;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements Dao<Order> {

    public static final Logger LOGGER = LogManager.getLogger();

    private final ItemDAO itemDAO;
    private final CustomerDAO customerDAO;

    public OrderDAO(CustomerDAO customerDao, ItemDAO itemDao) {
        this.itemDAO = itemDao;
        this.customerDAO = customerDao;
    }

    @Override
    public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
        Long orderId = resultSet.getLong("orders_id");
        Long customerId = resultSet.getLong("fk_customers_id");
        List<Item> itemList = getAllItemsInOrder(orderId);
        double totalPrice = calculateTotalCost(orderId);
        Customer customer = customerDAO.read(customerId);
        return new Order(orderId, customer, totalPrice, itemList);
    }

    public List<Item> getAllItemsInOrder(Long orderID) {
        List<Item> ListOfItems = new ArrayList<>();
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("SELECT * FROM orders_items WHERE fk_orders_id = ?")) {
            statement.setLong(1, orderID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ListOfItems.add(itemDAO.read(resultSet.getLong("fk_items_id")));
            }
            return ListOfItems;
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return ListOfItems;
    }

    public double calculateTotalCost(Long orderID) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("SELECT * FROM orders_items WHERE fk_orders_id = ?")) {
            statement.setLong(1, orderID);
            ResultSet resultSet = statement.executeQuery();
            double totalOrderCost = 0;
            while (resultSet.next()) {
                totalOrderCost += itemDAO.read(resultSet.getLong("fk_items_id")).getItemPrice();
            }
            return totalOrderCost;
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0.0;
    }

    @Override
    public Order create(Order order) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("INSERT INTO orders(fk_customers_id, orders_total_price) VALUES (?, 0.0)")) {
            statement.setLong(1, order.getCustomerId().getId());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    public Order readLatest() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY orders_id DESC LIMIT 1")) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Order read(Long id) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE orders_id = ?")) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                return modelFromResultSet(resultSet);
            }
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Order> readAll() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM orders")) {
            List<Order> allCreatedOrders = new ArrayList<>();
            while (resultSet.next()) {
                allCreatedOrders.add(modelFromResultSet(resultSet));
            }
            return allCreatedOrders;
        } catch (SQLException e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public Order update(Order order) {
        // Leave
        return null;
    }

    public Order updateAdd(Long orderID, Long itemID) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("INSERT INTO orders_items(fk_orders_id, fk_items_id) VALUES (?, ?)")) {
            statement.setLong(1, orderID);
            statement.setLong(2, itemID);
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return read(orderID);
    }

    public Order updateRemove(Long orderID, Long itemID) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("DELETE FROM orders_items WHERE fk_orders_id = " + orderID +" AND fk_items_id = " + itemID)) {
            statement.setLong(1, orderID);
            statement.setLong(2, itemID);
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return read(orderID);
    }


    @Override
    public int delete(long orderId) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            return statement.executeUpdate("DELETE FROM orders_items WHERE fk_orders_id = " + orderId);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }


}
