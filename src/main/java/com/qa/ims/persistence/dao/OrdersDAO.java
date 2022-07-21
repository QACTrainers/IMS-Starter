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

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAO implements Dao<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public List<Orders> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders");) {
			List<Orders> order = new ArrayList<>();
			while (resultSet.next()) {
				order.add(modelFromResultSet(resultSet));
			}
			return order;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders ORDER BY orderID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders read(Long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders WHERE orderID = ?");) {
			statement.setLong(1, orderID);
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

	public Orders readCost(Long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT orderID, SUM(price*quantity) AS TotalPrice FROM orders o \r\n"
								+ "INNER JOIN item i \r\n" + "ON o.fk_itemID = i.itemID\r\n" + "WHERE orderID = ?;");) {
			statement.setLong(1, orderID);
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

	/**
	 * Creates a customer in the database
	 * 
	 * @param customer - takes in an order object. id will be ignored
	 *                 (auto_increment)
	 */
	@Override
	public Orders create(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO Orders (fk_id, fk_itemID, quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, order.getFk_id());
			statement.setLong(2, order.getFk_itemID());
			statement.setLong(3, order.getQuantity());
			statement.executeUpdate();

			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

			LOGGER.error(e.getMessage());
		}
		return null;

	}

	@Override
	public Orders update(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE Orders SET fk_id = ?, fk_itemID = ?, quantity = ? WHERE orderID = ?");) {
			statement.setLong(1, order.getFk_id());
			statement.setLong(2, order.getFk_itemID());
			statement.setLong(3, order.getQuantity());
			statement.setLong(4, order.getOrderID());
			statement.executeUpdate();
			return read(order.getOrderID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM Orders WHERE orderID = ?");) {
			statement.setLong(1, orderID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderID = resultSet.getLong("orderID");
		Long fk_id = resultSet.getLong("fk_id");
		Long fk_itemID = resultSet.getLong("fk_itemID");
		Long quantity = resultSet.getLong("quantity");
		return new Orders(orderID, fk_id, fk_itemID, quantity);
	}

}
