package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
						"SELECT orders.customer_id, orders.order_id FROM orders JOIN order_items on order_items.order_id = orders.order_id order by order_item.order_item_id desc limit 1;");) {
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
						"Select items.item_name,items.item_price,items.item_id from items join order_item on order_item.ItemID = items.ItemID where order_item.OrderID ="
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

	public void create(int item_id, int order_id) throws SQLException {
		String itemSelect = "SELECT * FROM items WHERE item_id =" + item_id + ";";
		String orderSelect = "SELECT * FROM orders WHERE order_id =" + order_id + ";";
		int id = 0;
		String item_name = null;
		double item_price = 0;
		int o_id = 0;
		int quantity = 0;
		int cust_id = 0;
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(itemSelect);
				ResultSet resultSet = preparedStatement.executeQuery();) {
			while (resultSet.next()) {
				id = resultSet.getInt("item_id");
				item_name = resultSet.getString("item_name");
				item_price = resultSet.getDouble("item_price");
			}

			PreparedStatement stmt = connection.prepareStatement(orderSelect);
			ResultSet rslt = stmt.executeQuery();

			while (rslt.next()) {
				o_id = rslt.getInt("order_id");
				quantity = rslt.getInt("quantity");
				cust_id = rslt.getInt("customer_id");
			}

			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO order_items (item_id, item_name, item_price, order_id, quantity, customer_id) VALUES (?,?,?,?,?,?)");
			statement.setInt(1, id);
			statement.setString(2, item_name);
			statement.setDouble(3, item_price);
			statement.setInt(4, o_id);
			statement.setInt(5, quantity);
			statement.setInt(6, cust_id);
			statement.executeQuery();
		}
	}
}
