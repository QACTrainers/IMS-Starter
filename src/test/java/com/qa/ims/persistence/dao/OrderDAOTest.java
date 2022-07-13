package com.qa.ims.persistence.dao;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderDAOTest {

    private final OrderDAO orderDao = new OrderDAO(new CustomerDAO(), new ItemDAO());

    @Before
    public void setup() {
        DBUtils.connect();
        DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
    }

    @Test
    public void createTest() {
        Customer customer1 = new Customer(1L, "Ian", "Petts");
        List<Item> list = new ArrayList<>();
        Order newOrder = new Order(1L, customer1, 0.0, list);
        assertEquals(newOrder, orderDao.create(newOrder));
    }
}
