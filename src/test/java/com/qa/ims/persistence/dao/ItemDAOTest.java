package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ItemDAOTest {
    private final ItemDAO itemDAO = new ItemDAO();

    @Before
    public void setup() {
        DBUtils.connect();
        DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
    }

    @Test
    public void createTest() {
        Item item1 = new Item(1L, "MacBook Air", 699.99);
        assertEquals(item1, itemDAO.create(item1));
        assertNull(itemDAO.create(null));
    }

    @Test
    public void readLatestTest() {
        Item item2 =  new Item(1L, "MacBook Air", 699.99);
        assertEquals(item2, itemDAO.readLatest());
    }

    @Test
    public void readTest() {
        assertEquals(new Item(1L, "MacBook Air", 699.99), itemDAO.read(1L));
    }

    @Test
    public void readAllTest() {
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(3L, "MacBook Pro", 2500.99));
        assertEquals(expected, itemDAO.readAll());
    }

    @Test
    public void updateTest() {
        Item item6 = new Item(1L, "MacBook Air", 799.99);
        assertEquals(item6, itemDAO.update(item6));
    }

    @Test
    public void deleteTest() {
        assertEquals(1, itemDAO.delete(1L));
    }
}
