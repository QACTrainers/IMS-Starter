package com.qa.ims.persistence.dao;

import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.DBUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsDAO implements Dao<OrderItems> {

    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<OrderItems> readAll() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM order_item ");) {
            List<OrderItems> orderItems = new ArrayList<>();
            while (resultSet.next()) {
                orderItems.add(modelFromResultSet(resultSet));
            }
            return orderItems;
        } catch (SQLException e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    public OrderItems readLatest() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM order_item ORDER BY order_item_ID DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public OrderItems read(Long orderItemID) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_item WHERE order_item_ID = ?");) {
            statement.setLong(1, orderItemID);
            try (ResultSet resultSet = statement.executeQuery();) {
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
    public OrderItems create(OrderItems orderItems) {
        System.out.println("hello");
        System.out.println( "orderitemsid:" + orderItems.getQuantity() );
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("INSERT INTO order_item(fk_order_ID, fk_item_ID, quantity, total) VALUES (?, ?, ?, ?)");) {
            statement.setLong(1, orderItems.getFkOrderID());
            statement.setLong(2, orderItems.getFkItemID());
            statement.setLong(3, orderItems.getQuantity());
            statement.setLong(4, orderItems.getTotal());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public OrderItems update(OrderItems orderItems) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("UPDATE order_item SET fk_order_ID = ?, fk_item_ID = ?, quantity = ?, total = ? WHERE order_item_ID = ?");) {
            statement.setLong(1, orderItems.getFkOrderID());
            statement.setLong(2, orderItems.getFkItemID());
            statement.setLong(3, orderItems.getQuantity());
            statement.setLong(4, orderItems.getTotal());
            statement.setLong(5, orderItems.getOrderItemID());
            statement.executeUpdate();
            return read(orderItems.getOrderItemID());
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public int delete(long orderItemID) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM order_item WHERE fk_order_ID = ?");) {
            statement.setLong(1, orderItemID);
            return statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

    @Override
    public OrderItems modelFromResultSet(ResultSet resultSet) throws SQLException {
        Long orderItemID = resultSet.getLong("order_item_ID");
        Long fkOrderID = resultSet.getLong("fk_order_ID");
        Long fkItemID = resultSet.getLong("fk_item_ID");
        Long quantity = resultSet.getLong("quantity");
        Long total = resultSet.getLong("total");
        return new OrderItems(orderItemID, fkOrderID, fkItemID, quantity, total);
    }
}
