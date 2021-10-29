package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.qa.ims.persistence.domain.Item;

public class ItemDaoMysql implements Dao<Item> {

	public static final Logger LOGGER = LogManager.getLogger(ItemDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public ItemDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims";
		this.username = username;
		this.password = password;
	}

	public ItemDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Item itemFromResultSet(ResultSet resultSet) throws SQLException {
		Long item_id = resultSet.getLong("item_id");
		String item_name = resultSet.getString("item_name");
		Double item_price = resultSet.getDouble("item_price");
		return new Item(item_id, item_name, item_price);
	}

	/**
	 * Reads all Items from the database
	 * 
	 * @return A list of Items
	 */
	@Override
	public List<Item> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Items");) {
			ArrayList<Item> Items = new ArrayList<>();
			while (resultSet.next()) {
				Items.add(itemFromResultSet(resultSet));
			}
			return Items;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}


	public Item readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Items ORDER BY item_id DESC LIMIT 1");) {
			resultSet.next();
			return itemFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a Item in the database
	 * 
	 * @param Item - takes in a Item object. item_id will be ignored
	 */
	@Override
	public Item create(Item Item) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into Items(item_name, item_price) values('" + Item.getItem_name() + "','"
					+ Item.getItem_price() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}


	public Item readItem(Long item_id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Items where item_id = " + item_id);) {
			resultSet.next();
			return itemFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a Item in the database
	 * 
	 * @param Item - takes in a Item object, the item_id field will be used to
	 *             update that Item in the database
	 * @return
	 */
	@Override
	public Item update(Item Item) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update Items set item_name ='" + Item.getItem_name() + "', item_price ='"
					+ Item.getItem_price() + "' where item_id =" + Item.getItem_id());
			return readItem(Item.getItem_id());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a Item in the database
	 * 
	 * @param item_id - item_id of the Item
	 */
	@Override
	public void delete(long item_id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from Items where item_id = " + item_id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public Item addtoOrderline(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(long order_id) {
		// TODO Auto-generated method stub
		
	}


}