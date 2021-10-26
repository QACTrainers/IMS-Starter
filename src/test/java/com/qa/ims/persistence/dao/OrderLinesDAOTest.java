package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrderLines;
import com.qa.ims.utils.DBUtils;

public class OrderLinesDAOTest {

	private final OrderLinesDAO DAO = new OrderLinesDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final OrderLines created = new OrderLines(2L, 1L, 1L, 8L);
		assertEquals(created, DAO.create(created));
	}
	@Test
	public void testReadAll() {
		List<OrderLines> expected = new ArrayList<>();
		expected.add(new OrderLines(1L ,1L, 1L, 8L));
		assertEquals(expected, DAO.readAll());
	}
	@Test
	public void testReadLatest() {
		assertEquals(new OrderLines(1L, 1L, 1L, 8L), DAO.readLatest());
	}
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new OrderLines(ID, 1L, 1L, 8L), DAO.read(ID));
	}
	@Test
	public void testUpdate() {
		final OrderLines updated = new OrderLines(1L, 1L, 1L, 6L);
		assertEquals(updated, DAO.update(updated));

	}
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	@Test
	public void readOrderIdTest() {
		final long ID = 1L;
		List<OrderLines> expected = new ArrayList<>();
		expected.add(new OrderLines(1L, 1L, 1L, 8L));
		assertEquals(expected, DAO.readOrderId(ID));
	}
}
