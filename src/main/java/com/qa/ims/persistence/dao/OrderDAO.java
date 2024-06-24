package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	
	
	
	
	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Double totalOrderPrice = resultSet.getDouble("total_order_price");
		int customer_id = resultSet.getInt("fk_customer_id");
		return new Order (orderId, customer_id,totalOrderPrice);
		
		
	}
	


	@Override
	public List<Order> readAll() {
		try(Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement(); 
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");){
			List<Order> orders = new ArrayList<>(); 
			while(resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		}catch(SQLException e) {
			LOGGER.debug(e); 
			LOGGER.error(e.getMessage());	
			
		}
		
		return new ArrayList<>();
	}
	
	@Override
	public Order read(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE order_id = ?");) {
			statement.setLong(1, orderId); 
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


	
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}

	
	public Order create(Order orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(fk_customer_id, total_order_price) VALUES (?, ?)");) {
			statement.setInt(1, orders.getcustomer_id());
			statement.setDouble(2, orders.getTotalOrderPrice());
			statement.executeUpdate();
			addItemToOrder(orders);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	
	@Override
	public Order update(Order orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders SET total_order_price = ? WHERE order_id = ?");) {
			statement.setDouble(1, orders.getTotalOrderPrice());
			statement.setLong(2, orders.getOrderId());


			statement.executeUpdate();
			return read(orders.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	

	@Override
	public int delete(long Id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
			statement.setLong(1, Id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	
	public Order addItemToOrder(Order orders) {
		Order recentOrders=readLatest();
		Map<Long, Integer> items = new HashMap<Long, Integer>();
		items=orders.getItems(); 
		
		for (Map.Entry<Long, Integer> entry : items.entrySet()) {
		    Long itemId = entry.getKey();
		    Integer itemQuantity = entry.getValue();
		    
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection
							.prepareStatement("INSERT INTO order_lines(fk_order_id, order_quantity, fk_item_id) VALUES (?, ?, ?)");) {
				statement.setLong(1, recentOrders.getOrderId());
				statement.setInt(2, itemQuantity);
				statement.setLong(3, itemId);
				statement.executeUpdate();
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
		    
		    
		}
	
		return null;
	};
	
	public Order deleteItemFromOrder(Long orderId, Long itemId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM order_lines WHERE fk_item_id = ? and fk_order_id = ?");) {
			statement.setLong(1, itemId);
			statement.setLong(2, orderId);
			statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	};

	
}
