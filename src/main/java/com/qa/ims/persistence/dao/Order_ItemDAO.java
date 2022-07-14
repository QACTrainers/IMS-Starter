package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class Order_ItemDAO {

	public static final Logger LOGGER = LogManager.getLogger();
	ItemDAO itemDAO = new ItemDAO();
	OrderDAO orderDAO = new OrderDAO();

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"SELECT orders.fk_customer_id, orders.fk_order_id FROM orders JOIN order_items on order_items.fk_order_id = orders.order_id order by order_item.order_item_id desc limit 1;");) {
			resultSet.next();
			return orderDAO.modelFromResultSet(resultSet);
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public List<Item> readItemsByOrder(Long OrderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"Select items.title,items.price,items.ItemID from items join order_item on order_item.ItemID = items.ItemID where order_item.OrderID ="
								+ OrderID + ";");) {
			List<Item> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(itemDAO.modelFromResultSet(resultSet));
			}
			return (items);
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
}
