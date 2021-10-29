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



import com.qa.ims.persistence.domain.Customer;

public class CustomerDaoMysql implements Dao<Customer> {

	public static final Logger LOGGER = LogManager.getLogger(CustomerDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public CustomerDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims";
		this.username = username;
		this.password = password;
	}

	public CustomerDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Customer customerFromResultSet(ResultSet resultSet) throws SQLException {
		Long customer_id = resultSet.getLong("customer_id");
		String firstName = resultSet.getString("first_name");
		String surname = resultSet.getString("surname");
		return new Customer(customer_id, firstName, surname);
	}
	

	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	@Override
	public List<Customer> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from customers");) {
			ArrayList<Customer> customers = new ArrayList<>();
			while (resultSet.next()) {
				customers.add(customerFromResultSet(resultSet));
			}
			return customers;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Customer readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM customers ORDER BY customer_id DESC LIMIT 1");) {
			resultSet.next();
			return customerFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a customer in the database
	 * 
	 * @param customer - takes in a customer object. customer_id will be ignored
	 */
	@Override
	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into customers(first_name, surname, address) values('" + customer.getFirstName()
					+ "','" + customer.getSurname() );
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Customer readCustomer(Long customer_id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM customers where customer_id = " + customer_id);) {
			resultSet.next();
			return customerFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a customer in the database
	 * 
	 * @param customer - takes in a customer object, the customer_id field will be used to
	 *                 update that customer in the database
	 * @return
	 */
	@Override
	public Customer update(Customer customer) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update customers set first_name ='" + customer.getFirstName() + "', surname ='"
					+ customer.getSurname() + "', address ='"
							+ "' where customer_id =" + customer.getId());
			return readCustomer(customer.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a customer in the database
	 * 
	 * @param customer_id - customer_id of the customer
	 */
	@Override
	public void delete(long customer_id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from customers where customer_id = " + customer_id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public Customer addtoOrderline(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(long order_id) {
		// TODO Auto-generated method stub
		
	}


}