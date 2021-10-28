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
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		
	}


	@Test
	public void testCreate() {
		final Item created = new Item(2L,"Iphone", 400.52d);
		assertEquals(created, DAO.create(created));
	}
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L,"ps5", 500.25d));
		assertEquals(expected, DAO.readAll());
	}
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item(1L,"ps5" , 500.25), DAO.read(ID));
	}
	@Test
	public void testUpdate() {
		final Item updated = new Item(1L, "ps5", 400.53d);
		assertEquals(updated, DAO.update(updated));
		
	}
	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(1));
	}

	@Test
	public void testReadFail() {
		final long ID = 20L;
		assertEquals(null, DAO.read(ID));
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
		final Item created = new Item(2L,"SomethingTooLongSomethingTooLongSomethingTooLongSomethingTooLongSomethingTooLongSomethingTooLongSomethingTooLongSomethingTooLongSomethingTooLongSomethingTooLongSomethingTooLongSomethingTooLongSomethingTooLong", 400.52d);
		assertEquals(null, DAO.create(created));
	}
	
	

	
}