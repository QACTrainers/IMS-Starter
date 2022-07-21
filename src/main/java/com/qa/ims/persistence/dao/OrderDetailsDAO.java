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

import com.qa.ims.persistence.domain.Order_Details;
import com.qa.ims.utils.DBUtils;

public class OrderDetailsDAO implements Dao<Order_Details> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order_Details modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long FID = resultSet.getLong("FID");
		Long order_ID = resultSet.getLong("order_ID");
		Long item_ID = resultSet.getLong("item_ID");
		Long quantity = resultSet.getLong("quantity");
		Double cost = quantity * getCost(item_ID);
		return new Order_Details(FID, order_ID, item_ID, quantity, cost);
	}

	public Double getCost(Long item_ID) {
		ItemsDAO Items = new ItemsDAO();
		Double cost = Items.read(item_ID).getPrice();
		return cost;
	}

	@Override
	public List<Order_Details> readAll() {
		long count = 0;
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_details");) {
			List<Order_Details> ordersdetails = new ArrayList<>();
			while (resultSet.next()) {
				ordersdetails.add(modelFromResultSet(resultSet));
				count++;
			}
			if (count < 1) {
				LOGGER.info("Empty result set");
			}
			return ordersdetails;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order_Details readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_details ORDER BY Order_ID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order_Details create(Order_Details orderdetails) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_details(order_ID, item_ID, quantity) VALUES (?, ?,?)");) {
			statement.setLong(1, orderdetails.getOrder_ID());
			statement.setLong(2, orderdetails.getItem_ID());
			statement.setLong(3, orderdetails.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order_Details read(Long FID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM order_details WHERE FID = ?");) {
			statement.setLong(1, FID);
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
	public Order_Details update(Order_Details orderdetails) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE order_details SET order_ID = ?, Item_ID = ?,quantity= ? WHERE FID = ?");) {
			statement.setLong(1, orderdetails.getOrder_ID());
			statement.setLong(2, orderdetails.getItem_ID());
			statement.setLong(3, orderdetails.getQuantity());
			statement.setLong(4, orderdetails.getFID());
			statement.executeUpdate();
			return read(orderdetails.getFID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long FID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_details WHERE FID = ?");) {
			statement.setLong(1, FID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}


}