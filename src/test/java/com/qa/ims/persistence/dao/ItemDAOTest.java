package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema-item.sql", "src/test/resources/sql-data-item.sql");
	}

	@Test
	public void testCreate() {
		final Item created = new Item(3L, "Pencil", 1.50D);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testreadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(3L, "Ruler", 42.50D));
		expected.add(new Item(4L, "Highlighter", 5.50D));
		expected.add(new Item(5L, "Notepad", 7.50D));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Item(5L, "Notepad", 7.50D), DAO.readLatest());

	}

	@Test
	public void testreadItem() {
		final Item read = new Item("Pen", 1.75D);
		assertEquals(read, DAO.read(2L));
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item(2L, "Pen", 1.75D);
		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
