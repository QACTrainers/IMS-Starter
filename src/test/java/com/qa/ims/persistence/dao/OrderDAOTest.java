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
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Order created = new Order(2L, 1L);

		assertEquals(created, DAO.create(created));
	}

	@Test
	public void TestReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 1L));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order(1L, 1L), DAO.readLatest());
	}
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(ID, 1L), DAO.read(ID));
	}
	@Test
	public void testUpdate() {
		final Order updated = new Order(1L, 1L);
		assertEquals(updated, DAO.update(updated));

	}
	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(1));
	}

	@Test
	public void testReadFail() {
		final long ID = 1L;
		assertEquals(new Order(ID, 1L), DAO.read(ID));
	}
	@Test
	public void testUpdateFail() {
		
		assertEquals(null, DAO.update(null));

	}
	@Test
	public void testDeleteFail() {
		assertEquals(0, DAO.delete(20));
	}
	@Test
	public void testCreateFail() {
		final Order created = new Order(2L, 600L);

		assertEquals(null, DAO.create(created));
	}

}
