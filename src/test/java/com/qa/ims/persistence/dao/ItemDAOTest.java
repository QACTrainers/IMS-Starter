package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
	private final ItemDAO DAO = new ItemDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Item created = new Item(3, "Mirror", 19.99);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testreadItem() {
		final Item read = new Item(1, "Wheel", 29.99);
		assertEquals(read, DAO.read(1L));
	}

	@Test
	public void testreadAll() {
		List<Item> readall = new ArrayList<Item>();
		readall.add(new Item(1, "Wheel", 29.99));
		readall.add(new Item(2, "Mirror", 19.99));
		assertEquals(readall, DAO.readAll());
	}

	@Test
	public void testCreateExcept() {
		final Item exc = new Item(3, "Mirror", 10.99);
		assertEquals(null, DAO.create(exc));
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item(1, "Wheel", 29.99);
		assertEquals(updated, DAO.update(new Item(1, "Wheel", 29.99)));
	}

	@Test
	public void testUpdateExc() {
		final Item updated = new Item(1, "Wheel", 10.99);
		assertEquals(null, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(1));
	}
}
