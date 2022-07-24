package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema-order.sql", "src/test/resources/sql-data-order.sql");
	}

	@Test
	public void testCreate() {
		final Order created = new Order(1L, 2L);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testUpdate() {
		assertEquals(null, DAO.update(new Order(1L, 2L)));
	}

	@Test
	public void testDelete() {
		assertEquals(2, DAO.delete(2));
	}

	@Test
	public void testread() {
		final long ID = 5L;
		assertEquals(new Order(ID, 1L), DAO.read(ID));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 2L));
		assertEquals(expected, DAO.readAll());
	}

}
