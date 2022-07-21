package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;


public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/main/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void test1Create() {
		final Order created = new Order(1L, 2L, 3l);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void test2ReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 2L, null));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void test3Read() {
		final long ID = 1L;
		assertEquals(new Order(1L, 2L,3L), DAO.readOrder(ID));
	}

	@Test
	public void test4Update() {
		final Order updated = new Order(1L,2l, 3L);
		assertEquals(updated, DAO.update(updated));

	}
	
	@Test
	public void test5ReadLatest() {
		assertEquals(new Order(1L, 2l,3L), DAO.readLatest());
	}

	@Test
	public void test6Delete() {
		assertEquals(1, DAO.delete(1L));
	}
}