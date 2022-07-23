package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	private final OrderDAO DAO = new OrderDAO();

	@BeforeClass
	public static void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void TestCreate() {
		final Order created = new Order(1L, 3L, 2L);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void TestUpdate() {
		assertEquals(null, DAO.update(new Order(2l, 2l)));
	}

	@Test
	public void TestDelete() {
		assertEquals(2, DAO.delete(2));
	}

	@Test
	public void Testread() {
		final long ID = 5L;
		assertEquals(new Order(ID, 1L, 1L), DAO.read(ID));
	}

	@Test
	public void TestReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 1L));
		assertEquals(expected, DAO.readAll());
	}
}
