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
		DBUtils.getInstance().init("src/test/resources/sql-schema-items.sql", "src/test/resources/sql-data-items.sql");
	}

	@Test
	public void testCreate() {
		final Item created = new Item(6L, "Mirror", 19.9D);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testreadItem() {
		final Item read = new Item("Wheel", 29.9D);
		assertEquals(read, DAO.read(2L));
	}

	@Test
	public void testreadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(3L, "Dodge", 12.5D));
		expected.add(new Item(4L, "Duck", 4.4D));
		expected.add(new Item(5L, "Dip", 30.9D));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item(2L, "Wheel", 29.9D);
		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
