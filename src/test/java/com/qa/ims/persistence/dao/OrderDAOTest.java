package com.qa.ims.persistence.dao;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import org.junit.Before;
import org.junit.Test;

import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

    private final OrderDAO DAO = new OrderDAO();

    @Before
    public void setup() {
        DBUtils.connect();
        DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
    }

    @Test
    public void testCreate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final Date PLACED = new java.sql.Date(dateFormat.parse("26/8/2009").getTime());

        final Order created = new Order(1L, 1L, PLACED, 0L);
        assertEquals(created, DAO.create(created));
    }

   // @Test
    public void testReadAll() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final Date PLACED = new java.sql.Date(dateFormat.parse("26/8/2009").getTime());

        List<Order> expected = new ArrayList<>();
        expected.add(new Order(1L, 1L, PLACED, 0L, null ));
        assertEquals(expected, DAO.readAll());
    }

    //@Test
    public void testReadLatest() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final Date PLACED = new java.sql.Date(dateFormat.parse("26/8/2009").getTime());
        assertEquals(new Order(1L, 1L, PLACED, 0L), DAO.readLatest());
    }

    //@Test
    public void testRead() throws ParseException {
        final long ID = 1L;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final Date PLACED = new java.sql.Date(dateFormat.parse("26/8/2009").getTime());
        assertEquals(new Order(1L, 1L, PLACED, 3L), DAO.read(ID));
    }

    //@Test
    public void testUpdate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final Date PLACED = new java.sql.Date(dateFormat.parse("26/8/2009").getTime());
        final Order updated = new Order(1L, 1L, PLACED, 0L);
        assertEquals(updated, DAO.update(updated));

        //assertEquals(updated,updated);
    }

    @Test
    public void testDelete() {
        assertEquals(0, DAO.delete(1));
    }
}
