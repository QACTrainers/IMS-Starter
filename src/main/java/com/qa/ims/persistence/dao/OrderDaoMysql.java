package com.qa.ims.persistence.dao;


import com.qa.ims.persistence.domain.Item;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderDaoMysql implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger(OrderDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrderDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims";
		this.username = username;
		this.password = password;
	}

	public OrderDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	String getInput() {
		return Utils.getInput();
	}

	static Order OrderFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderline_id = resultSet.getLong("orderline_id");
		Long order_id = resultSet.getLong("order_id");
		Long customer_id = resultSet.getLong("customer_id");
		Long item_id = resultSet.getLong("item_id");
		Integer quantity = resultSet.getInt("quantity");
		Double orderline_price = resultSet.getDouble("orderline_price");
		String first_name = resultSet.getString("first_name");
		String surname = resultSet.getString("surname");
		String address = resultSet.getString("address");

		return new Order(orderline_id, order_id, customer_id, quantity, item_id, orderline_price, first_name, surname,
				address);
	}

	static Order OrderFormResultSetUpdateTwo(ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("order_id");
		Long item_id = resultSet.getLong("item_id");
		return new Order(order_id, item_id);
	}

	static Order CalculateFormResultSetUpdateTwo(ResultSet resultSet) throws SQLException {
		Long orderline_id = resultSet.getLong("orderline_id");
		Long order_id = resultSet.getLong("order_id");
		Double orderline_price = resultSet.getDouble("SUM(orderline_price)");
		return new Order(order_id, orderline_id, orderline_price);
	}

	static Order OrderFromCreate(ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("order_id");
		Long customer_id = resultSet.getLong("customer_id");

		return new Order(order_id, customer_id);
	}

	Order addingANewOrderline(ResultSet resultSet) throws SQLException {
		Long orderline_id = resultSet.getLong("orderline_id");

		return new Order(orderline_id);
	}

	/**
	 * Reads all Orders from the database
	 * 
	 * @return A list of Orders
	 */
	@Override
	public List<Order> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"select ol.orderline_id, ol.order_id, ol.item_id, ol.quantity, ol.orderline_price, cu.customer_id, cu.first_name , cu.surname, cu.address from orderline ol JOIN orders on orders.order_id=ol.order_id join items on items.item_id=ol.item_id LEFT JOIN customers cu on cu.customer_id=orders.customer_id");) {
			ArrayList<Order> Orders = new ArrayList<>();
			while (resultSet.next()) {
				Orders.add(OrderFromResultSet(resultSet));
			}
			return Orders;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return OrderFromCreate(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order readLatesOrderline() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM Orderline ORDER BY orderline_id DESC LIMIT 1");) {
			resultSet.next();
			return addingANewOrderline(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a Order in the database
	 * 
	 * @param Order - takes in a Order object. order_id will be ignored
	 */
	@Override
	public Order create(Order Order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into Orders(customer_id) values('" + Order.getCustomer_id() + "')");
			return readLatest();

		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

		return null;
	}

	// adding item to orderline
	public Order addtoOrderline(Order order) {
		Item item = order.getItem();
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			LOGGER.info(item.getItem_id());
			statement.executeUpdate("insert into orderline(order_id, item_id, quantity, orderline_price) values("
					+ order.getOrder_id() + "," + item.getItem_id() + "," + order.getQuantity() + ","
					+ order.getOrderline_price() + ")");
			return readLatesOrderline();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order readOrder(Long order_id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders where order_id = " + order_id);) {
			resultSet.next();
			return OrderFromCreate(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a Order in the database
	 * 
	 * @param Order - takes in a Order object, the order_id field will be used to
	 *              update that Order in the database
	 * @return
	 */
	@Override
	public Order update(Order Order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update orderline set order_id ='" + Order.getOrder_id() + "' where order_id ="
					+ Order.getOrder_id());
			statement.executeUpdate("update Orders set order_id ='" + Order.getOrder_id() + "', customer_id ='"
					+ Order.getCustomer_id() + "' where order_id =" + Order.getOrder_id());
			return readOrder(Order.getOrder_id());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order updateOrderline(Order Order) {
		Item item = Order.getItem();
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orderline(order_id, item_id, quantity, orderline_price) values("
					+ Order.getOrder_id() + "," + item.getItem_id() + "," + Order.getQuantity() + ","
					+ Order.getOrderline_price() + ")");
			return readLatesOrderline();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a Order in the database
	 * 
	 * @param order_id - order_id of the Order
	 */
	@Override
	public void delete(long orderline_id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from Orderline where orderline_id = " + orderline_id);

		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	/**
	 * Deletes a Order in the database
	 * 
	 * @param order_id - order_id of the Order
	 */
	@Override
	public void deleteOrder(long order_id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from Orderline where order_id = " + order_id);
			statement.executeUpdate("delete from orders where order_id = " + order_id);

		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	public Order addToOrder(Order Order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into Orders(order_id) values('" + Order.getItem_id() + "')");
			return readLatest();

		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return Order;

	}

	public Order calculateOrder(Long order_id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"SELECT orderline_id, order_id, SUM(orderline_price) FROM orderline GROUP BY order_id ="
								+ order_id);) {
			resultSet.next();
			System.out.println(resultSet.toString());
			return CalculateFormResultSetUpdateTwo(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
}