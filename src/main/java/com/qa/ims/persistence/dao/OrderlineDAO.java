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

import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.utils.DBUtils;

public class OrderlineDAO implements Dao<Orderline> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public List<Orderline> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orderline");) {
			List<Orderline> orderlines = new ArrayList<>();
			while (resultSet.next()) {
				orderlines.add(modelFromResultSet(resultSet));
			}
			return orderlines;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Orderline readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM Orderline ORDER BY orderlineID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orderline read(Long orderlineID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM Orderline WHERE orderlineID = ?");) {
			statement.setLong(1, orderlineID);
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

	public Orderline read(Long fk_orderID, Long fk_itemID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM Orderline WHERE fk_orderID = ? AND fk_itemID = ?");) {
			statement.setLong(1, fk_orderID);
			statement.setLong(2, fk_itemID);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet2(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orderline create(Orderline orderline) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO Orderline (fk_orderID, fk_itemID, quantity, price) VALUES (?, ?, ?, ?)");) {
			statement.setLong(1, orderline.getFk_orderID());
			statement.setLong(2, orderline.getFk_itemID());
			statement.setLong(3, orderline.getQuantity());
			statement.setDouble(4, orderline.getPrice());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orderline update(Orderline orderline) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE Orderline SET quantity = ?, price = ? WHERE fk_orderID = ? AND fk_itemID = ?");) {
			statement.setLong(1, orderline.getQuantity());
			statement.setDouble(2, orderline.getPrice());
			statement.setLong(3, orderline.getFk_orderID());
			statement.setLong(4, orderline.getFk_itemID());
			statement.executeUpdate();
			return read(orderline.getFk_orderID(), orderline.getFk_itemID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return orderline;
	}

	@Override
	public int delete(long orderlineID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM Orderline WHERE orderlineID = ?");) {
			statement.setLong(1, orderlineID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public Orderline modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderlineID = resultSet.getLong("orderlineID");
		Long fk_orderID = resultSet.getLong("fk_orderID");
		Long fk_itemID = resultSet.getLong("fk_itemID");
		Long quantity = resultSet.getLong("quantity");
		Double price = resultSet.getDouble("price");
		return new Orderline(orderlineID, fk_orderID, fk_itemID, quantity, price);
	}

	public Orderline modelFromResultSet2(ResultSet resultSet) throws SQLException {
		Long fk_orderID = resultSet.getLong("fk_orderID");
		Long fk_itemID = resultSet.getLong("fk_itemID");
		Long quantity = resultSet.getLong("quantity");
		Double price = resultSet.getDouble("price");
		return new Orderline(fk_orderID, fk_itemID, quantity, price);
	}

}