package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

    private final ItemDAO DAO = new ItemDAO();

    @Before
    public void setup() {

        DBUtils.getInstance().init("sql-schema.sql", "sql-data.sql");
    }

    @BeforeClass
    public static void init() {
        DBUtils.connect();
    }

    @Test
    public void testCreate() {
        final Item created = new Item(1L, "butter knife", 2L, 25L, "silver");
        System.out.println(created.toString());
        assertEquals(created, DAO.create(new Item(1L, "butter knife", 2L, 25L, "silver")));
    }

    @Test
    public void testReadAll() {
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(1L, "butter knife", 2L, 25L, "silver"));
        assertEquals(expected, DAO.readAll());
    }

    @Test
    public void testReadLatest() {
        assertEquals(new Item(1L, "butter knife", 2L, 25L, "silver"), DAO.readLatest());
    }

    @Test
    public void testRead() {
        final long ID = 1L;
        assertEquals(new Item(ID, "butter knife", 2L, 25L, "silver"), DAO.read(ID));
    }

    @Test
    public void testUpdate() {
        final Item updated = new Item(1L, "butter knife", 2L, 25L, "silver");
        assertEquals(updated, DAO.update(updated));

    }

    @Test
    public void testDelete() {
        assertEquals(1, DAO.delete(1));
    }

}
